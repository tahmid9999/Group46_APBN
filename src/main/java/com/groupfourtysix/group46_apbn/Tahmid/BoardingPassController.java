package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BoardingPassController
{

    @javafx.fxml.FXML
    private Label flightNoLabel;
    @javafx.fxml.FXML
    private Label boardingPassIdLabel;
    @javafx.fxml.FXML
    private Label passengerIdLabel;
    @javafx.fxml.FXML
    private Label passengerNameLabel;
    @javafx.fxml.FXML
    private Label statusLabel;
    private Passenger passenger = SessionManager.getLoggedInPassenger();

    @javafx.fxml.FXML
    public void initialize() {
        passengerNameLabel.setText(passenger.getName());
        passengerIdLabel.setText(passenger.getPassengerID());
        flightNoLabel.setText(passenger.getFlightNumber());
        statusLabel.setText(passenger.getPassengerStatus());
    }

    @javafx.fxml.FXML
    public void generateBoardingPassButton(ActionEvent actionEvent) {
        Passenger p = SessionManager.getLoggedInPassenger();
        Alert a = new Alert(Alert.AlertType.WARNING);
        if (p.getPassengerStatus().equals("Cancelled")){
            a.setContentText("Cancelled. You can't generate Boarding Pass ID.");
            a.showAndWait();
            return;
        } else {
            a.setContentText("Boarding Pass ID has been generated successfully.");
            a.showAndWait();
        }
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