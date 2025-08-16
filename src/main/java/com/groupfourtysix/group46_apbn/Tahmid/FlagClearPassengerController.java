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

public class FlagClearPassengerController
{   ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FCflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FCstatusColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> FCtableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FCpassengerIDcolumn;

    @javafx.fxml.FXML
    public void initialize() {
        FCpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        FCflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("Items"));
        FCstatusColumn.setCellValueFactory(new PropertyValueFactory<>("passengerStatus"));

        for (Passenger passenger: passengerArrayList) {
            FCtableview.getItems().add(passenger);
        }
    }

    public void clearButton(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void FCsubmitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FCflagAsSuspiciousButton(ActionEvent actionEvent) {
        Passenger selectedSlot = FCtableview.getSelectionModel().getSelectedItem();
        System.out.println(selectedSlot);



//        if (selectedSlot != null) {
//            Passenger updatedSlot = new Passenger(selectedSlot.getItemName(), selectedSlot.getFlagReason(), selectedSlot.getItemDetails(), "Cleared");
    }

    @javafx.fxml.FXML
    public void FCclearButton(ActionEvent actionEvent) {
//        Content selectedSlot = FCtableview.getSelectionModel().getSelectedItem();
//        if (selectedSlot != null) {
//            Content updatedSlot = new Content(selectedSlot.getItemName(), selectedSlot.getFlagReason(), selectedSlot.getItemDetails(), "Cleared");
//
//            FCtableview.getItems().remove(selectedSlot);
//            FCtableview.getItems().add(updatedSlot);
//        }
    }
}