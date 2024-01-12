import java.io.*;
import java.util.*;

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

    public void CreateInvoice(Doctor doctor, Patient patient, Treatment treatment) {
        setDoctor(doctor);
        setPatient(patient);
        setTreatment(treatment);
    }

    public void PrintInvoice() {
        System.out.println();
        System.out.println("******** Medical Clinic Invoice ********");
        System.out.println("=======================================");

        System.out.printf(" Patient's Information %n %s %s %n %s %n %s %n",
                patient.getFirstName(), patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getAddress());

        System.out.printf("Doctor's Information %n %s %s %n %s %n %s %n",
                doctor.getFirstName(), doctor.getLastName(),
                doctor.getPhoneNumber(),
                doctor.getAddress());

        System.out.println("Treatment: " + treatment.getTreatmentName());
        System.out.println("Description: " + treatment.getDescription());
        System.out.printf("Cost: $%.2f", treatment.getCost());

        System.out.println();
        System.out.println("Thank you for choosing Medical Clinic!");
        System.out.println("Medical Clinic 123 Main St. | Montreal QC H6Z 0Y4 | Phone: 123-456-7890");
    }

    public void WriteInvoice() throws IOException {
        PrintWriter invoice = new PrintWriter("C:\\Users\\user\\Desktop\\FSD-11\\C3-Programming II\\Team Project\\Team Project-JavaII\\Invoice.txt");

        invoice.println();
        invoice.printf("%50s %n","******** Medical Clinic Invoice ********");
        invoice.printf("%50s %n","=======================================");
        invoice.println();
        invoice.println();
        invoice.printf("%s %n %s %s %n %s %n %s %n", " Patient's Information ",
                patient.getFirstName(), patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getAddress());
                invoice.println("");
        invoice.printf("Doctor's Information %n %s %s %n %s %n %s %n",
                doctor.getFirstName(), doctor.getLastName(),
                doctor.getPhoneNumber(),
                doctor.getAddress());
        invoice.println();
        invoice.println();
        invoice.printf("%s", "Treatment: " );
        invoice.printf("%26s","Description: " );
        invoice.printf("%26s %n","Cost: ");
        invoice.printf("%-23s %-32s %-20s ", treatment.getTreatmentName(), treatment.getDescription(), treatment.getCost());
        invoice.println();
        invoice.println();
        invoice.println();
        invoice.printf("%50s %n","Thank you for choosing Medical Clinic!");
        invoice.println("Medical Clinic 123 Main St. | Montreal QC H6Z 0Y4 | Phone: 123-456-7890");
        invoice.close();
    }

}// END Invoice class
