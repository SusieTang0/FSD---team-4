package medical_clinic_system;



public class Invoice {
    String invoiceNum;
    Doctor doctor;
    Patient patient;
    Treatment treatment;

    public Invoice() {
    }

    public Invoice(Doctor doctor, Patient patient, Treatment treatment) {
        
        this.doctor = doctor;
        this.patient = patient;
        this.treatment = treatment;
        this.invoiceNum = String.format("%s%s%s", doctor.getWorkId(),String.join("",treatment.getDate().split("-")),String.join("",treatment.getStartTime().split(":")),String.join("",treatment.getEndTime().split(":")),patient.getMedicalCardNumber(),String.join("",treatment.getDate().split("-")));
    }

    public void setDoctor(Doctor theDoctor) {
        this.doctor = theDoctor;
    }

    public void setPatient(Patient thePatient) {
        this.patient = thePatient;
    }

    public void setTreatment(Treatment theTreatment) {
        this.treatment = theTreatment;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public Treatment getTreatment() {
        return this.treatment;
    }

    public void CreateInvoice(Doctor doctor, Patient patient, Treatment treatment) {
        setDoctor(doctor);
        setPatient(patient);
        setTreatment(treatment);
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %s", doctor.toString(),patient.toString(),treatment.toString());

    }

    public String displayInfo() {
        String newString = String.format("Patient's Information\t\t\tDoctor's Information \n"+
        "%s\t\t%s \n%s\t%s \n%s\t\t%s \n"+
        "Treatment: %s \nCost: $%.2f "+
        "Thank you for choosing Medical Clinic!\");\r\n" + 
        "Medical Clinic 123 Main St. | Montreal QC H6Z 0Y4 | Phone: 123-456-7890 ",
        patient.getName(), doctor.getName(),
        patient.getPhoneNumber(),doctor.getPhoneNumber(),
        patient.getShortAddress(),doctor.getShortAddress(),
        treatment.getTreatment(), treatment.getCost());

        return newString;
    }


    public void PrintInvoice() {
        System.out.println();
        System.out.println("******** Medical Clinic Invoice ********");
        System.out.println("=======================================");


        String patientString = String.format(" Patient's Information \n \t%s %s \n\t%s \n\t%s \n",
                patient.getFirstName(), patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getShortAddress());

        String doctorString = String.format("\tDoctor's Information \n\t%s %s \n\t%s \n\t%s \n",
                doctor.getFirstName(), doctor.getLastName(),
                doctor.getPhoneNumber(),
                doctor.getShortAddress());

        System.out.println(patientString + "\t " + doctorString);

        System.out.println("Treatment: " + treatment.getTreatment());
        System.out.printf("Cost: $%.2f", treatment.getCost());

        System.out.println();
        System.out.println("Thank you for choosing Medical Clinic!");
        System.out.println("Medical Clinic 123 Main St. | Montreal QC H6Z 0Y4 | Phone: 123-456-7890");
    }

    

   


}// END Invoice class
