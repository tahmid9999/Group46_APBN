package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CancelTravelController
{   ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void noGoBackButton(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void yesCancelButton(ActionEvent actionEvent) {
//        SessionManager.getPassengerSession().getLoggedInPassenger().setPassengerStatus("Cancelled");
//        System.out.println(SessionManager.getPassengerSession().getLoggedInPassenger().getPassengerStatus());


        for (Passenger ps: passengerArrayList) {
            if (ps.getPassengerAccountID().equals(SessionManager.getAccountSession().getAccountID())) {
//                System.out.println(ps);
                ps.setPassengerStatus("Cancelled");
//                System.out.println(ps);
            }
        }

        PassengerFileHandler.writeFile(passengerArrayList, "passengerInfo.bin");

    }
}