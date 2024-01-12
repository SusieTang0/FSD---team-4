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

public class Doctor extends Person{
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

    public String getShortAddress(){
        if(super.address ==null){
            super.address = "";
        }
        String[] newString = super.getAddress().split(",");
        StringBuilder result = new StringBuilder();
        for(String aString:newString){
            result.append(aString + "\n");
        }
        return result.toString();
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

    public String getAvailableTimesString(boolean count){
        StringBuilder newString = new StringBuilder();
        int number =1;
        if(count){
            newString.append(" "+ number+ ". ");
        }else{
            newString.append(" *. ");
        }
        for(String time:this.availableTimes){
            newString.append(time + "\n");
        }
        return newString.toString();
    }



    public boolean validatePassword(String aPassword){
        return this.password.equals(aPassword);
    }

    @Override
    public String toString(){
        StringBuilder newString =new StringBuilder();
        newString.append(this.workId);
        newString.append(" | " + super.firstname);
        newString.append(" | " + super.lastname);
        newString.append(" | " + super.age);
        newString.append(" | " + super.sex);
        newString.append(" | " + super.dateOfBirth);
        newString.append(" | " + super.email);
        newString.append(" | " + super.phoneNumber);
        newString.append(" | " + super.address);
        newString.append(" | " + this.medicalSchoolSpecialty);
        newString.append(" | " + this.password);
        newString.append(" | ");
        for(String time:this.availableTimes){
            newString.append(time + " / ");
        }
        newString.append(String.valueOf(this.availableTimes.size()));
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
        "\n *. Password: %s \n"+
        "\n *. Available Appointment Time: %s \n",
        getFirstName(), getLastName(),
        getWorkId(), getMedicalSchoolSpecialty(), 
        getAge(), getSex(), getDateOfBirth(),
        getEmail(), getPhoneNumber(), getAddress(), this.password,getAvailableTimesString(false));
        return temp;
    }

    
}
