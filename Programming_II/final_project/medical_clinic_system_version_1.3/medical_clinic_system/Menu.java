// menu.java
package medical_clinic_system;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is menu class for user to do the option and display the result of the option
 * 
 * 
 * @version 1.02
 * @since 2024-01-10
 * @author Team 4 : Bo Sun(Leader), Shuting Tang, Shawnelle Mc Nichols, Evan Sharp
 */


public class Menu{
    static Scanner input = new Scanner(System.in);
    static int counter = -1;
    static Patient patient;
    static Doctor doctor;
    static int positionOfPatient,positionOfDoctor,positionOfAppointment,positionOfInvoice;
    static ArrayList<Appointment> appointList = new ArrayList<>();
    static ArrayList<Invoice> invoiceList = new ArrayList<>();
    static ArrayList<Doctor> doctorList = new ArrayList<>();
    static ArrayList<Patient> patientList = new ArrayList<>();

    public static void main(String[] args) {
        
        Doctor doctor1 = new Doctor("Amy","Smith","amy@123.com","111-222-3333","D0001","123123");
        Doctor doctor2 = new Doctor("John","Rock","john@123.com","444-555-6666","D0002","456456");
        Doctor doctor3 = new Doctor("Tommy","Potter","tommy@123.com","777-888-9999","D0003","789789");
        doctor1.setAvailableTime("2024-01-25 15:00");
        doctor1.setAvailableTime("2024-01-27 10:00");
        doctor2.setAvailableTime("2024-02-25 15:00");
        doctor2.setAvailableTime("2024-02-27 10:00");
        doctor3.setAvailableTime("2024-02-05 13:00");
        doctor3.setAvailableTime("2024-02-17 08:00");

      
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);

        Patient patient1 = new Patient("Shuting","Tang","123@123.com","123-456-7890","TANS123456","asdasd");
        Patient patient2 = new Patient("Bo","Sun","456@456.com","456-789-0123","SUNB098765","qweqwe");
        Patient patient3 = new Patient("Evan","Sharp","789@789.com","789-012-3456","SHAE112233","zxczxc");

        Treatment treatment1 = new Treatment("new treatment", "2024-01-09", "12:00", "13:00", 105.23);
        Treatment treatment2 = new Treatment("Another treatment");
        Prescription prescription1 = new Prescription("Medicine Name",3,"Medicine Using description");
        Prescription prescription2 = new Prescription("Another Medicine Name",2,"Medicine Using description for test");

        Appointment appointment1 = new Appointment("2024-01-12 12:00", doctor3, patient3);
        Appointment appointment2 = new Appointment("2024-01-12 15:00", doctor3, patient1);
        Appointment appointment3 = new Appointment("2024-01-12 09:00", doctor3, patient2);

        appointList.add(appointment3);
        appointList.add(appointment1);
        appointList.add(appointment2);

        invoiceList.add(new Invoice(doctor3, patient2, treatment1));

