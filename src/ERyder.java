public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder() {
        bikeID = "DEF-001";
        batteryLevel = 100;
        isAvailable = true;
        kmDriven = 0.0;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available. Enjoy your ride!");
            kmDriven += 5.0;
            batteryLevel -= 10;
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("ID: " + bikeID);
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Available: " + isAvailable);
        System.out.println("Distance: " + kmDriven + " km");
        System.out.println("------------------------------");
    }

    public String getBikeID() { return bikeID; }
    public void setBikeID(String bikeID) { this.bikeID = bikeID; }

    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int level) {
        if (level >= 0 && level <= 100) {
            this.batteryLevel = level;
        } else {
            this.batteryLevel = 100;
        }
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public double getKmDriven() { return kmDriven; }
    public void setKmDriven(double kmDriven) { this.kmDriven = kmDriven; }

}
