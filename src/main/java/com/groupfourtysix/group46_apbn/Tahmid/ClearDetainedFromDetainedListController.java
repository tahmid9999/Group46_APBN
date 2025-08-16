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

public class ClearDetainedFromDetainedListController
{
    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");
    ArrayList<Passenger> detainedPassengers = DetainedPassengerFileHandler.readFile("detainedPassengerInfo.bin");

    @javafx.fxml.FXML
    private TableColumn<Passenger, String> CDdetainedNameColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> CDtableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> CDpassportNumberColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> CDflightNumberColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> CDstatusColumn;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Passenger> detainedPassengers = DetainedPassengerFileHandler.readFile("detainedPassengerInfo.bin");

        CDdetainedNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        CDpassportNumberColumn.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        CDflightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        CDstatusColumn.setCellValueFactory(new PropertyValueFactory<>("passengerStatus"));

        CDtableview.getItems().addAll(detainedPassengers);
    }

    @javafx.fxml.FXML
    public void CDclearPassengerButton(ActionEvent actionEvent) {
        Passenger selectedSlot = CDtableview.getSelectionModel().getSelectedItem();

        for (Passenger psngr: passengerArrayList) {
            if (psngr.getPassengerAccountID().equals(selectedSlot.getPassengerAccountID())) {
                psngr.setPassengerStatus("Cleared");

                for (Passenger dp: detainedPassengers) {
                    if (dp.getPassengerID().equals(psngr.getPassengerID())) {
                        detainedPassengers.remove(dp);
                    }
                }
            }
        }

        PassengerFileHandler.writeFile(passengerArrayList, "passengerInfo.bin");
        DetainedPassengerFileHandler.writeFile(detainedPassengers, "detainedPassengerInfo.bin");

        CDtableview.getItems().clear();
        ArrayList<Passenger> detainedPassengers = DetainedPassengerFileHandler.readFile("detainedPassengerInfo.bin");
        CDtableview.getItems().addAll(detainedPassengers);
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
    public void CDsubmitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CDreinvestigateButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/Reinvestigate.fxml"));
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