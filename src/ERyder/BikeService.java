package ERyder;



import java.time.LocalDateTime;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeService {
    private Stack<ERyderLog> logStack = new Stack<>();
    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();
    private boolean bikeAvailable = true;

    public void reserveBike(String userEmail, String bikeID, String location) {
        if (bikeAvailable) {
            bikeAvailable = false;
            String logId = "BR" + (int) (Math.random() * 999);
            String event = "Bike with bikeID " + bikeID + " was rented from " + location;
            logStack.push(new ERyderLog(logId, event, LocalDateTime.now()));
        } else {
            bikeRequest.add(new BikeRequest(userEmail, location, LocalDateTime.now()));
        }
    }

    public void removeTrip(String bikeID, String location) {
        bikeAvailable = true;
        String logId = "TR" + (int) (Math.random() * 999);
        String event = "Trip ended for bike " + bikeID + " at " + location;
        logStack.push(new ERyderLog(logId, event, LocalDateTime.now()));

        if (!bikeRequest.isEmpty()) {
            BikeRequest req = bikeRequest.poll();
            reserveBike(req.getUserEmail(), bikeID, req.getLocation());
        }
    }

    public void viewSystemLogs() {
        for (ERyderLog log : logStack) {
            System.out.println(log);
        }
    }

    public void viewQueue() {
        for (BikeRequest req : bikeRequest) {
            System.out.println(req);
        }
    }

    public void updateQueue() {
        if (!bikeRequest.isEmpty()) {
            bikeRequest.poll();
        }
    }
}