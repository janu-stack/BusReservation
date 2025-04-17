package busResev;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;

    // Constructor
    Bus(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
    }

    // Getter methods
    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setter methods
    public void setAc(boolean val) {
        ac = val;
    }

    public void setCapacity(int cap) {
        capacity = cap;
    }

    // Display method
    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " | AC: " + (ac ? "Yes" : "No") + " | Capacity: " + capacity);
    }
}
