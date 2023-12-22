// AdvancedTicket.java
package Take_Home_Assignment_01_Solution_Version_2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class AdvanceTicket to represent tickets purchased in advance.
 * 
 * @version  1.1
 * @since 2023-12-21
 * @author Shuting Tang (leader), Evan Sharp, Shawnelle Mc Nicols, Bo Sun
 */

public class AdvanceTicket extends Ticket{
    // data member
    protected double ticketPrice;
    
    // constructor with parameters
    public AdvanceTicket(String theTicketNumber, LocalDate ticketDate) {
        super(theTicketNumber);
        
        // call method setTicketPrice
        setTicketPrice(ticketDate);
    } // end constructor with parameters

    // set the price of advanced ticket
    public void setTicketPrice(LocalDate ticketDate){
        // invalidate walk-up ticket date
        if(ticketDate.equals(LocalDate.now())){
            throw new IllegalArgumentException("You can't buy advanced tickets now. Please choose walk-up ticket.");
        }else if(ChronoUnit.DAYS.between(LocalDate.now(),ticketDate)  >= 10){
            this.ticketPrice = 30;
        }else{
            this.ticketPrice = 40;
        } // end if block
    } // end set Price

    // return string representation of AdvancedTicket object
    @Override
    public String toString(){
        return String.format("Ticket Number: %s, Price: $%.1f ",super.toString(), getTicketPrice());
    } // end method toString

    // use abstract method getTicketPrice to get price
    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    } // end method getTicketPrice

} //  end class AdvancedTicket
