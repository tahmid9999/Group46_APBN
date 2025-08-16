package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewAllFlightsController
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

        List<Flight> flights = FileHandler.readFile("FlightInfo.bin");
        for (Flight flight: flights){
            FlightInformationTable.getItems().add(flight);
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