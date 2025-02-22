/**********************************************************
 * CSCI 470/502     Assignment 4    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 07/19/2024.
 * Purpose: Mile Redeemer program to read destinations, retrieve city names,
 * set mileage on accounts, and conclude which flights are possible within valid months
 **********************************************************/

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * MileRedeemer.java
 *
 * Adapts flights possible based on miles available.
 */
public class MileRedeemer {

    private int milesRemain;    //holds remaining miles
    ArrayList<Destination> destinationList = new ArrayList<Destination>(); //for destinations

    /*
     * Parses destination information in file into array of destination objects which are then sorted.
     */
    public void readDestinations(Scanner fileScanner) {

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();   //stores lines
            String[] tokens = line.split(";"); //delimiter to store split strings

            //set information based on tokens
            String destinationCity = tokens[0];
            int normalMiles = Integer.parseInt(tokens[1]);
            int superMiles = Integer.parseInt(tokens[2]);
            int addMiles = Integer.parseInt(tokens[3]);
            String months = tokens[4];

            //split months apart for off season months
            String[] monthSplit = months.split("-");
            int startMonth = Integer.parseInt(monthSplit[0]); //start month
            int endMonth = Integer.parseInt(monthSplit[1]); //end month

            Destination destination = new Destination(destinationCity, normalMiles, superMiles, addMiles, startMonth, endMonth);
            destinationList.add(destination); //Create destination object from info & add to array list
        }
        Collections.sort(destinationList, new MileComparator()); //sort array

        Destination[] destinationArray = (Destination[]) destinationList.toArray(new
                Destination[destinationList.size()]); //return to array of objects
    }

    /*
     * Retrieves possible city names from file by parsing
     */
    public String[] getCityNames(){
        String[] cityNames = new String[destinationList.size()]; //to hold cities

        for (int i = 0; i < destinationList.size(); i++) { //add cities to array
            cityNames[i] = destinationList.get(i).getDestinationCity();
        }

        Arrays.sort(cityNames); //sort alphabetically
        return cityNames;
    }

    /*
     * Redeems miles and verifies month for ticket descriptions in main program
     */
    public String[] redeemMiles(int miles, int month){
        ArrayList<String> ticketList = new ArrayList<>();   //holds list of tickets

        setRemainingMiles(miles); //set available miles
        int counter = 0;

        do {
            boolean validMonths = false; //checks if object is within month period

            //checks if month is valid
            if(month >= destinationList.get(counter).getStartMonth() && (month <= destinationList.get(counter).getEndMonth()))
            {
                validMonths = true;

                //determines if there is enough miles to reach city with super saver miles
                if (getRemainingMiles() >= destinationList.get(counter).getSuperSaverMiles()){
                    //subtract super miles from remaining miles
                    setRemainingMiles(getRemainingMiles() - destinationList.get(counter).getSuperSaverMiles());
                    //update current list of possible destinations
                    ticketList.add(destinationList.get(counter).getDestinationCity() + " in Economy Class");
                }

                //else its in off season and check
            } else if (validMonths == false){

                //determines if there is enough miles to reach city with normal miles
                if (getRemainingMiles() >= destinationList.get(counter).getNormalMiles()) {
                    //subtract super miles from normal miles
                    setRemainingMiles(getRemainingMiles() - destinationList.get(counter).getNormalMiles());
                    //update current list of possible destinations
                    ticketList.add(destinationList.get(counter).getDestinationCity() + " in Economy Class");
                }
            }
            counter++; //increase counter to loop through entire list.
        } while (counter < destinationList.size());

        //loop through list
        for (int i = 0; i < destinationList.size(); i++) {
            //compare to possible ticket locations
            for (int j = 0; j < ticketList.size(); j++) {
                //if ticket is in ticketArray and is possible, then check tickets required to travel
                if (ticketList.get(j).startsWith(destinationList.get(j).getDestinationCity()) && //isn't greater than
                        (getRemainingMiles() >= destinationList.get(i).getAdditionalMiles())){ //remaining miles.
                    ticketList.set(j, destinationList.get(j).getDestinationCity().replaceFirst("Economy", "First"));
                    //remove additional miles from remaining miles.
                    setRemainingMiles(getRemainingMiles() - destinationList.get(i).getAdditionalMiles());
                }
            }
        }

        //convert array list back into an array of strings
        String[] ticketArray = ticketList.toArray(new String[ticketList.size()]);

        //array loop
        for (int i = 0; i < ticketArray.length; i++) {
            ticketArray[i] = "* A trip to " + ticketArray[i]; //concatenate string at beginning of each string index
        }
        return ticketArray;
    }

    /*
     * Returns miles remaining
     */
    public int getRemainingMiles(){
        return milesRemain;
    }

    /*
     * Updates miles correctly.
     */
    public void setRemainingMiles(int miles){
        if (miles < 0) { //guarantees valid miles
            milesRemain = 0;
        } else {
            milesRemain = miles;
        }
    }
}
