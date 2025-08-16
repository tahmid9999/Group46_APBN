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

public class AddIncidentLoggerController
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
    private DatePicker IncidentDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentImpactComboBox;
    @javafx.fxml.FXML
    private TextField IncidentFlightNumberField;

    @javafx.fxml.FXML
    public void initialize() {
        IncidentTypeComboBox.getItems().addAll("delay","technical fault", "crew issue");
        IncidentImpactComboBox.getItems().addAll("minor","major","critical");
        IncidentStatusComboBox.getItems().addAll("open","under review","resolved");
    }

    @javafx.fxml.FXML
    public void AddIncidentButton(ActionEvent actionEvent) {

        IncidentLogger addIncident = new IncidentLogger(
                UniqueIDGenerator.generateId(),
                IncidentFlightNumberField.getText(),
                IncidentLocationField.getText(),
                IncidentTypeComboBox.getValue(),
                IncidentImpactComboBox.getValue(),
                IncidentDescriptionTextArea.getText(),
                IncidentStatusComboBox.getValue(),
                IncidentResponsibleDepartmentField.getText(),
                IncidentDatePicker.getValue(),
                IncidentResolutionDatePicker.getValue()
        );

        IncidentFileHandler.createFile(addIncident, "IncidentInfos.bin");
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