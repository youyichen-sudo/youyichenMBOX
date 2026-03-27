package ERyder;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private String emailAddress;
    private String location;
    private String bikeID;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);

    public void simulateApplicationInput() {
        System.out.print("Enter email: ");
        emailAddress = sc.nextLine();
        analyseRequest();

        System.out.print("Enter location: ");
        location = sc.nextLine();
        bikeID = validateLocation();

        if (bikeID != null) {
            reserveBike();
        }

        System.out.println("\n--- Active Rentals ---");
        viewActiveRentals();

        System.out.println("\n--- Ending Trip ---");
        removeTrip();

        System.out.println("\n--- After Trip End ---");
        viewActiveRentals();
    }

    public void analyseRequest() {
        System.out.println("Welcome back, " + emailAddress);
    }

    public String validateLocation() {
        for (Bike bike : BikeDatabase.bikeList) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                return bike.getBikeID();
            }
        }
        System.out.println("No bike available.");
        return null;
    }

    public void reserveBike() {
        for (Bike bike : BikeDatabase.bikeList) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                ActiveRental rental = new ActiveRental(bikeID, emailAddress, LocalDateTime.now());
                activeRentalsList.add(rental);
                System.out.println("Bike reserved!");
            }
        }
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals.");
            return;
        }

        for (ActiveRental ar : activeRentalsList) {
            System.out.println("Bike: " + ar.getBikeID() + " | User: " + ar.getUserEmail());
        }
    }

    public void removeTrip() {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();

        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getUserEmail().equals(emailAddress)) {
                iterator.remove();

                for (Bike bike : BikeDatabase.bikeList) {
                    if (bike.getBikeID().equals(rental.getBikeID())) {
                        bike.setAvailable(true);
                    }
                }
                System.out.println("Trip ended.");
            }
        }
    }
}