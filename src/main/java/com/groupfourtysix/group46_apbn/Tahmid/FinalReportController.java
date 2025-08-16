package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FinalReportController
{
    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
    @javafx.fxml.FXML
    private ComboBox<String> FRstatusFilterCombo;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRpassengerStatusColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRflagReasonColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRnameColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRpassengerIDColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRflightNumberColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> FRtableView;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

        FRnameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        FRpassengerIDColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        FRflightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        FRflagReasonColumn.setCellValueFactory(new PropertyValueFactory<>("FlagReason"));
        FRpassengerStatusColumn.setCellValueFactory(new PropertyValueFactory<>("passengerStatus"));

        FRstatusFilterCombo.getItems().addAll("Cleared", "Flagged", "Detained", "Cancelled");

        FRtableView.getItems().clear();
        FRtableView.getItems().addAll(passengerArrayList);
    }

    ArrayList<Passenger> tableShow = new ArrayList<>();

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
    public void FRfilterButton(ActionEvent actionEvent) {
        FRtableView.getItems().clear();
        FRtableView.getItems().addAll(passengerArrayList);
    }

    @javafx.fxml.FXML
    public void FRresetFilterButton(ActionEvent actionEvent) {
        FRtableView.getItems().clear();
        for (Passenger ps: passengerArrayList) {
            if (ps.getPassengerStatus().equals(FRstatusFilterCombo.getValue())) {
                tableShow.add(ps);
            }
        }
        FRtableView.getItems().addAll(tableShow);
    }
}