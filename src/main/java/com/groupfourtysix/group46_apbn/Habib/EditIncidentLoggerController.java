package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class EditIncidentLoggerController
{
    @javafx.fxml.FXML
    private TextField IncidentLocationField;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentTypeComboBox;
    @javafx.fxml.FXML
    private TextArea IncidentDescriptionTextArea;
    @javafx.fxml.FXML
    private DatePicker IncidentResolutionDatePicker;
    @javafx.fxml.FXML
    private TextField IncidentResponsibleDepartmentField;
    @javafx.fxml.FXML
    private TextField IncidentFlightNumberField;
    @javafx.fxml.FXML
    private DatePicker IncidentDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentImpactComboBox;

    List<IncidentLogger> incidentLoggers = IncidentFileHandler.readFile("IncidentInfos.bin");
    @javafx.fxml.FXML
    private TextField InputIncidentIDField;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void IncidentFetchButton(ActionEvent actionEvent) {
        for (IncidentLogger incidentLogger: incidentLoggers){
            if(incidentLogger.getIncidentID().equalsIgnoreCase(InputIncidentIDField.getText())){
                IncidentTypeComboBox.getItems().addAll("delay","technical fault", "crew issue");
                IncidentImpactComboBox.getItems().addAll("minor","major","critical");
                IncidentStatusComboBox.getItems().addAll("open","under review","resolved");
                IncidentFlightNumberField.setText(incidentLogger.getIncidentFlightNumber());
                IncidentDatePicker.setValue(incidentLogger.getIncidentDate());
                IncidentLocationField.setText(incidentLogger.getIncidentLocation());
                IncidentDescriptionTextArea.setText(incidentLogger.getIncidentDescription());
                IncidentResolutionDatePicker.setValue(incidentLogger.getIncidentResolutionDate());
                IncidentResponsibleDepartmentField.setText(incidentLogger.getIncidentResponsibleDepartment());
            }
        }
    }

    @javafx.fxml.FXML
    public void UpdateIncidentButton(ActionEvent actionEvent) {
        for (IncidentLogger incidentLogger: incidentLoggers) {
            if (incidentLogger.getIncidentID().equalsIgnoreCase(InputIncidentIDField.getText())) {
                incidentLogger.setIncidentFlightNumber(IncidentFlightNumberField.getText());
                incidentLogger.setIncidentDate(IncidentDatePicker.getValue());
                incidentLogger.setIncidentLocation(IncidentLocationField.getText());
                incidentLogger.setIncidentDescription(IncidentDescriptionTextArea.getText());
                incidentLogger.setIncidentResolutionDate(IncidentResolutionDatePicker.getValue());
                incidentLogger.setIncidentResponsibleDepartment(IncidentResponsibleDepartmentField.getText());
                incidentLogger.setIncidentType(IncidentTypeComboBox.getValue());
                incidentLogger.setIncidentImpact(IncidentImpactComboBox.getValue());
                incidentLogger.setIncidentStatus(IncidentStatusComboBox.getValue());
            }
        }
        IncidentFileHandler.writeFile(incidentLoggers, "IncidentInfos.bin");
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