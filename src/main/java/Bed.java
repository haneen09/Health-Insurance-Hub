public class Bed {
    private String bedID;
    private boolean isOccupied;


    public Bed(String bedID) {
        this.bedID = bedID;
        this.isOccupied = false;

    }

    public String getBedID() {
        return bedID;
    }

    public void setBedID(String bedID) {
        this.bedID = bedID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }


    public void toggleOccupied() {
        isOccupied = !isOccupied;
    }

    @Override
    public String toString() {
        return "Bed ID: " + bedID + ", Occupied: " + isOccupied;
    }
}
