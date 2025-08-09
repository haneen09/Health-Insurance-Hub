public class Specialization {
    // Create a constructor to initialize Specialization's objects.
    // Specialization usually has the following type of information:

    /*
     * • Field of expertise (e.g., Cardiology, Neurology)
     */


    private String specialty;


    public Specialization(String specialty) {
        this.specialty = specialty;
    }


    public String getSpecialty() {
        return specialty;
    }


    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Specialty: " + specialty;
    }
}
