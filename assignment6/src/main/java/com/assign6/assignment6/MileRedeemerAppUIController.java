package com.assign6.assignment6;
/**********************************************************
 * CSCI 470/502     Assignment 6    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 08/09/2024.
 * Purpose: Mile Redeemer program to read destinations, retrieve city names,
 * set mileage on accounts, and conclude which flights are possible within valid months
 * using javafx GUI to input values
 **********************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * MileRedeemerAppUIController.java
 *
 * Creates GUI for MileRedeemerApp
 */
public class MileRedeemerAppUIController
{
    //scanner for file
    Scanner fileScanner;
    
    //create class object
    MileRedeemer mileRedeemer;
    
    //create destination array
    ArrayList<Destination> destinationList = new ArrayList<Destination>();
    
    //enum for months
    enum months {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sept, Oct, Nov, Dec}; 

    @FXML
    private ComboBox<String> departureComboBox;

    @FXML
    private ListView<String> departureInfoListView;

    @FXML
    private ListView<String> destinationListView;

    @FXML
    private TextField enterMilesTextField;

    @FXML
    private TextField normalMilesTextField;

    @FXML
    private Button redeemMilesButton;

    @FXML
    private TextField remainingMilesTextField;

    @FXML
    private TextField supersaverDatesTextField;

    @FXML
    private TextField supersaverTextField;

    @FXML
    private TextField upgradeCostTextField;

    /*
     * Default Constructor
     */
    public MileRedeemerAppUIController(Scanner scanner, MileRedeemer mileRedeemer)
    {
        this.fileScanner = scanner; //set scanner
        this.mileRedeemer = mileRedeemer; //set object
    }

    /*
     * Click event to display information for departures
     */
    @FXML
    void departureInfoOnClick(MouseEvent event) 
    {
        //get destinationList from mileRedeemer
        destinationList = mileRedeemer.getDestinationList();
        
        //get index of normal miles of selected city based on city index
        int info = destinationList.get(destinationListView.getSelectionModel().getSelectedIndex()).getNormalMiles();
        
        //convert into string
        String infoString = Integer.toString(info);

        //set info string to normal miles text field
        normalMilesTextField.setText(infoString);

        //gets index of super saver miles of the selected city based on city index & convert to string
        info = destinationList.get(destinationListView.getSelectionModel().getSelectedIndex()).getSuperSaverMiles();
        infoString = Integer.toString(info);

        //set info string to the super saver miles text field
        supersaverTextField.setText(infoString);

        //get index of upgrade miles of the selected city based on city index & convert to string
        info = destinationList.get(destinationListView.getSelectionModel().getSelectedIndex()).getAdditionalMiles();
        infoString = Integer.toString(info);

        //set string to upgrade miles text field
        upgradeCostTextField.setText(infoString);

        //get first and last month of index city
        int startMonth = destinationList.get(destinationListView.getSelectionModel().getSelectedIndex()).getStartMonth();
        int endMonth = destinationList.get(destinationListView.getSelectionModel().getSelectedIndex()).getEndMonth();

        //format the string for date range
        String dateRange = months.values()[startMonth-1].toString() + "-" + months.values()[endMonth-1].toString();

        //set formatted string to super saver date text field
        supersaverDatesTextField.setText(dateRange); 
    }

    /*
     * Button event to redeem miles & process info from user
     */
    @FXML
    void redeemMilesButtonClick(ActionEvent event) {
        
        //clear trip view
        departureInfoListView.getItems().clear();
        
        //clear remaining miles
        remainingMilesTextField.clear();
        
        //If the user mile input field is not null
        if (enterMilesTextField.getText() != null) 
        {
            try {
                //get miles from user
                int miles = Integer.parseInt(enterMilesTextField.getText());
                //get trips based on selected month and miles entered
                String[] trips = mileRedeemer.redeemMiles(miles, departureComboBox.getSelectionModel().getSelectedIndex() - 1);
                //if empty
                if (trips[0] == null) {
                    departureInfoListView.getItems().add("Your client has not accumulated enough Frequent Flyer Miles");
                } else { //else loop and add trip to the trips
                    departureInfoListView.getItems().add("Your client's Frequent Flyer Miles can be used to redeem the following tickets:");
                    for (String trip : trips) {
                        if (trip != null)
                            departureInfoListView.getItems().add(trip);
                    }
                    //get remaining miles
                    miles = mileRedeemer.getRemainingMiles();
                }
                //set remaining miles
                remainingMilesTextField.setText(Integer.toString(miles));
            }
            catch (NumberFormatException exception) // if user enters incorrect input
            {
                System.out.println("Bad Input by user" + exception.getMessage());
                return;
            }
        }
    }

    /*
     * Initializes combo box for months and creates list of destinations
     */
    @FXML
    public void initialize() throws IOException
    {
        //pass scanner to read destination method
        mileRedeemer.readDestinations(this.fileScanner);

        //loop and set fill combo box
        for(int i = 0; i < 12; i++)
        {
            departureComboBox.getItems().add(months.values()[i].toString());
        }
        departureComboBox.getSelectionModel().select(0);
        String[] destinationNames = new String[12];

        //get city names
        destinationNames = mileRedeemer.getCityNames();

        //loop city list in gui
        for(int i = 0; i < destinationNames.length; i++)
        {
            //if null then break
            if(destinationNames[i] == null) {
                break;
            } //add to destination list view
            destinationListView.getItems().add(destinationNames[i]);
        }
    }
}