
/**
 * Treatment class sets and prints details of a patients treatment 
 * 
 * @version 1.00
 * @since 2024-01-04
 * @author Shawnelle McNichols
 */
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.*;

public class Treatment{
    //data members
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    private SimpleDateFormat stf = new SimpleDateFormat("hh:mm a");
    private String treatmentName, description;
    private Date date = new Date();
    private Date startTime = new Date();
    private Date endTime = new Date();
    private double cost;
   

    //default data constructor
    public Treatment(){}

    //constructor with parameters
    public Treatment(String aTreatmentName, String aDescription, String aDate, String aStartTime, String anEndTime, double aCost){
        this.treatmentName = aTreatmentName;
        this.description = aDescription;
        setDate(aDate);
        setStartTime(aStartTime);
        setEndTime(anEndTime);
        this.cost = aCost;
    }

    //SET methods
    
    public void setTreatmentName(String theTreatmentName){
        this.treatmentName = theTreatmentName;
    }
    public void setDescription(String theDescription){
        this.description = theDescription;
    }
    public void setDate(String theDate){
        try{
            this.date = sdf.parse(theDate);
        } catch (ParseException e){
            System.out.println("Invalid date format.");
        }
    }
    public void setStartTime(String theStartTime){
        try{
            this.startTime = stf.parse(theStartTime);
        } catch (ParseException e){
            System.out.println("Invalid time format.");
        }
    }
    public void setEndTime(String theEndTime){
        try{
            this.endTime = stf.parse(theEndTime);
        } catch (ParseException em){
            System.out.println("Invalid time format.");
        }
    }
    public void setCost(double theCost){
        this.cost = theCost;
    }

    //GET methods
    public String getTreatmentName(){
        return this.treatmentName;
    }
    public String getDescription(){
        return this.description;
    }
    public String getDate(){
        return sdf.format(date);
    }
    public String getStartTime(){
        return stf.format(startTime);
    }
    public String getEndTime(){
        return stf.format(endTime);
    }
    public double getCost(){
        return this.cost;
    }
    @Override
    public String toString(){
        return String.format (" Treatment: %s %n %s %s %n %s %s %n %s %s %n %s %s %n %s $%.2f", getTreatmentName(), "Description: ", getDescription(), "Date: ", getDate(), 
        "Start time: ", getStartTime(), "End time: ", getEndTime(), "Cost: ", getCost());

    }

 
}//END class Treatment