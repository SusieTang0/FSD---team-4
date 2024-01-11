import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctormanager {

    public static void main(String[] args) {
        // Set doctor information to a file
        setDoctorInformationToFile();

        // Get doctor information from the file and create Doctor objects
        ArrayList<Doctor> doctors = getDoctorInformationFromFile();

        // Print the information of the created Doctor objects
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    private static void setDoctorInformationToFile() {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get user input for doctor attributes
        System.out.println("Enter doctor details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Work ID: ");
        String workId = scanner.nextLine();

        System.out.print("Medical School Specialty: ");
        String specialty = scanner.nextLine();

        // Create a Doctor object with the provided details
        Doctor doctor = new Doctor(firstName, lastName, email, phoneNumber, workId);
        doctor.setMedicalSchoolSpecialty(specialty);

        // Save doctor information to a text file
        saveDoctorToFile(doctor);

        System.out.println("Doctor information saved to doctors.txt");

        // Close the scanner
        scanner.close();
    }

    private static void saveDoctorToFile(Doctor doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.txt", true))) {
            // Append doctor information to the file
            writer.write(doctor.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Doctor> getDoctorInformationFromFile() {
        ArrayList<Doctor> doctors = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each doctor's information is stored in two consecutive lines
                String[] info = line.split(", ");
                String firstName = info[0];
                String lastName = info[1];
                String email = info[2];
                String phoneNumber = info[3];
                String workId = info[4];

                // Creating a new Doctor object and adding it to the list
                Doctor doctor = new Doctor(firstName, lastName, email, phoneNumber, workId);
                doctors.add(doctor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doctors;
    }
}
