package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SearchLuggage
{
    @javafx.fxml.FXML
    private TableColumn<SearchLuggageRow, String>  PassengerIDCol;
    @javafx.fxml.FXML
    private TableColumn<SearchLuggageRow, String> SecondBaggageStatusCol;
    @javafx.fxml.FXML
    private Button btnClose;
    @javafx.fxml.FXML
    private Button searchLuggage;
    @javafx.fxml.FXML
    private TextField passengerIDnum;
    @javafx.fxml.FXML
    private TableColumn<SearchLuggageRow, String> FlightNoCol;
    @javafx.fxml.FXML
    private TableColumn <SearchLuggageRow, String>FirstBaggageStatusCol;
    @javafx.fxml.FXML
    private TableView<SearchLuggageRow> BaggageInfoTable;

    private final ObservableList<SearchLuggageRow> rows = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        PassengerIDCol.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        FlightNoCol.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        FirstBaggageStatusCol.setCellValueFactory(new PropertyValueFactory<>("firstBaggageStatus"));
        SecondBaggageStatusCol.setCellValueFactory(new PropertyValueFactory<>("secondBaggageStatus"));

        BaggageInfoTable.setItems(rows);
        loadData();
    }

    @javafx.fxml.FXML
    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    private void loadData() {
        ArrayList<BaggageModel> baggageList = BaggageHandler.readBaggage("baggage_data.bin");

        rows.clear();

        for (BaggageModel baggage : baggageList) {
            Passenger p = baggage.getPassenger();

            String firstStatus = baggage.getFirstBagWeight() > 23 ? "Overweight" : "OK";
            String secondStatus = baggage.getSecondBagWeight() > 23 ? "Overweight" : "OK";


            if ("Flagged".equalsIgnoreCase(baggage.getFlag())) {
                firstStatus = "Flagged";
                secondStatus = "Flagged";
            }

            rows.add(new SearchLuggageRow(
                    p.getPassengerID(),
                    p.getFlightNumber(),
                    firstStatus,
                    secondStatus
            ));
        }

        BaggageInfoTable.setItems(rows);
    }


    @javafx.fxml.FXML
    public void searchLuggagelist(ActionEvent actionEvent) {
        String searchID = passengerIDnum.getText().trim();
        if (searchID.isEmpty()) {
            BaggageInfoTable.setItems(rows);
        } else {
            ObservableList<SearchLuggageRow> filtered = rows.filtered(row ->
                    row.getPassengerID().equalsIgnoreCase(searchID)
            );
            BaggageInfoTable.setItems(filtered);
        }

}
}