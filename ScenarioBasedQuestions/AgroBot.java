import java.util.Scanner;

abstract class IrrigationUnit {
    protected String location;

    IrrigationUnit(String location) {
        this.location = location;
    }

    abstract void startWatering();
}

interface SensorReadable {
    void readSensorData();
}

class Sprinkler extends IrrigationUnit implements SensorReadable {
    Sprinkler(String location) {
        super(location);
    }

    public void readSensorData() {
        System.out.println("Sprinkler sensor: Soil moisture = 40%");
    }

    public void startWatering() {
        System.out.println("Sprinkler watering at " + location);
    }
}

class DripSystem extends IrrigationUnit implements SensorReadable {
    DripSystem(String location) {
        super(location);
    }

    public void readSensorData() {
        System.out.println("DripSystem sensor: Soil moisture = 30%");
    }

    public void startWatering() {
        System.out.println("Drip irrigation started at " + location);
    }
}

public class AgroBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter field location: ");
        String location = sc.nextLine();
        System.out.print("Choose unit (1: Sprinkler, 2: DripSystem): ");
        int choice = sc.nextInt();

        IrrigationUnit unit;
        if (choice == 1) {
            unit = new Sprinkler(location);
        } else {
            unit = new DripSystem(location);
        }

        ((SensorReadable) unit).readSensorData();
        unit.startWatering();
    }
}
