package com.groupfourtysix.group46_apbn.Habib;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddFlightInfoController
{
    @javafx.fxml.FXML
    private ComboBox <String> FlightStatusComboBox;
    @javafx.fxml.FXML
    private TextField ArrivalAirportField;
    @javafx.fxml.FXML
    private TextField SeatAvailabilityField;
    @javafx.fxml.FXML
    private TextField AirlineNameField;
    @javafx.fxml.FXML
    private TextField ArrivalTerminalField;
    @javafx.fxml.FXML
    private TextField DepartureTerminalField;
    @javafx.fxml.FXML
    private TextField DepartureAirportField;
    @javafx.fxml.FXML
    private TextField AircraftTypeField;
    @javafx.fxml.FXML
    private DatePicker DepartureDatePicker;
    @javafx.fxml.FXML
    private DatePicker ArrivalDatePicker;
    @javafx.fxml.FXML
    private TextField EstimateFlightDurationField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void AddFlightButton(ActionEvent actionEvent) {
    }
}