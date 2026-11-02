// Displaying Images
// Module 5 Programming Assignment (1)
// Author: Carson Hebner

// This program uses javaFX and you need all three files for compiling
// FILES NEEDED: settings.json, the Images folder, and this file.
// You also need javaFX downloaded and set a settings.json file to point to your javaFX download.
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class module5programmingAssignment1 extends Application {

    @Override
    public void start(Stage primarystage) {

        // building the GridPane to hold images
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(25);
        pane.setVgap(25);

        // creating an ImageView for the first flag
        Image image1 = new Image("file:/Users/carsonhebner/Desktop/fxtest/Images/flag1.gif");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(150);
        pane.add(imageView1, 0, 0);

        // creating an ImageView for the second flag
        Image image2 = new Image("file:/Users/carsonhebner/Desktop/fxtest/Images/flag2.gif");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(150);
        pane.add(imageView2, 0, 1);

        // creating an ImageView for the third flag
        Image image3 = new Image("file:/Users/carsonhebner/Desktop/fxtest/Images/flag6.gif");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(150);
        pane.add(imageView3, 1, 0);

        // creating an ImageView for the forth flag
        Image image4 = new Image("file:/Users/carsonhebner/Desktop/fxtest/Images/flag7.gif");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitHeight(100);
        imageView4.setFitWidth(150);
        pane.add(imageView4, 1, 1);

        // building the scene, setting the title, and outputting the window
        primarystage.setScene(new Scene(pane, 400, 300));
        primarystage.setTitle("Flags");
        primarystage.show();
    }

    public static void main(String[] args) {
        Application.launch(module5programmingAssignment1.class, args);
    }
}
