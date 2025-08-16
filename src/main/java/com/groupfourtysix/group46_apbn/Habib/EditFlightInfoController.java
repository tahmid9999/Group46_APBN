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

import java.util.List;

public class EditFlightInfoController
{
    @javafx.fxml.FXML
    private ComboBox<String> FlightStatusComboBox;
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
    private TextField FlightNumberField;
    @javafx.fxml.FXML
    private DatePicker ArrivalDatePicker;
    @javafx.fxml.FXML
    private TextField EstimateFlightDurationField;
    @javafx.fxml.FXML
    private TextField InputFlightNumberField;

    List<Flight> flights = FileHandler.readFile("FlightInfo.bin");
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void AddFlightButton(ActionEvent actionEvent) {
        for (Flight flight: flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(InputFlightNumberField.getText())) {
                flight.setFlightNumber(AirlineNameField.getText());
                flight.setAirlineName(AirlineNameField.getText());
                flight.setAircraftType(AircraftTypeField.getText());
                flight.setDepartureAirport(DepartureAirportField.getText());
                flight.setArrivalAirport(ArrivalAirportField.getText());
                flight.setSeatAvailability(SeatAvailabilityField.getText());
                flight.setDepartureDate(DepartureDatePicker.getValue());
                flight.setArrivalDate(ArrivalDatePicker.getValue());
                flight.setEstimateFlightDuration(EstimateFlightDurationField.getText());
                flight.setDepartureTerminal(DepartureTerminalField.getText());
                flight.setArrivalTerminal(ArrivalTerminalField.getText());
                flight.setFlightStatus(FlightStatusComboBox.getValue());
            }
        }

        FileHandler.writeFile(flights, "FlightInfo.bin");
    }

    @javafx.fxml.FXML
    public void FetchDataButton(ActionEvent actionEvent) {
        for (Flight flight: flights){
            if(flight.getFlightNumber().equalsIgnoreCase(InputFlightNumberField.getText())) {
                FlightNumberField.setText(flight.getFlightNumber());
                AirlineNameField.setText(flight.getAirlineName());
                AircraftTypeField.setText(flight.getAircraftType());
                DepartureAirportField.setText(flight.getDepartureAirport());
                ArrivalAirportField.setText(flight.getArrivalAirport());
                SeatAvailabilityField.setText(flight.getSeatAvailability());
                DepartureDatePicker.setValue(flight.getDepartureDate());
                ArrivalDatePicker.setValue(flight.getArrivalDate());
                EstimateFlightDurationField.setText(flight.getEstimateFlightDuration());
                DepartureTerminalField.setText(flight.getDepartureTerminal());
                ArrivalTerminalField.setText(flight.getArrivalTerminal());
                FlightStatusComboBox.getItems().addAll("Schedule", "Cancelled");
            }
        }
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