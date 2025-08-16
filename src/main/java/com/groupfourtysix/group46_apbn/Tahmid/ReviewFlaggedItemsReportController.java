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

public class ReviewFlaggedItemsReportController
{   @javafx.fxml.FXML
    private TableColumn<Passenger, String> RFIRflagReasonColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> RFIRflaggedItemReasonTableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RFIRflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RFIRluggageIDcolumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> RFIRpassengerIDcolumn;

    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
    ArrayList<Passenger> flaggedPassengers = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        RFIRpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        RFIRluggageIDcolumn.setCellValueFactory(new PropertyValueFactory<>("luggageID"));
        RFIRflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("Items"));
        RFIRflagReasonColumn.setCellValueFactory(new PropertyValueFactory<>("FlagReason"));

        for (Passenger passenger: passengerArrayList) {
            if (passenger.getPassengerStatus().equals("Flagged")) {
                flaggedPassengers.add(passenger);
            }
        }

//        for (Passenger flaggedPassenger: flaggedPassengers) {
//            RFIRflaggedItemReasonTableview.getItems().add(flaggedPassenger);
//        }

        RFIRflaggedItemReasonTableview.getItems().addAll(flaggedPassengers);
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