package medical_clinic_system;
// Patient.java

import java.util.ArrayList;

/**
 * PatientPerson(extend to Person)
o	medicardNumber:String
o	issuranceCompeny:Sting
o	contractNumber:String
+++   emergencyContact:String
+++   phoneNumOfEmergencyContact:String
o	Method:
	setMedicarNumber(String )
	setIssuranceCompeny(String )
	setContractNumber(String )
+++   setEmergencyContact(String );
+++   setPhoneNumOfEmergencyContact(String);
	getMedicarNumber
	getissuranceCompeny
   getContractNumber
+++	  getEmergencyContact
+++   getPhoneNumOfEmergencyContact
 * 
 * create a class contains patient's informations, such as medical insurance number, insuarance company and contract number
 * @author Shuting Tang
 * @since 2023-12-14
 */

public class Patient extends Person{
    String medicalCardNumber;
    String insuranceCompeny;
    String contractNumber;
    String emergencyContact;
    String phoneNumOfEmergencyContact;
    String password;
    ArrayList<MedicalRecord> medicalRecordsList = new ArrayList<>();

    public Patient(){
        super();
    }
    public Patient(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address,String password){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setPassword(password);
    }

    public Patient(Person aPerson,String password){
        super(aPerson.getFirstName(), aPerson.getLastName(), aPerson.getAge(), aPerson.getSex(), aPerson.getDateOfBirth(), aPerson.getEmail(), aPerson.getPhoneNumber(), aPerson.getAddress());
        setPassword(password);
    }

    public Patient(String firstName, String lastName,String email, String phoneNumber, String medicalCardNumber,String password){
        super(firstName, lastName, email, phoneNumber);
        setMedicalCardNumber(medicalCardNumber);
        setPassword(password);
    }

    public Patient(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address, String medicalCardNumber, String insuranceCompeny, String contractNumber, String emergencyContact,String phoneNumOfEmergencyContact,String password){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setMedicalCardNumber(medicalCardNumber);
        setInsuranceCompeny(insuranceCompeny);
        setContractNumber(contractNumber);
        setEmergencyContact(emergencyContact);
        setPhoneNumOfEmergencyContact(phoneNumOfEmergencyContact);
        setPassword(password);
    }

    public void setMedicalCardNumber(String theMedicalCardNumber){
        this.medicalCardNumber = theMedicalCardNumber;
    }
    public void setInsuranceCompeny(String theInsuranceCompeny){
        this.insuranceCompeny = theInsuranceCompeny;
    }
    public void setContractNumber(String theContractNumber){
        this.contractNumber = theContractNumber;
    }
    public void setEmergencyContact(String theEmergencyContact){
        this.emergencyContact = theEmergencyContact;
    }
    public void setPhoneNumOfEmergencyContact(String thePhoneNumOfEmergencyContact){
        this.phoneNumOfEmergencyContact = thePhoneNumOfEmergencyContact;
    }
    public void setPassword(String thePassword){
        this.password = thePassword;
    }
    public void setMedicalRecords(MedicalRecord theMedicalRecord){
        this.medicalRecordsList.add(theMedicalRecord);
    }
    
    public String getMedicalCardNumber(){
        return this.medicalCardNumber;
    }
    public String getInsuranceCompeny(){
        return this.insuranceCompeny;
    }
    public String getContractNumber(){
        return this.contractNumber;
    }
    public String getEmergencyContact(){
        return this.emergencyContact;
    }
    public String getPhoneNumOfEmergencyContact(){
        return this.phoneNumOfEmergencyContact;
    }
    public ArrayList<MedicalRecord> getMedicalRecords(){
        return this.medicalRecordsList;
    }
    public boolean validatePassword(String aPassword){
        return this.password.equals(aPassword);
    }
    public void setPatientVariable(String medicalCardNumber, String insuranceCompeny, String contractNumber, String emergencyContact, String phoneNumOfEmergencyContact){
        setMedicalCardNumber(medicalCardNumber);
        setInsuranceCompeny(insuranceCompeny);
        setContractNumber(contractNumber);
        setEmergencyContact(emergencyContact);
        setPhoneNumOfEmergencyContact(phoneNumOfEmergencyContact);
    }

    @Override
    public void setFirstName(String firstName){
        super.setFirstName(firstName);
    }
    @Override
    public void setLastName(String theLastName){
        super.setLastName(theLastName);
    }
    @Override
    public void setAge(int theAge){
        super.setAge(theAge);
    }
    @Override
    public void setSex(String theSex){
        super.setSex(theSex);
    }
    @Override
    public void setDateOfBirth(String theDateOfBirth){
        super.setDateOfBirth(theDateOfBirth);
    }
    @Override
    public void setEmail(String theEmail){
        super.setEmail(theEmail);
    }
    @Override
    public void setPhoneNumber(String thePhoneNumber){
        super.setPhoneNumber(thePhoneNumber);
    }
    @Override
    public void setAddress(String theAddress){
        super.setAddress(theAddress);
    }

    @Override
    public String getFirstName(){
        return super.getFirstName();
    }

    @Override
    public String getLastName(){
        return super.getLastName();
    }

    @Override
    public int getAge(){
        return super.getAge();
    }

    @Override
    public String getDateOfBirth(){
        return super.getDateOfBirth();
    }

    @Override
    public String getEmail(){
        return super.getEmail();
    }

    @Override
    public String getPhoneNumber(){
        return super.getPhoneNumber();
    }

    @Override
    public String getAddress(){
        return super.getAddress();
    }

    @Override
    public String toString(){
        
        StringBuilder newString = new StringBuilder();
        newString.append(super.getFirstName() + ", ");
        newString.append(super.getLastName() + ", ");
        newString.append(super.getEmail() + ", ");
        newString.append(super.getPhoneNumber() + ", ");
        newString.append(this.medicalCardNumber + ", ");
        newString.append(this.insuranceCompeny + ", ");
        newString.append(this.contractNumber + ", ");
        newString.append(this.emergencyContact + ", ");
        newString.append(this.phoneNumOfEmergencyContact);
        
        return newString.toString();
        
    }

    public String displayInfo(){
        String temp = String.format(
        "\n *. Firstname: %-20s \t*. Lastname: %-20s " +
        "\n *. Age: %-25d \t*. Sex: %-20s " +
        "\n *. Date of Birth: %-15s \t*. Medical Card Number: %s" +
        "\n *. E-mail: %-20s \t*. Phone Number: %s \n" +
        "\n *. Insurance Company: %-15s " +
        "\n *. Insurance Contract Number: %s " +
        "\n *. Address: %s " +
        "\n *. Emergency Contact: %s " +
        "\n *. Phone Number of Emergency Contact: %s \n"+
        "\n *. Password: %s \n",
        this.firstname, this.lastname, this.age, this.sex, this.dateOfBirth, this.email, this.phoneNumber, this.address, this.medicalCardNumber, this.insuranceCompeny, this.contractNumber, this.emergencyContact, this.phoneNumOfEmergencyContact, this.password);
        return temp;
    }
}
