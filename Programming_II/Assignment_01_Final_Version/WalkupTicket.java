// WalkupTicket.java
package Take_Home_Assignment_01_Solution_Version_2;

import java.time.LocalDate;

/**
 * Implement a class called WalkupTicket to represent a walk-up event ticket.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang
 */

public class WalkupTicket extends Ticket{
    // data member
    private double ticketPrice;

    // constructor with parameters
    public WalkupTicket(String theTicketNumber, LocalDate ticketDate){
        super(theTicketNumber); 

        // call method setTicketPrice
        setTicketPrice(ticketDate);
    } // end constructor with parameters

    // set the price of walk-up tickets 
    public void setTicketPrice(LocalDate ticketDate) {
        // invalidate walk-up ticket date
        if(!ticketDate.equals(LocalDate.now())){
            throw new IllegalArgumentException("You can't buy walk-up tickets now, please choose other type of tickets.");
        }else{
            // set walk-up ticket price
            this.ticketPrice = 50;
        } // end if block
    } // end method setTicketPrice

    // return string representation of WalkupTicket object
    @Override
    public String toString(){
        return String.format("Ticket Number: %s, Price: $%.1f ",super.toString(), getTicketPrice());
    } // end method toString

    // use abstract method getTicketPrice to get price
    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    } // end method getTicketPrice
 
} // end class WalkupTicket
