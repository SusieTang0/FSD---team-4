package Java_II_Take_Home_Assignment_01_Solution;

import java.time.LocalDate;
import java.util.Random;

/**
 * Implement a class called Ticket that will serve as the superclass for all three types of tickets.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang
 */

public abstract class Ticket {
    // data members
    private String ticketNumber;
    protected double ticketPrice;

    // constructor with parameter
    public Ticket(String currentDate, String ticketDate){
        LocalDate tempDate = LocalDate.now();
        // invalidate current date
        if(currentDate.compareTo(tempDate.toString()) > 0){
            throw new IllegalArgumentException("The first date must be current date");
        }

        // invalidate ticket date
        if(currentDate.compareTo(ticketDate) > 0){
            throw new IllegalArgumentException("Invalid date, ticket date cannot be earlier than the current date.");
        }else{
            setTicketNumber();
        }
    } // end constructor with parameter

    // set ticketNumber
    public void setTicketNumber(){
        Random randomInt = new Random();
        int temp = randomInt.nextInt(1,100);
        if(temp < 10){
            this.ticketNumber = String.format("0%d", temp);
        }else{
            this.ticketNumber = String.format("%d", temp);
        }
    } // end method setTicketNumber

    // set price
    public void setTicketPrice(double thePrice){
        this.ticketPrice = thePrice;
    } // end method setTicketPrice

    // set price by abstract method
    public abstract void setTicketPrice(String currentDate, String ticketDate);


    // get ticket number
    public String getTicketNumber(){
        return this.ticketNumber;
    } // end method getTicketNumber

    // get price
    public double getTicketPrice(){
        return this.ticketPrice;
    } // end method getTicketPrice

    // return string representation of Ticket object
    @Override
    public String toString(){
        return String.format("%n%s: %s, %s: %.1f",
        "Number",getTicketNumber(),
        "Price",getTicketPrice());
    } // end method toString

} // end class Ticket
