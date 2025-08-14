package com.groupfourtysix.group46_apbn.Summy;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DailyReportController
{
    @javafx.fxml.FXML
    private Button btnClose;
    @javafx.fxml.FXML
    private TableColumn DetailsCol;
    @javafx.fxml.FXML
    private Label totalBagsLabel;
    @javafx.fxml.FXML
    private TableView dailyReportTable;
    @javafx.fxml.FXML
    private Label flaggedBagsLabel;
    @javafx.fxml.FXML
    private TableColumn totalCol;
    @javafx.fxml.FXML
    private Label overweightBagsLabel;
    @javafx.fxml.FXML
    private TableColumn flaggedCol;
    @javafx.fxml.FXML
    private TableColumn PassengerIDCol;
    @javafx.fxml.FXML
    private Label generatedAtLabel;
    @javafx.fxml.FXML
    private Label totalIncidentsLabel;
    @javafx.fxml.FXML
    private TableColumn overweightCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void exportToPdf(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeWindow(ActionEvent actionEvent) {
    }
}