package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FinalReportController
{
    @javafx.fxml.FXML
    private ComboBox<String> FRstatusFilterCombo;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> FRpassengerStatusColumn;
    @javafx.fxml.FXML
    private TableColumn FRflagReasonColumn;
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
    public void FRfilterButton(ActionEvent actionEvent) {

    }
}