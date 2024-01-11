import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public interface PatientManager {
    // Declaration of methods in the interface (no implementation details here)
    void displayPatientInformation();

    void setPatientInformation();

    // Additional methods can be added as needed

    // Implementation class for the PatientManager interface
    class PatientManagerImpl implements PatientManager {
        private ArrayList<Patient> patients = getPatientInformationFromFile();

        @Override
        public void displayPatientInformation() {
            for (Patient patient : patients) {
                System.out.println(patient.toString());
            }
        }

        @Override
public void setPatientInformation() {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter patient details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Medical Card Number: ");
        String medicalCardNumber = scanner.nextLine();

        // Additional patient attributes can be added here

        Patient patient = new Patient(firstName, lastName, email, phoneNumber, medicalCardNumber);

        // Additional setters for patient attributes can be called here

        savePatientToFile(patient);

        System.out.println("Patient information saved to patients.txt");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


        private static void savePatientToFile(Patient patient) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt", true))) {
                writer.write(patient.toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private ArrayList<Patient> getPatientInformationFromFile() {
            ArrayList<Patient> patients = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Assuming each patient's information is stored in two consecutive lines
                    String[] info = line.split(", ");
                    String firstName = info[0];
                    String lastName = info[1];
                    String email = info[2];
                    String phoneNumber = info[3];
                    String medicalCardNumber = info[4];

                    // Creating a new Patient object and adding it to the list
                    Patient patient = new Patient(firstName, lastName, email, phoneNumber, medicalCardNumber);
                    patients.add(patient);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return patients;
        }
    }
}

