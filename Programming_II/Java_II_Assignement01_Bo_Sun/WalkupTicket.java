/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */
    public class WalkupTicket extends Ticket {
        public WalkupTicket() {
            super();
            setPrice(50.0);
        }
    
        @Override
        public void calculatePrice() {
            // WalkupTicket does not need to implement this method as the price is fixed
        }
    }
    
