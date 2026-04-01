package ERyder;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private BikeService bikeService;

    public RentalService(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    public void startRental(String bikeID, String email) {
        ActiveRental rental = new ActiveRental(bikeID, email, LocalDateTime.now());
        activeRentalsList.add(rental);
        bikeService.setBikeUnavailable(bikeID);
    }

    public void endRental(String email) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();

        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getUserEmail().equals(email)) {
                iterator.remove();
                bikeService.setBikeAvailable(rental.getBikeID());
            }
        }
    }

    public void showActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals.");
            return;
        }

        for (ActiveRental ar : activeRentalsList) {
            System.out.println("Bike ID: " + ar.getBikeID() + " | User: " + ar.getUserEmail());
        }
    }
}