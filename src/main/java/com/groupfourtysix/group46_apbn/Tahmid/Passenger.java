package com.groupfourtysix.group46_apbn.Tahmid;

import java.io.Serializable;
import java.time.LocalDate;

public class Passenger implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String nationality;
    private String passengerID;
    private String flightNumber;
    private LuggageInfo luggageInfo;
    private String status;
    private String boardingPassID;


    public Passenger(String name, LocalDate dateOfBirth, String passportNumber, String nationality, String passengerID, String flightNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.passengerID = passengerID;
        this.flightNumber = flightNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LuggageInfo getLuggageInfo() {
        return luggageInfo;
    }

    public void setLuggageInfo(LuggageInfo luggageInfo) {
        this.luggageInfo = luggageInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBoardingPassID() {
        return boardingPassID;
    }

    public void setBoardingPassID(String boardingPassID) {
        this.boardingPassID = boardingPassID;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passengerID='" + passengerID + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", luggageInfo=" + luggageInfo +
                ", status='" + status + '\'' +
                ", boardingPassID='" + boardingPassID + '\'' +
                '}';
    }
}
