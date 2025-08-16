package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class WriteIncidentReportController
{
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> WIRflaggedItemColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> WIRtableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> WIRstatusColumn;
    @javafx.fxml.FXML
    private TextArea WIRtextarea;
    @javafx.fxml.FXML
    private Label WIRalertLabel;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> WIRpassengerIDcolumn;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Passenger> flaggedPassengers = FlaggedPassengerFileHandler.readFile("flaggedPassengerInfo.bin");

        WIRpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        WIRflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("Items"));
        WIRstatusColumn.setCellValueFactory(new PropertyValueFactory<>("passengerStatus"));

        WIRtableview.getItems().clear();
        WIRtableview.getItems().addAll(flaggedPassengers);
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
    public void WIRsubmitButton(ActionEvent actionEvent) {
        if (WIRtextarea.getText().trim().isEmpty()) {
            WIRalertLabel.setText("Incident report can't be empty.");
            return;
        }

        Passenger selectedSlot = WIRtableview.getSelectionModel().getSelectedItem();

        ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
        ArrayList<Passenger> flaggedPassengers = FlaggedPassengerFileHandler.readFile("flaggedPassengerInfo.bin");

        for (Passenger ps: passengerArrayList) {
            if (ps.getPassengerAccountID().equals(selectedSlot.getPassengerAccountID())) {
                ps.setIncidentReport(WIRtextarea.getText());

                for (Passenger fp : flaggedPassengers) {
                    if (ps.getPassengerID().equals(fp.getPassengerID())) {
                        fp.setIncidentReport(WIRtextarea.getText());
                    }
                }
            }
        }
        WIRtextarea.clear();
        WIRalertLabel.setText("Incident report has been submitted successfully.");
    }
}