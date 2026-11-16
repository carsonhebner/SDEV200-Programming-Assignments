// Batch Update
// Module 6 Programming Assignment (2)
// Author: Carson Hebner
//
// Created with a MySQL database
// Using my own username and password (should be filled in automatically)
// Made with Maven
// Insure your JavaFX and mysql connectors are in a pom.xml file

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author carsonhebner
 */
public class Module6Assignment2 extends Application {

    // data fields
    private Label ctdb;
    private TextArea results;
    private Connection connection;

    @Override
    public void start(Stage primarystage) {

        // Building the panes for the first batch/non-batch update screen
        BorderPane foundation = new BorderPane();
        HBox top = new HBox();
        VBox middle = new VBox();
        HBox bottom = new HBox();
        foundation.setTop(top);
        foundation.setCenter(middle);
        foundation.setBottom(bottom);

        // Making the "Connect to Database" button
        Button ctd = new Button("Connect to Database");
        ctdb = new Label();
        top.getChildren().addAll(ctdb, ctd);

        // Making the results field in the middle of the screen
        results = new TextArea();
        middle.getChildren().add(results);

        // Making the two buttons on the bottom of the screen "Batch Update" and "Non-Batch Update"
        Button batchUpdate = new Button("Batch Update");
        Button nonBatchUpdate = new Button("Non-Batch Update");
        bottom.getChildren().addAll(batchUpdate, nonBatchUpdate);

        // Event handlers for the three buttons on the first screen
        ctd.setOnAction(e -> openDialog());
        batchUpdate.setOnAction(e -> batch());
        nonBatchUpdate.setOnAction(e -> nonBatch());

        // Creating the scene, renaming it, and outputting the window
        primarystage.setScene(new Scene(foundation, 450, 250));
        primarystage.setTitle("Batch");
        primarystage.show();

    }

    public static void main(String[] args) {
        Application.launch(Module6Assignment2.class, args);

    }

    // Method that holds the logic for the second window
    public void openDialog() {

        // Making the stage and creating the pane
        Stage dialog = new Stage();
        GridPane dialogPane = new GridPane();

        // adding the labels and textFields for driver, url, username, and password
        Label connectedTo = new Label();
        dialogPane.add(connectedTo, 0, 0, 2, 1);

        TextField driver = new TextField();
        driver.setText("com.mysql.cj.jdbc.Driver");
        dialogPane.add(new Label("JDBC Drive"), 0, 1);
        dialogPane.add(driver, 1, 1);

        TextField url = new TextField();
        url.setText("jdbc:mysql://localhost:3306/m6a1?rewriteBatchedStatements=true");
        dialogPane.add(new Label("Database URL"), 0, 2);
        dialogPane.add(url, 1, 2);

        TextField username = new TextField();
        username.setText("root");
        dialogPane.add(new Label("Username"), 0, 3);
        dialogPane.add(username, 1, 3);

        PasswordField password = new PasswordField();
        password.setText("henry");
        dialogPane.add(new Label("Password"), 0, 4);
        dialogPane.add(password, 1, 4);

        // Making the "Connect to DB" button
        Button connectToDB = new Button("Connect to DB");
        dialogPane.add(connectToDB, 2, 5);

        // Logic for when the "Connect to DB" is pressed
        connectToDB.setOnAction(e -> {
            try {
                String urlText = url.getText();
                String usernameText = username.getText();
                String passwordText = password.getText();

                connection = DriverManager.getConnection(urlText, usernameText, passwordText);
                connectedTo.setText("Connected to " + urlText);
                ctdb.setText("Connected");

            } catch (SQLException ex) {
                connectedTo.setText("Error: " + ex.getMessage());
            }
        });

        // logic for closing the second window
        Button close = new Button("Close Dialog");
        dialogPane.add(close, 1, 6);
        close.setOnAction(e -> dialog.close());

        // making the scene, setting the title, and outputting the window
        dialog.setScene(new Scene(dialogPane, 450, 220));
        dialog.setTitle("Connect to DB");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    // logic for when "Non-Batch Update" is pressed
    public void nonBatch() {
        if (connection == null) {
            ctdb.setText("Connect to the database first");
            return;
        }
        try {
            connection.createStatement().executeUpdate("delete from Temp");

            PreparedStatement ps = connection.prepareStatement("insert into Temp values (?, ?, ?)");

            long start = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                ps.setDouble(1, Math.random());
                ps.setDouble(2, Math.random());
                ps.setDouble(3, Math.random());
                ps.executeUpdate();
            }

            long end = System.currentTimeMillis();

            results.appendText("Non-Batch update completed\nThe elapsed time is " + (end - start) + "\n\n");
            ctdb.setText("Non-batch update succeeded");

        } catch (SQLException ex) {
            ctdb.setText("Error: " + ex.getMessage());
        }
    }

    // logic for when "Batch Update" is pressed
    public void batch() {
        if (connection == null) {
            ctdb.setText("Connect to the database first");
            return;
        }
        try {
            connection.createStatement().executeUpdate("delete from Temp");

            PreparedStatement ps = connection.prepareStatement("insert into Temp values (?, ?, ?)");

            long start = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                ps.setDouble(1, Math.random());
                ps.setDouble(2, Math.random());
                ps.setDouble(3, Math.random());
                ps.addBatch();
            }

            ps.executeBatch();
            long end = System.currentTimeMillis();

            results.appendText("Batch update completed\nThe elapsed time is " + (end - start) + "\n\n");
            ctdb.setText("Batch update succeeded");

        } catch (SQLException ex) {
            ctdb.setText("Error: " + ex.getMessage());
        }
    }

}
