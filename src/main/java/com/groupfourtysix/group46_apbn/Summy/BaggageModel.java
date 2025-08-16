package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;

import java.io.Serializable;

public class BaggageModel implements Serializable {

    private String luggageID;
    private Passenger passenger;
    private int totalBags;
    private String flag;
    private double firstBagWeight;
    private double secondBagWeight;
    private String issueDescription;

    public BaggageModel(Passenger passenger,
                        int totalBags, String flag,
                        double firstBagWeight,
                        double secondBagWeight,
                        String issueDescription) {

        this.passenger = passenger;
        this.totalBags = totalBags;
        this.flag = flag;
        this.firstBagWeight = firstBagWeight;
        this.secondBagWeight = secondBagWeight;
        this.issueDescription = issueDescription;

        int randomNumber = 100 + (int) (Math.random() * 900);
        this.luggageID = passenger.getPassengerID() + passenger.getFlightNumber() + randomNumber;
        passenger.setBoardingPassID(this.luggageID);

    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getTotalBags() {
        return totalBags;
    }

    public void setTotalBags(int totalBags) {
        this.totalBags = totalBags;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public double getFirstBagWeight() {
        return firstBagWeight;
    }

    public void setFirstBagWeight(double firstBagWeight) {
        this.firstBagWeight = firstBagWeight;
    }

    public double getSecondBagWeight() {
        return secondBagWeight;
    }

    public void setSecondBagWeight(double secondBagWeight) {
        this.secondBagWeight = secondBagWeight;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;

    }
    public String getPassengerName() {
        return passenger != null ? passenger.getName() : "";
    }

    public String getFlightNumber() {
        return passenger != null ? passenger.getFlightNumber() : "";
    }

    public String getBoardingPassID() {
        return passenger != null ? passenger.getBoardingPassID() : "";
    }


}
