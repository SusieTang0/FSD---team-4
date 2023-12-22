package Take_Home_Assignment_01_Solution_Version_2;

import java.time.LocalDate;

/**
 * Test superclass Ticket and three subclass: 
 * WalkupTicket, AdvancedTicket and StudentAdvanceTicket
 * 
 * @version  1.0
 * @since 2023-12-21
 * @author Shuting Tang (leader), Evan Sharp, Shawnelle Mc Nicols, Bo Sun
 */

public class TicketTesterOne {
    public static void main(String[] args) {
        // create instance of each ticket class
        WalkupTicket walkupTicket1 = new WalkupTicket("", LocalDate.now());
        AdvanceTicket advanceTicket1 = new AdvanceTicket("123456", LocalDate.now().plusDays(7));
        AdvanceTicket advanceTicket2 = new AdvanceTicket("", LocalDate.now().plusDays(15));
        StudentAdvanceTicket studentAdvanceTicket1 = new StudentAdvanceTicket("123456", LocalDate.now().plusDays(7), "223344555");
        StudentAdvanceTicket studentAdvanceTicket2 = new StudentAdvanceTicket("", LocalDate.now().plusDays(10), "667788999");


        // display these ticket and price
        System.out.println(walkupTicket1.toString()); 
        System.out.println();
        System.out.println(advanceTicket1.toString());
        System.out.println();
        System.out.println(advanceTicket2.toString());
        System.out.println();
        System.out.println(studentAdvanceTicket1.toString());
        System.out.println();
        System.out.println(studentAdvanceTicket2.toString());
    } // end method main
} // end class TicketTesterOne
