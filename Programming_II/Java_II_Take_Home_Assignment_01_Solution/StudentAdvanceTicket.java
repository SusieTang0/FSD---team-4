// StudentAdvanceTicket.java
package Java_II_Take_Home_Assignment_01_Solution;

/**
 * Implement a class called StudentAdvanceTicket to represent tickets purchased in advance by students.
 * 
 * @version  1.0
 * @since 2023-12-19
 * @author Shuting Tang
 */

public class StudentAdvanceTicket extends AdvancedTicket {
    // data member
    private String studentId;

    //
    public StudentAdvanceTicket(String currentDate, String ticketDate,String theStudentId){
        super(currentDate, ticketDate);
        setStudentId(studentId);
    }

    // set student id
    public void setStudentId(String aStudentId){
        if(aStudentId != ""){
            this.studentId = aStudentId;
        }else{
            throw new IllegalArgumentException("Not a student, please choose other ticket type");
        }
        
    } //  end method setStudentId

    // get student id
    public String getStudentId(){
        return this.studentId;
    } //  end method setStudentId
    
    // set the price of student advance ticket 
    @Override
    public void setTicketPrice(String currentDate, String ticketDate){
        super.setTicketPrice(currentDate, ticketDate);
        super.setTicketPrice(0.5 * super.getTicketPrice());
    } // end set Price

     // return string representation of StudentAdvanceTicket object
     @Override
     public String toString(){
         return String.format("%s %s (%s)","Student",super.toString(),"ID required");
     } // end method toString

} // end class StudentAdvanceTicket
