package ERyder;



import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {

    private boolean isRegistered;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    private UserRegistration userRegistration;
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    Scanner scanner = new Scanner(System.in);

    public void simulateApplicationInput() {
        System.out.print("Enter your email: ");
        emailAddress = scanner.nextLine();

        analyseRequest();

        System.out.print("Enter location: ");
        location = scanner.nextLine();

        bikeID = validateLocation();

        reserveBike();

        System.out.println("\n--- Active Rentals ---");
        viewActiveRentals();

        System.out.println("\nNow ending the trip...");
        removeTrip();

        System.out.println("\n--- After End Trip ---");
        viewActiveRentals();
    }

    public void analyseRequest() {
        isRegistered = true;
        System.out.println("Welcome back, " + emailAddress);
    }

    public String validateLocation() {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                locationValid = true;
                return bike.getBikeID();
            }
        }
        locationValid = false;
        System.out.println("No available bikes at this location!");
        return null;
    }

    public void reserveBike() {
        if (bikeID == null) {
            return;
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());

                ActiveRental rental = new ActiveRental(bikeID, emailAddress, LocalDateTime.now());
                activeRentalsList.add(rental);
                System.out.println("Bike " + bikeID + " reserved successfully!");
            }
        }
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals.");
            return;
        }

        for (ActiveRental ar : activeRentalsList) {
            System.out.println("Bike ID: " + ar.getBikeID() + " | User: " + ar.getUserEmail());
        }
    }

    public void removeTrip() {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();

        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();

            if (rental.getUserEmail().equals(emailAddress)) {
                iterator.remove();

                for (Bike bike : BikeDatabase.bikes) {
                    if (bike.getBikeID().equals(rental.getBikeID())) {
                        bike.setAvailable(true);
                    }
                }
                System.out.println("Trip ended successfully!");
            }
        }
    }
}