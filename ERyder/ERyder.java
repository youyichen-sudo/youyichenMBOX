public class ERyder {private String id;
    private int bat = 100;
    private boolean active = true;
    private double km = 0.0;

    public ERyder() {
        this.id = "B-" + System.currentTimeMillis() % 1000;
    }

    public ERyder(String id, int bat, boolean active, double km) {
        this.id = id;
        this.bat = bat > 100 ? 100 : Math.max(bat, 0);
        this.active = active;
        this.km = km;
    }

    public void ride() {
        if (!active || bat < 10) {
            System.out.println("Cannot ride: " + id + " (Low battery or locked)");
            return;
        }

        this.km += 5.0;
        this.bat -= 10;
        
        if (this.bat <= 0) {
            this.bat = 0;
            this.active = false;
        }
        System.out.println("Ride ok. Battery now: " + bat + "%");
    }

    public void dump() {
        System.out.println("ID:" + id + " | BT:" + bat + " | KM:" + km + " | OK:" + active);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getBat() { return bat; }
    public void setBat(int b) {
        this.bat = (b < 0) ? 0 : (b > 100 ? 100 : b);
    }

    public boolean isActive() { return active; }
    public void setActive(boolean a) { this.active = a; }

    public double getKm() { return km; }
    public void setKm(double km) { this.km = km; }

}
