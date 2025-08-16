package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.Habib.FileHandler;
import com.groupfourtysix.group46_apbn.Habib.Flight;
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
import java.util.List;

public class FlightInfoController
{
    @javafx.fxml.FXML
    private Label flightStatusLabel;
    @javafx.fxml.FXML
    private TextField flightNumberTextfield;

    List<Flight> flightArrayList = FileHandler.readFile("FlightInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void flightStatusCheckButton(ActionEvent actionEvent) {
        for (Flight fl : flightArrayList) {
            if (fl.getFlightNumber().equals(flightNumberTextfield.getText())) {
                flightStatusLabel.setText(fl.getFlightStatus());
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