package com.groupfourtysix.group46_apbn.Habib;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Iterator;
import java.util.List;

public class DeleteFlightInfoController
{
    @javafx.fxml.FXML
    private TextField FlightNumberField;

//    Custom
    String flightNumber;
    List<Flight> flights = FileHandler.readFile("FlightInfo.bin");
    @javafx.fxml.FXML
    private Label ArrivalDateLabel;
    @javafx.fxml.FXML
    private Label ArrivalAirportLabel;
    @javafx.fxml.FXML
    private Label AircarftTypeLabel;
    @javafx.fxml.FXML
    private Label SeatAvailabilityLabel;
    @javafx.fxml.FXML
    private Label ArrivalTerminalLabel;
    @javafx.fxml.FXML
    private Label FlightStatusLabel;
    @javafx.fxml.FXML
    private Label DepartureAirportLabel;
    @javafx.fxml.FXML
    private Label DepartureDateLabel;
    @javafx.fxml.FXML
    private Label DepartureTerminalLabel;
    @javafx.fxml.FXML
    private Label FlightNumberLabel;
    @javafx.fxml.FXML
    private Label AirlineNameLabel;
    @javafx.fxml.FXML
    private Label FlightDurationLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void DeleteFlightInformationButton(ActionEvent actionEvent) {
        Iterator<Flight> iterator = flights.iterator();
        boolean removed = false;
        while (iterator.hasNext()){
            Flight f = iterator.next();
            if(f.getFlightNumber().equalsIgnoreCase(flightNumber)){
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed){
            FileHandler.writeFile(flights,"FlightInfo.bin");
        }
    }

    @javafx.fxml.FXML
    public void FetchButton(ActionEvent actionEvent) {
        flightNumber =  FlightNumberField.getText();
        for (Flight flight: flights){
            if(flight.getFlightNumber().equalsIgnoreCase(flightNumber)){
                flightNumber = flight.getFlightNumber();
                FlightNumberLabel.setText(flight.getFlightNumber());
                AirlineNameLabel.setText(flight.getAirlineName());
                AircarftTypeLabel.setText(flight.getAircraftType());
                DepartureAirportLabel.setText(flight.getDepartureAirport());
                ArrivalAirportLabel.setText(flight.getArrivalAirport());
                SeatAvailabilityLabel.setText(flight.getSeatAvailability());
                DepartureDateLabel.setText(flight.getDepartureDate().toString());
                ArrivalDateLabel.setText(flight.getArrivalDate().toString());
                FlightDurationLabel.setText(flight.getEstimateFlightDuration());
                DepartureTerminalLabel.setText(flight.getDepartureTerminal());
                ArrivalTerminalLabel.setText(flight.getArrivalTerminal());
                FlightStatusLabel.setText(flight.getFlightStatus());
            }
        }

    }
}