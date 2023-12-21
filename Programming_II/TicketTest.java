/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */

public class TicketTest {
    public static void main(String[] args) {
        WalkupTicket walkupTicket = new WalkupTicket();
        System.out.println(walkupTicket);

        AdvanceTicket advanceTicket1 = new AdvanceTicket(12);
        System.out.println(advanceTicket1);

        AdvanceTicket advanceTicket2 = new AdvanceTicket(8);
        System.out.println(advanceTicket2);

        StudentAdvanceTicket studentAdvanceTicket1 = new StudentAdvanceTicket(15);
        System.out.println(studentAdvanceTicket1);

        StudentAdvanceTicket studentAdvanceTicket2 = new StudentAdvanceTicket(7);
        System.out.println(studentAdvanceTicket2);
    }
}

