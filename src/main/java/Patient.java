import java.time.LocalDate;
// Create a constructor to initialize Patient's objects.
// and a list of methods to get and retrieve Patient's information.
// Patient usually has the following type of information:

/*
 * • Patient ID
 * • Name
 * • Date of Birth
 * • Gender
 * • ContactDetails
 * • MedicalHistory
 * • InsuranceDetails
 */



public class Patient {
    private String patientID;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private ContactDetails contactDetails;
    private MedicalHistory medicalHistory;
    private InsuranceDetails insuranceDetails;
    private Bed assignedBed;
    // Constructor
    public Patient(String patientID, String name, LocalDate dateOfBirth, String gender,
                   ContactDetails contactDetails, MedicalHistory medicalHistory,
                   InsuranceDetails insuranceDetails) {
        this.patientID = patientID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
        this.insuranceDetails = insuranceDetails;
        this.assignedBed = null;
    }
    public Patient() {
        this.patientID = "N/A";
        this.name = "N/A";
        this.dateOfBirth = null;
        this.gender = "N/A";
        this.contactDetails = null;
        this.medicalHistory = null;
        this.insuranceDetails = null;
        this.assignedBed = null;
    }


    // Getters
    public String getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public InsuranceDetails getInsuranceDetails() {
        return insuranceDetails;
    }

    public Bed getAssignedBed(){
        return assignedBed;
    }

    // Setters
    public void resetPatient(String patientID, String name, LocalDate dateOfBirth, String gender,
                             ContactDetails contactDetails, MedicalHistory medicalHistory,
                             InsuranceDetails insuranceDetails) {
        this.patientID = patientID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
        this.insuranceDetails = insuranceDetails;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public void assignBed(Bed assignedBed){
        assignedBed.setOccupied(true);
        this.assignedBed = assignedBed;
    }

    public void unAssignBed(){
        if (this.assignedBed != null){
            assignedBed.setOccupied(false);
            this.assignedBed = null;
        }
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID +
                "\nName: " + name +
                "\nDate of Birth: " + dateOfBirth +
                "\nGender: " + gender +
                "\n\n--- Contact Details ---\n" + contactDetails +
                "\n\n--- Medical History ---\n" + medicalHistory +
                "\n\n--- Insurance Details ---\n" + insuranceDetails +
                "\n\n--- Assigned Bed ---\n" + assignedBed;
    }

}


