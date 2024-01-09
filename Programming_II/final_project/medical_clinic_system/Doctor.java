// Doctor.java
package medical_clinic_system;

import java.util.ArrayList;

/**
 * This class contains the attributes of docter, such as  medichal school specialty.
 * And has a method to update the specailty.
 * 
 * @author Shuting Tang
 * @version 1.0
 * @since 2024-1-8
 * 
 */

public class Doctor extends Person {
    private String workId;
    private String medicalSchoolSpecialty;
    private String availableTime;
    private ArrayList<String> availableTimes = new ArrayList<>();


    public Doctor(){}

    public Doctor(String firstName, String lastName,String email, String phoneNumber,String workId){
        super(firstName, lastName, email, phoneNumber);
        setWorkId(workId);
    }

    public Doctor(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address, String theSpecialty){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setMedicalSchoolSpecialty(theSpecialty);
    }

    public void setMedicalSchoolSpecialty(String theSpecialty){
        this.medicalSchoolSpecialty = theSpecialty;
    }
    public void setWorkId(String theWorkID){
        this.workId = theWorkID;
    }
    public void setAvailableTime(String theAvailableTime){
        availableTimes.add(theAvailableTime);
        this.availableTime = theAvailableTime;
    }

    public String getMedicalSchoolSpecialty(){
        return this.medicalSchoolSpecialty;
    }
    public String getWorkId(){
        return this.workId;
    }
    public ArrayList<String> getAvailableTimes(){
        return this.availableTimes;
    }

    @Override
    public String toString(){
        StringBuilder newString =new StringBuilder();
        newString.append(this.firstname + ", ");
        newString.append(this.lastname + ", ");
        newString.append(this.email + ", ");
        newString.append(this.phoneNumber + ", ");
        newString.append(this.workId );
        return newString.toString();
    }

    public String toString(ArrayList<String> availableTimes){
        StringBuilder newString = new StringBuilder(); 
        int count = 1;
        for(String availableTime:availableTimes){
            newString.append(" " + count +". " + availableTime + "\n");
            count++;
        }
        return newString.toString();
    }

}
