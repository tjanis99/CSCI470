/**********************************************************
 * CSCI 470/502     Assignment 5    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/26/2024.
 * Purpose: Payroll system test to create employees, categorize them,
 * and pay accordingly polymorphically
 **********************************************************/
// PayrollSystemTest.java
// Employee hierarchy test program.

import java.util.Scanner;

public class PayrollSystemTest {

   public static void main(String[] args) {

      //scanner for user input
      Scanner input = new Scanner(System.in);
   
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee("John", "Smith", "111-11-1111", new Date(6,15,1944),  800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(12,29,1960),  16.75, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee(
         "Sue", "Jones", "333-33-3333", new Date(9,8,1954), 10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee(
         "Bob", "Lewis", "444-44-4444", new Date(3,2,1965), 5000, .04, 300);

      System.out.println("Employees processed individually:");
      
      System.out.printf("%n%s%n%s: $%,.2f%n%n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      // read user input for current month
      System.out.print("Enter the current month: ");
      int currentMonth = input.nextInt();

      System.out.printf("%nEmployees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) {

         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) { 
         
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
         }

         // determine if current month matches current employees birthday month
         if (currentEmployee.getBirthDate().getMonth() == currentMonth) {
            System.out.printf("earned $%,.2f", currentEmployee.earnings());
            System.out.printf(" plus $100.00 birthday bonus%n%n");

            // otherwise print earnings regularly
         } else {
            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());

         }
      }

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName()); 
   }
}
