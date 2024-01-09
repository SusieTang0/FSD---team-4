package medical_clinic_system;
// Patient.java


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
    String issuranceCompeny;
    String contractNumber;
    String emergencyContact;
    String phoneNumOfEmergencyContact;

    public Patient(){
        super();
    }

    public Patient(String firstName, String lastName,String email, String phoneNumber, String medicalCardNumber){
        super(firstName, lastName, email, phoneNumber);
        setMedicalCardNumber(medicalCardNumber);
    }

    public Patient(String firstName, String lastName, int age, String sex, String dateOfBirth, String email, String phoneNumber, String address, String medicalCardNumber, String issuranceCompeny, String contractNumber, String emergencyContact,
    String phoneNumOfEmergencyContact){
        super(firstName, lastName, age, sex, dateOfBirth, email, phoneNumber, address);
        setMedicalCardNumber(medicalCardNumber);
        setInsuranceCompeny(issuranceCompeny);
        setContractNumber(contractNumber);
        setEmergencyContact(emergencyContact);
        setPhoneNumOfEmergencyContact(phoneNumOfEmergencyContact);
    }

    public void setMedicalCardNumber(String theMedicalCardNumber){
        this.medicalCardNumber = theMedicalCardNumber;
    }
    public void setInsuranceCompeny(String theIssuranceCompeny){
        this.issuranceCompeny = theIssuranceCompeny;
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
    
    public String getMedicalCardNumber(){
        return this.medicalCardNumber;
    }
    public String getIssuranceCompeny(){
        return this.issuranceCompeny;
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

}
