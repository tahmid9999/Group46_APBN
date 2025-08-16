package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BoardingGateOfficerController
{
    @javafx.fxml.FXML
    private Label verificationResult;
    @javafx.fxml.FXML
    private ComboBox<String> flightComboBox;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> colPassengerName;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> colBoardingPass;
    @javafx.fxml.FXML
    private TableView<Passenger> passengerTable;
    @javafx.fxml.FXML
    private TextField boardingPassInput;
    @javafx.fxml.FXML
    private TableColumn <Passenger, String>colStatus;

    private javafx.collections.ObservableList<Passenger> passengerList;

    @javafx.fxml.FXML
    public void initialize() {

        flightComboBox.setItems(FXCollections.observableArrayList("FL123", "FL456", "FL789"));

        colPassengerName.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
        colBoardingPass.setCellValueFactory(new PropertyValueFactory<>("boardingPassNo"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        passengerList = FXCollections.observableArrayList();
        passengerTable.setItems(passengerList);
    }

    @javafx.fxml.FXML
    public void onVerifyBoardingPass(ActionEvent actionEvent) {

        String passNo = boardingPassInput.getText();

        Passenger passenger = BoardingPassengerHandler.readPassengers("passengers_data.bin").stream()
                .filter(p -> passNo.equals(p.getBoardingPassID()))
                .findFirst().orElse(null);

        if (passenger != null) {
            verificationResult.setText("Boarding Pass Verified: " +passNo);
            passenger.setScanStatus("Verified");
            BoardingPassengerHandler.updatePassenger(passenger, "boardingpassengers_data.bin");
            passengerTable.refresh();
        } else {
            verificationResult.setText("Invalid Boarding Pass");
        }

        boardingPassInput.clear();
    }

    @javafx.fxml.FXML
    public void onGenerateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onFinalizeBoarding(ActionEvent actionEvent) {

        for (Passenger p : passengerList) {
            p.setPassengerStatus("Boarded");
            BoardingPassengerHandler.updatePassenger(p, "passengers_data.bin");
        }
        passengerTable.refresh();
        verificationResult.setText("All passengers finalized for boarding.");

    }

    @javafx.fxml.FXML
    public void onLoadManifest(ActionEvent actionEvent) {

        String selectedFlight = flightComboBox.getValue();
        if (selectedFlight != null) {
            passengerList.setAll(
                    BoardingPassengerHandler.readPassengers("boardingpassengers_data.bin").stream()
                            .filter(p -> selectedFlight.equals(p.getFlightNumber()))
                            .toList()
            );
            verificationResult.setText("Manifest loaded for " + selectedFlight);
        } else {
            verificationResult.setText("Please select a flight first");
        }
    }


    @javafx.fxml.FXML
    public void onDenyBoarding(ActionEvent actionEvent) {

        Passenger selected = passengerTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setPassengerStatus("Denied");
            BoardingPassengerHandler.updatePassenger(selected, "boardingpassengers_data.bin");
            passengerTable.refresh();
            verificationResult.setText("Denied boarding for " + selected.getName());
        } else {
            verificationResult.setText("Select a passenger first!");
        }
    }

    @javafx.fxml.FXML
    public void openPassengerList(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openReportedPassengerList(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openEditBoardingList(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openReportPassenger(ActionEvent actionEvent) {
    }
}