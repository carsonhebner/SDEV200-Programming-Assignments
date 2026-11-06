// Use ScrollBar and Slider
// Module 5 Programming Assignment (3)
// Author: Carson Hebner

// This program uses javaFX and you need your settings.json file for compiling
// You need javaFX downloaded and set a settings.json file to point to your javaFX download.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class module5programmingAssignment3 extends Application {

    @Override
    public void start(Stage primarystage) {

        // building a pane and adding text
        Pane pane = new Pane();
        Text text = new Text(165, 25, "Show Colors");
        pane.getChildren().add(text);

        // adding the text for the red, green, and blue labels
        Text red = new Text(50, 75, "Red");
        pane.getChildren().add(red);

        Text green = new Text(50, 105, "Green");
        pane.getChildren().add(green);

        Text blue = new Text(50, 135, "Blue");
        pane.getChildren().add(blue);

        // adding a slider for each color
        Slider sliderRed = new Slider(0, 255, 127.5);
        sliderRed.setLayoutX(100);
        sliderRed.setLayoutY(63);
        pane.getChildren().add(sliderRed);

        Slider sliderGreen = new Slider(0, 255, 127.5);
        sliderGreen.setLayoutX(100);
        sliderGreen.setLayoutY(93);
        pane.getChildren().add(sliderGreen);

        Slider sliderBlue = new Slider(0, 255, 127.5);
        sliderBlue.setLayoutX(100);
        sliderBlue.setLayoutY(123);
        pane.getChildren().add(sliderBlue);

        // adding three listeners to detect when sliders are moved and change the color respectivly
        sliderRed.valueProperty().addListener((observable) -> {
            text.setFill(Color.rgb((int) sliderRed.getValue(), (int) sliderGreen.getValue(), (int) sliderBlue.getValue()));
        });

        sliderGreen.valueProperty().addListener((observable) -> {
            text.setFill(Color.rgb((int) sliderRed.getValue(), (int) sliderGreen.getValue(), (int) sliderBlue.getValue()));
        });

        sliderBlue.valueProperty().addListener((observable) -> {
            text.setFill(Color.rgb((int) sliderRed.getValue(), (int) sliderGreen.getValue(), (int) sliderBlue.getValue()));
        });

        // building the scene, setting the title, and outputting the window
        primarystage.setScene(new Scene(pane, 400, 200));
        primarystage.setTitle("Color Changer");
        primarystage.show();

    }

    public static void main(String[] args) {
        Application.launch(module5programmingAssignment3.class, args);
    }

}
