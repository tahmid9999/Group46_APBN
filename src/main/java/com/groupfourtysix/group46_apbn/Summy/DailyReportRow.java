package com.groupfourtysix.group46_apbn.Summy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DailyReportRow {
    private final StringProperty passengerID;
    private final IntegerProperty totalBags;
    private final StringProperty flagged;
    private final StringProperty overweight;
    private final StringProperty details;



    public DailyReportRow(String passengerID,
                          int totalBags,
                          String flagged,
                          String overweight,
                          String details) {

        this.passengerID = new SimpleStringProperty(passengerID);
        this.totalBags = new SimpleIntegerProperty(totalBags);
        this.flagged = new SimpleStringProperty(flagged);
        this.overweight = new SimpleStringProperty(overweight);
        this.details = new SimpleStringProperty(details);
    }

    public String getPassengerID() {
        return passengerID.get();
    }

    public StringProperty passengerIDProperty() {
        return passengerID;
    }

    public int getTotalBags() {
        return totalBags.get();
    }

    public IntegerProperty totalBagsProperty() {
        return totalBags;
    }

    public String getFlagged() {
        return flagged.get();
    }

    public StringProperty flaggedProperty() {
        return flagged;
    }

    public String getOverweight() {
        return overweight.get();
    }

    public StringProperty overweightProperty() {
        return overweight;
    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }
}
