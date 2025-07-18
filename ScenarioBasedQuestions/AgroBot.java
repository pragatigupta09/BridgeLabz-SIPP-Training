package ScenarioBasedQuestions;
interface SensorReadable {
    void readSensorData();
}

class IrrigationUnit {
    private int calibrationLevel;

    public IrrigationUnit(int calibrationLevel) {
        this.calibrationLevel = calibrationLevel;
    }

    protected void calibrate() {
        System.out.println("Calibrating system at level: " + calibrationLevel);
    }

    public void startWatering() {
        System.out.println("Starting generic watering...");
    }
}

class Sprinkler extends IrrigationUnit implements SensorReadable {
    public Sprinkler(int calibrationLevel) {
        super(calibrationLevel);
    }

    @Override
    public void startWatering() {
        calibrate();
        System.out.println("Sprinkler is watering the field.");
    }

    public void readSensorData() {
        System.out.println("Sprinkler sensor: moisture = 45%");
    }
}

class DripSystem extends IrrigationUnit implements SensorReadable {
    public DripSystem(int calibrationLevel) {
        super(calibrationLevel);
    }

    @Override
    public void startWatering() {
        calibrate();
        System.out.println("DripSystem is watering the field.");
    }

    public void readSensorData() {
        System.out.println("DripSystem sensor: moisture = 38%");
    }
}

public class AgroBot {
    public static void main(String[] args) {
        Sprinkler s = new Sprinkler(3);
        DripSystem d = new DripSystem(2);

        s.readSensorData();
        s.startWatering();

        d.readSensorData();
        d.startWatering();
    }
}

