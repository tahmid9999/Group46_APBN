package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ReinvestigateController
{
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RpassengerIDcolumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RflagReasonColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RflaggedItemColumn;
    @javafx.fxml.FXML
    private TableView Rtableview;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Passenger> detainedPassengers = DetainedPassengerFileHandler.readFile("detainedPassengerInfo.bin");

        RpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        RflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("Items"));
        RflagReasonColumn.setCellValueFactory(new PropertyValueFactory<>("FlagReason"));

        Rtableview.getItems().clear();
        Rtableview.getItems().addAll(detainedPassengers);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/APBNScreeningOfficerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("APBN Screening Officer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }
}