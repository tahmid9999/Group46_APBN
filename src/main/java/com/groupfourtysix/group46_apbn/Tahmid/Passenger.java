package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.Account;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Passenger implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private int age;
    private String passportNumber;
    private String nationality;
    private String passengerID;
    private String flightNumber;
    private String passengerStatus;
    private String scanStatus;
    private String luggageStatus;
    private String luggageID;
    private int totalNumOfBags;
    private int numOfCarryOnBags;
    private String Items;
    private String FlagReason;
    private String IncidentReport;
    private String boardingPassID;
    private String user;
    private String emailAddress;
    private String password;
    private String passengerAccountID;

    public static ArrayList<Passenger> passengerArrayList = new ArrayList<>();

    public Passenger(String name, LocalDate dateOfBirth, int age, String passportNumber, String nationality, String passengerID, String flightNumber, String passengerStatus, String scanStatus, String luggageStatus, String luggageID, int totalNumOfBags, int numOfCarryOnBags, String items, String flagReason, String incidentReport, String boardingPassID, String user, String emailAddress, String password, String passengerAccountID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.passengerID = passengerID;
        this.flightNumber = flightNumber;
        this.passengerStatus = passengerStatus;
        this.scanStatus = scanStatus;
        this.luggageStatus = luggageStatus;
        this.luggageID = luggageID;
        this.totalNumOfBags = totalNumOfBags;
        this.numOfCarryOnBags = numOfCarryOnBags;
        Items = items;
        FlagReason = flagReason;
        IncidentReport = incidentReport;
        this.boardingPassID = boardingPassID;
        this.user = user;
        this.emailAddress = emailAddress;
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }

    public String getLuggageStatus() {
        return luggageStatus;
    }

    public void setLuggageStatus(String luggageStatus) {
        this.luggageStatus = luggageStatus;
    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
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

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
    }

    public String getFlagReason() {
        return FlagReason;
    }

    public void setFlagReason(String flagReason) {
        FlagReason = flagReason;
    }

    public String getIncidentReport() {
        return IncidentReport;
    }

    public void setIncidentReport(String incidentReport) {
        IncidentReport = incidentReport;
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
                ", age=" + age +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passengerID='" + passengerID + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", passengerStatus='" + passengerStatus + '\'' +
                ", scanStatus='" + scanStatus + '\'' +
                ", luggageStatus='" + luggageStatus + '\'' +
                ", luggageID='" + luggageID + '\'' +
                ", totalNumOfBags=" + totalNumOfBags +
                ", numOfCarryOnBags=" + numOfCarryOnBags +
                ", Items='" + Items + '\'' +
                ", FlagReason='" + FlagReason + '\'' +
                ", IncidentReport='" + IncidentReport + '\'' +
                ", boardingPassID='" + boardingPassID + '\'' +
                ", user='" + user + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", passengerAccountID='" + passengerAccountID + '\'' +
                '}';
    }
}
