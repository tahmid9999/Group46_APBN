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
import javafx.stage.Stage;

public class WriteIncidentReportController
{
    @javafx.fxml.FXML
    private TableColumn<Content, String> WIRflaggedItemColumn;
    @javafx.fxml.FXML
    private TableView<Content> WIRtableview;
    @javafx.fxml.FXML
    private TableColumn<Content, String> WIRstatusColumn;
    @javafx.fxml.FXML
    private TextArea WIRtextarea;
    @javafx.fxml.FXML
    private Label WIRalertLabel;
    @javafx.fxml.FXML
    private TableColumn<Content, String> WIRpassengerIDcolumn;

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
    public void WIRsubmitButton(ActionEvent actionEvent) {
        if (WIRtextarea.getText().isEmpty()) {
            WIRalertLabel.setText("Incident report can't be empty.");
            return;
        }


    }
}