package medical_clinic_system;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.Diagnostic;

public class MedicalRecord {
    private String recordId;
    private LocalDate today;
    private Doctor doctor;
    private Patient patient;
    private Treatment treatment;
    private Prescription Prescription;

    public MedicalRecord(){
    }

    public MedicalRecord(Doctor doctor, Patient patient,Treatment treatment, Prescription Prescription){
        
        this.today = LocalDate.now();
        setDoctor(doctor);
        setPatient(patient);
        setTreatment(treatment);
        setPrescription(Prescription); 
        this.recordId = String.format(this.doctor.getWorkId() + String.join("",this.today.toString().split("-"))+ this.patient.getMedicalCardNumber());
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
        this.Prescription = aPrescription;
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
    public Prescription getPrescription(){
        return this.Prescription;
    }
    public String getRecordId(){
        return this.recordId;
    }

    @Override
    public String toString(){
        return String.format("Record ID: %20s \tDate: %s \n" +
        "Patient Name: %s \tMedical Card Number: %s \n"+
        "Doctor Name: %s \tDoctor Work ID: %s \n%s \n%s \n", this.recordId,this.today.toString(),patient.getName(),patient.getMedicalCardNumber(), doctor.getName(), doctor.getWorkId(),treatment.toString(), Prescription.toString()) ;
    }


}
