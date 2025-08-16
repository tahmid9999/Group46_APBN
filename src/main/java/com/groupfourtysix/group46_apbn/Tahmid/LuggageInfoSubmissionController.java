package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LuggageInfoSubmissionController
{   ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    private TextField numOfCarryOnBagsTextfield;
    @javafx.fxml.FXML
    private TextField totalNumOfBagsTextfield;
    @javafx.fxml.FXML
    private Label vdVrLuggageInfoSubLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private String generateUniqueLuggageID() {
        String prefix = "LID";
        int Num = (int)(Math.random() * 90000) + 10000;
        String psID = prefix + Num;

        for (Passenger ps : Passenger.passengerArrayList) {
            if (ps.getPassengerID().equals(psID)) {
                return generateUniqueLuggageID(); // recursion
            }
        }

        return psID;
    }

    @javafx.fxml.FXML
    public void luggageInfoSubmitButton(ActionEvent actionEvent) {
        if (totalNumOfBagsTextfield.getText().isEmpty()) {
            vdVrLuggageInfoSubLabel.setText("Please enter total number of bags");
            return;
        }

        try{
            int isNumber = Integer.parseInt(totalNumOfBagsTextfield.getText());
        } catch (Exception e){
            vdVrLuggageInfoSubLabel.setText("Total number of bags must be a number");
            return;
        }

        if (numOfCarryOnBagsTextfield.getText().isEmpty()) {
            vdVrLuggageInfoSubLabel.setText("Please enter number of carry-on bags");
            return;
        }

        try{
            int isNumber = Integer.parseInt(numOfCarryOnBagsTextfield.getText());
        } catch (Exception e){
            vdVrLuggageInfoSubLabel.setText("Number of carry-on bags must be a number");
            return;
        }


        for (Passenger passenger: passengerArrayList) {
            if (passenger.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
                passenger.setTotalNumOfBags(Integer.parseInt(totalNumOfBagsTextfield.getText()));
                passenger.setNumOfCarryOnBags(Integer.parseInt(numOfCarryOnBagsTextfield.getText()));
                passenger.setLuggageStatus("Submitted");
            }
        }

        PassengerFileHandler.writeFile(passengerArrayList, "passengerInfo.bin");

        vdVrLuggageInfoSubLabel.setText("Luggage Info has been submitted successfully");

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/PassengerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Hello!");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }
}