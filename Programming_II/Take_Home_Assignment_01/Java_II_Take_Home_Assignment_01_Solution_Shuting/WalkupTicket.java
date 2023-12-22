package Java_II_Take_Home_Assignment_01_Solution;


/**
 * Implement a class called WalkupTicket to represent a walk-up event ticket.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang
 */

public class WalkupTicket extends Ticket{

    // constructor with parameters
    public WalkupTicket(String currentDate, String ticketDate){
        super(currentDate, ticketDate); 
        setTicketPrice(currentDate, ticketDate);
    } // end constructor with parameters

    // return string representation of WalkupTicket object
    @Override
    public String toString(){
        return "Walk-up Ticket: " + super.toString();
    } // end method toString

    // use the abstract method setTicketPrice of superclass to set the price of walk-up tickets 
    @Override
    public void setTicketPrice(String currentDate, String ticketDate) {
        // invalidate walk-up ticket 
        if(currentDate.compareTo(ticketDate) == 0){
            super.setTicketPrice(50);
        }else{
            throw new IllegalArgumentException("You can't buy walk-up tickets now, please choose other type of tickets.");
        }  
    } // end method setTicketPrice
 
} //  end class WalkupTicket
