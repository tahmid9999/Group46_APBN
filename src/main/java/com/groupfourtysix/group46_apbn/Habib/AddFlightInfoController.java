package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/FlightDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Flight Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}