import java.util.*;

public class BusBooking {
    static int busFare = 100;
    String customerName;
    String source;
    String destination;
    int noOfPassengers;

    BusBooking(String customerName, String source, String destination, int noOfPassengers) {
        this.customerName = customerName;
        this.source = source;
        this.destination = destination;
        this.noOfPassengers = noOfPassengers;
    }

    public void printBookingSummary() {
        System.out.println("\nBooking Summary:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("From: " + source + " To: " + destination);
        System.out.println("Passengers: " + noOfPassengers);
        System.out.println("Total Fare: Rs." + displayTotalFare());
    }

    public int displayTotalFare() {
        return noOfPassengers * busFare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean moreBooking = true;
        while (moreBooking) {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            System.out.print("Enter source location: ");
            String source = sc.nextLine();
            System.out.print("Enter destination location: ");
            String destination = sc.nextLine();
            System.out.print("Enter number of passengers: ");
            int passengers = sc.nextInt();
            sc.nextLine();  

            BusBooking booking = new BusBooking(name, source, destination, passengers);
            booking.printBookingSummary();

            System.out.print("\nDo you want to make another booking?");
            moreBooking = sc.nextBoolean();
            sc.nextLine();          
        }

        System.out.println("Thank you for booking!");
    }
}
