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

import java.util.ArrayList;

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

    ArrayList<LuggageInfo> luggageInfoArrayList = new ArrayList<>();
    ArrayList<String> luggageTypeArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void luggageInfoSubmitButton(ActionEvent actionEvent) {
        if (totalNumOfBagsTextfield.getText().isEmpty()) {
            vdVrLuggageInfoSubLabel.setText("Please enter total number of bags");
            return;
        }

        try{
            int isNumber = Integer.parseInt(totalNumOfBagsTextfield.getText());
        } catch (Exception e){
            vdVrLuggageInfoSubLabel.setText("Total number of bags must be a number");
            return;
        }

        if (numOfCarryOnBagsTextfield.getText().isEmpty()) {
            vdVrLuggageInfoSubLabel.setText("Please enter number of carry-on bags");
            return;
        }

        try{
            int isNumber = Integer.parseInt(numOfCarryOnBagsTextfield.getText());
        } catch (Exception e){
            vdVrLuggageInfoSubLabel.setText("Number of carry-on bags must be a number");
            return;
        }

        String luggageType;
        if (smallCheckbox.isSelected()) {
            luggageType = "Small";
            luggageTypeArrayList.add(luggageType);
        }
        if (mediumCheckbox.isSelected()) {
            luggageType = "Medium";
            luggageTypeArrayList.add(luggageType);
        }
        if (largeCheckbox.isSelected()) {
            luggageType = "Large";
            luggageTypeArrayList.add(luggageType);
        }
        if (oversizedCheckbox.isSelected()) {
            luggageType = "Oversized";
            luggageTypeArrayList.add(luggageType);
        }

        LuggageInfo lg = new LuggageInfo(
                Integer.parseInt(totalNumOfBagsTextfield.getText()),
                Integer.parseInt(numOfCarryOnBagsTextfield.getText()),
                luggageTypeArrayList
        );

        luggageInfoArrayList.add(lg);
        vdVrLuggageInfoSubLabel.setText("Luggage Info has been submitted successfully");

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