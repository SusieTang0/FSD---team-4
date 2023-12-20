// Employee.java
package In_Class_Activities_Class_04;

/**
 * Employee abstract superclass implements interface Payable
 * 
 * @version 1.02
 * @since 2023-12-19
 * @author Shuting Tang
 */

public abstract class Employee implements Cloneable,Comparable<Integer>,AutoCloseable,Runnable{
    // data member 
    private String firstname;
    private String lastname;
    private String socialSecurityNumber;

    // default constructor
    public Employee() {}

    // constructor with parameters
    public Employee(String aFirstName, String aLastName, String aSocialSecurityNumber) {
        this.firstname = aFirstName;
        this.lastname = aLastName;
        this.socialSecurityNumber = aSocialSecurityNumber;
    } // end constructor with parameters 

    //set employee
    public void setEmployee(String aFirstName, String aLastName, String aSocialSecurityNumber){
        this.firstname = aFirstName;
        this.lastname = aLastName;
        this.socialSecurityNumber = aSocialSecurityNumber;
    }
    // return first name
    public String getFirstName() {
        return this.firstname;
    } // end method getFirstName

    // return lastname 
    public String getLastName() {
        return this.lastname;
    } // end method getLastName

    // return social security number 
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    } // end method socilaSecurityNumber

    // return string representation of employee object 
    @Override 
    public String toString() {
        return String.format("Name: %s %s \tSIN: %s"
        , getFirstName(), getLastName(), getSocialSecurityNumber());
    } // end emthod toString 
 
    // abstract method must be overriden by concrete subclass
    public abstract double getEarnings();   // no implementation here 

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


} // end class Employee

