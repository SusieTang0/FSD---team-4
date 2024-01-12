package medical_clinic_system;

import java.util.ArrayList;

public class Doctors{
    private ArrayList<Doctor> doctorsList = new ArrayList<>();

    public Doctors(){}

    public void addDoctor(Doctor doctor){
        this.doctorsList.add(doctor);
    }

    public ArrayList<Doctor> getDoctorsList(){
        return this.doctorsList;
    }

    public Doctor findDoctor(String workID){

        for(Doctor aDoctor:getDoctorsList()){
            if(workID.equals(aDoctor.getWorkId())){
                return aDoctor;
            }
        }
        return null;
    }


}
