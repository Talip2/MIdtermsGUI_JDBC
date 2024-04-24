package com.example.demo;

import JDBCapr9.CreateTable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-viewJDBC.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().clear();
        stage.setTitle("Java Database Connectivity!");
        stage.setScene(scene);
        stage.show();
        CreateTable.create();
    }

    public static void main(String[] args) {
        launch();
    }
}