/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */

public class StudentAdvanceTicket extends AdvanceTicket {
    public StudentAdvanceTicket(int daysInAdvance) {
        super(daysInAdvance);
        setPrice(getPrice() / 2); // Half of normal advance ticket price
    }

    @Override
    public String toString() {
        return super.toString() + " (ID required)";
    }
}
