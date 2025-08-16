package com.groupfourtysix.group46_apbn;

import com.groupfourtysix.group46_apbn.util.AccountSession;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField emailAdressTextfield;
    @javafx.fxml.FXML
    private TextField passwordTextfield;
    @javafx.fxml.FXML
    private Label logInAlertsLabel;
    @javafx.fxml.FXML
    private ComboBox<String> userComboInput;

    @javafx.fxml.FXML
    public void initialize() {
        userComboInput.getItems().addAll("Passenger", "APBN Screening Officer", "Airport check-in staff", "Security Scanner Operator", "Baggage Handler", "Boarding Gate Officer", "Flight Scheduler", "Incident Logger");
    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) {
        if (userComboInput.getValue() == null) {
            logInAlertsLabel.setText("Please select user type.");
            return;
        }
//
        if(emailAdressTextfield.getText().trim().isEmpty()) {
            logInAlertsLabel.setText("Your email address can't be empty.");
            return;
        }

        boolean atSignFound = false;
        for (int i = 0; i < emailAdressTextfield.getText().length(); i++) {
            if (emailAdressTextfield.getText().charAt(i) == '@') {
                atSignFound = true;
            }
        }
        if (atSignFound == false) {
            logInAlertsLabel.setText("Email address must include @ sign.");
            return;
        }

        boolean dotFound = false;
        for (int i = 0; i < emailAdressTextfield.getText().length(); i++) {
            if (emailAdressTextfield.getText().charAt(i) == '.') {
                dotFound = true;
            }
        }
        if (dotFound == false) {
            logInAlertsLabel.setText("Email address must include .(dot) sign.");
            return;
        }

        if(passwordTextfield.getText().trim().isEmpty()) {
            logInAlertsLabel.setText("Your password can't be empty.");
            return;
        }

        if (passwordTextfield.getText().length() < 9) {
            logInAlertsLabel.setText("Password must be of at least 8 characters.");
            return;
        }

        ArrayList<Account> accountsArrayList = AccountFileHandler.readFile("AccountInfo.bin");
        for (Account acs: accountsArrayList) {
            if (userComboInput.getValue().equals(acs.getAccountUserType()) && emailAdressTextfield.getText().equals(acs.getAccountEmail()) && passwordTextfield.getText().equals(acs.getAccountPassword())) {
                if (userComboInput.getValue().equals("Passenger")) {
                    SessionManager.getAccountSession().setAccountID(acs.getAccountID());
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/PassengerDashboard.fxml"));
                        Scene nextScene = new Scene(fxmlLoader.load());
                        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        stage.setTitle("Passenger Dashboard");
                        stage.setScene(nextScene);
                        stage.show();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                if (userComboInput.getValue().equals("APBN Screening Officer")) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/APBNScreeningOfficerDashboard.fxml"));
                        Scene nextScene = new Scene(fxmlLoader.load());
                        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        nextStage.setTitle("APBN Screening Officer");
                        nextStage.setScene(nextScene);
                        nextStage.show();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        }


    }

    @javafx.fxml.FXML
    public void createAccountButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccount.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Hello!");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}