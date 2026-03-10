package Exercise4;

public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder();
        bike1.printBikeDetails();

        System.out.println("--- test bike2 ---");

        ERyder bike2 = new ERyder("E888", 75, true, 12.5, "Alice_99", "555-0199");
        bike2.ride();
        bike2.printBikeDetails();
        
        System.out.println();
        
        bike1.printRideDetails(15);
        bike2.printRideDetails(30);
    }
}
