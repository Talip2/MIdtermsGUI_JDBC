package com.example.demo;

import JDBCapr9.InsertData;
import JDBCapr9.MySQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class loginController {
    public VBox vbSignIn;
    public Button btnSignIn;
    public Button btnCreateUser;
    public Button Return;
    public TextField txtName;
    public TextField txtEmail;

    public void SignIn(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) vbSignIn.getParent();
        p.getScene().getStylesheets().clear();
        Parent scene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
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
        String email = txtEmail.getText().toString();
        System.out.println(name + email);
        InsertData.insert(name,email);
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
