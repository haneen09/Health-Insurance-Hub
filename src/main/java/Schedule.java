public class Schedule {
    // Create a constructor to initialize Schedule's objects.
    // Schedule usually has the following type of information:

    /*
     * • Available days
     * • Available times
     */

    private String availableDays;
    private String availableTimes;

    // Constructor
    public Schedule(String availableDays, String availableTimes) {
        this.availableDays = availableDays;
        this.availableTimes = availableTimes;
    }

    // Getter methods
    public String getAvailableDays() { return availableDays; }
    public String getAvailableTimes() { return availableTimes; }

    @Override
    public String toString() {
        return "Available Days: " + availableDays + ", Available Times: " + availableTimes;
    }

}
