package com.groupfourtysix.group46_apbn;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) {
        if(emailAdressTextfield.getText().trim().isEmpty()) {
            logInAlertsLabel.setText("Please enter your email address properly.");
            return;
        }

        for (int i = 0; i < emailAdressTextfield.getText().length(); i++) {
            boolean atSignFound;
            if (emailAdressTextfield.getText().charAt(i) == '@') {
                atSignFound = true;
            }
            else {
                atSignFound = false;
                return;
            }
        }

        for (int i = 0; i < emailAdressTextfield.getText().length(); i++) {
            boolean dotFound;
            if (emailAdressTextfield.getText().charAt(i) == '.') {
                dotFound = true;
            }
            else {
                dotFound = false;
                return;
            }
        }

        if(passwordTextfield.getText().trim().isEmpty()) {
            logInAlertsLabel.setText("Please enter your password properly.");
            return;
        }

        if (passwordTextfield.getText().length() < 9) {
            logInAlertsLabel.setText("Password must be of at least 8 characters.");
            return;
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