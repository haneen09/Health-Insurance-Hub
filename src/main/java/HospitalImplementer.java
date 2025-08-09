public class HospitalImplementer implements HIH {

    @Override
    public HospitalSystem InitializeHospitalSystem(int numOfPatients, int numOfWards, int numOfDoctors) {

        HospitalSystem hs = new HospitalSystem();

        for (int i = 0; i < numOfPatients; i++){
            Patient pTemp = new Patient();
            pTemp.setPatientID("P"+(i+1));
            hs.addPatient(pTemp);

        }

        for (int i = 0; i < numOfWards; i++){
            Ward wTemp = new Ward();

            for (int j = 0; j < wTemp.getCapacity(); j++){


                wTemp.addBed(new Bed("B"+(j+1)));
            }
            wTemp.setWardID("W"+(i+1));
            hs.addWard(wTemp);

        }

        for (int i = 0; i < numOfDoctors; i++){
            Doctor dTemp = new Doctor();
            dTemp.setDoctorID("D"+(i+1));
            hs.addDoctor(dTemp);
        }
        return hs;
    }

    @Override
    public AdmissionRecord Admit(Patient p, Ward w, Doctor d) {
        if (p == null || w == null || d == null) {
            System.out.println("Admit failed: Patient, Ward, or Doctor is null.");
            return null;
        }

        if (w.isFull()) {
            System.out.println("Admit failed: Ward is full.");
            return null;
        }

        Bed availableBed = w.getAvailableBed();
        if (availableBed == null) {
            System.out.println("Admit failed: No available bed.");
            return null;
        }


        p.assignBed(availableBed);

        AdmissionRecord admissionRecord = new AdmissionRecord(p, d, w);
        System.out.println("\n --- Patient admitted successfully --- \n" + "Patient: " +p.getPatientName() + " ("+p.getPatientID()+")\n"+"Doctor: " +d.getDoctorName()+"\nWard: "+w.getWardID());
        return admissionRecord;
    }

    @Override
    public TreatedRecord Treat(AdmissionRecord ar, TreatmentPlan tp) {
        if (ar == null) {
            System.out.println("Admission record is missing. Cannot proceed with treatment.");
            return null;
        }
        if (tp == null) {
            System.out.println("Treatment plan is missing. Cannot proceed with treatment.");
            return null;
        }

        tp.updateRecoveryDays();
        TreatedRecord treatedRecord = new TreatedRecord(
                ar.getPatient(),
                ar.getDoctor(),
                ar.getWard(),
                tp

        );

        String patientName = ar.getPatient().getPatientName();

        System.out.println("\n --- Patient treated successfully --- \n" + "Patient: " +ar.getPatient().getPatientName() + " ("+ar.getPatient().getPatientID()+")\n"+"Doctor: " +ar.getDoctor().getDoctorName()+"\nWard: "+ar.getWard().getWardID() + "\n"+ tp);
        return treatedRecord;
    }


    @Override
    public DischargedRecord Discharge(TreatedRecord tr, DischargeSummary ds, BillingDetails bd) {
        if (tr == null) {
            throw new IllegalArgumentException("Treated record cannot be null.");
        }
        tr.getPatient().unAssignBed();

        DischargedRecord dischargedRecord = new DischargedRecord(
                tr.getPatient(),
                tr.getDoctor(),
                tr.getWard(),
                tr.getTreatmentPlan(),
                ds,
                bd
        );

        System.out.println("\n --- Patient discharged successfully --- \n" + "Patient: " +tr.getPatient().getPatientName() + " ("+tr.getPatient().getPatientID()+")\n"+"Doctor: " +tr.getDoctor().getDoctorName()+"\nWard: "+tr.getWard().getWardID() +
                "\n"+ tr.getTreatmentPlan()+"Discharge Summary: "+ds +"\nBilling Details: "+bd+"\n");
        return dischargedRecord;
    }
}