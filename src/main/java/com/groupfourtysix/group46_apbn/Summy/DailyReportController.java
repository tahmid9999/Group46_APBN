package com.groupfourtysix.group46_apbn.Summy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




public class DailyReportController
{
    @javafx.fxml.FXML
    private Button btnClose;
    @javafx.fxml.FXML
    private TableColumn<DailyReportRow, String> DetailsCol;
    @javafx.fxml.FXML
    private Label totalBagsLabel;
    @javafx.fxml.FXML
    private TableView <DailyReportRow> dailyReportTable;
    @javafx.fxml.FXML
    private Label flaggedBagsLabel;
    @javafx.fxml.FXML
    private TableColumn<DailyReportRow, Integer> totalCol;
    @javafx.fxml.FXML
    private Label overweightBagsLabel;
    @javafx.fxml.FXML
    private TableColumn<DailyReportRow, String> flaggedCol;
    @javafx.fxml.FXML
    private TableColumn<DailyReportRow, String> PassengerIDCol;
    @javafx.fxml.FXML
    private Label generatedAtLabel;
    @javafx.fxml.FXML
    private Label totalIncidentsLabel;
    @javafx.fxml.FXML
    private TableColumn<DailyReportRow, String> overweightCol;

    private final ObservableList<DailyReportRow> rows = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        PassengerIDCol.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalBags"));
        flaggedCol.setCellValueFactory(new PropertyValueFactory<>("flagged"));
        overweightCol.setCellValueFactory(new PropertyValueFactory<>("overweight"));
        DetailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));



        dailyReportTable.setItems(rows);
        loadReportData();}

    private void loadReportData(){
        rows.clear();


        ArrayList<BaggageModel> baggageList = BaggageHandler.readBaggage("baggage_data.bin");

        int totalBags = 0;
        int flaggedCount = 0;
        int overweightCount = 0;

        for (BaggageModel b: baggageList) {
            totalBags += b.getTotalBags();
            if (b.getFlag().equalsIgnoreCase("Flagged")) flaggedCount++;
            if ((b.getFirstBagWeight() > 40) || (b.getTotalBags() == 2 && b.getSecondBagWeight() > 40)) overweightCount++;

            String details = b.getIssueDescription();
            String passengerID = (b.getPassenger() != null) ? b.getPassenger().getPassengerID() : "Unknown";

            String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            generatedAtLabel.setText("Report Generated: " + timestamp);

            rows.add(new DailyReportRow(
                    passengerID,
                    b.getTotalBags(),
                    b.getFlag(),
                    (b.getFirstBagWeight() > 40 || (b.getTotalBags() == 2 && b.getSecondBagWeight() > 40)) ? "Yes" : "No",
                    details
            ));
        }

        dailyReportTable.setItems(rows);
        totalBagsLabel.setText("Total Luggage Processed: "+ totalBags);
        flaggedBagsLabel.setText("Suspicious Luggage: "+ flaggedCount);
        overweightBagsLabel.setText("Overweight Luggage: "+ overweightCount);
        totalIncidentsLabel.setText("Total Incidents: "+ baggageList.size());


}



    @javafx.fxml.FXML
    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}