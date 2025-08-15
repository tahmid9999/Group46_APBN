package com.groupfourtysix.group46_apbn;

import com.groupfourtysix.group46_apbn.Tahmid.AppendableObjectOutputStream;
import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private ComboBox<String> CNAuserComboInput;
    @javafx.fxml.FXML
    private TextField CNAemailAdressTextfield;
    @javafx.fxml.FXML
    private TextField CNApasswordTextfield;
    @javafx.fxml.FXML
    private Label CNAalertsLabel;

    List<Account> accountArrayList = AccountFileHandler.readFile("AccountInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
        CNAuserComboInput.getItems().addAll("Passenger", "APBN Screening Officer", "Airport check-in staff", "Security Scanner Operator", "Baggage Handler", "Boarding Gate Officer", "Flight Scheduler", "Incident Logger");
//        List<Account> accounts = AccountFileHandler.readFile("AccountInfo.bin");
//        for (Account ac: accounts) {
//            System.out.println(ac);
//        }
    }

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void createNewAccountButton(ActionEvent actionEvent) {
        if (CNAuserComboInput.getValue() == null) {
            CNAalertsLabel.setText("Please select user type.");
            return;
        }
//
        if(CNAemailAdressTextfield.getText().trim().isEmpty()) {
            CNAalertsLabel.setText("Your email address can't be empty.");
            return;
        }

        boolean atSignFound = false;
        for (int i = 0; i < CNAemailAdressTextfield.getText().length(); i++) {
            if (CNAemailAdressTextfield.getText().charAt(i) == '@') {
                atSignFound = true;
            }
        }
        if (atSignFound == false) {
            CNAalertsLabel.setText("Email address must include @ sign.");
            return;
        }

        boolean dotFound = false;
        for (int i = 0; i < CNAemailAdressTextfield.getText().length(); i++) {
            if (CNAemailAdressTextfield.getText().charAt(i) == '.') {
                dotFound = true;
            }
        }
        if (dotFound == false) {
            CNAalertsLabel.setText("Email address must include .(dot) sign.");
            return;
        }

        if(CNApasswordTextfield.getText().trim().isEmpty()) {
            CNAalertsLabel.setText("Your password can't be empty.");
            return;
        }

        if (CNApasswordTextfield.getText().length() < 9) {
            CNAalertsLabel.setText("Password must be of at least 8 characters.");
            return;
        }

        Account ac = new Account(
                CNAuserComboInput.getValue(),
                CNAemailAdressTextfield.getText(),
                CNApasswordTextfield.getText(),
                UniqueID.generateID()
        );

        //Write
        AccountFileHandler.createFile(ac, "AccountInfo.bin");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Hello!");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
        showAlert("Your account has been created successfully. You can now log in.");
        System.out.println(ac);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
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