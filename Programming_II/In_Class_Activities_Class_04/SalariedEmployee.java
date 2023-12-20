// SalariedEmployee.java
package In_Class_Activities_Class_04;

import java.util.Scanner;

/**
 * SalariedEmployee extends the Abstract class Employee
 * 
 * @version 1.02
 * @since 2023-12-19
 * @author Shuting Tang
 */

public class SalariedEmployee extends Employee {
    // data members
    protected double weeklySalary;
    private int employedYears;

    // default constructor
    public SalariedEmployee(){
        super();
    };

    // constructor with parameters
    public SalariedEmployee(String aFirstName, String aLastName, String aSocialSecurityNumber, int anEmployedYears,double aWeeklySalary) {
        super(aFirstName, aLastName, aSocialSecurityNumber);

        // call setEmployedYears
        setEmployedYears(anEmployedYears);
        // call setWeeklySalary
        setWeeklySalary(aWeeklySalary);
    } // end constructor with parameters

     // return employed years
    public void setEmployedYears(int theEmployedYears) {
        this.employedYears = theEmployedYears;
    } // end method getEmployedYears

    // set weekly salary
    public void setWeeklySalary(double theWeeklySalary){
        // check if weeklySalary is a positive value
        if (theWeeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be greater than or equal to zero.");
        } 
        this.weeklySalary = theWeeklySalary;
    } // end method setWeeklySalary

    // return employed years
    public int getEmployedYears() {
        return this.employedYears;
    } // end method getEmployedYears

    // return weeklySalary
    public double getWeeklySalary() {
        return this.weeklySalary;
    } // end method getWeeklySalary

    // calculate earnings: implement (override) the abstract method getEarnings in
    // the abstract class Employee
    @Override
    public double getEarnings() {
        return getWeeklySalary();
    } // end method getEarnings

    // return string representation of salariedEmployee object
    @Override
    public String toString() {
        return String.format("%s %n%s: %d \t%s: $%,.2f",
                super.toString(), "Employed Years", getEmployedYears(),"Weekly Salary", getWeeklySalary());
    } // end mwthod toString

    // implement method close of interface AutoCloseable
    @Override
    public void close() throws Exception {
        System.out.println("This Employee Card is closed.");
        System.out.println();
    } // end method close

    // implement method run of interface Runnable
    @Override
    public void run() {
        String firstStr,secondStr,thirdStr;
        int years;
        double salary;
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please enter your first name: ");
        firstStr = console.next();
        System.out.println("Please enter your last name: ");
        secondStr = console.next();
        System.out.println("Please enter your social insurance number: ");
        thirdStr = console.next();
        System.out.println("Please enter your employeed years: ");
        years = console.nextInt();
        System.out.println("Please enter your weekly salary: ");
        salary = console.nextDouble();

        console.close();
        super.setEmployee(firstStr, secondStr, thirdStr);
        this.employedYears = years;
        this.weeklySalary = salary;
    } // end method run

    // implement method compareTo of interface Comparable
    @Override
    public int compareTo(Integer year) {
        if(getEmployedYears() == year){
            return 0;
        }else if(getEmployedYears() < year){
            return -1;
        }else{
            return 1;
        }
    } // end method compareTo

    // return string representation of employed year comparation result
    public String compare(SalariedEmployee employee2) {
        if(compareTo(employee2.getEmployedYears()) < 0){
            return String.format("%s has been with this company longer than %s.",employee2.getFirstName(),getFirstName());
        }else if(compareTo(employee2.getEmployedYears()) > 0){
            return String.format("%s has been with this company longer than %s.",getFirstName(),employee2.getFirstName());
        }else{
            return String.format("%s and %s both have been in this company for %d years ",getFirstName(),employee2.getFirstName(),getEmployedYears());
        }
    } // end method compareTo
} // end class SalariedEmployee