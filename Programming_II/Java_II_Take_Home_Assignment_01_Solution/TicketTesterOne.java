package Java_II_Take_Home_Assignment_01_Solution;

/**
 * Implement a class called Ticket that will serve as the superclass for all three types of tickets.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang
 */

public class TicketTesterOne {
    public static void main(String[] args) {
        // create instance of each ticket class
        WalkupTicket walkupTicket1 = new WalkupTicket("2023-12-19", "2023-12-19");
        AdvancedTicket advancedTicket1 = new AdvancedTicket("2023-12-19", "2023-12-25");
        AdvancedTicket advancedTicket2 = new AdvancedTicket("2023-01-19", "2023-12-19");
        StudentAdvanceTicket studentAdvanceTicket1 = new StudentAdvanceTicket("2023-12-19", "2023-12-25", "223344555");
        StudentAdvanceTicket studentAdvanceTicket2 = new StudentAdvanceTicket("2023-12-19", "2024-01-25", "667788999");


        // display these ticket and price
        System.out.println(walkupTicket1.toString());
        System.out.println();
        System.out.println(advancedTicket1.toString());
        System.out.println();
        System.out.println(advancedTicket2.toString());
        System.out.println();
        System.out.println(studentAdvanceTicket1.toString());
        System.out.println();
        System.out.println(studentAdvanceTicket2.toString());
    }
}
