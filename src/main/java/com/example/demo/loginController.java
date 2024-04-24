package com.example.demo;

import JDBCapr9.InsertData;
import JDBCapr9.MySQLConnection;
import JDBCapr9.ReadData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController {
    public VBox vbSignIn;
    public Button btnSignIn;
    public Button btnCreateUser;
    public Button Return;
    public TextField txtName;
    public TextField txtUser;
    public PasswordField txtPasswordSignIn;
    public PasswordField txtPasswordSignUp;

    public static int currUserID;


    public void SignIn(ActionEvent actionEvent) throws IOException {

        String user = txtUser.getText().toString();
        String pass = txtPasswordSignIn.getText().toString();


        if(ReadData.scan(user, pass)){
            currUserID = ReadData.getUserID();
            System.out.println("ID in loginController: " + currUserID);
            AnchorPane p = (AnchorPane) vbSignIn.getParent();
            p.getScene().getStylesheets().clear();
            Parent scene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);


        }

        // do toast error message

        

    }

    public void SignUp(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) vbSignIn.getParent();
        p.getScene().getStylesheets().clear();
        Parent scene = FXMLLoader.load(getClass().getResource("register-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void CreateUser(ActionEvent actionEvent) {
        String name = txtName.getText().toString();
        String email = txtPasswordSignUp.getText().toString();
        System.out.println(name + email);
        InsertData.insertUser(name,email);
        System.out.println("created!");
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) vbSignIn.getParent();
        p.getScene().getStylesheets().clear();
        Parent scene = FXMLLoader.load(getClass().getResource("login-viewJDBC.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }





}
