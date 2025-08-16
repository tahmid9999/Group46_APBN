package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import com.groupfourtysix.group46_apbn.util.AccountSession;
import com.groupfourtysix.group46_apbn.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.time.LocalDate;

public class PassengerDashboardController
{

    @javafx.fxml.FXML
    private AnchorPane passengerDashboardAnchorpane;

    @javafx.fxml.FXML
    public void initialize() {
//        for (Passenger ps: Passenger.passengerArrayList) {
//
//        }
//        Passenger passenger =
//
//        SessionManager.setLoggedInPassenger(passenger);

//        System.out.println(SessionManager.getAccountSession().getAccountID());
    }

    @javafx.fxml.FXML
    public void registerButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/NewPassengerRegistration.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setScene(nextScene);
            nextStage.setTitle("Register New Passenger");
            nextStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void cancelTravelButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/CancelTravelView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Cancel Travel");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void boardingButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/BoardingPassView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Boarding");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Log In");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void flightInfoButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/FlightInfoView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Flight Info");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void securityCheckButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/SecurityCheckView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Security");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void luggageInfoButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/LuggageInfoSubmissionView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Luggage Info");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @javafx.fxml.FXML
    public void myJourneyButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/TravelSummaryView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Travel Summary");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}