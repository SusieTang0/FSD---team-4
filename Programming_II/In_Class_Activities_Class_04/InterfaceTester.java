package In_Class_Activities_Class_04;

import java.util.*;

/**
 * Find at least 5 interfaces of the Java API and give an example of each.
 * For example:
 * Comparable interface
 * Cloneable interface
 * Comparator Interface
 * Runnable Interface
 * AutoCloseable Interface
 * 
 * @version 1.00
 * @since 2023-12-19
 * @author Shuting Tang
 */

public class InterfaceTester{

    public static void main(String[] args) throws Exception,CloneNotSupportedException {
        // declare new instances of class SalariedEmployee
        SalariedEmployee firstEmployee = new SalariedEmployee(); // John, Smith, 111-222-333, 10, 800
        SalariedEmployee secondEmployee = new SalariedEmployee("Mary","Bell","555-666-777",15,900);
        SalariedEmployee thirdEmployee = new SalariedEmployee("Lily","Rock","000-999-111",10,750);

        /* 1. Test Runnable Interface */ 
        // prompt user to start
        System.out.println("======================================");
        System.out.println("1.Test Runnable Interface");
        System.out.println("======================================");
        firstEmployee.run();
        System.out.println();

        /* 2. Test Closable Interface */
        System.out.println("======================================");
        System.out.println("2.Test Closable Interface");
        System.out.println("======================================");
        firstEmployee.close();

        /* 3. Test Comparable Interface */ 
        // campare the years employees work in this company
        System.out.println("======================================");
        System.out.println("3. Test Comparable Interface");
        System.out.println("======================================");
        
        // display employees' information
        System.out.println("Employees Information Display");
        System.out.println("-----------------------------");
        System.out.printf("Emloyee One: %n%s%n", firstEmployee.toString());
        System.out.println();
        System.out.printf("Emloyee Two: %n%s%n", secondEmployee.toString());
        System.out.println();
        System.out.printf("Emloyee Three: %n%s%n",thirdEmployee.toString());
        System.out.println();

        // campare the employed years of two employees
        System.out.printf("1. Compare %s and %s",firstEmployee.getFirstName(), secondEmployee.getFirstName());
        if(firstEmployee.compareTo(secondEmployee.getEmployedYears()) < 0){
            System.out.printf("%n\t%s has been with this company longer than %s.",secondEmployee.getFirstName(),firstEmployee.getFirstName());
        }else if(firstEmployee.compareTo(secondEmployee.getEmployedYears()) > 0){
            System.out.printf("%n\t%s has been with this company longer than %s.",firstEmployee.getFirstName(),secondEmployee.getFirstName());
        }else{
            System.out.printf("%n\t%s and %s both have been in this company for %d years ",firstEmployee.getFirstName(), secondEmployee.getFirstName(),firstEmployee.getEmployedYears());
        }
        System.out.println();

        // compare the work years between employee1 and employee3
        System.out.printf("2. Compare %s and %s",firstEmployee.getFirstName(),thirdEmployee.getFirstName());
        System.out.printf("%n\t%s%n",firstEmployee.compare(thirdEmployee));
        System.out.println();

        /* 4. Test Cloneable Interface */
        System.out.println("======================================");
        System.out.println("4. Test Cloneable Interface");
        System.out.println("======================================");
        
        System.out.printf("Clone information from %s, %nhis/her information is: %n%n%s%n",thirdEmployee.getFirstName(),thirdEmployee.toString());
        SalariedEmployee forthEmployee = (SalariedEmployee) thirdEmployee.clone();
    
        System.out.printf("%nEmployee Four: %n\t%s%n", forthEmployee.toString());

        // change values in the cloning instance
        System.out.println("--------------------------------------");
        System.out.printf("Reset Name and SIN of Employee Four %nName: %s \tSIN: %s%n","Laura Wood","777-888-999");
        forthEmployee.setEmployee("Laura", "Wood", "777-888-999");
        System.out.printf("%nResult after reset:%n%s%n",forthEmployee.toString());
        System.out.println("--------------------------------------");

        System.out.printf("%nDisplay the information of %s & %s: %n%n%s%n%n%s%n",thirdEmployee.getFirstName(),forthEmployee.getFirstName(),thirdEmployee.toString(),forthEmployee.toString());
        System.out.println();

        /* 5. Test Comparator Interface */
        System.out.println("======================================");
        System.out.println("5. Test Comparator Interface");
        System.out.println("======================================");
        // create a list , the type of element is SalariedEmployee 
        List<SalariedEmployee> employees = new ArrayList<>();
        // add four elements 
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        employees.add(forthEmployee);

        // display the list before sorted
        System.out.println("Employees List before sorted");
        System.out.println("----------------------------");
        for(SalariedEmployee employee:employees){
            System.out.println(employee);
            System.out.println();
        }

        // use comparator and collections to sort the elements of the list employees
        Comparator<SalariedEmployee> salaryComparator = Comparator.comparingDouble(employee -> employee.weeklySalary);
        Collections.sort(employees, salaryComparator);

        // display the list after sorted
        System.out.println("Employees sorted by Salary");
        System.out.println("--------------------------");
        for(SalariedEmployee employee:employees){
            System.out.println(employee);
            System.out.println();
        }

    } // end method main
} // end class InterfaceTester