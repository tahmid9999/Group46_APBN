package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IncidentLoggerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void LogoutIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("User Login");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void DeleteIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/DeleteIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Delete Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void EditIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/EditIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Edit Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void FilterIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/FilterIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Filter Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void CheckIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/SearchIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Check Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void AddIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/AddIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("Add Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void ViewIncidentLoggerButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/ViewIncidentLogger.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            Object source = actionEvent.getSource();
            Stage nextStage = null;

            if (source instanceof Node) {
                nextStage = (Stage) ((Node) source).getScene().getWindow();
            }

            if (nextStage == null) {
                System.err.println("Could not find stage");
                return;
            }

            nextStage.setTitle("View Incident Logger Information");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}