package com.groupfourtysix.group46_apbn.Habib;

import java.io.Serializable;
import java.time.LocalDate;

public class Flight implements Serializable {
    private String flightNumber, AirlineName, AircraftType, departureAirport, arrivalAirport, seatAvailability, estimateFlightDuration, departureTerminal, arrivalTerminal, flightStatus;
    private LocalDate departureDate, arrivalDate;

    public Flight(String flightNumber, String airlineName, String aircraftType, String departureAirport, String arrivalAirport, String seatAvailability, String estimateFlightDuration, String departureTerminal, String arrivalTerminal, String flightStatus, LocalDate departureDate, LocalDate arrivalDate) {
        this.flightNumber = flightNumber;
        AirlineName = airlineName;
        AircraftType = aircraftType;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.seatAvailability = seatAvailability;
        this.estimateFlightDuration = estimateFlightDuration;
        this.departureTerminal = departureTerminal;
        this.arrivalTerminal = arrivalTerminal;
        this.flightStatus = flightStatus;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public String getAircraftType() {
        return AircraftType;
    }

    public void setAircraftType(String aircraftType) {
        AircraftType = aircraftType;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getEstimateFlightDuration() {
        return estimateFlightDuration;
    }

    public void setEstimateFlightDuration(String estimateFlightDuration) {
        this.estimateFlightDuration = estimateFlightDuration;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", AirlineName='" + AirlineName + '\'' +
                ", AircraftType='" + AircraftType + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", seatAvailability='" + seatAvailability + '\'' +
                ", estimateFlightDuration='" + estimateFlightDuration + '\'' +
                ", departureTerminal='" + departureTerminal + '\'' +
                ", arrivalTerminal='" + arrivalTerminal + '\'' +
                ", flightStatus='" + flightStatus + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}


