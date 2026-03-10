package Exercise4;

public class ERyder {
    String bikeID;
    int batteryLevel;
    boolean isAvailable;
    double kmDriven;

    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder() {
        bikeID = "B000";
        batteryLevel = 100;
        isAvailable = true;
        kmDriven = 0.0;
        LINKED_ACCOUNT = "None";
        LINKED_PHONE_NUMBER = "000000";
        totalUsageInMinutes = 0;
        totalFare = 0.0;
    }

    public ERyder(String id, int battery, boolean available, double km, String account, String phone) {
        bikeID = id;
        batteryLevel = battery;
        isAvailable = available;
        kmDriven = km;
        LINKED_ACCOUNT = account;
        LINKED_PHONE_NUMBER = phone;
    }

    public void ride() {
        if (batteryLevel > 0 && isAvailable == true) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    public void printRideDetails(int usageInMinutes) {
        double fare = calculateFare(usageInMinutes);
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("User: " + LINKED_ACCOUNT);
        System.out.println("Phone: " + LINKED_PHONE_NUMBER);
        System.out.println("Bike: " + bikeID);
        System.out.println("Duration: " + usageInMinutes + " mins");
        System.out.println("Fare: $" + fare);
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
