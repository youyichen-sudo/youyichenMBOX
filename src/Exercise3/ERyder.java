package Exercise3;
public class ERyder {
    String bikeID;
    int batteryLevel;
    boolean isAvailable;
    double kmDriven;

    public ERyder() {
        bikeID = "B000";
        batteryLevel = 100;
        isAvailable = true;
        kmDriven = 0.0;
    }

    public ERyder(String id, int battery, boolean available, double km) {
        bikeID = id;
        batteryLevel = battery;
        isAvailable = available;
        kmDriven = km;
    }

    public void ride() {
        if (batteryLevel > 0 && isAvailable == true) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery: " + batteryLevel);
        System.out.println("Available: " + isAvailable);
        System.out.println("Distance: " + kmDriven);
    }

    public void setBatteryLevel(int battery) {
        if (battery >= 0 && battery <= 100) {
            batteryLevel = battery;
        } else {
            System.out.println("Invalid battery level!");
        }
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }
}
