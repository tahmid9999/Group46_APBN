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

import java.util.ArrayList;

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

    ArrayList<Passenger> passengersArrayListsArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    private String generateUniquePassengerID() {
        String prefix = "BPID";
        int Num = (int)(Math.random() * 90000) + 10000;
        String bpID = prefix + Num;

        for (Passenger ps : Passenger.passengerArrayList) {
            if (ps.getPassengerID().equals(bpID)) {
                return generateUniquePassengerID(); // recursion
            }
        }

        return bpID;
    }

    @javafx.fxml.FXML
    public void initialize() {
//        passengerNameLabel.setText(SessionManager.getPassengerSession().getLoggedInPassenger().getName());
//        passengerIdLabel.setText(SessionManager.getPassengerSession().getLoggedInPassenger().getPassengerID());
//        flightNoLabel.setText(SessionManager.getPassengerSession().getLoggedInPassenger().getFlightNumber());
//        statusLabel.setText(SessionManager.getPassengerSession().getLoggedInPassenger().getPassengerStatus());

        for (Passenger ps : passengersArrayListsArrayList) {
            if (ps.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
                passengerNameLabel.setText(ps.getName());
                passengerIdLabel.setText(ps.getPassengerID());
                flightNoLabel.setText(ps.getFlightNumber());
                statusLabel.setText(ps.getPassengerStatus());
            }
        }
    }

    @javafx.fxml.FXML
    public void generateBoardingPassButton(ActionEvent actionEvent) {
        String bpID = generateUniquePassengerID();
        for (Passenger ps : passengersArrayListsArrayList) {
            if (ps.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
                ps.setBoardingPassID(bpID);
                boardingPassIdLabel.setText(bpID);

                Alert a = new Alert(Alert.AlertType.WARNING);
                if (ps.getPassengerStatus().equals("Cancelled")){
                    a.setContentText("Cancelled. You can't generate Boarding Pass ID.");
                    a.showAndWait();
                    return;
                } else {
                    a.setContentText("Boarding Pass ID has been generated successfully.");
                    a.showAndWait();
                }
            }
        }

        PassengerFileHandler.writeFile(passengersArrayListsArrayList, "passengerInfo.bin");
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