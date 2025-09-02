import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class SmartCityApp {
    static final class Location {
        final double lat, lon;
        Location(double lat, double lon){ this.lat = lat; this.lon = lon; }
    }

    static final class Trip {
        final String serviceId;
        final String serviceType;
        final String route;
        final LocalTime departure;
        final boolean peak;
        final int passengers;
        final double distanceKm;
        final double fare;
        Trip(String serviceId, String serviceType, String route, LocalTime departure,
             boolean peak, int passengers, double distanceKm, double fare) {
            this.serviceId = serviceId;
            this.serviceType = serviceType;
            this.route = route;
            this.departure = departure;
            this.peak = peak;
            this.passengers = passengers;
            this.distanceKm = distanceKm;
            this.fare = fare;
        }
        public LocalTime getDeparture() { return departure; }
        public String getRoute(){ return route; }
        public String getServiceType(){ return serviceType; }
        public boolean isPeak(){ return peak; }
        public int getPassengers(){ return passengers; }
        public double getFare(){ return fare; }
        public double getRevenue(){ return fare * passengers; }
        public String toString(){
            return serviceType+"["+serviceId+"] "+route+" @"+departure+" fare="+fare+" passengers="+passengers+(peak?" (peak)":"");
        }
    }

    interface TransportService {
        String id();
        String type();
        List<Trip> trips();
        default void printServiceDetails() {
            System.out.println(type()+"["+id()+"] -> " + trips().size()+" trips");
        }
    }

    interface GeoUtils {
        static double calculateDistance(Location a, Location b) {
            double R = 6371.0;
            double dLat = Math.toRadians(b.lat - a.lat);
            double dLon = Math.toRadians(b.lon - a.lon);
            double s1 = Math.sin(dLat/2), s2 = Math.sin(dLon/2);
            double aa = s1*s1 + Math.cos(Math.toRadians(a.lat))*Math.cos(Math.toRadians(b.lat))*s2*s2;
            return 2*R*Math.asin(Math.sqrt(aa));
        }
    }

    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(double base, double distanceKm, boolean peak);
    }

    interface EmergencyService {}

    static abstract class BaseService implements TransportService {
        private final String id, type;
        protected final double baseFare;
        protected final List<Trip> trips = new ArrayList<>();
        BaseService(String id, String type, double baseFare){
            this.id = id; this.type = type; this.baseFare = baseFare;
        }
        public String id(){ return id; }
        public String type(){ return type; }
        public List<Trip> trips(){ return trips; }
    }

    static final class BusService extends BaseService {
        BusService(String id){ super(id,"Bus", 10.0); }
    }
    static final class MetroService extends BaseService {
        MetroService(String id){ super(id,"Metro", 12.0); }
    }
    static final class TaxiService extends BaseService {
        TaxiService(String id){ super(id,"Taxi", 40.0); }
    }
    static final class AmbulanceService extends BaseService implements EmergencyService {
        AmbulanceService(String id){ super(id,"Ambulance", 0.0); }
    }

    public static void main(String[] args) {
        BusService busA = new BusService("B12");
        MetroService metroA = new MetroService("M02");
        TaxiService taxiA = new TaxiService("T55");
        AmbulanceService ambu = new AmbulanceService("EMR1");

        List<TransportService> all = Arrays.asList(busA, metroA, taxiA, ambu);

        FareCalculator busFare   = (base, d, peak) -> base + d*2 + (peak?3:0);
        FareCalculator metroFare = (base, d, peak) -> base + d*1.5 + (peak?2:0);
        FareCalculator taxiFare  = (base, d, peak) -> base + d*8 + (peak?10:0);
        FareCalculator freeFare  = (base, d, peak) -> 0;

        Location a = new Location(28.7041, 77.1025);
        Location b = new Location(28.4595, 77.0266);
        double dAB = GeoUtils.calculateDistance(a, b);

        addTrip(busA,   "B12-R1", LocalTime.of(8,10),  true,  40, dAB,   busFare);
        addTrip(busA,   "B12-R1", LocalTime.of(8,40),  true,  45, dAB,   busFare);
        addTrip(busA,   "B12-R2", LocalTime.of(9,15),  false, 30, dAB*0.8, busFare);

        addTrip(metroA, "M02-GN", LocalTime.of(8, 5),  true,  200, dAB*1.1, metroFare);
        addTrip(metroA, "M02-GN", LocalTime.of(8,30),  true,  220, dAB*1.1, metroFare);
        addTrip(metroA, "M02-GN", LocalTime.of(9,20),  false, 180, dAB*1.1, metroFare);

        addTrip(taxiA,  "DL-RID", LocalTime.of(8,20),  true,   1, dAB*0.9, taxiFare);
        addTrip(taxiA,  "DL-RID", LocalTime.of(9,10),  false,  1, dAB*0.7, taxiFare);

        addTrip(ambu,   "EMR",    LocalTime.of(8,25),  true,   1, dAB*0.9, freeFare);

        System.out.println("\n=== Search: earliest departure for route 'M02-GN' after 8:00 ===");
        List<Trip> options = all.stream()
                .flatMap(s -> s.trips().stream())
                .filter(t -> t.route.equals("M02-GN") && !t.departure.isBefore(LocalTime.of(8,0)))
                .sorted(Comparator.comparing(Trip::getDeparture))
                .collect(toList());
        options.forEach(System.out::println);

        System.out.println("\n=== Lowest fare across all services after 8:00 ===");
        all.stream().flatMap(s -> s.trips().stream())
                .filter(t -> !t.departure.isBefore(LocalTime.of(8,0)))
                .min(Comparator.comparingDouble(Trip::getFare))
                .ifPresent(System.out::println);

        System.out.println("\n=== Live Dashboard: Current Services ===");
        all.forEach(TransportService::printServiceDetails);
        System.out.println("--- Next departures (sorted) ---");
        all.stream().flatMap(s -> s.trips().stream())
                .sorted(Comparator.comparing(Trip::getDeparture))
                .forEach(System.out::println);

        System.out.println("\n=== Revenue by Route (groupingBy + summarizingDouble) ===");
        Map<String, DoubleSummaryStatistics> revenueByRoute =
                all.stream().flatMap(s -> s.trips().stream())
                   .collect(groupingBy(Trip::getRoute, summarizingDouble(Trip::getRevenue)));
        revenueByRoute.forEach((route, stats) ->
                System.out.println(route + " -> trips=" + stats.getCount()
                        + ", total=" + round(stats.getSum())
                        + ", avg=" + round(stats.getAverage())));

        System.out.println("\n=== Peak vs Non-Peak Revenue (partitioningBy) ===");
        Map<Boolean, Double> revPeakPartition =
                all.stream().flatMap(s -> s.trips().stream())
                   .collect(partitioningBy(Trip::isPeak, summingDouble(Trip::getRevenue)));
        revPeakPartition.forEach((peak, sum) ->
                System.out.println((peak?"Peak":"Non-Peak") + " -> " + round(sum)));

        System.out.println("\n=== Top-used routes (by passengers) ===");
        all.stream().flatMap(s -> s.trips().stream())
                .collect(groupingBy(Trip::getRoute, summingInt(Trip::getPassengers)))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey()+" -> passengers="+e.getValue()));

        TransportService ferry = new BaseService("F01","Ferry", 15.0) {};
        FareCalculator ferryFare = (base, d, peak) -> base + d*2.5 + (peak?4:0);
        addTrip((BaseService)ferry, "F01-RIV", LocalTime.of(9,45), false, 80, 12.0, ferryFare);
        System.out.println("\n=== Added new service type dynamically ===");
        ferry.printServiceDetails();
        ferry.trips().forEach(System.out::println);

        System.out.println("\n=== Emergency Priority Queue ===");
        List<TransportService> prio =
                all.stream()
                   .sorted(Comparator.comparing((TransportService s) -> !(s instanceof EmergencyService)))
                   .collect(toList());
        prio.forEach(s -> System.out.println((s instanceof EmergencyService ? "[EMERGENCY] " : "") + s.type()+"["+s.id()+"]"));
    }

    static void addTrip(BaseService svc, String route, LocalTime time, boolean peak, int passengers,
                        double distanceKm, FareCalculator calc) {
        double fare = calc.calculateFare(svc.baseFare, distanceKm, peak);
        svc.trips.add(new Trip(svc.id(), svc.type(), route, time, peak, passengers, distanceKm, round2(fare)));
    }

    static double round(double v){ return Math.round(v*100.0)/100.0; }
    static double round2(double v){ return Math.round(v*100.0)/100.0; }
}
