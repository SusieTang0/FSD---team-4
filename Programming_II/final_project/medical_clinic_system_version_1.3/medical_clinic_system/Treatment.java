package medical_clinic_system;
/**
 * Treatment class sets and prints details of a patients treatment 
 * 
 * @version 1.00
 * @since 2024-01-04
 * @author Shawnelle McNichols
 */
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Treatment{
    //data members
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private String treatment;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double cost;
   

    //default data constructor
    public Treatment(){ }

    public Treatment(String theTeatment){
        setTreatment(theTeatment);
    }


    //constructor with parameters
    public Treatment(String theTeatment,LocalDate theDate,LocalTime theStartTime, LocalTime theEndTime,double theCost){
        setTreatment(theTeatment);
        setDate(theDate);
        setStartTime(theStartTime);
        setEndTime(theEndTime);
        this.cost = theCost;
    }


    public Treatment(String theTeatment,String theDate,String theStartTime, String theEndTime,double theCost){
        setTreatment(theTeatment);
        setDateAndTime(theDate,theStartTime,theEndTime);
        this.cost = theCost;
    }

    //SET methods
    
    public void setTreatment(String theTreatment){
        this.treatment= theTreatment;
    }

    
    public void setDate(LocalDate theDate){
        this.date = theDate;
    }

    public void setDateAndTime(String theDate,String theStartTime, String theEndTime){
        this.date = LocalDate.parse(theDate, dateFormatter);
        this.startTime = LocalTime.parse(theStartTime, timeFormatter);
        this.endTime = LocalTime.parse(theEndTime, timeFormatter);
    }

    public void setStartTime(LocalTime theStartTime){
        this.startTime = theStartTime;
    }

    public void setEndTime(LocalTime theEndTime){
        this.endTime =theEndTime;
       
    }
    public void setCost(double theCost){
        this.cost = theCost;
    }

    //GET methods
    public String getTreatment(){
        return this.treatment;
    }

    public String getDate(){
        return this.dateFormatter.format(this.date);
    }
    public String getStartTime(){
        return this.timeFormatter.format(this.startTime);
    }
    public String getEndTime(){
        return this.timeFormatter.format(this.endTime);
    }
    public String getDateAndTime(){
        return String.format("%s %s-%s", getDate(),getStartTime(),getEndTime());
    }
    public double getCost(){
        return this.cost;
    }
    @Override
    public String toString(){
        return String.format ("%s / %s / %.2f\n",getDateAndTime(),getTreatment(),getCost());
    }

    public String displayInfo(){
        String temp = String.format("Date : %s \nTreatment: %s \nDescription: %s \nCost: %.2f\n",getDateAndTime(),getTreatment(),getCost());
        return temp;
    }
    public Treatment setTreatment(LocalTime starTime){
        Treatment temp = new Treatment();
        Scanner input = new Scanner(System.in);
        temp.setStartTime(starTime);
        temp.setEndTime(LocalTime.now());
        System.out.println("Please enter the treatment name: ");
        temp.setTreatment(input.nextLine());
        System.out.println();
        LocalDate.now();
        System.out.println("Please enter the cost of treatment: ");
        temp.setCost(input.nextDouble());
        System.out.println();

        input.close();

        return temp;
    }

 
}//END class Treatment