package com.groupfourtysix.group46_apbn.Habib;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class ViewIncidentLoggerController
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
    private TableColumn<IncidentLogger, String> IncidentResolutionDateCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentLocationCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentLogger, String> IncidentIDCol;
    @javafx.fxml.FXML
    private Label TotalRecordLabel;

    @javafx.fxml.FXML
    public void initialize() {
        IncidentIDCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentID"));
        IncidentFlightNumberCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentFlightNumber"));
        IncidentLocationCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentLocation"));
        IncidentTypeCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentType"));
        IncidentImpactCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentImpact"));
        IncidentDescriptionCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentDescription"));
        IncidentStatusCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentStatus"));
        ResponsibleDepartmentCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentResponsibleDepartment"));
        IncidentDateCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentDate"));
        IncidentResolutionDateCol.setCellValueFactory(new PropertyValueFactory<IncidentLogger, String>("incidentResolutionDate"));


        List<IncidentLogger> incidentLoggers = IncidentFileHandler.readFile("IncidentInfos.bin");

        for (IncidentLogger incidentLogger: incidentLoggers){
            System.out.println(incidentLogger);
            IncidentLoggerTable.getItems().add(incidentLogger);
        }

        TotalRecordLabel.setText(String.valueOf(incidentLoggers.toArray().length));
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