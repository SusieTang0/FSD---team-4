package medical_clinic_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagement {
    static ArrayList<Appointment> appointList = new ArrayList<>();
    static ArrayList<Invoice> invoiceList = new ArrayList<>();
    static ArrayList<Doctor> doctorList = new ArrayList<>();
    static ArrayList<Patient> patientList = new ArrayList<>();

    public FileManagement(){

    }


    private static ArrayList<Doctor> getDoctorFromFile(String listName) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        String fileName = String.format(listName + ".txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" | ");
                Doctor newDoctor = new Doctor();
                        
                newDoctor.setWorkId(info[0]); 
                newDoctor.setFirstName(info[1]);
                newDoctor.setLastName(info[2]);
                newDoctor.setAge(Integer.parseInt(info[3]));
                newDoctor.setSex(info[4]);
                newDoctor.setDateOfBirth(info[5]);
                newDoctor.setEmail(info[6]);
                newDoctor.setPhoneNumber(info[7]);
                newDoctor.setAddress(info[8]);
                newDoctor.setMedicalSchoolSpecialty(info[9]);
                newDoctor.setPassword(info[10]);
                for(int i= 11; i< info.length-2; i++){
                    newDoctor.setAvailableTime(info[i]);
                }
                
                doctors.add(newDoctor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    private static ArrayList<Patient> getPatientFromFile() {
        ArrayList<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each doctor's information is stored in two consecutive lines
                String[] info = line.split(" | ");
                Patient newPatient = new Patient();
            
                newPatient.setMedicalCardNumber(info[0]); 
                newPatient.setFirstName(info[1]);
                newPatient.setLastName(info[2]);
                newPatient.setAge(Integer.parseInt(info[3]));
                newPatient.setSex(info[4]);
                newPatient.setDateOfBirth(info[5]);
                newPatient.setEmail(info[6]);
                newPatient.setPhoneNumber(info[7]);
                newPatient.setAddress(info[8]);
                newPatient.setInsuranceCompeny(info[9]);
                newPatient.setContractNumber(info[10]);
                newPatient.setEmergencyContact(info[11]);
                newPatient.setPhoneNumOfEmergencyContact(info[12]);
                newPatient.setPassword(info[13]);
                String[]  medicalRecordsList = info[14].split(" / ");

                readString()

                return newPatient;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    private static ArrayList<Patient> getInvoiceFromFile() {
        ArrayList<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each doctor's information is stored in two consecutive lines
                String[] info = line.split(" | ");
                Patient newPatient = new Patient();
            
                newPatient.setMedicalCardNumber(info[0]); 
                newPatient.setFirstName(info[1]);
                newPatient.setLastName(info[2]);
                newPatient.setAge(Integer.parseInt(info[3]));
                newPatient.setSex(info[4]);
                newPatient.setDateOfBirth(info[5]);
                newPatient.setEmail(info[6]);
                newPatient.setPhoneNumber(info[7]);
                newPatient.setAddress(info[8]);
                newPatient.setInsuranceCompeny(info[9]);
                newPatient.setContractNumber(info[10]);
                newPatient.setEmergencyContact(info[11]);
                newPatient.setPhoneNumOfEmergencyContact(info[12]);
                newPatient.setPassword(info[13]);
                String[]  medicalRecordsList = info[14].split(" / ");
                
                readString()

                return newPatient;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    private static void saveDoctorToFile(ArrayList<>) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.txt", true))) {
            // Append doctor information to the file
            writer.write(doctor.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
