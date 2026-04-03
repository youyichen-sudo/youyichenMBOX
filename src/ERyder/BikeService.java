package ERyder;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.time.LocalDateTime;

public class BikeService {

    private Stack<ERyderLog> systemLogStack = new Stack<>();
    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();

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
                bike.setLastUsedTime(LocalDateTime.now());
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

    public void addSystemLog(String logId, String eventDesc) {
        ERyderLog log = new ERyderLog(logId, eventDesc, LocalDateTime.now());
        systemLogStack.push(log);
    }

    public void viewSystemLogs() {
        for (ERyderLog log : systemLogStack) {
            System.out.println(log);
        }
    }

    public void addBikeRequest(String userEmail, String location) {
        BikeRequest req = new BikeRequest(userEmail, location, LocalDateTime.now());
        bikeRequest.add(req);
    }

    public void viewBikeRequestQueue() {
        for (BikeRequest req : bikeRequest) {
            System.out.println(req);
        }
    }

    public void removeFirstRequest() {
        if (!bikeRequest.isEmpty()) {
            bikeRequest.poll();
        }
    }
}