package com.groupfourtysix.group46_apbn.Habib;

import java.io.Serializable;
import java.time.LocalDate;

public class IncidentLogger implements Serializable {
    private String incidentID,incidentFlightNumber, incidentLocation, incidentType, incidentImpact, incidentDescription, incidentStatus, incidentResponsibleDepartment;
    private LocalDate incidentDate, incidentResolutionDate;

    public IncidentLogger(String incidentID, String incidentFlightNumber, String incidentLocation, String incidentType, String incidentImpact, String incidentDescription, String incidentStatus, String incidentResponsibleDepartment, LocalDate incidentDate, LocalDate incidentResolutionDate) {
        this.incidentID = incidentID;
        this.incidentFlightNumber = incidentFlightNumber;
        this.incidentLocation = incidentLocation;
        this.incidentType = incidentType;
        this.incidentImpact = incidentImpact;
        this.incidentDescription = incidentDescription;
        this.incidentStatus = incidentStatus;
        this.incidentResponsibleDepartment = incidentResponsibleDepartment;
        this.incidentDate = incidentDate;
        this.incidentResolutionDate = incidentResolutionDate;
    }

    public String getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(String incidentID) {
        this.incidentID = incidentID;
    }

    public String getIncidentFlightNumber() {
        return incidentFlightNumber;
    }

    public void setIncidentFlightNumber(String incidentFlightNumber) {
        this.incidentFlightNumber = incidentFlightNumber;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getIncidentImpact() {
        return incidentImpact;
    }

    public void setIncidentImpact(String incidentImpact) {
        this.incidentImpact = incidentImpact;
    }

    public String getIncidentDescription() {
        return incidentDescription;
    }

    public void setIncidentDescription(String incidentDescription) {
        this.incidentDescription = incidentDescription;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public String getIncidentResponsibleDepartment() {
        return incidentResponsibleDepartment;
    }

    public void setIncidentResponsibleDepartment(String incidentResponsibleDepartment) {
        this.incidentResponsibleDepartment = incidentResponsibleDepartment;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public LocalDate getIncidentResolutionDate() {
        return incidentResolutionDate;
    }

    public void setIncidentResolutionDate(LocalDate incidentResolutionDate) {
        this.incidentResolutionDate = incidentResolutionDate;
    }

    @Override
    public String toString() {
        return "IncidentLogger{" +
                "incidentID='" + incidentID + '\'' +
                ", incidentFlightNumber='" + incidentFlightNumber + '\'' +
                ", incidentLocation='" + incidentLocation + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", incidentImpact='" + incidentImpact + '\'' +
                ", incidentDescription='" + incidentDescription + '\'' +
                ", incidentStatus='" + incidentStatus + '\'' +
                ", incidentResponsibleDepartment='" + incidentResponsibleDepartment + '\'' +
                ", incidentDate=" + incidentDate +
                ", incidentResolutionDate=" + incidentResolutionDate +
                '}';
    }
}
