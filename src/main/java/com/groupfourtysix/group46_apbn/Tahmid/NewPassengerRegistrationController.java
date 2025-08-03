package com.groupfourtysix.group46_apbn.Tahmid;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewPassengerRegistrationController
{
    @javafx.fxml.FXML
    private ComboBox nationalityComboInput;
    @javafx.fxml.FXML
    private Label vdVrLabel;
    @javafx.fxml.FXML
    private TextField passportNumberTextfield;
    @javafx.fxml.FXML
    private TextField passengerNameTextfield;
    @javafx.fxml.FXML
    private DatePicker passengerDateOfBirth;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void newPassengerRegSaveButton(ActionEvent actionEvent) {
    }
}