        MedicalRecord record1 = new MedicalRecord(doctor3, patient2, treatment1, prescription1);
        MedicalRecord record2 = new MedicalRecord(doctor1, patient2, treatment1, prescription1);
        MedicalRecord record3 = new MedicalRecord(doctor1, patient2, treatment1, prescription1);
        MedicalRecord record4 = new MedicalRecord(doctor3, patient2, treatment2, prescription1);
        MedicalRecord record5 = new MedicalRecord(doctor1, patient2, treatment2, prescription1);
        MedicalRecord record6 = new MedicalRecord(doctor1, patient2, treatment2, prescription1);
        MedicalRecord record7 = new MedicalRecord(doctor3, patient2, treatment2, prescription2);
        MedicalRecord record8 = new MedicalRecord(doctor1, patient2, treatment2, prescription2);
        MedicalRecord record9 = new MedicalRecord(doctor1, patient2, treatment2, prescription2);
        MedicalRecord record10 = new MedicalRecord(doctor3, patient2, treatment1, prescription2);
        MedicalRecord record11 = new MedicalRecord(doctor1, patient2, treatment1, prescription2);
        MedicalRecord record12 = new MedicalRecord(doctor1, patient2, treatment1, prescription2);
        
        
        patient2.setMedicalRecords(record1);
        patient2.setMedicalRecords(record2);
        patient2.setMedicalRecords(record3);
        patient2.setMedicalRecords(record4);
        patient2.setMedicalRecords(record5);
        patient2.setMedicalRecords(record6);
        patient2.setMedicalRecords(record7);
        patient2.setMedicalRecords(record8);
        patient2.setMedicalRecords(record9);
        patient2.setMedicalRecords(record10);
        patient2.setMedicalRecords(record11);
        patient2.setMedicalRecords(record12);
        
       
        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        doctor = doctor3;
        patient = patient2;
        // receptioist1 = ReceptionFirst
        // receptioist2 = ReceptionSecond 
        // admin code = MedicalSecurity1234
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
     * 3. Receptionist Entrance
     * 4. Admin Entrance
     * 0. Exit Medical Clinic System 
     * ---------------------------------------
     */
    private static void enterHomePage(){
        printHomePageTitle();
        System.out.printf("  1. Patient Entrance\r\n" + 
                "  2. Doctor Entrance\r\n" + 
                "  3. Receptionist Entrance\r\n" + 
                "  4. Admin Entrance\r\n" + 
                " -1. Exit Medical Clinic System\r\n\n" +
                "---------------------------------------\r\n\n");
        System.out.println("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();

        if(number == 1){
            if(patient == null){
                validatePatient();;
            }else{
                enterPatientPage();
            }
        }else if(number == 2){
            if(doctor == null){
                validateDoctor();
            }else{
                enterDoctorPage();
            }
        }else if(number == 3){
            if(validateReceptionist() == 1){
                enterReceptionistPage();
            }else{
                enterHomePage();
            }
        }else if(number == 4){
            if(validateAdmin() == 1){
                enterAdminPage();
            }else{
                enterHomePage();
            }
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
    } // end method enterHomePage

    private static void signInFailedPage() {
        System.out.println("-----------------------------------------");
        System.out.printf("  Welcome to XXX Medical Clinic \n"+
        "  You can book your first appointment by phone.\n"+
        "  After first visit you will get your account.\n"+
        "  \nOur Phone Number:  \n\n" +
        "  Have a good day! ");
        System.out.println("-----------------------------------------");
        System.out.println("Press any key to quit: "+ input.nextLine());
        enterHomePage();
    } // signInPatientPage

    // Sign-in Validations
    public static void validatePatient() {
        printSignInTitle();
        System.out.println("-----------  Patient Sign-In  -----------");
        System.out.println("Medical Card Number(case sensitive): ");
        String account = input.next();
        input.nextLine();
        System.out.println("Password(case sensitive): ");
        String password = input.next();
        input.nextLine();
        patient = findPatient(account);
        if(patient == null){
            System.out.println("Account not exist.");
            signInFailedPage();
        }else{
            if(patient.validatePassword(password)){
                enterPatientPage(); 
            }else{
                System.out.println("Invalid account.Do you want to try again? Y or N: ");
                String letter = input.next();
                input.nextLine();
                System.out.println();
                if(letter.equalsIgnoreCase("Y")){
                    validatePatient();
                }else if(letter.equalsIgnoreCase("N")){
                    signInFailedPage();
                }else{
                    System.out.println("Invalid Value. Turn to the previous page.");
                    signInFailedPage();
                }
            }
        }
    } // end method validatePatient

    private static void validateDoctor() {
        printSignInTitle();
        String workId,password;
        System.out.printf("-----------  Doctor Sign-In  -----------\n");
        System.out.println("Please enter your workId to log in: ");
        workId = input.next();
        input.nextLine();
        System.out.println("Please enter your password: ");
        password = input.next();
        input.nextLine();
        doctor = findDoctor(workId);
        if(doctor == null){
            System.out.println("Account not exist.");
            signInFailedPage();
        }else{
            if(doctor.validatePassword(password)){
                enterDoctorPage(); 
            }else{
                System.out.println("Invalid account.Do you want to try again? Y or N: ");
                String letter = input.next();
                input.nextLine();
                System.out.println();
                if(letter.equalsIgnoreCase("Y")){
                    validateDoctor();
                }else if(letter.equalsIgnoreCase("N")){
                    enterHomePage();
                }else{
                    System.out.println("Invalid Value. Turn to the previous page.");
                    enterHomePage();
                }
            }
        }

    }// end method validateDoctor
  
    private static int validateReceptionist(){
        System.out.println("Please enter you reception code:");
        String adminCode = input.next();
        if(adminCode.equals("ReceptionSecond") || adminCode.equals("ReceptionFirst")){
            return 1;
        }else{
            System.out.println("Invalid code.");
            return -1;
        }
    }// end method validateReceptionist

    private static int validateAdmin(){
        System.out.println("Please enter you admin code:");
        String adminCode = input.next();
        if(adminCode.equals("MedicalSecurity1234")){
            return 1;
        }else{
            System.out.println("Invalid code.");
            return -1;
        }
    } // end method validateAdmin

    public static Patient findPatient(String medicalNum){
        for(Patient aPatient:patientList){
            if(medicalNum.equals(aPatient.getMedicalCardNumber())){
                return aPatient;
            }
        }
        return null;
    }// end find doctor

    public static Doctor findDoctor(String workID){
        for(Doctor aDoctor:doctorList){
            if(workID.equals(aDoctor.getWorkId())){
                return aDoctor;
            }
        }
        return null;
    }

    // Patient Page Start
    public static void enterPatientPage() {
        printPatientPageTitle();
        System.out.printf("  1. Edit Personal Information\r\n" + 
                "  2. Create New Appointment\r\n" + 
                "  3. View Existing Appointment\r\n" + 
                "  4. View Medical Record\r\n" + 
                "  5. View Invoice\r\n");
        printLogEnding();
        System.out.printf("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){  
            viewPatientInfo();
        }else if(number == 2){
            createAppointment();
        }else if(number == 3){
            viewAppointments();
        }else if(number == 4){
            viewMedicalRecords();
        }else if(number == 5){
            patientPayments();
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
    }

    private static void viewPatientInfo(){
        printPatientPageTitle();
        System.out.println("--------  Personal Information  ---------");
        System.out.printf("\n *. Firstname: %-20s \t*. Lastname: %-20s " +
        "\n *. Age: %-25d \t*. Sex: %-20s " +
        "\n *. Date of Birth: %-15s \t*. Medical Card Number: %s" +
        "\n *. E-mail: %-20s \t*. Phone Number: %s \n" +
        "\n A. Insurance Company: %-15s " +
        "\n B. Insurance Contract Number: %s " +
        "\n C. Address: %s " +
        "\n D. Emergency Contact: %s " +
        "\n E. Phone Number of Emergency Contact: %s \n"+
        "\n F. Change Password \n", 
        patient.getFirstName(),patient.getLastName(),patient.getAge(),patient.getSex(),patient.getDateOfBirth(),patient.getMedicalCardNumber(),
        patient.getEmail(),patient.getPhoneNumber(),
        patient.getInsuranceCompeny(), patient.getContractNumber(),patient.getAddress(),
        patient.getEmergencyContact(), patient.getPhoneNumOfEmergencyContact());
        printLogEnding();
        
        System.out.println("Enter the letter to reset info or the number to exit \n(Ignore letter case and \'*\' mains can't edit): ");
        String letter = input.next();
        input.nextLine();
        System.out.println();
        if((letter.hashCode() >=65) && (letter.hashCode() <= 122) ){
            System.out.println("Enter new info: ");
            String newString = input.nextLine();
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            input.nextLine();
            if(letter.equalsIgnoreCase("A")){
                if(temp.equalsIgnoreCase("Y")){
                    patient.setInsuranceCompeny(newString);
                    viewPatientInfo();
                }else{
                    enterPatientPage();
                }
            } else if(letter.equalsIgnoreCase("B")){
                if(temp.equalsIgnoreCase("Y")){
                    patient.setContractNumber(newString);
                    viewPatientInfo();
                }else{
                    enterPatientPage();
                }
            } else if(letter.equalsIgnoreCase("C")){
                if(temp.equalsIgnoreCase("Y")){
                    patient.setAddress(newString);
                    viewPatientInfo();
                }else{
                    enterPatientPage();
                }
            } else if(letter.equalsIgnoreCase("D")){
                if(temp.equalsIgnoreCase("Y")){
                    patient.setEmergencyContact(newString);
                    viewPatientInfo();
                }else{
                    enterPatientPage();
                }
            } else if(letter.equalsIgnoreCase("E")){
                if(temp.equalsIgnoreCase("Y")){
                    patient.setPhoneNumOfEmergencyContact(newString);
                    viewPatientInfo();
                }else{
                    enterPatientPage();
                }
            } else if(letter.equalsIgnoreCase("F")){
                if(temp.equalsIgnoreCase("Y")){
                    if(patient.validatePassword(newString)){
                        System.out.println("The new password is the same as the old one. Password reset failed.");
                        viewPatientInfo();
                    }else{
                        System.out.println("Password Reset Successful.");
                        patient.setPassword(newString);
                        viewPatientInfo();
                    }
                }else{
                    enterPatientPage();
                }
            }else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
                viewPatientInfo();
            }
        }else{
            if(letter.equals("9")){
                enterPatientPage();
            } else if(letter.equals("0")){
                logOut();
            } else if(letter.equals("-1")){
                exitSystem();
            } else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
                viewPatientInfo();
            } 
        }
    }

    private static void patientAppointments(){
        printPatientPageTitle();
        System.out.printf("Appointment Management    \r\n" +
                "---------------------------------------\r\n" + 
                " 1. Create a new appointment\r\n" + 
                " 2. Review existing appointments\r\n");
        printLogEnding();
        System.out.printf("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){  
            if (appointList.size()<=5) {
                createAppointment();
            }else{
                System.out.println("You have exceeded the maximum number of reservations.");
                enterPatientPage();
            }
        }else if(number == 2){
            viewAppointments();
        }else if(number == 9){
            enterPatientPage();;
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
        
    }

    private static void createAppointment(){
        printPatientPageTitle();
        System.out.printf("Create Appointment\n" + 
                "-------------------------------------------\n" +
                "Doctors In This Clinic: \n");
        for(Doctor aDoctor:doctorList){
            System.out.printf(" %d. %s\n phone: %s\n",doctorList.indexOf(aDoctor)+1, (aDoctor.getFirstName() + " " + aDoctor.getLastName()),aDoctor.getPhoneNumber());
        }
        printLogEnding();
        System.out.println("Please choose Your Doctor: ");
        int number = input.nextInt();
        input.nextLine();
        if(number <= doctorList.size() && number > 0){ 
            chooseAppointTime(number);
        }else if(number == 9){
            patientAppointments();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid Number. ");
            createAppointment();
        }
    }// end method createAppointment

    private static void chooseAppointTime(int number){
        Doctor thisDoctor = doctorList.get(number-1);
        doctor = thisDoctor;
        System.out.println("Choose the time of the appointment: " ); 
        ArrayList<String> timeList =  thisDoctor.getAvailableTimes();
        for(String time:timeList){
            System.out.printf(" %d. %s", (timeList.indexOf(time)+1),time);
            System.out.println();
        }
        System.out.printf("Please enter number to choose the time: ");
        int newNumber = input.nextInt();
        String[] timeStrings = timeList.get(newNumber-1).split(" ");
        System.out.println("the date is " + timeStrings[0]);

        Appointment appointment1 = new Appointment(timeList.get(newNumber-1), thisDoctor, patient);
        input.nextLine();
        appointList.add(appointment1);
        System.out.println(appointment1.toString());
        System.out.println("Do you want to make another appointmenr? Y or N: ");
        String letter = input.next();
        if(letter.equalsIgnoreCase("Y")){
            createAppointment();
        }else if(letter.equalsIgnoreCase("N")){
            patientAppointments();
        }else{
            System.out.println("Invalid value.");
            patientAppointments();
        }
        
    }

    private static void viewAppointments(){
        printPatientPageTitle();
        if(doctor==null){
            System.out.println("There's no appointment.Please create a new one.");
            createAppointment();
        }
        for(Appointment appointment:appointList){
            System.out.printf(appointment.toString());
        }
        
        printLogEnding();
        System.out.printf("Enter the number 1-%d to delete the appointment: ",appointList.size());
        int number = input.nextInt();
        input.nextLine();
        
        if(number == 9){
            enterPatientPage();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else if((number <= appointList.size()) && (number > 0)){
            System.out.println(appointList.get(number).toString());
            System.out.println("Do you want to delete this appointment? Y or N ");
            String letter = input.next();
            if(letter.equalsIgnoreCase("Y")){
                appointList.remove(number);
            }
            viewAppointments();
        }else{
            System.out.println("Invalid Number. ");
            patientAppointments();
        }
    }

    private static void viewMedicalRecords(){
        printPatientPageTitle();
        int[] count = new int[]{0,1,1};
        ArrayList<MedicalRecord> temp = patient.getMedicalRecords();
        if(temp == null){
            System.out.printf("There is no medical record here. \nTurn to the patient home page.\n");
            enterPatientPage();
        }
        while(count[0] <= temp.size()){
            if((temp.size() <= 5) && (temp.size() - 1 == count[0])){
                printLogEnding();
                System.out.println("Please enter the number: ");
                int number = input.nextInt();
                input.nextLine();
                if(number == 9){
                    enterPatientPage();
                }else if(number == 0){
                    logOut();
                }else if(number == -1){
                    exitSystem();
                }else{
                    System.out.println("Invalid Number. ");
                    viewMedicalRecords();
                }
            }else if(temp.size() > 5){
                if((count[1] == 6) && (count[0] <= 5)){
                    System.out.printf("6. Next Page\n");
                    printLogEnding();
                    System.out.println("Please enter the number: ");
                    int number = input.nextInt();
                    input.nextLine();
                    if(number == 6){ 
                        count[1] = 1;
                        count[2] += 1;
                        printPatientPageTitle();
                    }else if(number == 9){
                        enterPatientPage();
                    }else if(number == 0){
                        logOut();
                    }else if(number == -1){
                        exitSystem();
                    }else{
                        System.out.println("Invalid Number. ");
                        viewMedicalRecords();
                    }
                }else if((count[1] == 6 ) && (count[0] <= (temp.size() - temp.size()%5))){
                    System.out.printf("6. Preceding Page\n" +
                    "7. Next Page\n");
                    printLogEnding();
                    System.out.println("Please enter the number: ");
                    int number = input.nextInt();
                    input.nextLine();
                    if(number == 6){ 
                        count[1] = 1;
                        count[0] -= 10;
                        count[2] -= 1;
                        printPatientPageTitle();
                    }else if(number == 7){
                        count[1] = 1;
                        count[2] += 1;
                        printPatientPageTitle();
                    }else if(number == 9){
                        enterPatientPage();
                    }else if(number == 0){
                        logOut();
                    }else if(number == -1){
                        exitSystem();
                    }else{
                        System.out.println("Invalid Number. ");
                        viewMedicalRecords();
                    }
                }else if((count[0] == temp.size()) && (count[0] % 5 !=0)){
                    System.out.printf("6. Preceding Page");
                    printLogEnding();
                    System.out.println("Please enter the number: ");
                    int number = input.nextInt();
                    input.nextLine();
                    if(number == 6){
                        count[0] -= (5 + count[1]-1);
                        count[1] = 1;
                        count[2] -= 1;
                        printPatientPageTitle();
                    }else if(number == 9){
                        enterPatientPage();
                    }else if(number == 0){
                        logOut();
                    }else if(number == -1){
                        exitSystem();
                    }else{
                        System.out.println("Invalid Number. ");
                        viewMedicalRecords();
                    } 
                }
            }
            System.out.printf("%s. \n%s\n",count[1],temp.get(count[0]).toString());
            count[0]++;
            count[1]++;
        }// end while loop
    } // end method patientMedicalRecords

    private static void patientPayments(){
        printPatientPageTitle();
        System.out.println("----------  Patient Invoices  -----------");
        for(Invoice aInvoice:invoiceList){
            
            if(aInvoice.getPatient().equals(patient)){
                System.out.println(aInvoice.displayInfo());
            }
        }
        
        printLogEnding();
        System.out.println("Press any key to go out."+ input.next());
       
    } // end method patientPayments

    // Doctor Page Start
    public static void enterDoctorPage() {
        printDoctorPageTitle();
        ArrayList<Appointment> todayAppointments = viewTodayAppointment(doctor);
        System.out.printf("  1. Edit Personal Information \r\n" + 
                "  2. View & Edit Today's Appointment\r\n" + 
                "  3. Patient Record Menagement\r\n");
        printLogEnding();
        System.out.printf("Please select a number from the list above and enter it: ");
        int number = input.nextInt();
        System.out.println();
        if(number == 1){
            viewDoctorInfo();
        }else if(number == 2){
            viewDoctorAppointments(todayAppointments);
        }else if(number == 3){
            managePatientMR(todayAppointments);
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid Number. Please enter the number in the list.");
        }
    }
    
    private static void viewDoctorInfo(){
        printDoctorPageTitle();
        System.out.println("--------  Personal Information  ---------");
        System.out.printf(" *. Firstname: %-20s \t*. Lastname: %-20s \n" +
        " *. Work ID: %-20s \t*. Medical School Specialty: %s \n" +
        " *. Age: %-25d \t*. Sex: %-20s \t*. Date of Birth: %-15s \n" +
        " *. E-mail: %-20s \t*. Phone Number: %s \n" +
        " A. Address: %-15s \n" +
        " B. Change Password \n", 
        doctor.getFirstName(),doctor.getLastName(),
        doctor.getWorkId(),doctor.getMedicalSchoolSpecialty(),
        doctor.getAge(),doctor.getSex(),doctor.getDateOfBirth(),
        doctor.getEmail(),doctor.getPhoneNumber(),
        doctor.getAddress());
        printLogEnding();
        
        System.out.println("Enter the letter to reset info or the number to exit \n(Ignore letter case and \'*\' mains can't edit): ");
        String letter = input.next();
        input.nextLine();
        System.out.println();
        if((letter.hashCode() >=65) && (letter.hashCode() <= 122) ){
            System.out.println("Enter new info: ");
            String newString = input.nextLine();
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            input.nextLine();
            if(letter.equalsIgnoreCase("A")){
                if(temp.equalsIgnoreCase("Y")){
                    doctor.setAddress(newString);
                    viewDoctorInfo();
                }else{
                    enterDoctorPage();
                }
            } else if(letter.equalsIgnoreCase("B")){
                if(temp.equalsIgnoreCase("Y")){
                    if(doctor.validatePassword(newString)){
                        System.out.println("The new password is the same as the old one. Password reset failed.");
                        viewDoctorInfo();
                    }else{
                        System.out.println("Password Reset Successful.");
                        doctor.setPassword(newString);
                        viewDoctorInfo();
                    }
                }else{
                    enterDoctorPage();
                }
            }else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
                viewDoctorInfo();
            }
        }else{
            if(letter.equals("9")){
                enterDoctorPage();
            } else if(letter.equals("0")){
                logOut();
            } else if(letter.equals("-1")){
                exitSystem();
            } else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
                viewDoctorInfo();
            } 
        }
    } // end method viewDoctorInfo

    private static void viewDoctorAppointments(ArrayList<Appointment> theTodayAppointments){
        ArrayList<Appointment> todayAppointments = theTodayAppointments;
        printDoctorPageTitle();
        if(todayAppointments.size() == 0){
            System.out.println("There is no appointment today.");
            enterDoctorPage();
        }
        int[] count = new int[]{0,0,0,0};
        int[] newCount = displayList(todayAppointments,count,true,false);

        System.out.println("Please enter the number to edit or to quit: ");
        int number = input.nextInt();
        System.out.println();
       
        
        if(number > 0 && number< 6){
            patient = todayAppointments.get(number-1).getAppointmentPatient();
            editPatientMR(todayAppointments.get(number-1),null,false);
        }else if(number == 9){
            enterDoctorPage();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid value. ");
            enterDoctorPage();
        }
    }// end method viewDoctorAppointments

    private static void managePatientMR(ArrayList<Appointment> todayAppointments){
        printDoctorPageTitle();
        System.out.printf("Please enter the Medical Card Number of the Patient:  \n");
        String newString = input.next();
        System.out.println();

        patient = findPatient(newString);
        
        if(patient == null){
            System.out.println("This patient is not exist.Try again.");
            managePatientMR(todayAppointments);
        }else{

            int[] count = new int[]{0,0,0,0};
            int[] newCount = displayList(todayAppointments,count,true,false);
            int number = newCount[3];
            
            if(number > 0 && number< 6){
                editPatientMR(todayAppointments.get(newCount[0]),null,true);
            }else if(number == 9){
                enterDoctorPage();
            }else if(number == 0){
                logOut();
            }else if(number == -1){
                exitSystem();
            }else{
                System.out.println("Invalid value. ");
                enterDoctorPage();
            }
        }
    } // end method viewDoctorInfo
    
    private static void viewPatientMR(Appointment theAppointment){
        printDoctorPageTitle();
        patient = theAppointment.getAppointmentPatient();
        System.out.println("------ Edit Patient Medical Record ------");
        System.out.println(patient.displayInfo());
        printLogEnding();

    }

    private static void editPatientMR(Appointment theAppointment,LocalTime startTime,Boolean enter){
        Treatment treatment = new Treatment();
        Prescription prescription = new Prescription();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDoctor(theAppointment.getAppointmentDoctor());
        medicalRecord.setPatient(theAppointment.getAppointmentPatient());

        printDoctorPageTitle();
        patient = theAppointment.getAppointmentPatient();
        System.out.println("------ Edit Patient Medical Record ------");
        System.out.printf("\n *. Firstname: %-20s \t*. Lastname: %-20s " +
        "\n *. Age: %-25d \t*. Sex: %-20s " +
        "\n *. Date of Birth: %-15s \t*. Medical Card Number: %s" +
        "\n *. E-mail: %-20s \t*. Phone Number: %s \n" +
        "\n *. Insurance Company: %-15s \t*. Insurance Contract Number: %s " +
        "\n *. Address: %s " +
        "\n *. Emergency Contact: %s " +
        "\n *. Phone Number of Emergency Contact: %s \n\n",
        patient.getFirstName(),patient.getLastName(),patient.getAge(),patient.getSex(),patient.getDateOfBirth(),patient.getMedicalCardNumber(),
        patient.getEmail(),patient.getPhoneNumber(),
        patient.getInsuranceCompeny(), patient.getContractNumber(),patient.getAddress(),
        patient.getEmergencyContact(), patient.getPhoneNumOfEmergencyContact());
        System.out.println("-----------------------------------------");
        if(startTime==null){
            System.out.println("  1. Start This Treatment");
            System.out.println("  *. Create Treatment & Prescription");
        }else{
            System.out.println("  *. Start This Treatment");
            System.out.println("  1. Create Treatment & Prescription");
        }
        printLogEnding();

        String letter;
        System.out.println("Please enter the choice: ");
        int number = input.nextInt();
        System.out.println();
        if(number == 9){
            if(enter){
                enterDoctorPage();
            }{
                viewDoctorAppointments(appointList);
            }
        }else if(number == 0){
            exitSystem();
        }else if(number == -1){
            exitSystem();
        }else if(number!=1){
            System.out.println("Invalid value. ");
            enterDoctorPage();
        }

        if(startTime == null){
            System.out.println("Please start treatment first.");
            editPatientMR(theAppointment,LocalTime.now(),enter);
        }else{
            System.out.println("---------------  Treatment  -------------");
            System.out.println("The treatment description: ");
            treatment.setTreatment(input.nextLine());
            System.out.println();
            System.out.println("The cost of this treatment: ");
            treatment.setCost(input.nextDouble());
            System.out.println();
            input.nextLine();
            int count = 0;
            while(count!= -1){
                System.out.println("-------------  Prescription  ------------");
                System.out.println("medicine name: ");
                prescription.setMedicine(input.nextLine());
                System.out.println();
                System.out.println("Please enter the quantity of medicine: ");
                prescription.setQuantity(input.nextInt());
                System.out.println();
                input.nextLine();
                System.out.println("Please enter the description of this medicine: ");
                prescription.setInstruction(input.nextLine());
                System.out.println();
                input.nextLine();
                System.out.println("Press \"Y\" to add another medicine prescription\nOr press anykey to stop:");
                letter = input.next();
                System.out.println();
                if(letter.equalsIgnoreCase("Y")){
                    medicalRecord.setPrescription(prescription);
                }else {
                    count = -1;
                }
            }

            medicalRecord.setPrescription(prescription);
            medicalRecord.setTreatment(treatment);

            System.out.println("Do you want to complete the changes? Y or N: ");
            letter = input.next();
            if(letter.equalsIgnoreCase("Y")){
                patient.setMedicalRecords(medicalRecord);
                Invoice invoice = new Invoice(doctor, patient, treatment);
                invoiceList.add(invoice);
            }else if(letter.equalsIgnoreCase("N")){
                viewPatientMR(theAppointment);
                System.out.println("Invalid value.Turn to previous page.");
                enterAdminPage();
            }else{
                System.out.println("Invalid value.Turn to previous page.");
                enterAdminPage();
            }
        }
        
    } // end method editPatientMR
    
    private static ArrayList<Appointment> viewTodayAppointment(Doctor  aDoctor){
        ArrayList<Appointment> newArray = new ArrayList<>();
        String today = LocalDate.now().toString(); 
        for(Appointment anAppoint: appointList){
            String date = anAppoint.getDate();
            if(date.equals(today) && (anAppoint.getAppointmentDoctor().equals(aDoctor))){
                newArray.add(anAppoint);
            }
        }
        
        return newArray;
    }

    private static int[] displayList(ArrayList<Appointment> aList,int[] count,boolean theFirstpage , boolean theLastpage){
        // int[] count = new int[]{total,line,page,index};
        int number = 0;
        boolean firstpage = theFirstpage,lastpage = theLastpage;

        if(aList == null){
            System.out.printf("The list is empty. \n\n");
            count[3] = 9;
            return count;
        }

        int temp = aList.size() / 5;
        while((count[1] < 5) && (count[0] < aList.size())){
            count[1]++; 
            System.out.printf("%s. \n%s\n",count[1],aList.get(count[0]).toString());
            count[0]++;
            if(count[1] == 5){
                count[2]++;
                // diaplay different ending
                if((aList.size() <= 5) && (aList.size() - 1 == count[0])){
                    count[3] = count[0];
                    printLogEnding();
                }else if(aList.size() > 5){
                    if((count[2] > 1) && (count[2] < temp)){
                        firstpage = false;  
                          
                    }else if((count[2] >= temp)){
                        firstpage = false;
                        lastpage = true;
                    }
                    printPageTransferEnding(firstpage,lastpage);
                }
                System.out.println("Please enter the number to edit or to quit: ");
                number = input.nextInt();
                System.out.println();
                input.nextLine();
                if(number == 7){
                    count[0] -= (count[1] + count[2]*5);
                    count[1] = 0;
                    count[2] -= 1;
                    displayList(aList,count,theFirstpage , theLastpage) ;

                }else if(number == 8){
                    count[1] = 0;
                    count[2] += 1;
                    displayList(aList, count, theFirstpage, theLastpage) ;
                }else{
                    count[3] = number;
                    return count;
                }
            }
            
        }
        printLogEnding();

        
        count[3] = count[0];
        return count;
    } // end method displayList

    // Receptionist Page Start
    private static void enterReceptionistPage(){
        printReceptionistPageTitle();
        System.out.printf(" 1. Add Patient\n" + 
            " 2. Edit Patient\n" + 
            " 3. Delete Patient\n");
        printLogEnding();    
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
        if(number == 1){
            createNewFile("patient");
        }else if(number == 2){
            viewAndEditPatientInfo();
        }else if(number == 3){
            deletePatient();
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            exitSystem();
        }else{
            System.out.println("Invalid Number. ");
            createAppointment();
        }
    } // end method enterReceptionistPage
    
    private static void viewAndEditPatientInfo(){
        printReceptionistPageTitle();
        System.out.println("----------- Edit Patient Info -----------");
        System.out.println("Please enter the Medical Card Number of the patient to be edited: ");
        String newString = input.next();
        
        Patient newPatient = findPatient(newString);
        if(newPatient!=null){
            System.out.println("---------  Patient Information  ---------");
            System.out.printf("%s\n",newPatient.displayInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Do you want to edit this patient? Y or N: ");
            String temp = input.next();
            System.out.println();
            if(temp.equalsIgnoreCase("Y")){
                patient = newPatient;
                editPatientInfo();
            }else if(temp.equalsIgnoreCase("N")) {
                
            }else{
                System.out.println("Invalid value.Turn to previous page.");
                viewAndEditPatientInfo();
            } 
        }else{
             System.out.println("This patient is not in the list. ");
        }

        System.out.println("Do you want to continue edit? Y or N: ");
        String letter = input.next();
        if(letter.equalsIgnoreCase("Y")){
            viewAndEditPatientInfo();
        }else if(letter.equalsIgnoreCase("N")){
            enterReceptionistPage();
        }else {
            System.out.println("Invalid value.Turn to previous page.");
            viewAndEditPatientInfo();
        }
        
    } // end method viewAndEditPatientInfo
    
    private static void editPatientInfo(){
        printReceptionistPageTitle();
        
        System.out.println("--------  Personal Information  ---------");
        System.out.printf("\n  *. Medical Card Number: %s" +
        "\n  A. Firstname: %s " +
        "\n  B. Lastname: %s" +
        "\n  C. Age: %d " +
        "\n  D. Sex: %s " +
        "\n  E. Date of Birth: %s " +
        "\n  F. Insurance Company: %s " +
        "\n  G. Insurance Contract Number: %s " +
        "\n  H. E-mail: %s " +
        "\n  I. Phone Number: %s " +
        "\n  J. Address: %s " +
        "\n  K. Emergency Contact: %s " +
        "\n  L. Phone Number of Emergency Contact: %s \n"+
        "\n  M. Password: %s \n", 
        patient.getFirstName(),patient.getLastName(),patient.getAge(),patient.getSex(),patient.getDateOfBirth(),patient.getMedicalCardNumber(),
                patient.getInsuranceCompeny(), patient.getContractNumber(),
                patient.getEmail(),patient.getPhoneNumber(),patient.getAddress(),
                patient.getEmergencyContact(), patient.getPhoneNumOfEmergencyContact(),"********");
        printLogEnding();
        
        System.out.println("Enter the letter to reset info or the number to exit (Ignore letter case): ");
        String letter = input.next();
        input.nextLine();
        System.out.println();
        if((letter.hashCode() >=65) && (letter.hashCode() <= 122) ){
            System.out.println("Enter new info: ");
            String newString = input.nextLine();
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            input.nextLine();
            if(temp.equalsIgnoreCase("Y")){
                if(letter.equalsIgnoreCase("A")){
                    patient.setFirstName(newString);
                }else if(letter.equalsIgnoreCase("B")){
                    patient.setLastName(newString);
                }else if(letter.equalsIgnoreCase("C")){
                    patient.setAge(Integer.parseInt(newString));
                }else if(letter.equalsIgnoreCase("D")){
                    patient.setSex(newString);
                }else if(letter.equalsIgnoreCase("E")){
                    patient.setDateOfBirth(newString);
                }else if(letter.equalsIgnoreCase("F")){
                    patient.setInsuranceCompeny(newString);  
                }else if(letter.equalsIgnoreCase("G")){
                    patient.setContractNumber(newString);
                }else if(letter.equalsIgnoreCase("H")){
                    patient.setEmail(newString);
                }else if(letter.equalsIgnoreCase("I")){
                    patient.setPhoneNumber(newString);
                }else if(letter.equalsIgnoreCase("J")){
                    patient.setAddress(newString);
                }else if(letter.equalsIgnoreCase("K")){
                    patient.setEmergencyContact(newString);
                }else if(letter.equalsIgnoreCase("L")){
                    patient.setPhoneNumOfEmergencyContact(newString);
                }else if(letter.equalsIgnoreCase("M")){
                    patient.setPassword(newString);
                    System.out.println("The password of this patient is reset");
                }else{
                    System.out.println("Invalid value.Try again");
                }
                editPatientInfo();
            }else if((temp.equalsIgnoreCase("N"))){
                System.out.println("Do you want to continue editing this patient? Y or N: ");
                letter = input.next();
                if(letter.equalsIgnoreCase("Y")){
                    editPatientInfo();
                }else if(letter.equalsIgnoreCase("N")){
                    System.out.println("Do you want to continue editing another patient? Y or N: ");
                    letter = input.next();
                    if(letter.equalsIgnoreCase("Y")){
                        viewAndEditPatientInfo();
                    }else if(letter.equalsIgnoreCase("N")){
                        enterReceptionistPage();
                    }else{
                        System.out.println("Invalid value.Turn to previous page.");
                        viewAndEditPatientInfo();
                    }
                letter = input.next();
                }else {
                    System.out.println("Invalid value.Turn to previous page.");
                    viewAndEditPatientInfo();
                }
            }else{
                System.out.println("Invalid value.Please try again.");
                viewAndEditPatientInfo();
            }
        }else{
            if(letter.equals("9")){
                enterReceptionistPage();
            } else if(letter.equals("0")){
                logOut();
            } else if(letter.equals("-1")){
                exitSystem();
            } else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
            } 
        }
    }

    private static void deletePatient() {
        printReceptionistPageTitle();
        System.out.println("------------ Delete Patient -------------");
        System.out.println("Please enter the Medical Card Number of the patient: ");
        String newString = input.next();
        input.nextLine();

        Patient aPatient = findPatient(newString);
        String letter;
        if(aPatient != null){
            System.out.println("---------  Patient Information  ---------");
            System.out.printf("%s\n",aPatient.displayInfo());
            System.out.println("-----------------------------------------");
        
            System.out.println("Do you want to delete the patient? Y or N: ");
            letter = input.next();
            System.out.println();
            if(letter.equalsIgnoreCase("Y")){
                patientList.remove(aPatient);
                System.out.println("Delete Successful!");
            }else if(letter.equalsIgnoreCase("N")){
            }else{
                System.out.println("Invalid value.Try again.");
                deletePatient();
            }   
        }else{
            System.out.println("This patient is not in the list. ");
        }

        System.out.println("Do you want to continue? Y or N: ");
        letter = input.next();
        if(letter.equalsIgnoreCase("Y")){
            deletePatient();
        }else if(letter.equalsIgnoreCase("N")){
            enterReceptionistPage();
        }else {
            System.out.println("Invalid value.Turn to previous page.");
            deletePatient();
        }
    }

    // Admin Page Start
    private static void enterAdminPage(){
        printAdminPageTitle();
        System.out.printf(" 1. Add Doctor\n" + 
            " 2. Edit Doctor\n" + 
            " 3. Delete Doctor\n");
        printLogEnding();    
        System.out.println("Please enter the number: ");
        int number = input.nextInt();
        input.nextLine();
         if(number == 1){
            createNewFile("doctor");
        }else if(number == 2){
            viewAndEditDoctorInfo();
        }else if(number == 3){
            deleteDoctor();
        }else if(number == 9){
            enterHomePage();
        }else if(number == 0){
            exitSystem();
        }else{
            System.out.println("Invalid Number. ");
            createAppointment();
        }
        
    }

    private static void viewAndEditDoctorInfo(){
        printAdminPageTitle();
        System.out.println("----------- Edit Doctor Info -----------");
        System.out.println("Please enter the Work ID of the doctor to be edited: ");
        String newString = input.next();
        
        Doctor newDoctor = findDoctor(newString);
        if(newDoctor!=null){
            System.out.println("----------  Doctor Information  ---------");
            System.out.printf("%s\n",newDoctor.displayDoctorInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Do you want to edit this doctor? Y or N: ");
            String temp = input.next();
            System.out.println();
            if(temp.equalsIgnoreCase("Y")){
                doctor = newDoctor;
                editDoctorInfo();
            }else if(temp.equalsIgnoreCase("N")) {
                
            }else{
                System.out.println("Invalid value.Turn to previous page.");
                viewAndEditDoctorInfo();
            } 
        }else{
             System.out.println("This doctor is not in the list. ");
        }

        System.out.println("Do you want to continue edit? Y or N: ");
        String letter = input.next();
        if(letter.equalsIgnoreCase("Y")){
            viewAndEditDoctorInfo();
        }else if(letter.equalsIgnoreCase("N")){
            enterAdminPage();
        }else {
            System.out.println("Invalid value.Turn to previous page.");
            viewAndEditDoctorInfo();
        }
    } // end method viewAndEditDoctorInfo

    private static void editDoctorInfo(){
        printAdminPageTitle();
        
        System.out.println("--------  Personal Information  ---------");
        System.out.printf("\n  *. Work ID: %s " +
            "\n  A. Firstname: %s " +
            "\n  B. Lastname: %s" +
            "\n  C. Age: %d " +
            "\n  D. Sex: %s " +
            "\n  E. Date of Birth: %s " +
            "\n  F. Medical School Specialty: %s" +
            "\n  G. E-mail: %s " +
            "\n  H. Phone Number: %s " +
            "\n  I. Address: %s " +
            "\n  J. Password: %s \n"+
            "\n  K. Available Appointment Time: %s \n",
            doctor.getWorkId(),doctor.getFirstName(),doctor.getLastName(),doctor.getAge(),doctor.getSex(),doctor.getDateOfBirth(),doctor.getMedicalSchoolSpecialty(),
            doctor.getEmail(),doctor.getPhoneNumber(),doctor.getAddress(),"********",doctor.getAvailableTimesString(false));
        printLogEnding();
        
        System.out.println("Enter the letter to reset info or the number to exit (Ignore letter case): ");
        String letter = input.next();
        input.nextLine();
        System.out.println();
        if((letter.hashCode() >=65) && (letter.hashCode() <= 122) ){
        
            setDoctorAppointment();
            if(letter.equalsIgnoreCase("K")){
                setDoctorAppointment();
            }
            System.out.println("Enter new info: ");
            String newString = input.nextLine();
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            input.nextLine();
            if(temp.equalsIgnoreCase("Y")){
                try {
                    if(letter.equalsIgnoreCase("A")){
                        doctor.setFirstName(newString);
                    } else if(letter.equalsIgnoreCase("B")){
                        doctor.setLastName(newString);
                    } else if(letter.equalsIgnoreCase("C")){
                        doctor.setAge(Integer.parseInt(newString));
                    } else if(letter.equalsIgnoreCase("D")){
                        doctor.setSex(newString);
                    } else if(letter.equalsIgnoreCase("E")){
                        doctor.setDateOfBirth(newString);
                    } else if(letter.equalsIgnoreCase("F")){
                        doctor.setMedicalSchoolSpecialty(newString);
                    } else if(letter.equalsIgnoreCase("G")){
                        doctor.setEmail(newString);
                    } else if(letter.equalsIgnoreCase("H")){
                        doctor.setPhoneNumber(newString);
                    } else if(letter.equalsIgnoreCase("I")){
                        doctor.setAddress(newString);
                    } else if(letter.equalsIgnoreCase("J")){
                        doctor.setPassword(newString);
                        System.out.println("The password of this doctor is reset");
                    }else{
                        System.out.println("Invalid value.Try again");
                    }
                    editDoctorInfo();
                } catch (Exception e) {
                    System.out.println("Ivalid value. ");
                    editDoctorInfo();
                }
                
            }else if((temp.equalsIgnoreCase("N"))){
                System.out.println("Do you want to continue editing this doctor? Y or N: ");
                letter = input.next();
                if(letter.equalsIgnoreCase("Y")){
                    editDoctorInfo();
                }else if(letter.equalsIgnoreCase("N")){
                    System.out.println("Do you want to continue editing another doctor? Y or N: ");
                    letter = input.next();
                    if(letter.equalsIgnoreCase("Y")){
                        viewAndEditDoctorInfo();
                    }else if(letter.equalsIgnoreCase("N")){
                        enterAdminPage();
                    }else{
                        System.out.println("Invalid value.Turn to previous page.");
                        enterAdminPage();
                    }
                }else {
                    System.out.println("Invalid value.Turn to previous page.");
                    enterAdminPage();
                }
            }else{
                System.out.println("Invalid value.Please try again.");
                viewAndEditDoctorInfo();
            }
        }else{
            if(letter.equals("9")){
                enterAdminPage();
            } else if(letter.equals("0")){
                logOut();
            } else if(letter.equals("-1")){
                exitSystem();
            } else{
                System.out.println("Invalid Value. Please enter the letter in the list.");
            } 
        }
    }

    private static void setDoctorAppointment(){
        printAdminPageTitle();
        System.out.println("----- Availabled Appointment Time -----\n");
        System.out.printf(" 1. Add Availabled Appointment Time\n" +
                " 2. Reset Availabled Appointment Time\n" +
                " 3. Delete Availabled Appointment Time\n");
        System.out.println("-----------------------------------------");
        System.out.printf("Please enter the number: ");
        int choice = input.nextInt();
        if(choice == 9){
            enterDoctorPage();
        }else if(choice == 0){
            logOut();
        }else if(choice == -1){
            exitSystem();
        }else if((choice < 1) || (choice >3)){
            System.out.println("Invalid value. ");
            enterDoctorPage();
        }else{
        }

        printAdminPageTitle();
        int[] count = new int[]{0,0,0,0};
        int[] newCount = displayDateList(doctor.getAvailableTimes(),count,true ,false);
        printLogEnding();
        System.out.printf("Please enter the number to choose: ");
        int number = input.nextInt(); 
        System.out.println();
        


        if(number > 0 && number < 6){
            
            System.out.printf("Please enter the new Date( \"yyyy-mm-dd\" ):  \n");
            String date = input.nextLine();
            System.out.printf("Please enter the new Time( \"hh:mm\" ):  \n");
            String time = input.nextLine();
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            input.nextLine();
            if(temp.equalsIgnoreCase("Y")){
                if(choice != 1){
                    doctor.getAvailableTimes().remove(count[0]);
                }
                if(choice != 3){
                    doctor.setAvailableTime(date + " " + time);
                } 
                setDoctorAppointment();
            }else if(temp.equalsIgnoreCase("N")){
                setDoctorAppointment();
            }else{
                System.out.println("Invalid value. ");
                enterDoctorPage();
            }
        }else if(number == 9){
            enterDoctorPage();
        }else if(number == 0){
            logOut();
        }else if(number == -1){
            exitSystem();
        }else{
            System.out.println("Invalid value. ");
            enterDoctorPage();
        }

    } // end method setDoctorAppointment

    private static void deleteDoctor() {
        printAdminPageTitle();
        System.out.println("-------------- Delete Doctor ---------------");
        System.out.println("Please enter the Work ID of the doctor: ");
        String newString = input.next();
        input.nextLine();

        Doctor aDoctor = findDoctor(newString);
        String letter;
        if(aDoctor != null){
            System.out.println("----------  Doctor Information  ---------");
            System.out.printf("%s\n",aDoctor.displayDoctorInfo());
            System.out.println("-----------------------------------------");
        
            System.out.println("Do you want to delete this doctor? Y or N: ");
            letter = input.next();
            System.out.println();
            if(letter.equalsIgnoreCase("Y")){
                doctorList.remove(aDoctor);
                System.out.println("Delete Successful!");
            }else if(letter.equalsIgnoreCase("N")){
            }else{
                System.out.println("Invalid value.Try again.");
                deletePatient();
            }   
        }else{
            System.out.println("This doctor is not in the list. ");
        }

        System.out.println("Do you want to continue? Y or N: ");
        letter = input.next();
        if(letter.equalsIgnoreCase("Y")){
            deletePatient();
        }else if(letter.equalsIgnoreCase("N")){
            enterReceptionistPage();
        }else {
            System.out.println("Invalid value.Turn to previous page.");
            deletePatient();
        }
    } // end method deleteDoctor

    private static int[] displayDateList(ArrayList<String> aList,int[] count,boolean theFirstpage , boolean theLastpage){
        // int[] count = new int[]{total,line,page,index};
        int number = -1;
        boolean firstpage = theFirstpage,lastpage = theLastpage;

        if(aList == null){
            System.out.printf("The list is empty. \n\n");
            count[3] = 9;
            return count;
        }

        int temp = aList.size() / 5;
        while((count[1] <= 5) && (count[0] < aList.size())){
            count[1]++; 
            System.out.printf("%s. %s\n",count[1],aList.get(count[0]).toString());
            count[0]++;
            if(count[1] == 5){
                count[2]++;
                // diaplay different ending
                if((aList.size() <= 5) && (aList.size() - 1 == count[0])){
                    count[3] = count[0];
                    printLogEnding();
                }else if(aList.size() > 5){
                    if((count[2] > 1) && (count[2] < temp)){
                        firstpage = false;       
                    }else if((count[2] >= temp)){
                        firstpage = false;
                        lastpage = true;
                    }
                    printPageTransferEnding(firstpage,lastpage);
                }
                System.out.println("Please enter the number to edit or to quit: ");
                number = input.nextInt();
                input.nextLine();
                if(number == 7){
                    count[0] -= (count[1] + count[2]*5);
                    count[1] = 0;
                    count[2] -= 1;
                    displayDateList(aList,count,theFirstpage , theLastpage);
                }else if(number == 8){
                    count[1] = 0;
                    count[2] += 1;
                    displayDateList(aList,count,theFirstpage , theLastpage);
                }else{
                    count[3] = number;
                    return count;
                }
            }
            
        }
        printLogEnding();
        count[3] = count[0];
        return count;
    } // end method displayDateList


    // file creation
    private static void createNewFile(String actor) {
        String password;
        printPatientPageTitle();
        System.out.printf("Please set the information of %s\n",actor);
        System.out.println("-----------------------------------------");
        System.out.printf("Set your password: ");
        password = input.next();
        input.nextLine();
        Person newPerson = createNewPerson(actor);
        if(actor.equalsIgnoreCase("patient")){
            Patient newPatient = new Patient(newPerson,password);
            newPatient = createNewPatient(newPatient);
            System.out.println("---------  Patient Information  ---------");
            System.out.printf("%s",newPatient.displayInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            if(temp.equalsIgnoreCase("Y")){
                patientList.add(newPatient);
                System.out.println("Patient Creation Successful!");
                System.out.println("Do you want to add another patient? Y or N: ");
                temp = input.next();
                if(temp.equalsIgnoreCase("Y")){
                    createNewFile(actor);
                }else{
                    enterReceptionistPage();
                }
            }else{
                System.out.println("Do you want to quit? Y or N: ");
                temp = input.next();
                if(temp.equalsIgnoreCase("Y")){
                    enterReceptionistPage();
                }else{
                    createNewFile(actor);
                }
            }
        }else if(actor.equalsIgnoreCase("doctor")){
            Doctor newDoctor = new Doctor(newPerson, password);
            newDoctor = createNewDoctor(newDoctor);
            System.out.println();
            System.out.println("---------  Doctor Information  ----------");
            System.out.printf("%s",newDoctor.displayDoctorInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Do you want to complete the change? Y or N: ");
            String temp = input.next();
            System.out.println();
            if(temp.equalsIgnoreCase("Y")){
                doctorList.add(newDoctor);
                System.out.println("Doctor Creation Successful!");
                System.out.println("Do you want to add another doctor? Y or N: ");
                temp = input.next();
                if(temp.equalsIgnoreCase("Y")){
                    createNewFile(actor);
                }else{
                    enterAdminPage();
                }
            }else{
                System.out.println("Do you want to quit? Y or N: ");
                temp = input.next();
                if(temp.equalsIgnoreCase("Y")){
                    enterReceptionistPage();
                }else{
                    createNewFile(actor);
                }
            }
        }
        
    } // end method createNewFile

    private static Person createNewPerson(String actor) {
        String firstname, lastname, sex, dateOfBirth, email, phoneNumber, address;
        int age;
        Person newPerson = new Person();

        try{
            System.out.printf("Firstname: ");
            firstname = input.next();
            input.nextLine();
            System.out.printf("Lastname: ");
            lastname = input.next();
            input.nextLine();
            System.out.printf("Age: ");
            age = input.nextInt();
            input.nextLine();
            System.out.printf("Sex: ");
            sex = input.next();
            input.nextLine();
            System.out.printf("Date Of Birth: ");
            dateOfBirth = input.next();
            input.nextLine();
            System.out.printf("E-mail: ");
            email = input.next();
            input.nextLine();
            System.out.printf("Phone number: ");
            phoneNumber = input.next();
            input.nextLine();
            System.out.printf("Address: ");
            address = input.next();
            input.nextLine();
            newPerson = new Person(firstname, lastname, age, sex, dateOfBirth, email, phoneNumber, address);
        }catch(InputMismatchException ime){
            System.out.println("Invalid vaLue.");
            
        }
    
        return newPerson;
    }// end method createNewPatient

    private static Patient createNewPatient(Patient aPatient) {
        String medicalCardNumber, insuranceCompeny, contractNumber, emergencyContact,
        phoneNumOfEmergencyContact;
        try{
            System.out.printf("Medical card number: ");
            medicalCardNumber = input.next();
            input.nextLine();
            System.out.printf("InsuranceCompeny: ");
            insuranceCompeny = input.next();
            input.nextLine();
            System.out.printf("Contract Number: ");
            contractNumber = input.next();
            input.nextLine();
            System.out.printf("Emergency Contact: ");
            emergencyContact = input.next();
            input.nextLine();
            System.out.printf("Phone Number Of Emergency Contact: ");
            phoneNumOfEmergencyContact = input.next();
            input.nextLine();
            System.out.println();
            aPatient.setPatientVariable(medicalCardNumber, insuranceCompeny, contractNumber, emergencyContact,phoneNumOfEmergencyContact);
        }catch(InputMismatchException ime){
            System.out.println("Invalid vaLue.");
            
        }
        return aPatient;
    }// end method createNewPatient

    private static Doctor createNewDoctor(Doctor aDoctor) {
        String workId, medicalSchoolSpecialty;
        try {
            System.out.printf("Work ID: ");
            workId = input.next();
            input.nextLine();
            System.out.printf("Medical School Specialty:");
            medicalSchoolSpecialty = input.next();
            input.nextLine();
            System.out.println();
            aDoctor.setDoctorVariable(workId, medicalSchoolSpecialty);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid vaLue.");
        }
        
        return aDoctor;
    }// end method createNewDoctor

    private static void logOut(){
        System.out.println("Log out now. Thank you for using Medical Clinic System!");
        
        // patient = null;
        // doctor = null;
        enterHomePage();
    }

    private static void exitSystem(){
        System.out.println("Exit now. Thank you for using Medical Clinic System!");
        System.exit(0);
    }
    
    private static void printHomePageTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  ******  Medical Clinic System  ******  ");
        System.out.println();
        System.out.println("=========================================");
        System.out.println();
    }

    private static void printSignInTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Medical Clinic System -- Sign-In Page  ");
        System.out.println("=========================================");
        System.out.println();
    }

    private static void printPatientPageTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Medical Clinic System -- Patient Page  ");
        System.out.println("=========================================");
        System.out.println();
    }

    private static void printLogEnding(){
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("  9. Go To Previous Page");
        System.out.println("  0. Log out and Back to HomePage");
        System.out.println(" -1. Exit Medical Clinic System");
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    private static void printDoctorPageTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Medical Clinic System -- Doctor Page   ");
        System.out.println("=========================================");
        System.out.println();
    }

    private static void printAdminPageTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Medical Clinic System -- Admin Page    ");
        System.out.println("=========================================");
        System.out.println();
    }

    private static void printReceptionistPageTitle(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println(" Medical Clinic System -- Reception Page ");
        System.out.println("=========================================");
        System.out.println();
    } 

    
    private static void printPageTransferEnding(boolean firstpage,boolean lastpage){
        System.out.println();
        System.out.println("-----------------------------------------");
        if(!lastpage){
            if(!firstpage){
                System.out.println("  7. Preceding Page");
            }
            System.out.println("  8. Next Page");
        }else{
            System.out.println("  7. Preceding Page");
        }
        System.out.println("  9. Go To Previous Page");
        System.out.println("  0. Log out and Back to HomePage");
        System.out.println(" -1. Exit Medical Clinic System");
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    




    
}
