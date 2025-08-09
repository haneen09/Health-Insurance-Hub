public class Doctor {
    // Create a constructor to initialize Doctor's objects.
    // Doctor usually has the following type of information:

    /*
     * • Doctor ID
     * • Name
     * • Specialization
     * • Schedule
     */

    private String doctorID;
    private String doctorName;
    private Specialization doctorSpecialization;
    private Schedule doctorSchedule;

    public Doctor(String doctorID, String doctorName, Specialization doctorSpecialization,Schedule doctorSchedule){
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorSchedule = doctorSchedule;

    }

    public Doctor(){
        this.doctorID = "N/A";
        this.doctorName = "N/A";
        this.doctorSpecialization = new Specialization("N/A");
        this.doctorSchedule = new Schedule("N/A", "N/A");

    }

    public void resetDoctor(String doctorID, String doctorName, Specialization doctorSpecialization,Schedule doctorSchedule){
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorSchedule = doctorSchedule;
    }

    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }

    // Getter methods
    public String getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Specialization getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public Schedule getDoctorSchedule() {
        return doctorSchedule;
    }
    @Override
    public String toString() {
        return "Doctor ID: " + doctorID + "\n" +
                "Name: " + doctorName + "\n" +
                "Specialization: " + doctorSpecialization.toString() + "\n" +
                "Schedule: " + doctorSchedule.toString();
    }

}
