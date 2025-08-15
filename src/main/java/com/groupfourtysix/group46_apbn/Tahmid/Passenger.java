package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.Account;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Passenger implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String nationality;
    private String passengerID;
    private String flightNumber;
    private String passengerStatus;
    private String boardingPassID;
    private String user;
    private String emailAddress;
    private String password;
    private String PassengerFlagReason;
    private String passengerAccountID;

    public static ArrayList<Passenger> passengerArrayList = new ArrayList<>();

    public Passenger(String name, LocalDate dateOfBirth, String passportNumber, String nationality, String passengerID, String flightNumber, String passengerStatus, String boardingPassID, String user, String emailAddress, String password, String passengerFlagReason, String passengerAccountID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.passengerID = passengerID;
        this.flightNumber = flightNumber;
        this.passengerStatus = passengerStatus;
        this.boardingPassID = boardingPassID;
        this.user = user;
        this.emailAddress = emailAddress;
        this.password = password;
        PassengerFlagReason = passengerFlagReason;
        this.passengerAccountID = passengerAccountID;
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

    public String getPassengerStatus() {
        return passengerStatus;
    }

    public void setPassengerStatus(String passengerStatus) {
        this.passengerStatus = passengerStatus;
    }

    public String getBoardingPassID() {
        return boardingPassID;
    }

    public void setBoardingPassID(String boardingPassID) {
        this.boardingPassID = boardingPassID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassengerFlagReason() {
        return PassengerFlagReason;
    }

    public void setPassengerFlagReason(String passengerFlagReason) {
        PassengerFlagReason = passengerFlagReason;
    }

    public String getPassengerAccountID() {
        return passengerAccountID;
    }

    public void setPassengerAccountID(String passengerAccountID) {
        this.passengerAccountID = passengerAccountID;
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
                ", passengerStatus='" + passengerStatus + '\'' +
                ", boardingPassID='" + boardingPassID + '\'' +
                ", user='" + user + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", PassengerFlagReason='" + PassengerFlagReason + '\'' +
                ", passengerAccountID='" + passengerAccountID + '\'' +
                '}';
    }
}
