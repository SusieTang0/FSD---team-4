// StudentAdvanceTicket.java
package Take_Home_Assignment_01_Solution_Version_2;

import java.time.LocalDate;

/**
 * Class StudentAdvanceTicket to represent tickets purchased in advance by students.
 * 
 * @version  1.0
 * @since 2023-12-18
 * @author Shuting Tang (leader), Evan Sharp, Shawnelle Mc Nicols, Bo Sun
 */

public class StudentAdvanceTicket extends AdvanceTicket {
    // data member
    private String studentId;

    // constructor with parameters
    public StudentAdvanceTicket(String theTicketNumber, LocalDate ticketDate,String theStudentId){
        super(theTicketNumber, ticketDate);
        // call method setStudentId
        setStudentId(theStudentId);
    } // end constructor with parameters

    // set student id
    public void setStudentId(String aStudentId){
        // invalidate student id
        if(aStudentId == ""){
            throw new IllegalArgumentException("Not a student, please choose other ticket type");
        } // end if block

        this.studentId = aStudentId; 
    } //  end method setStudentId

    // get student id
    public String getStudentId(){
        return this.studentId;
    } // end method setStudentId
    
    // set the price of student advance ticket 
    @Override
    public void setTicketPrice(LocalDate ticketDate){
        super.setTicketPrice(ticketDate);
        super.ticketPrice = 0.5 * super.getTicketPrice();
    } // end set Price

    // return string representation of StudentAdvanceTicket object
    @Override
    public String toString(){
        return String.format("%s %s (%s: %s)","Student",super.toString(),"ID",getStudentId());
    } // end method toString

} // end class StudentAdvanceTicket
