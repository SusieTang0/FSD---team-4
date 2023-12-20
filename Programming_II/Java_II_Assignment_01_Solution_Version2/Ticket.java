// Ticket.java
package Java_II_Assignment_1_V2_data;

import java.util.*;

/**
 * Implement a abstract class called Ticket that will serve as the superclass for all three types of tickets
 * @version  1.0
 * @since 2023-12-18
 * @author Evan Sharp
 */

abstract class Ticket{
    // data member
    public String ticketNumber;
 
    // constructor with parameters
    public Ticket(String theTicketNumber) {
        // check validation of ticket number
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


    @Override
    public String toString(){
        return this.ticketNumber;
    };
 
    // abstract method to get ticket price
    public abstract double getPrice();
 
}
