package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.List;

public class DeleteIncidentLoggerController
{
    @javafx.fxml.FXML
    private TextField IncidentIdField;
    @javafx.fxml.FXML
    private Label IncidentLocationLabel;
    @javafx.fxml.FXML
    private Label IncidentFlightNumberLabel;
    @javafx.fxml.FXML
    private Label IncidentDateLabel;

    List<IncidentLogger> incidentLoggers = IncidentFileHandler.readFile("IncidentInfos.bin");
    String incidentId;
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void DeleteIncidentRecord(ActionEvent actionEvent) {
        Iterator<IncidentLogger> iterator = incidentLoggers.iterator();
        boolean removed = false;
        while (iterator.hasNext()){
            IncidentLogger f = iterator.next();
            if(f.getIncidentID().equalsIgnoreCase(incidentId)){
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed){
            IncidentFileHandler.writeFile(incidentLoggers,"IncidentInfos.bin");
        }
    }

    @javafx.fxml.FXML
    public void IncidentFetchButton(ActionEvent actionEvent) {
        for (IncidentLogger incidentLogger: incidentLoggers){
            if (incidentLogger.getIncidentID().equalsIgnoreCase(IncidentIdField.getText())){
                incidentId = incidentLogger.getIncidentID();
                IncidentFlightNumberLabel.setText(incidentLogger.getIncidentFlightNumber());
                IncidentDateLabel.setText(incidentLogger.getIncidentDate().toString());
                IncidentLocationLabel.setText(incidentLogger.getIncidentLocation());
            }
        }
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Habib/IncidentLoggerDashboard.fxml"));
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

            nextStage.setTitle("Incident Logger Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}