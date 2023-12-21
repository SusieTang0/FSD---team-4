/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */


public class WalkupTicket extends Ticket {

    // Data members
    private double ticketPrice;

    // Constructors

    // Default constructor
    public WalkupTicket() {
        super("");
        this.ticketPrice = 50;
    }

    // Constructor with parameters
    public WalkupTicket(String theTicketNumber, double theTicketPrice) {
        super(theTicketNumber);
        this.ticketPrice = theTicketPrice;
    }



    @Override
    public double getPrice() {
        return this.ticketPrice;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Ticket id: " + super.toString() + ", Price: " + getPrice();
    }

    
}

