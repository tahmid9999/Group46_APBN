package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.LuggageInfo;
import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;




public class BaggageHandlerController
{
    @javafx.fxml.FXML
    private TextField tagIdField;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String>passengerCol;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String>luggageIdCol;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> flightCol;
    @javafx.fxml.FXML
    private TextArea issueDescriptionField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableView <Passenger>luggageTable;
    @javafx.fxml.FXML
    private ComboBox<String> flagIDComboBox;
    @javafx.fxml.FXML
    private TextField firstbagweight;
    @javafx.fxml.FXML
    private Button btndailyeport;
    @javafx.fxml.FXML
    private TextField secondbagweight;
    @javafx.fxml.FXML
    private ComboBox<Integer> TotalBagsComboBox;
    @javafx.fxml.FXML
    private Button SearchLuggageButton;
    @javafx.fxml.FXML
    private Button editBaggageButton;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Button manualcheckbtn;
    @javafx.fxml.FXML
    private Button DelteButton;

    @javafx.fxml.FXML
    public void initialize() {
        passengerCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        luggageIdCol.setCellValueFactory(new PropertyValueFactory<>("boardingPassID"));
        flightCol.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

        flagIDComboBox.getItems().addAll("Clear", "Suspicious");
        TotalBagsComboBox.getItems().addAll(1,2);

        confirmationLabel.setVisible(false);
        luggageTable.getItems().clear();





    }

    @Deprecated
    public void submitIncidentReport(ActionEvent actionEvent) {

        String passengerID = tagIdField.getText();
        Integer totalBags = TotalBagsComboBox.getValue();
        String flag = flagIDComboBox.getValue();
        String firstWeight = firstbagweight.getText();
        String secondWeight = secondbagweight.getText();


        if (passengerID == null){
            confirmationLabel.setText("Please enter a valid Passenger ID");
            confirmationLabel.setVisible(true);
            return;
        }
        if (passengerID.isEmpty()) {
            confirmationLabel.setText("Please enter a valid Passenger ID");
            confirmationLabel.setVisible(true);
            return;
        }

//        Passenger foundPassenger = null;
//        For (Passenger passenger : allPassengers){

//        }
    }

    @Deprecated
    public void openIncidentReporting(ActionEvent actionEvent) {
    }

    @Deprecated
    public void openLuggageManagement(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleTagSubmission(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void opendownloadreport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openEditBaggageView(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Matchpassenger(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DeleteSpecificBaggageInformation(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openManualCheckView(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openSearch(ActionEvent actionEvent) {
    }
}