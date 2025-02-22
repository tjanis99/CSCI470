package com.assign6.assignment6;
/**********************************************************
 * CSCI 470/502     Assignment 6    Summer 2024
 * Developer(s): Trevor Janis
 * Due Date: Due by 11:59 PM on 08/09/2024.
 * Purpose: Mile Redeemer program to read destinations, retrieve city names,
 * set mileage on accounts, and conclude which flights are possible within valid months
 * using javafx GUI to input values
 **********************************************************/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * MileRedeemerApp.java
 *
 * Driver program for MileRedeemer
 */
public class MileRedeemerApp extends Application {

    /*
     * Initiate GUI
     */
    @Override
    public void start(Stage stage) throws IOException {
        //create a file chooser
        FileChooser f = new FileChooser();
        //set the title
        f.setTitle("Opening the location...");
        //open the dialog box
        File userFile = f.showOpenDialog(stage);

        HBox r = new HBox();
        r.setSpacing(20);
        //create scene
        Scene sc = new Scene(r, 350, 100);
        //set the scene
        stage.setScene(sc);
        //set title
        stage.setTitle("Sample file chooser");
        //display the result
        stage.show();

        //scanner with selected file
        Scanner scanner = new Scanner(userFile);
        //call mileRedeemer constructor
        MileRedeemer mileRedeemer = new MileRedeemer();
        //call the main controller to pass the scanner & mileRedeemer object
        MileRedeemerAppUIController controller = new MileRedeemerAppUIController(scanner, mileRedeemer);

        //create fxml loader with ui resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MileRedeemerAppUI.fxml"));
        //set controller
        fxmlLoader.setController(controller);
        //load root & set scene
        Parent root = fxmlLoader.load();
        //create new scene for ui
        Scene scene = new Scene(root, 978, 481);
        stage.setTitle("Mile Redemption App");
        stage.setScene(scene);

        //show program gui
        stage.show();

    }
        public static void main(String[] args) {
        launch();
    }
}