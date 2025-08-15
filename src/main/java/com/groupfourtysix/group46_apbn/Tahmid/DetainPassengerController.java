package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DetainPassengerController
{
    @javafx.fxml.FXML
    private TableView DPtableview;
    @javafx.fxml.FXML
    private TableColumn<Content, String> DPstatusColumn;
    @javafx.fxml.FXML
    private TableColumn<Content, String> DPflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPpassengerIDcolumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> DPpassportNumberColumn;

    @javafx.fxml.FXML
    public void initialize() {
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
        showAlert("Passenger-status updated to Detained. This person cannot generate a Boarding Pass.");
    }
}