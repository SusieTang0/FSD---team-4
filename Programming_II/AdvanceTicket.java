/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */

public class AdvanceTicket extends Ticket {
    private int daysInAdvance;

    public AdvanceTicket(int daysInAdvance) {
        super();
        this.daysInAdvance = daysInAdvance;
        calculatePrice(); // Call the abstract method in the constructor
    }

    @Override
    public void calculatePrice() {
        if (daysInAdvance >= 10) {
            setPrice(30.0);
        } else {
            setPrice(40.0);
        }
    }
}
