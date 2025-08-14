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
    private TextField FlightNumberField;

    @javafx.fxml.FXML
    public void initialize() {
        FlightStatusComboBox.getItems().addAll("Schedule", "Cancelled");
    }

    @javafx.fxml.FXML
    public void AddFlightButton(ActionEvent actionEvent) {
        Flight addFlightData = new Flight(
                FlightNumberField.getText(),
                AirlineNameField.getText(),
                AircraftTypeField.getText(),
                DepartureAirportField.getText(),
                ArrivalAirportField.getText(),
                SeatAvailabilityField.getText(),
                EstimateFlightDurationField.getText(),
                DepartureTerminalField.getText(),
                ArrivalTerminalField.getText(),
                FlightStatusComboBox.getValue(),
                DepartureDatePicker.getValue(),
                ArrivalDatePicker.getValue()
        );
        FileHandler.createFile(addFlightData, "FlightInfo.bin");
//        System.out.println(addFlightData);
    }
}