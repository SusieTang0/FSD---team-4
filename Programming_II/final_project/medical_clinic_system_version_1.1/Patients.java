package medical_clinic_system;

import java.util.ArrayList;

public class Patients {
    private ArrayList<Patient> patientsList = new ArrayList<>();

    public Patients(){}
    
    public void addPatient(Patient patient){
        this.patientsList.add(patient);
    }

    public void removePatient(Patient patient){
        this.patientsList.remove(patient);
    }

    public ArrayList<Patient> getPatientsList(){
        return this.patientsList;
    }

    public Patient findPatient(String medicalNum){
        for(Patient aPatient:getPatientsList()){
            if(medicalNum.equals(aPatient.getMedicalCardNumber())){
                return aPatient;
            }
        }
        return null;
    }
}
