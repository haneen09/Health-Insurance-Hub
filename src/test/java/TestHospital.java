import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class TestHospital {

    private HospitalImplementer hospitalImplementer;
    private HospitalSystem hospitalSystem;
    private Patient patient1;
    private Doctor doctor1;
    private Doctor doctor2;
    private Ward ward1;

    @Before
    public void setUp() {
        // Initialize Hospital System
        hospitalImplementer = new HospitalImplementer();
        hospitalSystem = hospitalImplementer.InitializeHospitalSystem(1, 1, 2);

        // Get references to the created objects
        patient1 = hospitalSystem.getPatientByID(1);
        doctor1 = hospitalSystem.getDoctorByID(1);
        doctor2 = hospitalSystem.getDoctorByID(2);
        ward1 = hospitalSystem.getWardByID(1);

        // Set up patient details
        ContactDetails pContact1 = new ContactDetails(
                "123 Main Street, Springfield",
                "+1-555-123-4567",
                "john.doe@example.com",
                "+1-555-987-6543"
        );

        List<String> pConditions1 = new ArrayList<>();
        pConditions1.add("Hypertension");
        pConditions1.add("Diabetes");

        List<String> pSurgeries1 = new ArrayList<>();
        pSurgeries1.add("Appendectomy");
        pSurgeries1.add("Knee Surgery");

        List<String> pOngoingTreatments1 = new ArrayList<>();
        pOngoingTreatments1.add("Blood Pressure Medication");

        List<String> pAllergies1 = new ArrayList<>();
        pAllergies1.add("Penicillin");
        pAllergies1.add("Peanuts");

        String pBloodType1 = "O+";

        MedicalHistory pMedicalHistory1 = new MedicalHistory(
                pConditions1,
                pSurgeries1,
                pOngoingTreatments1,
                pAllergies1,
                pBloodType1
        );

        InsuranceDetails pInsurance1 = new InsuranceDetails(
                "HealthCare Insurance Ltd.",
                "HC123456789",
                "Partial Coverage",
                LocalDate.of(2025, 12, 31)
        );

        patient1.resetPatient(
                patient1.getPatientID(),
                "John Doe",
                LocalDate.of(1990, 5, 15),
                "Male",
                pContact1,
                pMedicalHistory1,
                pInsurance1
        );

        // Set up doctor details
        doctor1.resetDoctor(
                doctor1.getDoctorID(),
                "Dr. Smith",
                new Specialization("Cardiology"),
                new Schedule("Mon-Fri", "9-5")
        );

        doctor2.resetDoctor(
                doctor2.getDoctorID(),
                "Dr. Brown",
                new Specialization("Neurology"),
                new Schedule("Mon-Fri", "10-6")
        );

        // Set up ward details
        List<Equipment> wEquipment1 = new ArrayList<>();
        wEquipment1.add(new Equipment("X-ray Machine", 5));
        wEquipment1.add(new Equipment("MRI Scanner", 2));
        wEquipment1.add(new Equipment("ECG Machine", 10));
        wEquipment1.add(new Equipment("Stethoscope", 50));
        ward1.setEquipments(wEquipment1);
    }

    @Test
    public void testHospitalSystemInitialization() {
        System.out.println("====================== TEST HOSPITAL INITIALIZATION ======================\n");
        assertNotNull("Hospital system should be initialized", hospitalSystem);
        assertEquals("Should have 1 patient", 1, hospitalSystem.getAllPatients().size());
        assertEquals("Should have 2 doctors", 2, hospitalSystem.getAllDoctors().size());
        assertEquals("Should have 1 ward", 1, hospitalSystem.getAllWards().size());
        assertNotNull("Patient 1 should be initialized correctly and stored in patients' list in HospitalSystem", hospitalSystem.getPatientByID(1));
        assertNotNull("Doctor 1 should be initialized correctly and stored in doctors' list in HospitalSystem", hospitalSystem.getDoctorByID(1));
        assertNotNull("Doctor 2 should be initialized correctly and stored in doctors' list in HospitalSystem", hospitalSystem.getDoctorByID(2));

        assertNotNull("Ward 1 should be initialized correctly and stored in wards' list in HospitalSystem", hospitalSystem.getWardByID(1));
        System.out.println("Hospital Initialized Successfully, with "+ hospitalSystem.getAllPatients().size()+" patients, "+ hospitalSystem.getAllDoctors().size()+" doctors, and "+ hospitalSystem.getAllWards().size()+" wards");
    }

    @Test
    public void testPatientAdmission() {
        System.out.println("====================== TEST PATIENT ADMISSION ======================\n");
        // Admit patient with different doctors
        AdmissionRecord admissionRecord1 = hospitalImplementer.Admit(patient1, ward1, doctor1);
        AdmissionRecord admissionRecord2 = hospitalImplementer.Admit(patient1, ward1, doctor2);

        // Verify admission records
        assertNotNull("First admission record should not be null", admissionRecord1);
        assertNotNull("Second admission record should not be null", admissionRecord2);
        assertEquals("Admission record 1 should have the correct patient", patient1, admissionRecord1.getPatient());
        assertEquals("Admission record 1 should have the correct doctor", doctor1, admissionRecord1.getDoctor());
        assertEquals("Admission record 2 should have the correct doctor", doctor2, admissionRecord2.getDoctor());
    }

    @Test
    public void testPatientTreatment() {
        System.out.println("====================== TEST PATIENT TREATMENT ======================\n");
        // First, admit the patient
        AdmissionRecord admissionRecord1 = hospitalImplementer.Admit(patient1, ward1, doctor1);
        AdmissionRecord admissionRecord2 = hospitalImplementer.Admit(patient1, ward1, doctor2);

        // Create treatment plans
        List<Medication> medications1 = new ArrayList<>();
        medications1.add(new Medication("Aspirin", 500, 1));
        medications1.add(new Medication("Ibuprofen", 250, 2));

        List<String> procedures1 = new ArrayList<>();
        procedures1.add("X-Ray");
        procedures1.add("Physical Therapy");

        TreatmentPlan treatmentPlan1 = new TreatmentPlan(medications1, procedures1, "Follow-up after a week.");

        List<Medication> medications2 = new ArrayList<>();
        medications2.add(new Medication("Amoxicillin", 250, 2));
        medications2.add(new Medication("Paracetamol", 150, 1));

        List<String> procedures2 = new ArrayList<>();
        procedures2.add("Blood Test");
        procedures2.add("CT Scan");

        TreatmentPlan treatmentPlan2 = new TreatmentPlan(medications2, procedures2, "Check-up in two weeks");

        // Treat the patient
        TreatedRecord treatedRecord1 = hospitalImplementer.Treat(admissionRecord1, treatmentPlan1);
        TreatedRecord treatedRecord2 = hospitalImplementer.Treat(admissionRecord2, treatmentPlan2);

        // Verify treated records
        assertNotNull("First treated record should not be null", treatedRecord1);
        assertNotNull("Second treated record should not be null", treatedRecord2);

        assertEquals("Treated record 1 should have correct patient",
                admissionRecord1.getPatient(), treatedRecord1.getPatient());
        assertEquals("Treated record 1 should have correct doctor",
                admissionRecord1.getDoctor(), treatedRecord1.getDoctor());
        assertEquals("Treated record 1 should have correct ward",
                admissionRecord1.getWard(), treatedRecord1.getWard());

        assertEquals("Treated record 1 should have correct treatment plan", treatmentPlan1, treatedRecord1.getTreatmentPlan());

        assertEquals("Treated record 1 should have correct patient",
                admissionRecord1.getPatient(), treatedRecord1.getPatient());
        assertEquals("Treated record 1 should have correct doctor",
                admissionRecord1.getDoctor(), treatedRecord1.getDoctor());
        assertEquals("Treated record 1 should have correct ward",
                admissionRecord1.getWard(), treatedRecord1.getWard());
        assertEquals("Treated record 2 should have correct treatment plan", treatmentPlan2, treatedRecord2.getTreatmentPlan());

    }

    @Test
    public void testPatientDischarge() {
        System.out.println("====================== TEST PATIENT DISCHARGE ======================\n");
        // First, admit the patient
        AdmissionRecord admissionRecord1 = hospitalImplementer.Admit(patient1, ward1, doctor1);
        AdmissionRecord admissionRecord2 = hospitalImplementer.Admit(patient1, ward1, doctor2);

        // Create treatment plans
        List<Medication> medications1 = new ArrayList<>();
        medications1.add(new Medication("Aspirin", 500, 1));
        medications1.add(new Medication("Ibuprofen", 250, 2));

        List<String> procedures1 = new ArrayList<>();
        procedures1.add("X-Ray");
        procedures1.add("Physical Therapy");

        TreatmentPlan treatmentPlan1 = new TreatmentPlan(medications1, procedures1, "Follow-up after a week.");

        List<Medication> medications2 = new ArrayList<>();
        medications2.add(new Medication("Amoxicillin", 250, 2));
        medications2.add(new Medication("Paracetamol", 150, 1));

        List<String> procedures2 = new ArrayList<>();
        procedures2.add("Blood Test");
        procedures2.add("CT Scan");

        TreatmentPlan treatmentPlan2 = new TreatmentPlan(medications2, procedures2, "Check-up in two weeks");

        // Treat the patient
        TreatedRecord treatedRecord1 = hospitalImplementer.Treat(admissionRecord1, treatmentPlan1);
        TreatedRecord treatedRecord2 = hospitalImplementer.Treat(admissionRecord2, treatmentPlan2);

        // Prepare discharge information
        DischargeSummary dischargeSummary1 = new DischargeSummary(
                "Patient is stable",
                "No complications",
                "Visit clinic on 2023-10-20"
        );

        DischargeSummary dischargeSummary2 = new DischargeSummary(
                "Patient responded well to antibiotics and vital signs are normal.",
                "Suspected infection ruled out, no abnormalities in scan",
                "Schedule a general check-up on 2023-11-10"
        );

        BillingDetails billingDetails = new BillingDetails(
                5000.0,  // Total cost
                2000.0,  // Insurance coverage
                3000.0,  // Outstanding balance
                "Credit Card", // Payment method
                true           // Payment status
        );

        // Choose best treatment and discharge
        int recoveryDays1 = treatedRecord1.getTreatmentPlan().getRecoveryDays();
        int recoveryDays2 = treatedRecord2.getTreatmentPlan().getRecoveryDays();

        DischargedRecord dischargedRecord;

        if (recoveryDays2 > recoveryDays1) {
            dischargedRecord = hospitalImplementer.Discharge(treatedRecord1, dischargeSummary1, billingDetails);
        } else {
            dischargedRecord = hospitalImplementer.Discharge(treatedRecord2, dischargeSummary2, billingDetails);
        }

        // Verify discharge record
        assertNotNull("Discharge record should not be null", dischargedRecord);
        assertEquals("Discharged record should have the correct patient", patient1, dischargedRecord.getPatient());
        assertEquals("Discharge record should have correct summary", dischargeSummary1, dischargedRecord.getDischargeSummary());
        assertEquals("Discharge record should have correct billing details", billingDetails, dischargedRecord.getBillingDetails());

        // Verify we discharged with the best treatment plan
        TreatedRecord bestTreatment = (recoveryDays2 > recoveryDays1) ? treatedRecord1 : treatedRecord2;
        assertTrue("Patient should be discharged with the most effective treatment",
                dischargedRecord.getTreatmentOutcome() == bestTreatment.getTreatmentPlan());
    }

    @Test
    public void testEndToEndProcess() {
        System.out.println("====================== TEST END TO END PROCESS ======================\n");
        // This test combines all steps into one comprehensive test

        // Step 1: Admit patient with different doctors
        AdmissionRecord admissionRecord1 = hospitalImplementer.Admit(patient1, ward1, doctor1);
        AdmissionRecord admissionRecord2 = hospitalImplementer.Admit(patient1, ward1, doctor2);

        // Step 2: Create and apply treatments

        List<Medication> medications1 = new ArrayList<>();
        medications1.add(new Medication("Aspirin", 500, 1));
        medications1.add(new Medication("Ibuprofen", 250, 2));

        List<String> procedures1 = new ArrayList<>();
        procedures1.add("X-Ray");
        procedures1.add("Physical Therapy");

        TreatmentPlan treatmentPlan1 = new TreatmentPlan(medications1, procedures1, "Follow-up after a week.");

        List<Medication> medications2 = new ArrayList<>();
        medications2.add(new Medication("Amoxicillin", 250, 2));
        medications2.add(new Medication("Paracetamol", 150, 1));

        List<String> procedures2 = new ArrayList<>();
        procedures2.add("Blood Test");
        procedures2.add("CT Scan");

        TreatmentPlan treatmentPlan2 = new TreatmentPlan(medications2, procedures2, "Check-up in two weeks");

        // Treat the patient
        TreatedRecord treatedRecord1 = hospitalImplementer.Treat(admissionRecord1, treatmentPlan1);
        TreatedRecord treatedRecord2 = hospitalImplementer.Treat(admissionRecord2, treatmentPlan2);


        // Step 3: Prepare discharge information
        DischargeSummary dischargeSummary1 = new DischargeSummary(
                "Patient is stable",
                "No complications",
                "Visit clinic on 2023-10-20"
        );

        DischargeSummary dischargeSummary2 = new DischargeSummary(
                "Patient responded well to antibiotics and vital signs are normal.",
                "Suspected infection ruled out, no abnormalities in scan",
                "Schedule a general check-up on 2023-11-10"
        );


        BillingDetails billingDetails = new BillingDetails(
                5000.0,  // Total cost
                2000.0,  // Insurance coverage
                3000.0,  // Outstanding balance
                "Credit Card", // Payment method
                true           // Payment status
        );

        // Step 4: Choose best treatment and discharge
        int recoveryDays1 = treatedRecord1.getTreatmentPlan().getRecoveryDays();
        int recoveryDays2 = treatedRecord2.getTreatmentPlan().getRecoveryDays();

        DischargedRecord dischargedRecord;

        if (recoveryDays2 > recoveryDays1) {
            dischargedRecord = hospitalImplementer.Discharge(treatedRecord1, dischargeSummary1, billingDetails);
            // Recovery days are lower for treatment 1, so it's better
            assertEquals("Treatment 1 should be chosen for discharge as it has fewer recovery days",
                    treatedRecord1.getTreatmentPlan(), dischargedRecord.getTreatmentOutcome());
        } else {
            dischargedRecord = hospitalImplementer.Discharge(treatedRecord2, dischargeSummary2, billingDetails);
            // Recovery days are lower for treatment 2, so it's better
            assertEquals("Treatment 2 should be chosen for discharge as it has fewer recovery days",
                    treatedRecord2.getTreatmentPlan(), dischargedRecord.getTreatmentOutcome());
        }

        // Verify the entire process was successful
        assertNotNull("End-to-end process should produce a valid discharge record", dischargedRecord);
        assertEquals("Discharged patient should be John Doe", "John Doe", dischargedRecord.getPatient().getPatientName());
        assertTrue("Payment should be completed successfully",
                dischargedRecord.getBillingDetails().isPaymentStatus());
    }
}

