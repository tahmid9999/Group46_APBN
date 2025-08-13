package com.groupfourtysix.group46_apbn.Tahmid;

import java.util.ArrayList;

public class LuggageInfo {
    private int totalNumOfBags;
    private int numOfCarryOnBags;
    private ArrayList luggageTypes;

    public LuggageInfo(int totalNumOfBags, int numOfCarryOnBags, ArrayList luggageTypes) {
        this.totalNumOfBags = totalNumOfBags;
        this.numOfCarryOnBags = numOfCarryOnBags;
        this.luggageTypes = luggageTypes;
    }

    public LuggageInfo() {
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

    public ArrayList getLuggageTypes() {
        return luggageTypes;
    }

    public void setLuggageTypes(ArrayList luggageTypes) {
        this.luggageTypes = luggageTypes;
    }

    @Override
    public String toString() {
        return "LuggageInfo{" +
                "totalNumOfBags=" + totalNumOfBags +
                ", numOfCarryOnBags=" + numOfCarryOnBags +
                ", luggageTypes=" + luggageTypes +
                '}';
    }
}
