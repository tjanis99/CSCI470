/**********************************************************
 * CSCI 470/502     Assignment 4    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/19/2024.
 * Purpose: Mile Redeemer main program to read destinations, retrieve city names,
 * set mileage on accounts, and conclude which flights are possible within valid months
 * includes interface to interact
 **********************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * MileRedeemerApp.java
 *
 * Driver program for MileRedeemer
 */
public class MileRedeemerApp {

    public static void main(String[] args) throws FileNotFoundException {
        int month;  //stores month input
        int miles;  //saves mile input
        boolean stop; //toggle to stop loop

        Scanner nameScanner = new Scanner(System.in); //to scan file names
        Scanner keyScanner = new Scanner(System.in); //to scan for input

        System.out.print("Please enter the name of the destination file: ");
        String fileName = nameScanner.nextLine(); //retrieve input

        Scanner fileScanner = new Scanner(new File(fileName)); //enter files

        MileRedeemer mileRedeemer = new MileRedeemer(); //mile redeemer object creation
        mileRedeemer.readDestinations(fileScanner); //pass file to redeemer

        String[] cities = mileRedeemer.getCityNames(); //create city list

        for (int i = 0; i < 75; i++) {
            System.out.print("-");
        }

        System.out.println("\n\tWELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");

        for (int i = 0; i < 75; i++) { //header
            System.out.print("-");
        }

        System.out.println("\n\nList of destination cities your client can travel to:\n");

        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]); //possible cities based on mile redeemer cities
        }
        System.out.print("\n");

        do {
            for (int i = 0; i < 75; i++) {
                System.out.print("-");
            }

            System.out.print("\n\nPlease enter your client's accumulated Frequent Flyer Miles: ");
            miles = keyScanner.nextInt(); //enter user input for accumulated miles

            System.out.print("\nPlease enter your client's month of departure (1-12): ");
            month = keyScanner.nextInt(); //enter departure month from user

            String[] redeem = mileRedeemer.redeemMiles(miles, month); //pass vars to mile redeemer, return tickets

            if (redeem.length > 0) { //if not empty
                System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets: \n");

                for (int i = 0; i < redeem.length; i++) {
                    System.out.println(redeem[i]); //print possible locations
                }
            } else { //otherwise print message
                System.out.print("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
            }

            System.out.println("\nYour client's remaining Frequent Flyer Miles: " + mileRedeemer.getRemainingMiles());
            System.out.print("\n");

            for (int i = 0; i < 75; i++) {
                System.out.print("-");
            }

            System.out.print("\n\n");
            System.out.print("Do you want to continue? (Y/N): ");
            String answer = keyScanner.next(); //to check for more mileages
            System.out.print("\n");

            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    stop = true;
            } else {
                    stop = false; //stop loop based on user input
                }
            } while (stop);

            for (int i = 0; i < 85; i++) {
                System.out.print("-");
            }

            System.out.println("\n\tTHANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");

            for (int i = 0; i < 85; i++) {
                System.out.print("-");
            }
    }
}

