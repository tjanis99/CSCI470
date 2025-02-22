/**********************************************************
 * CSCI 470/502     Assignment 1    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 06/21/2024.
 * Purpose: First assignment to add numbers in terminal.
 **********************************************************/
import java.util.Scanner;
/*
 * Add1.java
 *
 * Console program to add two numbers.
 */
public class Add1
{
    public static void main(String[] args)
    {
        String amountStr;
        double num1, num2;
        Scanner sc = new Scanner(System.in);
// Read the first number as a String.
        System.out.println("Enter the first number: ");
        amountStr = sc.next();
// Try to convert String to double for calculation.
        try {
            num1 = Double.parseDouble(amountStr);
        } catch (NumberFormatException nfe) {
            System.out.println("1st number invalid.");
            return;
        }
// Read the second number as a String.
        System.out.println("Enter the second number: ");
        amountStr = sc.next();
// Try to convert String to double for calculation.
        try {
            num2 = Double.parseDouble(amountStr);
        } catch (NumberFormatException nfe) {
            System.out.println("2nd number invalid.");
            return;
        }
// Compute and print the sum.
        System.out.printf("Sum is: %.2f\n", num1 + num2);
    }
}