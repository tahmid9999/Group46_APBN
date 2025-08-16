package com.groupfourtysix.group46_apbn.Summy;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchLuggageRow {
    private final StringProperty passengerID;
    private final StringProperty flightNumber;
    private final StringProperty firstBaggageStatus;
    private final StringProperty secondBaggageStatus;

    public String getPassengerID() {
        return passengerID.get();
    }

    public StringProperty passengerIDProperty() {
        return passengerID;
    }

    public String getFlightNumber() {
        return flightNumber.get();
    }

    public StringProperty flightNumberProperty() {
        return flightNumber;
    }

    public String getFirstBaggageStatus() {
        return firstBaggageStatus.get();
    }

    public StringProperty firstBaggageStatusProperty() {
        return firstBaggageStatus;
    }

    public String getSecondBaggageStatus() {
        return secondBaggageStatus.get();
    }

    public StringProperty secondBaggageStatusProperty() {
        return secondBaggageStatus;
    }




    public SearchLuggageRow(String passengerID,
                            String flightNumber,
                            String firstBaggageStatus,
                            String secondBaggageStatus) {
        this.passengerID = new SimpleStringProperty(passengerID);
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.firstBaggageStatus = new SimpleStringProperty(firstBaggageStatus);
        this.secondBaggageStatus = new SimpleStringProperty(secondBaggageStatus);
    }
}
