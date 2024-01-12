package medical_clinic_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Appointment{
    // LocalDateTime of current date
    LocalDateTime currentDateTime = LocalDateTime.now();
    int currentYear = currentDateTime.getYear();
    int currentMonth = currentDateTime.getMonthValue();
    int currentDay = currentDateTime.getDayOfMonth();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    
    //variable of the class
    private String appointmentId;
    private LocalDateTime appointmentTime;
    private Doctor doctor;
    private Patient patient;

    //constructor
    Appointment(String dateString, Doctor doctor, Patient patient){
        LocalDateTime temp = transferFormat(dateString);
        setAppointmentId(temp.getMonthValue(), temp.getDayOfMonth(), temp.getHour(), doctor, patient);
        setAppointment(temp.getMonthValue(), temp.getDayOfMonth(), temp.getHour(), doctor, patient);
    }

    //methods below
    @Override
    public String toString(){
        return String.format("Appointment ID: " + getAppointmentId()+ 
        "\tAppointment Date: " + getAppointmentTime() + 
        "\tDoctor: " + doctor.getName() +
        "\tPatient: " + patient.getName());
    }

    public void setAppointment(int month, int day, int time, Doctor doctor, Patient patient){

        // if(day >= currentDay + 5){

            this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0, 0);
            this.doctor = doctor;
            this.patient = patient;        
        
        // } else {
        //     System.out.println("We are currently not taking appointments within this week, we ask that you set an appointment at least 5 days from now.");
        // }

    }

    public void setAppointmentId(int month, int day, int time, Doctor doctor, Patient patient) {
        this.appointmentId = String.format("%s%d%d%d%s",doctor.getWorkId(),month,day,time,doctor.getWorkId(),patient.medicalCardNumber);
        System.out.printf("Im here ---> ",this.appointmentId);
    }

    public void setAppointmentTime(int month, int day, int time){
        if(day >= currentDay){
            this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0,0);
        }
    }

    public void setAppointmentDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void setAppointmentPatient(Patient patient){
        this.patient = patient;
    }


    public int[] getAppointmentIntTime(){
        return new int[]{this.appointmentTime.getYear(), this.appointmentTime.getMonthValue(), this.appointmentTime.getDayOfMonth(), this.appointmentTime.getHour()};
    }

    public LocalDateTime transferFormat(String newString){
        String[] strings = newString.split(" ");
        LocalDate date = LocalDate.parse(strings[0], dateFormatter);
        LocalTime time = LocalTime.parse(strings[1], timeFormatter);
        return LocalDateTime.of(date, time);
    }

    public String getAppointmentSetTime(){
        return this.currentDateTime.format(formatter);
    }

    public String getAppointmentId() {
        return this.appointmentId;
    }


    public String getDate(){
        return this.appointmentTime.format(dateFormatter);
    }

    public String getTime(){
        return this.appointmentTime.format(timeFormatter);
    }


    public LocalDateTime getAppointmentTime(){
        return this.appointmentTime;
    }

    public String getDateTimeString(){
        return String.format("%s %s",getDate(),getTime());
    }

    public Doctor getAppointmentDoctor(){
        return this.doctor;
    }

    public Patient getAppointmentPatient(){
        return this.patient;
    }

    

}
