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
 
    public int ticketPrice;
 
    public Ticket(Date currentDate, Date ticketDate) {
    }

    protected String setTicketNumber(){
        Random r = new Random();
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
 
        StringBuilder ticketNumber = new StringBuilder();
        //generates random string of 10 characters randomly picked form allChars.
        for(int i=0; i<=10; i++){
            int index = r.nextInt(36);
            ticketNumber.append(allChars.charAt(index));
        }
        return ticketNumber.toString();
    }
 
    @Override
    public abstract String toString();
 
    public abstract void getPrice();
 
}
