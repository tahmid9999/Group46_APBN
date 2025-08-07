package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TravelSummaryController
{
    @javafx.fxml.FXML
    private Label boardingStatusLabel;
    @javafx.fxml.FXML
    private Label dateOfBirthLabel;
    @javafx.fxml.FXML
    private Label nationalityLabel;
    @javafx.fxml.FXML
    private Label securityClearanceLabel;
    @javafx.fxml.FXML
    private Label passportNumberLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private Label luggageStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void downloadSummaryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/PassengerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Hello!");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }
}