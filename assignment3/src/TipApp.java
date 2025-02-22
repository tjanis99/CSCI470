/**********************************************************
 * CSCI 470/502     Assignment 3    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/12/2024.
 * Purpose: Tip calculator console program to calculate total
 * bill including tips and split the total amongst guests.
 **********************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

/*
 * TipApp.java
 *
 * Encapsulates the user interface of tip calculator app.
 */
public class TipApp {

    static TipCalculator tipCalculator = new TipCalculator();
        //tip calculator object

    public static void main(String[] args) {
        TipApp app = new TipApp(); //tip app object to call calculator
        app.calculateTips(); //calculator to initiate user input
    }

    /*
     * Interface to receive user input, call functions in tipCalculator to
     * find total and tip shares for individuals, then prints each followed
     * by calculated bill including tips for any number of checks.
     */
    public static void calculateTips() {
        char choice; //saves user input to restart program
        Scanner scanner = new Scanner(System.in); //scanner for input
        System.out.println("*** Tip Calculator ***\n"); //header
        do {    //loops all calculations in program for new bill

            double calcBill; //to save bill to be processed
            while (true) { //restarts bill input in case of errors
                try { //to catch number format exceptions
                    System.out.print("Enter the bill amount: ");
                    calcBill = Double.parseDouble(scanner.next()); //get user input
                    if (calcBill > 0) { //if equal to or less than zero
                        tipCalculator.setBillAmount(calcBill); //otherwise update valid bill amount
                        break;
                    } else {
                        System.out.println("Bill amount cannot be negative"); //error message
                    }
                } catch (NumberFormatException e) { //checks for invalid characters
                    System.out.println("Please enter a valid bill amount."); //error message
                }
            }

            int calcTip; //to save tip from user input
            while (true) { //restarts tip input in case of errors
                try { //to catch number format exceptions
                    System.out.print("Enter your desired tip percentage (20 equals 20%): ");
                    calcTip = Integer.parseInt(scanner.next()); //get user input
                    if (calcTip >= 0) {
                        tipCalculator.setTipPercent(calcTip); //otherwise update valid tip percent
                        break;
                    } else {
                        System.out.println("Tip amount cannot be negative"); //error message
                    }
                } catch (NumberFormatException e) { //checks for invalid characters
                    System.out.println("Please enter a valid tip percentage."); //error message
                }
            }

            int calcParty; //to save party size from user input
            while (true) { //restarts tip input in case of errors
                try { //to catch number format exceptions
                    System.out.print("Enter the size of your party: ");
                    calcParty = Integer.parseInt(scanner.next()); //get user input
                    if (calcParty > 0) {
                        tipCalculator.setPartySize(calcParty); //otherwise update party size
                        break;
                    } else {
                        System.out.println("Party size cannot be negative"); //error message
                    }
                } catch (NumberFormatException e) { //checks for invalid characters
                    System.out.println("Please enter a valid party size."); //error message
                }
            }

            System.out.println("\n*** Your Bill ***\n"); //header
            DecimalFormat tipFormat = new DecimalFormat("$##,###,##0.00");
                //decimal format for prices
            System.out.printf("Bill Amount: %s\n", tipFormat.format(tipCalculator.getBillAmount()));
                //prints bill amount without tip added
            System.out.printf("Tip percentage: %d%%\n", tipCalculator.getTipPercent());
                //prints tip percentage
            System.out.printf("Party Size: %d\n\n", tipCalculator.getPartySize());
                //prints party size
            double totalBill = tipCalculator.getTotalBillAmount(tipCalculator.getBillAmount(), tipCalculator.getTipPercent());
            System.out.printf("Total Bill (with Tip): %s\n", tipFormat.format(totalBill));
                //prints total bill amount with tip included after calculation from tipCalculator

            double totalShare = tipCalculator.getIndividualShare(totalBill, tipCalculator.getPartySize());
            System.out.printf("Share for Each Individual: %s\n", tipFormat.format(totalShare));
                //prints total share for each customer after calculation from tipCalculator
            System.out.print("\nAnother bill? (y/n): ");
            choice = scanner.next().toLowerCase().charAt(0); //character input to restart loop for new bill
        } while ((choice == 'y') || (choice == 'Y')); //checks for Y/y input to restart
        System.out.println("\nGoodbye!\n"); //exit message
    }
}
