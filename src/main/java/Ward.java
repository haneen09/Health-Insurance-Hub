import java.util.List;
import java.util.ArrayList;

public class Ward {
    // Create a constructor to initialize Ward's objects.
    // Ward usually has the following type of information:

    /*
     * • Ward number
     * • Capacity
     * • Bed information
     * • Equipment available
     */

    private String wardID;
    private List<Bed> beds;
    private List<Equipment> equipments;
    private int capacity;

    // Constructor
    public Ward(String wardID, List<Bed> beds, List<Equipment> equipments, int capacity) {
        this.wardID = wardID;
        this.beds = beds;
        this.equipments = equipments;
        this.capacity = capacity;
    }
    public Ward() {
        this.wardID = "N/A";
        this.beds = new ArrayList<>();
        this.equipments = new ArrayList<>();
        this.capacity = 2;  // Default capacity value assignment for a ward

    }


    // Getter for wardId
    public String getWardID() {
        return wardID;
    }

    // Setter for wardId
    public void setWardID(String wardID) {
        this.wardID = wardID;
    }

    // Getter for beds
    public List<Bed> getBeds() {
        return beds;
    }

    // Setter for beds
    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    // Getter for equipments
    public List<Equipment> getEquipments() {
        return equipments;
    }

    // Setter for equipments
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;

    }

    public void resetWard(String wardID, List<Bed> beds, List<Equipment> equipments, int capacity){
        this.wardID = wardID;
        this.beds = beds;
        this.equipments = equipments;
        this.capacity = capacity;
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }

    // Optional: Add equipment
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public Bed getAvailableBed() {
        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                return bed;
            }
        }
        return null; // No available bed found
    }

    public boolean isFull() {
        if (getAvailableBed() == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Ward ID: " + wardID +
                "\nBeds: " + beds +
                "\nCapacity: " + capacity +
                "\nEquipments: " + equipments;
    }
}


