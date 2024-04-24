package com.example.demo;

import JDBCapr9.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    public TableColumn colEditButton;
    public TableColumn colDeleteButton;
    ResultSet legitResult;

    public Button txtCreateSpending;
    public TextField txtReason;
    public TextField txtAmount;
    public static int currUserID;

    @FXML
    private TableColumn<Spending, Integer> colAmount;

    @FXML
    public TableColumn<Spending, String> colReason;
    @FXML
    public TableView<Spending> tableSpending;


    ObservableList<Spending> list =  FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            currUserID = ReadData.getUserID();
            loadSpending();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void refreshTable() {
        ObservableList<Spending> tempList = FXCollections.observableArrayList();

        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            c.setAutoCommit(false);
            String query = "SELECT * FROM spending WHERE userID = " + currUserID;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int spendingID = resultSet.getInt("spendingID");
                int amount = resultSet.getInt("amount");
                String reason = resultSet.getString("reason");

                System.out.println("Debug - spendingID: " + spendingID + ", amount: " + amount + ", reason: " + reason);

                Button editButton = new Button("Edit");
                editButton.setOnAction(e -> {
                    editSpending(new Spending(spendingID, amount, reason));
                });

                Button deleteButton = new Button("Delete");
                deleteButton.setOnAction(e -> {
                    deleteSpending(new Spending(spendingID, amount, reason));
                });

                Spending spending = new Spending(spendingID, amount, reason);
                spending.setEditButton(editButton);
                spending.setDeleteButton(deleteButton);

                tempList.add(spending);
            }

            Platform.runLater(() -> {
                list.setAll(tempList);
                tableSpending.setItems(list);
            });

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void loadSpending() throws SQLException {
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colEditButton.setCellValueFactory(new PropertyValueFactory<>("editButton"));
        colDeleteButton.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));
        refreshTable();
    }


    public void createSpend(ActionEvent actionEvent) throws SQLException {
        int amount = Integer.parseInt(txtAmount.getText().toString());
        String reason = txtReason.getText().toString();
        InsertData.insertSpending(amount, reason, currUserID);
        refreshTable();


    }

    private void editSpending(Spending spending) {
        // Create a new dialog

        Stage editStage = new Stage();
        editStage.setTitle("Edit Spending");

        int rowID = spending.getSpendingID();

        Label amountLabel = new Label("Amount:");
        TextField amountTextField = new TextField(String.valueOf(spending.getAmount()));

        Label reasonLabel = new Label("Reason:");
        TextField reasonTextField = new TextField(spending.getReason());

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            int newAmount = Integer.parseInt(amountTextField.getText());
            String newReason = reasonTextField.getText();

            UpdateData.updateSpending(rowID, newAmount, newReason, currUserID);

            refreshTable();

            editStage.close();
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            editStage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(amountLabel, 0, 0);
        gridPane.add(amountTextField, 1, 0);
        gridPane.add(reasonLabel, 0, 1);
        gridPane.add(reasonTextField, 1, 1);
        gridPane.add(saveButton, 0, 2);
        gridPane.add(cancelButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 150);
        editStage.setScene(scene);
        editStage.show();
    }



    private void deleteSpending(Spending spending) {
        DeletData.deleteSpending(spending.getSpendingID());
        refreshTable();
    }

}
