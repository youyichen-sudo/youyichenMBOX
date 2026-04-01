package ERyder;

public class BikeService {

    public boolean checkBikeAvailableAtLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public String getAvailableBikeId(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                return bike.getBikeID();
            }
        }
        return null;
    }

    public void setBikeUnavailable(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(false);
                bike.setLastUsedTime(java.time.LocalDateTime.now());
            }
        }
    }

    public void setBikeAvailable(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
            }
        }
    }
}