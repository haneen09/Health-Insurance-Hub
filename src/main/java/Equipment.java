public class Equipment {
    // Create a constructor to initialize Equipment's objects.
    // Equipment usually has the following type of information:

    /*
     * • Equipment name
     * • Quantity available
     */

    private String equipmentName;
    private int quantity;

    // Constructor
    public Equipment(String equipmentName, int quantity) {
        this.equipmentName = equipmentName;
        this.quantity = quantity;
    }

    // Getter methods
    public String getEquipmentName() { return equipmentName; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Equipment Name: " + equipmentName + ", Quantity Available: " + quantity;
    }

}
