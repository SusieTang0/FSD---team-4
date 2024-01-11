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
    private String password;
    private String medicalSchoolSpecialty;
    private ArrayList<String> availableTimes = new ArrayList<>();


    public Doctor(){}

    public Doctor(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address, String password){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setPassword(password);
    }

    public Doctor(Person aPerson,String password){
        super(aPerson.getFirstName(), aPerson.getLastName(), aPerson.getAge(), aPerson.getSex(), aPerson.getDateOfBirth(), aPerson.getEmail(), aPerson.getPhoneNumber(), aPerson.getAddress());
        setPassword(password);
    }

    public Doctor(String firstName, String lastName,String email, String phoneNumber,String workId,String password){
        super(firstName, lastName, email, phoneNumber);
        setWorkId(workId);
        setPassword(password);
    }

    public Doctor(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address, String workId,String theSpecialty,String password){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setWorkId(workId);
        setMedicalSchoolSpecialty(theSpecialty);
        setPassword(password);
    }

    public void setMedicalSchoolSpecialty(String theSpecialty){
        this.medicalSchoolSpecialty = theSpecialty;
    }
    public void setWorkId(String theWorkID){
        this.workId = theWorkID;
    }
    public void setPassword(String thePassword){
        this.password = thePassword;
    }
    public void setAvailableTime(String theAvailableTime){
        this.availableTimes.add(theAvailableTime);
    }

    public void setDoctorVariable(String workId,String theSpecialty){
        setWorkId(workId);
        setMedicalSchoolSpecialty(theSpecialty);
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

    public boolean validatePassword(String aPassword){
        return this.password.equals(aPassword);
    }

    @Override
    public String toString(){
        StringBuilder newString =new StringBuilder();
        newString.append(this.workId);
        newString.append(" / " + this.firstname);
        newString.append(" / " + this.lastname);
        newString.append(" / " + this.email);
        newString.append(" / " + this.phoneNumber);
        for(String time:availableTimes){
            newString.append(" / " + time);
        }
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

    public String displayDoctorInfo(){
        String temp = String.format("\n *. Firstname: %-20s \t*. Lastname: %s " +
        "\n *. Work ID: %-20s \t*. Medical School Specialty: %s " +
        "\n *. Age: %-10d *. Sex: %-10s \t*. Date of Birth: %s " +
        "\n *. E-mail: %-20s \t*. Phone Number: %s " +
        "\n *. Address: %s " +
        "\n *. Password: %s \n",
        getFirstName(), getLastName(),
        getWorkId(), getMedicalSchoolSpecialty(), 
        getAge(), getSex(), getDateOfBirth(),
        getEmail(), getPhoneNumber(), getAddress(), this.password);
        return temp;
    }

}
