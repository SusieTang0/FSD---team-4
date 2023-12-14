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
    private Object doctor;
    private Object patient;



        //constructor
        Appointment(int month, int day, int time, Object doctor, Object patient){
            
           setAppointment(month, day, time, doctor, patient);

        }


        //methods below
    @Override
    public String toString(){
        return "This appointment is set for " + appointmentTime.format(formatter) + " with " + this.doctor + " for " + this.patient;
    }

    public void setAppointment(int month, int day, int time, Object doctor, Object patient){

        if(day >= currentDay + 5){

            this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0, 0);
            this.doctor = doctor;
            this.patient = patient;        
        
        } else {
            System.out.println("We are currently not taking appointments within this week, we ask that you set an appointment at least 5 days from now.");
        }

    }

    public void setAppointmentTime(int month, int day, int time){
        if(day >= currentDay){
            this.appointmentTime = LocalDateTime.of(currentYear, month, day, time, 0, 0);
        }
    }

    public void setAppointmentDoctor(Object doctor){
        this.doctor = doctor;
    }

    public void setAppointmentPatient(Object patient){
        this.patient = patient;
    }

    public String getAppointmentTime(){
        return appointmentTime.format(formatter);
    }

    public Object getAppointmentDoctor(){
        return this.doctor;
    }

    public Object getAppointmentPatient(){
        return this.patient;
    }

}
