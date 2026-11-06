// Change Color Using a Mouse
// Module 5 Programming Assignment (2)
// Author: Carson Hebner

// This program uses javaFX and you need your settings.json file for compiling
// You need javaFX downloaded and set a settings.json file to point to your javaFX download.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class module5programmingAssignment2 extends Application {

    @Override
    public void start(Stage primarystage) {

        // building a pane to hold the circle
        Pane pane = new Pane();
        Circle circle = new Circle(200, 100, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        // creating a listener to detect when the mouse button is pressed
        pane.setOnMousePressed((MouseEvent) -> {
            if (MouseEvent.isPrimaryButtonDown()) {
                circle.setStroke(Color.WHITE);
                circle.setFill(Color.BLACK);
            }
        });

        // creating a listener to detect when mouse button is released
        pane.setOnMouseReleased((MouseEvent) -> {
            if (!MouseEvent.isPrimaryButtonDown()) {
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
            }
        });

        // building the scene, setting the title, and outputting the window
        primarystage.setScene(new Scene(pane, 400, 200));
        primarystage.setTitle("Circle");
        primarystage.show();

    }

    public static void main(String[] args) {
        Application.launch(module5programmingAssignment2.class, args);
    }

}
