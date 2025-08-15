package com.groupfourtysix.group46_apbn.Tahmid;

import java.io.Serializable;
import java.util.ArrayList;

public class LuggageInfo implements Serializable{
    private int totalNumOfBags;
    private int numOfCarryOnBags;
    private String luggageID;
    private String passengerID;

    public LuggageInfo(int totalNumOfBags, int numOfCarryOnBags, String luggageID, String passengerID) {
        this.totalNumOfBags = totalNumOfBags;
        this.numOfCarryOnBags = numOfCarryOnBags;
        this.luggageID = luggageID;
        this.passengerID = passengerID;
    }

    public int getTotalNumOfBags() {
        return totalNumOfBags;
    }

    public void setTotalNumOfBags(int totalNumOfBags) {
        this.totalNumOfBags = totalNumOfBags;
    }

    public int getNumOfCarryOnBags() {
        return numOfCarryOnBags;
    }

    public void setNumOfCarryOnBags(int numOfCarryOnBags) {
        this.numOfCarryOnBags = numOfCarryOnBags;
    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    @Override
    public String toString() {
        return "LuggageInfo{" +
                "totalNumOfBags=" + totalNumOfBags +
                ", numOfCarryOnBags=" + numOfCarryOnBags +
                ", luggageID='" + luggageID + '\'' +
                ", passengerID='" + passengerID + '\'' +
                '}';
    }
}