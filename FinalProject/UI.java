// Plane Tracker 
// SDEV-200 Final Project (11/14/26)
// Author: Carson Hebner

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// UI class for running the program
public class UI extends Application {

    // data fields
    private FlightLog log = new FlightLog();
    private VBox lastFive;
    private Label planeCountLabel;
    private BorderPane pane;
    private BorderPane addPlanePane;
    private GridPane planeData;
    private TextField callsignField;
    private TextField AircraftTypeField;
    private TextField toFromField;
    private TextField altitudeField;
    private TextField timeOfRecField;
    private TextField commOrPrivateField;
    private BorderPane viewPlanesPane;
    private VBox allPlanes;
    private Label viewCountLabel;

    @Override
    public void start(Stage primarystage) {

        // Creating Panes and Scenes 
        pane = new BorderPane();
        VBox addView = new VBox(20);
        lastFive = new VBox();
        addPlanePane = new BorderPane();
        planeData = new GridPane();
        Scene main = new Scene(pane, 400, 300);
        viewPlanesPane = new BorderPane();
        allPlanes = new VBox();
        viewCountLabel = new Label();
        Scene addPlaneScene = new Scene(addPlanePane, 400, 300);
        Scene viewPlanesScene = new Scene(viewPlanesPane, 400, 300);
        planeData.setAlignment(Pos.CENTER);
        allPlanes.setAlignment(Pos.CENTER);
        lastFive.setAlignment(Pos.CENTER);

        // Label for displaying plane count on main screen
        planeCountLabel = new Label("Plane Count: " + Plane.getPlaneCount());

        // Making Buttons for adding and viewing planes
        Button addPlane = new Button("Add Plane");
        Button viewPlanes = new Button("View Planes");
        addView.getChildren().add(addPlane);
        addView.getChildren().add(viewPlanes);
        addView.setAlignment(Pos.CENTER);

        // Displaying the last five added planes on the main screen
        lastFiveOutput();

        // Lines 67-89 is adding the label and textFields for each plane data type (within "Add Plane" button)
        AircraftTypeField = new TextField();
        planeData.add(new Label("Aircraft Type:"), 0, 1);
        planeData.add(AircraftTypeField, 1, 1);

        toFromField = new TextField();
        planeData.add(new Label("Enter the Aircrafts To and From Location:"), 0, 2);
        planeData.add(toFromField, 1, 2);

        altitudeField = new TextField();
        planeData.add(new Label("Enter Aircraft Altitude:"), 0, 3);
        planeData.add(altitudeField, 1, 3);

        callsignField = new TextField();
        planeData.add(new Label("Enter Aircrafts Callsign:"), 0, 4);
        planeData.add(callsignField, 1, 4);

        timeOfRecField = new TextField();
        planeData.add(new Label("Enter The Time of Recording:"), 0, 5);
        planeData.add(timeOfRecField, 1, 5);

        commOrPrivateField = new TextField();
        planeData.add(new Label("Is The Aircraft Commercial or Private:"), 0, 6);
        planeData.add(commOrPrivateField, 1, 6);

        // Making a label for exceptions (errors)
        Label errorLabel = new Label();
        planeData.add(errorLabel, 0, 8);

        // logic for adding each plane to the plane list (plane gets added when you press submit)
        Button submit = new Button("Submit");
        planeData.add(submit, 1, 7);
        submit.setOnAction(actionEvent -> {
            String aircraftType = AircraftTypeField.getText();
            String toFrom = toFromField.getText();
            int altitude = 0;
            try {
                String altitudeText = altitudeField.getText();
                altitude = Integer.parseInt(altitudeText);
            } catch (NumberFormatException ex) {
                errorLabel.setText("Altitude must be a number.");
                return;
            }
            String callsign = callsignField.getText();
            String timeOfRecording = timeOfRecField.getText();
            String commercialOrPrivate = commOrPrivateField.getText();

            try {
                LoggedPlane plane = new LoggedPlane(aircraftType, toFrom, altitude, callsign, timeOfRecording, commercialOrPrivate);
                log.addPlane(plane);
            } catch (IllegalArgumentException ex) {
                errorLabel.setText(ex.getMessage());
                return;
            }

            planeCountLabel.setText("Plane Count: " + Plane.getPlaneCount());
            lastFiveOutput();
            errorLabel.setText("");

            primarystage.setScene(main);
            primarystage.setMaximized(true);

            AircraftTypeField.clear();
            toFromField.clear();
            altitudeField.clear();
            callsignField.clear();
            timeOfRecField.clear();
            commOrPrivateField.clear();

        });

        // logic for the "View Planes" button (changing scene when the button is pressed)
        viewPlanesPane.setCenter(allPlanes);
        viewPlanes.setOnAction((actionEvent) -> {
            viewCountLabel.setText("Plane Count: " + Plane.getPlaneCount());
            outputAllPlanes();
            primarystage.setScene(viewPlanesScene);
            primarystage.setMaximized(true);

        });

        addPlanePane.setCenter(planeData);

        // (Lines 150-166) adding back buttons for the "Add Plane" and "View Planes" buttons
        Button back = new Button("Back");
        addPlanePane.setTop(back);

        Button back2 = new Button("Back");
        StackPane topBar = new StackPane(back2, viewCountLabel);
        StackPane.setAlignment(back2, Pos.CENTER_LEFT);
        viewPlanesPane.setTop(topBar);

        back.setOnAction((actionEvent) -> {
            primarystage.setScene(main);
            primarystage.setMaximized(true);
        });

        back2.setOnAction((actionEvent) -> {
            primarystage.setScene(main);
            primarystage.setMaximized(true);
        });

        // logic for the actual "Add Plane" button (changing scene when the button is pressed)
        addPlane.setOnAction((actionEvent) -> {
            primarystage.setScene(addPlaneScene);
            primarystage.setMaximized(true);
        });

        // Formatting the main scene
        pane.setTop(planeCountLabel);
        pane.setCenter(addView);
        Label recentLabel = new Label("Recently Added Planes");
        VBox bottomBox = new VBox(5, recentLabel, lastFive);
        bottomBox.setAlignment(Pos.CENTER);
        pane.setBottom(bottomBox);

        // Setting the scene, title, and displaying the window
        primarystage.setScene(main);
        primarystage.setTitle("Plane Tracker");
        primarystage.setMaximized(true);
        primarystage.show();
    }

    public static void main(String[] args) {
        Application.launch(UI.class, args);
    }

    // Method for getting the last five added planes
    public void lastFiveOutput() {
        lastFive.getChildren().clear();
        for (LoggedPlane plane : log.getLastFive()) {
            Label lastFiveLabel = new Label(plane.toString());
            lastFive.getChildren().add(lastFiveLabel);
        }
    }

    // Method for displaying all planes
    public void outputAllPlanes() {
        allPlanes.getChildren().clear();
        for (LoggedPlane plane : log.getPlanes()) {
            Label planeListLabel = new Label(plane.toString());
            allPlanes.getChildren().add(planeListLabel);
        }
    }
}
