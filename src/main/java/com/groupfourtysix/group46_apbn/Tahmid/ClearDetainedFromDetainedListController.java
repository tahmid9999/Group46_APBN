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
    private TableColumn CDflagReasonColumn;
    @javafx.fxml.FXML
    private TableColumn CDdetainedNameColumn;
    @javafx.fxml.FXML
    private TableView CDtableview;
    @javafx.fxml.FXML
    private TableColumn CDpassportNumberColumn;
    @javafx.fxml.FXML
    private TableColumn CDflightNumberColumn;
    @javafx.fxml.FXML
    private TableColumn CDstatusColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CDclearPassengerButton(ActionEvent actionEvent) {
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