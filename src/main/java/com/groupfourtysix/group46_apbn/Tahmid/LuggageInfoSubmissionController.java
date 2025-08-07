package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LuggageInfoSubmissionController
{
    @javafx.fxml.FXML
    private CheckBox largeCheckbox;
    @javafx.fxml.FXML
    private TextField numOfCarryOnBagsTextfield;
    @javafx.fxml.FXML
    private CheckBox mediumCheckbox;
    @javafx.fxml.FXML
    private TextField totalNumOfBagsTextfield;
    @javafx.fxml.FXML
    private Label vdVrLuggageInfoSubLabel;
    @javafx.fxml.FXML
    private CheckBox oversizedCheckbox;
    @javafx.fxml.FXML
    private CheckBox smallCheckbox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void luggageInfoSubmitButton(ActionEvent actionEvent) {
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