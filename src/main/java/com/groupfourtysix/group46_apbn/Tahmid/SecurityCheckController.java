package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.Account;
import com.groupfourtysix.group46_apbn.AccountFileHandler;
import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SecurityCheckController
{
    @javafx.fxml.FXML
    private Label securityConcernLabel;
    @javafx.fxml.FXML
    private Label scanStatusLabel;
    @javafx.fxml.FXML
    private Label securityStatusLabel;

    ArrayList<Passenger> passengersArrayListsArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
//        for (Passenger ps: passengersArrayListsArrayList) {
//            if (ps.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
//                scanStatusLabel.setText(ps.getScanStatus());
//                securityStatusLabel.setText(ps.getPassengerStatus());
//                if (ps.getPassengerStatus().equals("Flagged")) {
//                    securityConcernLabel.setText("Security concern detected. Please contact airport security");
//            }
//        }
//
//        }
    }

    @javafx.fxml.FXML
    public void viewScanResultButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/ScanResultView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Scan-result");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
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