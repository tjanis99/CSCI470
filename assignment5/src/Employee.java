/**********************************************************
 * CSCI 470/502     Assignment 5    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/26/2024.
 * Purpose: Employee constructor & methods for superclass
 **********************************************************/
// Employee.java
// Employee abstract superclass.

public abstract class Employee {

   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthDate;

   // constructor
   public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
   
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;
      this.birthDate = birthDate;
   } 

   // return first name
   public String getFirstName() {
   
      return firstName;
   } 

   // return last name
   public String getLastName() {
   
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber() {
   
      return socialSecurityNumber;
   }

   // return birthDate object containing month, day, year
   public Date getBirthDate() {

      return birthDate;

   }

   // return String representation of Employee object
   @Override
   public String toString() {
   
      return String.format("%s %s%nsocial security number: %s %nbirth date: %s",
         getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings();
     // no implementation here
}
