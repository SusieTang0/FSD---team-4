// AdvancedTicket.java
package Java_II_Take_Home_Assignment_01_Solution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Implement a class called AdvanceTicket to represent tickets purchased in advance.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang
 */


public class AdvancedTicket extends Ticket{
    
    // constructor with parameters
    public AdvancedTicket(String currentDate, String ticketDate) {
        super(currentDate, ticketDate);
        setTicketPrice(currentDate, ticketDate);
    } // end constructor with parameters

    // set the price of advance ticket
    @Override
    public void setTicketPrice(String currentDate, String ticketDate){
        if(dateCalculate(currentDate, ticketDate) >= 10){
            super.setTicketPrice(30);
        }else if(dateCalculate(currentDate, ticketDate) == 0){
            throw new IllegalArgumentException("You can't buy advanced tickets now, please choose walk-up tickets.");
        }else{
            super.setTicketPrice(40);
        }
    } // end set Price

    // return string representation of AdvancedTicket object
    @Override
    public String toString(){
        return "Advance Ticket:" + super.toString();
    } // end method toString

    // method to calculate the gap between two dates
    public long dateCalculate(String dateStr1,String dateStr2){
        // parses a string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(dateStr1, formatter);
        LocalDate date2 = LocalDate.parse(dateStr2, formatter);

        // calculate the gap between two dates
        long days = ChronoUnit.DAYS.between(date1, date2);

        return days;
    } // end method dateCalculate

} //  end class AdvancedTicket
