package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    public VBox pnLogout;
    public Button logout;
    public Label loginError;

    private String user = new String("admin123");
    private String pass = new String("qwerty");

    private String user1 = new String("admin1234");
    private String pass1 = new String("qwerty1");

    private String user2 = new String("admin12345");
    private String pass2 = new String("qwerty2");

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUser;
    @FXML
    private Button btnSignIn;
    @FXML
    private ColorPicker btnColorPicker;

    @FXML
    private VBox pnLogin;



    @FXML
    void SignIn() throws IOException {
        String userInput = txtUser.getText();
        String userPassword = txtPassword.getText();


        if (user.equals(userInput) && pass.equals(userPassword)) {
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getScene().getStylesheets().clear();
            p.getScene().getStylesheets().add(getClass().getResource("user1.css").toExternalForm());
            Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);
        } else {
            System.out.println("gay");
            loginError.setText("Invalid username or password");
        }

        if (user1.equals(userInput) && pass1.equals(userPassword)) {
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getScene().getStylesheets().clear();
            p.getScene().getStylesheets().add(getClass().getResource("user2.css").toExternalForm());
            Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);
        } else {
            System.out.println("gay");
            loginError.setText("Invalid username or password");
        }

        if (user2.equals(userInput) && pass2.equals(userPassword)) {
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getScene().getStylesheets().clear();
            p.getScene().getStylesheets().add(getClass().getResource("user3.css").toExternalForm());
            Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);
        } else {
            System.out.println("gay");
            loginError.setText("Invalid username or password...");
        }


    }
    @FXML
    void LogOut() throws IOException {
        AnchorPane p = (AnchorPane) pnLogout.getParent();
        p.getScene().getStylesheets().clear();
        p.getScene().getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        Parent scene = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void onChoose() {
        String color = btnColorPicker.getValue().toString();
        System.out.println(color);
        color = (color.substring(2,8));
        System.out.println(color);


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("user1.css").getPath(), true));
            bw.write(".button{\n" +
                    "     -fx-background-color: #" + color + ";\n" +
                    "}");
            bw.close();
        }catch (IOException e){

        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("user2.css").getPath(), true));
            bw.write(".button{\n" +
                    "     -fx-background-color: #" + color + ";\n" +
                    "}");
            bw.close();
        }catch (IOException e){

        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("user3.css").getPath(), true));
            bw.write(".button{\n" +
                    "     -fx-background-color: #" + color + ";\n" +
                    "}");
            bw.close();
        }catch (IOException e){

        }
    }

    boolean dark = false;
    public void darkMode(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) pnLogout.getParent();
        dark = !dark;
        if(dark){
            p.getScene().getStylesheets().clear();
            p.setBackground(Background.fill(Color.BLACK));
        }else{
            p.getScene().getStylesheets().clear();
            p.setBackground(Background.fill(Color.WHITE));

        }
    }

    public void goBackToLebron(ActionEvent actionEvent) throws IOException {
        AnchorPane p = (AnchorPane) pnLogout.getParent();
        p.getScene().getStylesheets().clear();
        p.getScene().getStylesheets().add(getClass().getResource("user1.css").toExternalForm());
        Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
