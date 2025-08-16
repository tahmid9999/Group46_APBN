package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DetainPassengerController
{
    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
    ArrayList<Passenger> flaggedPassengers = FlaggedPassengerFileHandler.readFile("flaggedPassengerInfo.bin");
    ArrayList<Passenger> detainedPassengers = DetainedPassengerFileHandler.readFile("detainedPassengerInfo.bin");

    @javafx.fxml.FXML
    private TableView<Passenger> DPtableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPstatusColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPpassengerIDcolumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPpassportNumberColumn;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Passenger> flaggedPassengers = FlaggedPassengerFileHandler.readFile("flaggedPassengerInfo.bin");

        DPpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        DPpassportNumberColumn.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        DPflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("Items"));
        DPstatusColumn.setCellValueFactory(new PropertyValueFactory<>("passengerStatus"));

        DPtableview.getItems().addAll(flaggedPassengers);
    }

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void DPsubmitButton(ActionEvent actionEvent) {
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
    public void detainPassengerButton(ActionEvent actionEvent) {
        Passenger selectedSlot = DPtableview.getSelectionModel().getSelectedItem();

        for (Passenger ps: passengerArrayList) {
            if (ps.getPassengerAccountID().equals(selectedSlot.getPassengerAccountID())) {
                ps.setPassengerStatus("Detained");
                detainedPassengers.add(ps);

                for (Passenger fp: flaggedPassengers) {
                    if (fp.getPassengerID().equals(ps.getPassengerID())) {
                        flaggedPassengers.remove(fp);
                    }
                }
            }
        }

        PassengerFileHandler.writeFile(passengerArrayList, "passengerInfo.bin");
        DetainedPassengerFileHandler.writeFile(detainedPassengers, "detainedPassengerInfo.bin");
        FlaggedPassengerFileHandler.writeFile(flaggedPassengers, "flaggedPassengerInfo.bin");

        DPtableview.getItems().clear();
        ArrayList<Passenger> flaggedPassengers = FlaggedPassengerFileHandler.readFile("flaggedPassengerInfo.bin");
        DPtableview.getItems().addAll(flaggedPassengers);

        showAlert("Passenger-status updated to Detained. This person cannot generate a Boarding Pass.");
    }
}