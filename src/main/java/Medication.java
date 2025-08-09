public class Medication {
    private String name;
    private int dosage; // in mg
    private int frequencyPerDay; // e.g., 3 times a day

    public Medication(String name, int dosage, int frequencyPerDay) {
        this.name = name;
        this.dosage = dosage;
        this.frequencyPerDay = frequencyPerDay;
    }

    public int getDosage() {
        return dosage;
    }

    public int getFrequency() {
        return frequencyPerDay;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public void setFrequency(String frequency) {
        this.frequencyPerDay = frequencyPerDay;
    }

    @Override
    public String toString() {
        return name + " (" + dosage + ", " + frequencyPerDay + ")";
    }
}

