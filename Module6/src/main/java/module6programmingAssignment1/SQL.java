// Access and Update a Staff table
// Module 6 Programming Assignment (1)
// Author: Carson Hebner
//
// Created with a MySQL database
// Using my own username and password
// Made with Maven
// Insure your JavaFX and mysql connectors are in a pom.xml file

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package module6programmingAssignment1;

/**
 *
 * @author carsonhebner
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SQL extends Application {

    private TextField id;
    private TextField lastName;
    private TextField firstName;
    private TextField mi;
    private TextField adress;
    private TextField city;
    private TextField state;
    private TextField telephone;
    private TextField email;
    private Connection connection;

    @Override
    public void start(Stage primarystage) {

        initilizeBD();

        GridPane pane1 = new GridPane();
        HBox pane2 = new HBox();
        BorderPane foundation = new BorderPane();
        foundation.setLeft(pane1);
        foundation.setBottom(pane2);

        id = new TextField();
        pane1.add(new Label("ID"), 0, 0);
        pane1.add(id, 1, 0);

        lastName = new TextField();
        pane1.add(new Label("Last Name"), 0, 1);
        pane1.add(lastName, 1, 1);

        firstName = new TextField();
        pane1.add(new Label("First Name"), 2, 1);
        pane1.add(firstName, 3, 1);

        mi = new TextField();
        pane1.add(new Label("MI"), 4, 1);
        pane1.add(mi, 5, 1);

        adress = new TextField();
        pane1.add(new Label("Address"), 0, 2);
        pane1.add(adress, 1, 2);

        city = new TextField();
        pane1.add(new Label("City"), 0, 3);
        pane1.add(city, 1, 3);

        state = new TextField();
        pane1.add(new Label("State"), 2, 3);
        pane1.add(state, 3, 3);

        telephone = new TextField();
        pane1.add(new Label("Telephone"), 0, 4);
        pane1.add(telephone, 1, 4);

        email = new TextField();
        pane1.add(new Label("Email"), 0, 5);
        pane1.add(email, 1, 5);

        Button view = new Button("View");
        Button insert = new Button("Insert");
        Button update = new Button("Update");
        Button clear = new Button("Clear");

        pane2.getChildren().addAll(view, insert, update, clear);

        view.setOnAction(e -> viewRecord());
        insert.setOnAction(e -> insert());
        update.setOnAction(e -> update());
        clear.setOnAction(e -> clear());

        primarystage.setScene(new Scene(foundation, 400, 300));
        primarystage.setTitle("Database");
        primarystage.setMaximized(true);
        primarystage.show();

    }

    public static void main(String[] args) {
        Application.launch(SQL.class, args);
    }

    public void initilizeBD() {

        String url = "jdbc:mysql://localhost:3306/m6a1";
        String user = "root";
        String password = "henry";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewRecord() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Staff where id = ?");
            ps.setString(1, id.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lastName.setText(rs.getString("lastname"));
                firstName.setText(rs.getString("firstname"));
                mi.setText(rs.getString("MI"));
                adress.setText(rs.getString("Address"));
                city.setText(rs.getString("City"));
                state.setText(rs.getString("State"));
                telephone.setText(rs.getString("Telephone"));
                email.setText(rs.getString("Email"));
            } else {
                System.out.println("No such ID");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }

    private void insert() {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into Staff values (?,?,?,?,?,?,?,?,?)");

            ps.setString(1, id.getText());
            ps.setString(2, lastName.getText());
            ps.setString(3, firstName.getText());
            ps.setString(4, mi.getText());
            ps.setString(5, adress.getText());
            ps.setString(6, city.getText());
            ps.setString(7, state.getText());
            ps.setString(8, telephone.getText());
            ps.setString(9, email.getText());

            ps.executeUpdate();
            System.out.println("Record inserted");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void update() {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update Staff set lastname = ?, firstname = ?, mi = ?, address = ?, "
                    + "city = ?, state = ?, telephone = ?, email = ? where id = ?");

            ps.setString(1, lastName.getText());
            ps.setString(2, firstName.getText());
            ps.setString(3, mi.getText());
            ps.setString(4, adress.getText());
            ps.setString(5, city.getText());
            ps.setString(6, state.getText());
            ps.setString(7, telephone.getText());
            ps.setString(8, email.getText());
            ps.setString(9, id.getText());

            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) updated");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clear() {
        id.setText("");
        lastName.setText("");
        firstName.setText("");
        mi.setText("");
        adress.setText("");
        city.setText("");
        state.setText("");
        telephone.setText("");
        email.setText("");
    }
}
