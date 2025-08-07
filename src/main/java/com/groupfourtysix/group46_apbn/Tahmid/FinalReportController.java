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
    private ComboBox FRstatusFilterCombo;
    @javafx.fxml.FXML
    private TableColumn FRpassengerStatusColumn;
    @javafx.fxml.FXML
    private TableColumn FRflagReasonColumn;
    @javafx.fxml.FXML
    private TableColumn FRnameColumn;
    @javafx.fxml.FXML
    private TableColumn FRpassengerIDColumn;
    @javafx.fxml.FXML
    private TableColumn FRflightNumberColumn;
    @javafx.fxml.FXML
    private TableView FRtableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void FRexportButton(ActionEvent actionEvent) {
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
}