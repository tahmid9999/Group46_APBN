package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class APBNScreeningOfficerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    public String showAlert(String message){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(message);

        ButtonType yButton = new ButtonType("Yes");
        ButtonType nButton = new ButtonType("No");
        a.getButtonTypes().setAll(yButton, nButton);
        Optional<ButtonType> resultButtonType = a.showAndWait();

        if(resultButtonType.isPresent() && resultButtonType.get() == yButton){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        if(showAlert("Are you sure you want to log out?").equals("Yes")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());
                Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                nextStage.setTitle("Log in");
                nextStage.setScene(nextScene);
                nextStage.show();
            }
            catch(Exception e){
                //
            }
        }

    }

    @javafx.fxml.FXML
    public void passengerListButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/ViewPassengerList.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Passenger List");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void writeIncidentReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void flagClearPassengerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void finalReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void flaggedItemsReportButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/ReviewFlaggedItemsReport.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Review Flagged Items");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void viewLuggageInfoButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/ViewSubmittedLuggageInfo.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Luggage Info");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void detainPassengerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void detainedListButton(ActionEvent actionEvent) {
    }
}