package com.groupfourtysix.group46_apbn.Habib;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchFlightController
{
    @javafx.fxml.FXML
    private TableColumn<Flight, String> AircraftTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> ArrivalDateCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> DepartureDateCol;
    @javafx.fxml.FXML
    private TableView<Flight> FlightInformationTable;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> FlightNumberCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> FlightDurationCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> AirlineNameCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> DepartureTerminalCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> ArrivalTerminalCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> DepartureAirportCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> SeatAvailabilityCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> FlightStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Flight, String> ArrivalAirportCol;
    @javafx.fxml.FXML
    private TextField SearchFlightByFlightNumberField;

    List<Flight> flights = FileHandler.readFile("FlightInfo.bin");
    @javafx.fxml.FXML
    public void initialize() {

        FlightNumberCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("flightNumber"));
        AirlineNameCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("airlineName"));
        AircraftTypeCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("aircraftType"));
        DepartureAirportCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("departureAirport"));
        ArrivalAirportCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("arrivalAirport"));
        SeatAvailabilityCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("seatAvailability"));
        DepartureDateCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("departureDate"));
        ArrivalDateCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("arrivalDate"));
        FlightDurationCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("estimateFlightDuration"));
        DepartureTerminalCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("departureTerminal"));
        ArrivalTerminalCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("arrivalTerminal"));
        FlightStatusCol.setCellValueFactory( new PropertyValueFactory<Flight, String>("flightStatus"));

        for (Flight flight: flights){
            FlightInformationTable.getItems().add(flight);
        }
    }

    @javafx.fxml.FXML
    public void SearchFlightByFlightNumberButton(ActionEvent actionEvent) {
        List<Flight> filtered = new ArrayList<>();
        boolean filterFlag = false;

        for (Flight flight: flights){
            if (flight.getFlightNumber().equalsIgnoreCase(SearchFlightByFlightNumberField.getText())){
                filtered.add(flight);
                filterFlag = true;
            }
        }

        if(filterFlag){
            FlightInformationTable.getItems().clear();
            FlightInformationTable.getItems().addAll(filtered);
        }
    }

    @javafx.fxml.FXML
    public void ViewAllFlightButton(ActionEvent actionEvent) {
        FlightInformationTable.getItems().clear();
        for (Flight flight: flights){
            FlightInformationTable.getItems().add(flight);
        }
    }
}