/**********************************************************
 * CSCI 470/502     Assignment 2    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/03/2024.
 * Purpose: Tests invoice terminal program using hardcoded values.
 **********************************************************/
/*
 * InvoiceTest.java
 *
 * Driver program to test Invoice.java for items sold
 */
public class InvoiceTest
{
    public static void main(String[] args)
    {   // New invoice object for part sold
        Invoice invoice1 = new Invoice();
        // Changes data for part
        invoice1.setPartNumber("AB-23-4312");
        invoice1.setDescription("Cordless Drill");
        invoice1.setQuantity(10);
        invoice1.setPrice(189.00);
        // Invoice header
        System.out.println("\nInvoice #1");
        // Print part data
        invoice1.getPartNumber();
        invoice1.getDescription();
        invoice1.getQuantity();
        invoice1.getPrice();
        invoice1.getInvoiceAmount();
        System.out.println("******************************\n");

        // New invoice object for part sold
        Invoice invoice2 = new Invoice();
        // Changes data for part
        invoice2.setPartNumber("CD-24-4313");
        invoice2.setDescription("Hammer");
        invoice2.setQuantity(-32);
        invoice2.setPrice(-5.00);
        // Invoice header
        System.out.println("\nInvoice #2");
        // Print part data
        invoice2.getPartNumber();
        invoice2.getDescription();
        invoice2.getQuantity();
        invoice2.getPrice();
        invoice2.getInvoiceAmount();
        System.out.println("******************************\n");

        // New invoice object for part sold
        Invoice invoice3 = new Invoice();
        // Changes data for part
        invoice3.setPartNumber("EF-25-4314");
        invoice3.setDescription("Phillips Head Screwdriver");
        invoice3.setQuantity(35);
        invoice3.setPrice(9.99);
        // Invoice header
        System.out.println("\nInvoice #3");
        // Print part data
        invoice3.getPartNumber();
        invoice3.getDescription();
        invoice3.getQuantity();
        invoice3.getPrice();
        invoice3.getInvoiceAmount();
        System.out.println("******************************\n");

        // New invoice object for part sold
        Invoice invoice4 = new Invoice();
        // Changes data for part
        invoice4.setPartNumber("GH-26-4315");
        invoice4.setDescription("Light Switch");
        invoice4.setQuantity(40);
        invoice4.setPrice(39.00);
        // Invoice header
        System.out.println("\nInvoice #4");
        // Print part data
        invoice4.getPartNumber();
        invoice4.getDescription();
        invoice4.getQuantity();
        invoice4.getPrice();
        invoice4.getInvoiceAmount();
        System.out.println("******************************\n");

        // New invoice object for part sold
        Invoice invoice5 = new Invoice();
        // Changes data for part
        invoice5.setPartNumber("IJ-27-4316");
        invoice5.setDescription("Carpenter's Square");
        invoice5.setQuantity(14);
        invoice5.setPrice(15.00);
        // Invoice header
        System.out.println("\nInvoice #5");
        // Print part data
        invoice5.getPartNumber();
        invoice5.getDescription();
        invoice5.getQuantity();
        invoice5.getPrice();
        invoice5.getInvoiceAmount();
        System.out.println("******************************\n");

    }
}
