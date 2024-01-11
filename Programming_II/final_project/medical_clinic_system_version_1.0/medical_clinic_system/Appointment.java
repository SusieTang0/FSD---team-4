package medical_clinic_system;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment{
    
    // LocalDateTime of current date
    LocalDateTime currentDateTime = LocalDateTime.now();
    int currentYear = currentDateTime.getYear();
    int currentMonth = currentDateTime.getMonthValue();
    int currentDay = currentDateTime.getDayOfMonth();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    //variable of the class
    private LocalDateTime appointmentTime;
    private String date;
    private String time;
    private Doctor doctor;
    private Patient patient;



        //constructor
        Appointment(String date,String time, Doctor doctor, Patient patient){
            
           setAppointment(date, time, doctor, patient);

        }


        //methods below
    @Override
    public String toString(){
        return "This appointment is set for " + getAppointmentTime() + " with Dr." + this.doctor.getLastName() + " for " + this.patient;
    }

    // public void setAppointment(int month, int day, int time, Object doctor, Object patient){

    //     if(day >= currentDay + 5){

    //         this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0, 0);
    //         this.doctor = doctor;
    //         this.patient = patient;        
        
    //     } else {
    //         System.out.println("We are currently not taking appointments within this week, we ask that you set an appointment at least 5 days from now.");
    //     }

    // }
    public void setAppointment(String date, String time, Doctor doctor, Patient patient){
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public void setAppointmentTime(int month, int day, int time){
        if(day >= currentDay){
            this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0, 0);
        }
    }

    public void setAppointmentDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void setAppointmentPatient(Patient patient){
        this.patient = patient;
    }

    public String getAppointmentTime(){
        return date + "," + time;
    }

    public Object getAppointmentDoctor(){
        return this.doctor;
    }

    public Object getAppointmentPatient(){
        return this.patient;
    }

     public Object getDate(){
        return this.date;
    }

    public Object getTime(){
        return this.time;
    }

}
