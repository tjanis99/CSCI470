/**********************************************************
 * CSCI 470/502     Assignment 4    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/19/2024.
 * Purpose: Destination constructor & get + set methods to update values
 **********************************************************/
public class Destination {

    private String destinationCity;
    private int normalMiles;
    private int superSaverMiles;
    private int additionalMiles;
    private int startMonth;
    private int endMonth;

    /*
     * Default constructor
     */
    public Destination(String destinationCity, int normalMiles, int superSaverMiles, int additionalMiles, int startMonth, int endMonth)
    {
        this.destinationCity = destinationCity;
        this.normalMiles = normalMiles;
        this.superSaverMiles = superSaverMiles;
        this.additionalMiles = additionalMiles;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    /*
     * returns city name
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /*
     * updates destination city
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    /*
     * returns normal miles
     */
    public int getNormalMiles() {
        return normalMiles;
    }

    /*
     * updates normal miles
     */
    public void setNormalMiles(int normalMiles) {
        this.normalMiles = normalMiles;
    }

    /*
     * returns super saver mileage
     */
    public int getSuperSaverMiles() {
        return superSaverMiles;
    }

    /*
     * updates saver miles
     */
    public void setSuperSaverMiles(int superSaverMiles) {
        this.superSaverMiles = superSaverMiles;
    }

    /*
     * returns additional miles required
     */
    public int getAdditionalMiles() {
        return additionalMiles;
    }

    /*
     * updates
     */
    public void setAdditionalMiles(int additionalMiles) {
        this.additionalMiles = additionalMiles;
    }

    /*
     * returns start month
     */
    public int getStartMonth() {
        return startMonth;
    }

    /*
     * updates start month
     */
    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    /*
     * returns end month
     */
    public int getEndMonth() {
        return endMonth;
    }

    /*
     * updates end month
     */
    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }
}
