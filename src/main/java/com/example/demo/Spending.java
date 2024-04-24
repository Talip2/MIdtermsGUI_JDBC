package com.example.demo;

import javafx.scene.control.Button;

public class Spending {

    private int spendingID;
    private int amount;
    private String reason;

    private Button editButton;
    private Button deleteButton;

    public Spending(int spendingID, int amount, String reason) {
        this.spendingID = spendingID;
        this.amount = amount;
        this.reason = reason;
    }

    public int getSpendingID() {
        return this.spendingID;
    }


    public int getAmount() {
        return amount;
    }



    public String getReason() {
        return reason;
    }



    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }
}
