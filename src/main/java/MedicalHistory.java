import java.util.List;
import java.util.ArrayList;

public class MedicalHistory {

    /*
     * • Previous medical conditions
     * • Surgeries
     * • Ongoing treatments
     * • Allergies
     */
    private List<String> conditions;        // Previous medical conditions
    private List<String> surgeries;         // Previous surgeries
    private List<String> ongoingTreatments; // Current ongoing treatments
    private List<String> allergies;         // Known allergies
    private String bloodType;               // Patient's blood type

    // Constructor
    public MedicalHistory(List<String> conditions, List<String> surgeries,
                          List<String> ongoingTreatments, List<String> allergies, String bloodType) {
        this.conditions = conditions;
        this.surgeries = surgeries;
        this.ongoingTreatments = ongoingTreatments;
        this.allergies = allergies;
        this.bloodType = bloodType;
    }

    // Alternative constructor with default empty lists
    public MedicalHistory() {
        this.conditions = new ArrayList<>();
        this.surgeries = new ArrayList<>();
        this.ongoingTreatments = new ArrayList<>();
        this.allergies = new ArrayList<>();
        this.bloodType = "N/A";
    }

    // Getters
    public List<String> getConditions() {
        return conditions;
    }

    public List<String> getSurgeries() {
        return surgeries;
    }

    public List<String> getOngoingTreatments() {
        return ongoingTreatments;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public String getBloodType() {
        return bloodType;
    }

    // Setters
    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public void setSurgeries(List<String> surgeries) {
        this.surgeries = surgeries;
    }

    public void setOngoingTreatments(List<String> ongoingTreatments) {
        this.ongoingTreatments = ongoingTreatments;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    // Methods to add individual items
    public void addCondition(String condition) {
        conditions.add(condition);
    }

    public void addSurgery(String surgery) {
        surgeries.add(surgery);
    }

    public void addOngoingTreatment(String treatment) {
        ongoingTreatments.add(treatment);
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blood Type: ").append(bloodType).append("\n");

        sb.append("Previous Conditions: ");
        if (conditions.isEmpty()) sb.append("None");
        else sb.append(String.join(", ", conditions));
        sb.append("\n");

        sb.append("Previous Surgeries: ");
        if (surgeries.isEmpty()) sb.append("None");
        else sb.append(String.join(", ", surgeries));
        sb.append("\n");

        sb.append("Ongoing Treatments: ");
        if (ongoingTreatments.isEmpty()) sb.append("None");
        else sb.append(String.join(", ", ongoingTreatments));
        sb.append("\n");

        sb.append("Allergies: ");
        if (allergies.isEmpty()) sb.append("None");
        else sb.append(String.join(", ", allergies));

        return sb.toString();
    }
}