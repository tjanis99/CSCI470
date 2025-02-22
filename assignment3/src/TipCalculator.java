/**********************************************************
 * CSCI 470/502     Assignment 3    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/12/2024.
 * Purpose: Methods for Tip calculator console program to calculate total
 * bill including tips and split the total amongst guests.
 **********************************************************/
/*
 * TipCalculator.java
 *
 * Program to generate total bill & calculate share
 */
public class TipCalculator {

    private double billAmount = 0.0;
    private int tipPercent = 20;
    private int partySize = 0;

    /*
     * Default constructor
     */
    public TipCalculator(){
        this.billAmount = billAmount;
        this.tipPercent = tipPercent;
        this.partySize = partySize;
    }

    /*
     * Sets current bill amount
     */
    public void setBillAmount(double billAmount){
        this.billAmount = billAmount; //update current bill
    }

    /*
     * Sets current tip percentage
     */
    public void setTipPercent(int tipPercent){
        this.tipPercent = tipPercent; //update current tip percent
    }

    /*
     * Sets current party size
     */
    public void setPartySize(int partySize){
        this.partySize = partySize; //update current party size
    }

    /*
     * Gets current bill amount
     */
    public double getBillAmount(){
        return billAmount; //return current bill amount
    }

    /*
     * Gets current tip percentage
     */
    public int getTipPercent(){
        return tipPercent; //return current tip percentage
    }

    /*
     * Gets current party size
     */
    public int getPartySize(){
        return partySize; //return current party size
    }

    /*
     * Gets bill amount, calculates total bill amount including tip.
     */
    public double getTotalBillAmount(double billAmount, int tipPercent){
        double totalBillAmount = 0.0; //to save final total
        double tipAmount = 0.0; //to save dollar amount of tip

        tipAmount = billAmount * (tipPercent / 100.0); //tip total calculation
        totalBillAmount = tipAmount + billAmount; //final total including tip
        return totalBillAmount; //return total
    }

    /*
     * Gets individual share of total bill amount by dividing by size of party.
     */
    public double getIndividualShare(double totalBillAmount, int partySize){
        return totalBillAmount / partySize; //divides total by number of customers
    }
}
