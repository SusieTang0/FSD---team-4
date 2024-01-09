package medical_clinic_system;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static int counter = -1;
    static Patient patient;
    static Doctor doctor;
    static ArrayList<Appointment> appointList = new ArrayList<>();
    static Doctors doctorList;
    public static void main(String[] args) {
        
        Doctor doctor1 = new Doctor("Amy","Smith","amy@123.com","111-222-3333","D0001");
        Doctor doctor2 = new Doctor("John","Rock","john@123.com","444-555-6666","D0002");
        Doctor doctor3 = new Doctor("Tommy","Potter","tommy@123.com","777-888-9999","D0003");
        doctor1.setAvailableTime("2024-01-25,15:00-16:00");
        doctor1.setAvailableTime("2024-01-27,10:00-11:00");
        doctor2.setAvailableTime("2024-02-25,15:00-16:00");
        doctor2.setAvailableTime("2024-02-27,10:00-11:00");
        doctor3.setAvailableTime("2024-02-05,13:00-14:00");
        doctor3.setAvailableTime("2024-02-17,08:00-09:00");

        doctorList = new Doctors();
        doctorList.addDoctor(doctor1);
        doctorList.addDoctor(doctor2);
        doctorList.addDoctor(doctor3);

        patient = new Patient("Shuting","Tang","123@123.com","123-456-7890","TANS123456");
        while(counter != 0){
            enterHomePage();
        }
        input.close();
    }

    /*
     * ===========================================
     * ********** Medical Clinic System **********
     * ===========================================
     * 1. Patient Entrance
     * 2. Doctor Entrance
     * 0. Exit Medical Clinic System 
     */
    private static void enterHomePage(){
        System.out.println("=======================================");
        System.out.println("******** Medical Clinic System ********");
        System.out.println("=======================================");
        System.out.printf(" 1. Patient Entrance\r\n" + 
                " 2. Doctor Entrance\r\n" + 
                " 3. Admin Entrance\r\n" + 
                " 0. Exit Medical Clinic System\r\n" +
                "---------------------------------------\r\n");
        System.out.println("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();

        if(number == 1){
            if(patient == null){
                createPatient();
            }
            patientPage();
        }else if(number == 2){
            validateDoctor();
            doctorPage(doctor);
        }else if(number == 3){
            int validation = validateAdmin();
            if(validation == 1){
                adminPage();
            }else{
                enterHomePage();
            }
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");

        }
    }


    public static void patientPage() {
        printPatientPageTitle();
        System.out.printf(" 1. Personal Information Edit\r\n" + 
                " 2. New Appointment Create\r\n" + 
                " 3. Medical Records\r\n" + 
                " 4. Payment Management\r\n" + 
                " 9. Exit To Previous Page\r\n" + 
                " 0. Exit Medical Clinic System\r\n" +
                "---------------------------------------\r\n");
        System.out.printf("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){  
            patientInfoEdit();
        }else if(number == 2){
            patientAppointments();
        }else if(number == 3){
            patientMedicalRecords();
        }else if(number == 4){
            patientPayments();
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
    }

     private static void createPatient() {
        String firstname,lastname,email,phoneNumber,medicalCardNumber;
        System.out.println("---------------------------------------");
        System.out.println("Please enter your information to sign up:");
        System.out.printf("Enter your firstname:");
        firstname = input.next();
        input.nextLine();
        System.out.printf("Enter your lastname:");
        lastname = input.next();
        input.nextLine();
        System.out.printf("Enter your e-mail:");
        email = input.next();
        input.nextLine();
        System.out.printf("Enter your phone number:");
        phoneNumber = input.next();
        input.nextLine();
        System.out.printf("Enter your medical card number:");
        medicalCardNumber = input.next();
        input.nextLine();
        patient = new Patient(firstname,lastname,email,phoneNumber,medicalCardNumber);
    }

    private static void patientInfoEdit(){
        printPatientPageTitle();
        System.out.printf("Patient Personal Info:"+
        "\n\tA. Firstname: %s " +
        "\n\tB. Lastname: %s" +
        "\n\tC. Age: %d " +
        "\n\tD. Sex: %s " +
        "\n\tE. Date of Birth: %s " +
        "\n\tF. Medical Card Number: %s" +
        "\n\tG. Insurance Company: %s " +
        "\n\tH. Insurance Contract Number: %s " +
        "\n\tI. E-mail: %s " +
        "\n\tJ. Phone Number: %s " +
        "\n\tK. Address: %s " +
        "\n\tL. Emergency Contact: %s " +
        "\n\tM. Phone Number of Emergency Contact: %s \n", 
        patient.getFirstName(),patient.getLastName(),patient.getAge(),patient.getSex(),patient.getDateOfBirth(),patient.getMedicalCardNumber(),
                patient.getIssuranceCompeny(), patient.getContractNumber(),
                patient.getEmail(),patient.getPhoneNumber(),patient.getAddress(),
                patient.getEmergencyContact(), patient.getPhoneNumOfEmergencyContact());
        printPatientPageEnding();
        System.out.println("Enter the letter to reset info or the number to exit (Ignore letter case): ");
        String number = input.next().toUpperCase();
        String newString,temp;
        if(number.hashCode() >= "A".hashCode()){
            System.out.println("Enter new info: ");
            newString = input.next();
            System.out.println("Do you want to complete the change? Y or N: ");
            temp = input.next().toUpperCase();
            System.out.println();
            if(number.equals("A")){
                if(temp.equals("Y")){
                    patient.setFirstName(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            }else if(number.equals("B")){
                if(temp.equals("Y")){
                    patient.setLastName(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("C")){
                if(temp.equals("Y")){
                    patient.setAge(Integer.parseInt(newString));
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("D")){
                if(temp.equals("Y")){
                    patient.setSex(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("E")){
                if(temp.equals("Y")){
                    patient.setDateOfBirth(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("F")){
                if(temp.equals("Y")){
                    patient.setMedicalCardNumber(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("G")){
                if(temp.equals("Y")){
                    patient.setInsuranceCompeny(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("H")){
                if(temp.equals("Y")){
                    patient.setContractNumber(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("I")){
                if(temp.equals("Y")){
                    patient.setEmail(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("J")){
                if(temp.equals("Y")){
                    patient.setPhoneNumber(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("K")){
                if(temp.equals("Y")){
                    patient.setAddress(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("L")){
                if(temp.equals("Y")){
                    patient.setEmergencyContact(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            } else if(number.equals("M")){
                if(temp.equals("Y")){
                    patient.setPhoneNumOfEmergencyContact(newString);
                    patientInfoEdit();
                }else{
                    patientPage();
                }
            }
        }else{
            if(number.equals("9")){
                System.out.println();
                patientPage();
            }else if(number.equals("0")){
                System.out.println("Exit now. Thank you for using Medical Clinic System!");
                counter = 0;
            }else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
            } 
        } 
    }

    private static void patientAppointments(){
        printPatientPageTitle();
        System.out.printf("Appointment Management    \r\n" +
                "---------------------------------------\r\n" + 
                " 1. Create a new appointment\r\n" + 
                " 2. Review existing appointments\r\n" + 
                " 9. Exit To Previous Page\r\n" + 
                " 0. Exit Medical Clinic System\r\n" +
                "---------------------------------------\r\n");
        System.out.printf("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){  
            createAppointment();
        }else if(number == 2){
            reviewAppointments();
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
        
    }

    private static void createAppointment(){
        printPatientPageTitle();
        System.out.printf("Create Appointment\n" + 
                "-------------------------------------------\n" +
                "Doctors In This Clinic: \n");
        for(Doctor aDoctor:doctorList.getDoctorsList()){
            System.out.printf(" %d. %s\n",doctorList.getDoctorsList().indexOf(aDoctor)+1, (aDoctor.getFirstName() + " " + aDoctor.getLastName()));
        }
        printPatientPageEnding();
        System.out.println("Please choose Your Doctor: ");
        int number = input.nextInt();
        input.nextLine();
        if(number <= doctorList.getDoctorsList().size() && number > 0){ 
            createNewAppointment(number);
        }else if(number == 9){
            patientAppointments();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. ");
            createAppointment();
        }
        
    }

    private static void createNewAppointment(int number){
        Doctor thisDoctor = doctorList.getDoctorsList().get(number-1);
        doctor = thisDoctor;
        System.out.println("Choose the time of the appointment: " ); 
        ArrayList<String> timeList =  thisDoctor.getAvailableTimes();
        for(String time:timeList){
            System.out.printf(" %d. %s", (timeList.indexOf(time)+1),time);
            System.out.println();
        }
        System.out.printf("Please enter number to choose the time: ");
        int newNumber = input.nextInt();
        String[] timeStrings = timeList.get(newNumber-1).split(",");
        System.out.println("the date is " + timeStrings[0]);
        Appointment appointment1 = new Appointment(timeStrings[0],timeStrings[1], thisDoctor, patient);
        appointList.add(appointment1);
        System.out.println(appointment1.toString());
        System.out.println("Do you want to make another appointmenr? Y or N: ");
        String letter = input.next().toUpperCase();
        if(letter.equals("Y")){
            createAppointment();
        }else if(letter.equals("N")){
            patientAppointments();
        }else{
            System.out.println("Invalid value.");
            patientAppointments();
        }
        
    }

    private static void reviewAppointments(){
        printPatientPageTitle();
        if(doctor==null){
            System.out.println("There's no appointment.Please create a new one.");
            createAppointment();
        }
        for(Appointment appointment:appointList){
            System.out.printf(" 1. Date: %s \tTime: %s \n    Doctor: %s \tPatient: %s\n",appointment.getDate(),appointment.getTime(),doctor.getName(),patient.getName());
        }
        
        printPatientPageEnding();
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 9){
            patientPage();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else if((number <= appointList.size()) && (number > 0)){
            System.out.println("Please enter 9 or 0: ");
            reviewAppointments();
        }else{
            System.out.println("Invalid Number. ");
            patientAppointments();
        }
    }

    private static void patientMedicalRecords(){
        printPatientPageTitle();
        System.out.println("This is patient medical record page");
        printPatientPageEnding();
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){ 

        }else if(number == 9){
            patientPage();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. ");
            patientMedicalRecords();
        }
    }

     private static void patientPayments(){
        printPatientPageTitle();
        System.out.println("This is patient Payments page");
        printPatientPageEnding();
        
    }

    private static void doctorPage(Doctor aDoctor) {
        printDoctorPageTitle();
        System.out.println("This is doctor page!");
        printPatientPageEnding();
    }

    private static void validateDoctor() {
        String workId,lastname;
        System.out.println("---------------------------------------");
        System.out.println("Please enter your workId to log in: ");
        workId = input.next();
        input.nextLine();
        System.out.println("Please enter your lastname: ");
        lastname = input.next();
        input.nextLine();
        System.out.println("validate the doctor info and then enter the page of doctor");
        // doctor = new Doctor(firstname,lastname,email,phoneNumber,workId);
    }

    
    private static int validateAdmin(){
        System.out.println("Please enter you admin code:");
        String adminCode = input.next();
        if(adminCode.equals("MedicalSecurity1234")){
            return 1;
        }else{
            System.out.println("Invalid code.");
            return -1;
        }
    }

    private static void adminPage(){
        printAdminPageTitle();
        System.out.printf(" 1. Add Doctor\n" + 
            " 2. Edit Doctor\n" + 
            " 3. Delete Doctor\n");
        printPatientPageEnding();    
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){
            createDoctor();
        }else if(number == 2){
            enterHomePage();
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. ");
            createAppointment();
        }
        System.out.println("this is admin page");
    }
    

    private static void createDoctor(){
        printAdminPageTitle();
        System.out.println("This is the page to create doctor");
        printPatientPageEnding();
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){
           
        }else if(number == 2){
            
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. ");
            adminPage();
        }
        
    }

    private static void doctoerInfoEdit(){
        printAdminPageTitle();
        System.out.println("This is the page to edit doctor's info");
        printPatientPageEnding();
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){
           
        }else if(number == 2){
            
        }else if(number == 0){
            System.out.println("Exit now. Thank you for using Medical Clinic System!");
            counter = 0;
        }else{
            System.out.println("Invalid Number. ");
            adminPage();
        }
    }
    

    private static void printPatientPageTitle(){
        System.out.println("=======================================");
        System.out.println(" Medical Clinic System -- Patient Page  ");
        System.out.println("=======================================");
    }

    private static void printPatientPageEnding(){
        System.out.println("---------------------------------------");
        System.out.println(" 9. Exit To Previous Page");
        System.out.println(" 0. Exit Medical Clinic System");
        System.out.println("---------------------------------------");
    }

    private static void printDoctorPageTitle(){
        System.out.println("=======================================");
        System.out.println(" Medical Clinic System -- Doctor Page  ");
        System.out.println("=======================================");
    }

     private static void printAdminPageTitle(){
        System.out.println("=======================================");
        System.out.println(" Medical Clinic System -- Admin Page   ");
        System.out.println("=======================================");
    }
    
}
