package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FilterIncidentLoggerController
{
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentFlightNumberCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentTypeCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentStatusCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> ResponsibleDepartmentCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentImpactCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentDateCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentDescriptionCol;
    @javafx.fxml.FXML
    private TableView<IncidentLogger> IncidentLoggerTable;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentLocationCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentResolutionDateCol;

    List<IncidentLogger> incidentLoggers = IncidentFileHandler.readFile("IncidentInfos.bin");
    @javafx.fxml.FXML
    private TextField FilterIncidentLoggerField;

    @javafx.fxml.FXML
    public void initialize() {
        IncidentFlightNumberCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentFlightNumber"));
        IncidentLocationCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentLocation"));
        IncidentTypeCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentType"));
        IncidentImpactCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentImpact"));
        IncidentDescriptionCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentDescription"));
        IncidentStatusCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentStatus"));
        ResponsibleDepartmentCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentResponsibleDepartment"));
        IncidentDateCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentDate"));
        IncidentResolutionDateCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentResolutionDate"));

        for (IncidentLogger incidentLogger: incidentLoggers){
            IncidentLoggerTable.getItems().add(incidentLogger);
        }
    }

    @javafx.fxml.FXML
    public void ViewAllIncidentButton(ActionEvent actionEvent) {
        IncidentLoggerTable.getItems().clear();
        for (IncidentLogger incidentLogger: incidentLoggers){
            IncidentLoggerTable.getItems().add(incidentLogger);
        }
    }

    @javafx.fxml.FXML
    public void FilterIncidentButton(ActionEvent actionEvent) {
        List<IncidentLogger> filtered = new ArrayList<>();
        boolean filterFlag = false;

        for (IncidentLogger incidentLogger: incidentLoggers){
            if (incidentLogger.getIncidentType().toLowerCase().startsWith(FilterIncidentLoggerField.getText().toLowerCase())){
                filtered.add(incidentLogger);
                filterFlag = true;
            }
        }

        if(filterFlag){
            IncidentLoggerTable.getItems().clear();
            IncidentLoggerTable.getItems().addAll(filtered);
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