// Patient.java


/**
 * PatientPerson(extend to Person)
o	medicardNumber:String
o	issuranceCompeny:Sting
o	appliantID?:String
o	Method:
	setMedicarNumber
	setIssuranceCompeny
	setID
	setPatient(Sring,Date,String,Sting)
	getMedicarNumber
	getissuranceCompeny
	getPatient(Sring,Date,String,Sting)
 * 
 * create a class contains patient's informations, such as medical insurance number, insuarance company and contract number
 * @author Shuting Tang
 * @since 2023-12-14
 */

public class Patient extends Person{
    String medicalCardNumber;
    String issuranceCompeny;
    String contractNumber;

    public Patient(){
        super();
    }

    public Patient(String firstName,String lastName,String dateOfBirth, String theMedicalCardNumber, String theIssuranceCompeny, String theContractNumber){
        super(firstName, lastName, dateOfBirth);
        setMedicalCardNumber(theMedicalCardNumber);
        setIssuranceCompeny(theIssuranceCompeny);
        setContractNumber(theContractNumber);
    }

    public void setMedicalCardNumber(String theMedicalCardNumber){
        this.medicalCardNumber = theMedicalCardNumber;
    }

    public void setIssuranceCompeny(String theIssuranceCompeny){
        this.issuranceCompeny = theIssuranceCompeny;
    }

    public void setContractNumber(String theContractNumber){
        this.contractNumber = theContractNumber;
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


}
