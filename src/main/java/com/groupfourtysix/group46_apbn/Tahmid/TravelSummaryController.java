package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TravelSummaryController {
    @javafx.fxml.FXML
    private Label dateOfBirthLabel;
    @javafx.fxml.FXML
    private Label nationalityLabel;
    @javafx.fxml.FXML
    private Label securityClearanceLabel;
    @javafx.fxml.FXML
    private Label passportNumberLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private Label luggageStatusLabel;

    ArrayList<Passenger> passengersArrayListsArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
    @javafx.fxml.FXML
    private Label boardingPassIDLabel;

    @javafx.fxml.FXML
    public void initialize() {
        for (Passenger ps : passengersArrayListsArrayList) {
            if (ps.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
                nameLabel.setText(ps.getScanStatus());
                dateOfBirthLabel.setText(ps.getDateOfBirth().toString());
                nationalityLabel.setText(ps.getPassengerStatus());
                passportNumberLabel.setText(ps.getPassportNumber());
                luggageStatusLabel.setText(ps.getLuggageStatus());
                securityClearanceLabel.setText(ps.getPassengerStatus());
                boardingPassIDLabel.setText(ps.getBoardingPassID());
            }
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