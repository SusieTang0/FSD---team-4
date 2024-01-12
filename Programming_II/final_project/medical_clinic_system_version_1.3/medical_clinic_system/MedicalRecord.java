package medical_clinic_system;

import java.time.LocalDate;
import java.util.ArrayList;


public class MedicalRecord {
    private String recordId;
    private LocalDate today;
    private Doctor doctor;
    private Patient patient;
    private Treatment treatment;
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    public MedicalRecord(){}

    public MedicalRecord(Doctor doctor, Patient patient,Treatment treatment, Prescription Prescription){
        this.today = LocalDate.now();
        setDoctor(doctor);
        setPatient(patient);
        setTreatment(treatment);
        setPrescription(Prescription); 
        this.recordId = String.format(this.doctor.getWorkId() + String.join("",this.today.toString().split("-"))+ this.patient.getMedicalCardNumber());
        this.prescriptions.add(Prescription);
    }

    public void setDoctor(Doctor aDoctor){
        this.doctor = aDoctor;
    }
    public void setPatient(Patient aPatient){
        this.patient = aPatient;
    }
    public void setTreatment(Treatment aTreatment){
        this.treatment = aTreatment;
    }
    public void setPrescription(Prescription aPrescription){
        this.prescriptions.add(aPrescription);
    }

    public LocalDate getDate(){
        return this.today;
    }
    public Doctor getDoctor(){
        return this.doctor;
    }
    public Patient getPatient(){
        return this.patient;
    }
    public Treatment getTreatment(){
        return this.treatment;
    }
    public ArrayList<Prescription> getPrescriptions(){
        return this.prescriptions;
    }
    public String getRecordId(){
        return this.recordId;
    }

    public String prescripToString(){
        StringBuilder temp = new StringBuilder();
        for(Prescription aPrescription: getPrescriptions()){
            temp.append(aPrescription.toString() + "\n");
        }
        return this.recordId;
    }

    @Override
    public String toString(){
        return String.format("Record ID: %20s \tDate: %s \n" +
        "Patient Name: %s \tMedical Card Number: %s \n"+
        "Doctor Name: %s \tDoctor Work ID: %s \n%s \n%s \n", this.recordId,this.today.toString(),patient.getName(),patient.getMedicalCardNumber(), doctor.getName(), doctor.getWorkId(),treatment.toString(), prescripToString()) ;
    }

    public String displayInfo(){
        return String.format("Record ID: %20s \tDate: %s \n" +
        "Patient Name: %s \tMedical Card Number: %s \n"+
        "Doctor Name: %s \tDoctor Work ID: %s \n%s \n%s \n", this.recordId,this.today.toString(),patient.getName(),patient.getMedicalCardNumber(), doctor.getName(), doctor.getWorkId(),treatment.toString(), prescripToString()) ;
    }




}
