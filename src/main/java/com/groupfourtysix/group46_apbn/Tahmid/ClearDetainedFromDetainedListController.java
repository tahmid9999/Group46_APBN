package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ClearDetainedFromDetainedListController
{
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> CDflagReasonColumn;
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
    }

    @javafx.fxml.FXML
    public void CDclearPassengerButton(ActionEvent actionEvent) {
//         Passenger selectedSlot = CDtableview.getSelectionModel().getSelectedItem();
//        if (selectedSlot != null) {
//            Passenger updatedSlot = new Passenger(selectedSlot.getName(), selectedSlot.getDateOfBirth(), selectedSlot.getPassportNumber(), selectedSlot.getNationality(), selectedSlot.getPassengerID(), selectedSlot.getFlightNumber(), selectedSlot.getStatus(), "Clear");
//
//            slotTable.getItems().remove(selectedSlot);
//            slotTable.getItems().add(updatedSlot);
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
    }
}