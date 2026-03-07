public class Main {
    public static void main(String[] args) {
        ERyder b1 = new ERyder();
        System.out.println("Testing Default Constructor:");
        b1.printBikeDetails();

        ERyder b2 = new ERyder("E-BIKE-77", 85, true, 50.5);
        System.out.println("Testing Parameterized Constructor:");
        b2.ride();
        b2.printBikeDetails();
        
        b2.setBatteryLevel(150);
        System.out.println("Testing Level Validation: " + b2.getBatteryLevel());
    }

}
