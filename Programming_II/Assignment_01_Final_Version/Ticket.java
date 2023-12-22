// Ticket.java
package Take_Home_Assignment_01_Solution_Version_2;

import java.util.Random;

/**
 * Abstract class Ticket serve as the superclass for all three types of tickets.
 * 
 * @version  1.0
 * @since 2023-12-21
 * @author Shuting Tang (leader), Evan Sharp, Shawnelle Mc Nicols, Bo Sun
 */

public abstract class Ticket {
    // data member
    public String ticketNumber;
 
    // constructor with parameters
    public Ticket(String theTicketNumber) {
        // check validation of ticket number
        // if the ticket number equal to "", create a number for the user
        if(theTicketNumber == ""){
            Random r = new Random();
            String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
            StringBuilder aTicketNumber = new StringBuilder();
            //generates random string of 10 characters randomly picked form allChars.
            for(int i=0; i<=10; i++){
                int index = r.nextInt(36);
                aTicketNumber.append(allChars.charAt(index));
            }
            this.ticketNumber = aTicketNumber.toString();
        }else{
            this.ticketNumber = theTicketNumber;
        } // end if block
    }// end constructor with parameters

    // return string representation of WalkupTicket object
    @Override
    public String toString(){
        return this.ticketNumber;
    } // end method toString
 
    // abstract method to get ticket price
    public abstract double getTicketPrice();

} // end class Ticket
