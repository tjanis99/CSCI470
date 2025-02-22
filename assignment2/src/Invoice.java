/**********************************************************
 * CSCI 470/502     Assignment 2    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/03/2024.
 * Purpose: Creates invoices for a hardware store to represent
 * an item sold at the store.
 **********************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

/*
 * Invoice.java
 *
 * Program to generate invoices for items sold
 */
public class Invoice
{
        private String partNumber;
        private String description;
        private Integer quantity;
        private Double price;

        /*
         * Sets current number for new part.
         */
        public void setPartNumber(String partNumber)
        {
                this.partNumber = partNumber; //updates part number
        }

        /*
         * Prints and returns current part number.
         */
        public String getPartNumber()
        {
                System.out.printf("\tPart No.: %s", partNumber); //print number
                return partNumber; //current part number
        }

        /*
         * Sets current description for new part.
         */
        public void setDescription(String description)
        {
                this.description = description; //changes description
        }

        /*
         * Prints and returns current description.
         */
        public String getDescription()
        {
                System.out.printf("\n\tItem Desc.: %s", description);
                return description; //current description
        }

        /*
         * Sets current quantity for new part.
         */
        public void setQuantity(Integer quantity)
        {
                this.quantity = quantity; //changes quantity
        }

        /*
         * Prints and returns current quantity if positive.
         */
        public Integer getQuantity()
        {
                if (quantity < 0){ //Guarantees quantity isn't subzero.
                        System.out.printf("\n\tQuantity: %d", quantity = 0);
                        return quantity = 0; //resets to zero
                } else { //prints otherwise
                        System.out.printf("\n\tQuantity: %d", quantity);
                        return quantity; //updates quantity for invoice
                }
        }

        /*
         * Sets current price for new part.
         */
        public void setPrice(Double price)
        {
                this.price = price; //changes price
        }

        /*
         * Prints and returns current price if positive.
         */
        public Double getPrice()
        {
                if (price < 0.0){ //Checks price isn't negative.
                        System.out.printf("\n\tItem Price: %.2f", price = 0.0);
                        return price = 0.0; //resets to zero
                } else { //prints otherwise
                        System.out.printf("\n\tItem Price: %.2f", price);
                        return price;
                }
        }

        /*
         * Calculates parts total, converts to decimal format
         * then prints and returns invoice subtotal of parts.
         */
        public double getInvoiceAmount()
        {
                double invoiceAmount = quantity * price; //calculate total
                DecimalFormat invFormat = new DecimalFormat("$##,###,##0.00"); //convert
                System.out.printf("\n\tInvoice Subtotal: %s\n", invFormat.format(invoiceAmount)); //print
                return invoiceAmount; //return total
        }
}

