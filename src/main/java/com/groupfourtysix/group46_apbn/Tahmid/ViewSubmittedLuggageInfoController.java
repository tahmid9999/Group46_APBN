package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewSubmittedLuggageInfoController
{

    @javafx.fxml.FXML
    private TableView<Passenger> VSLItableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, Integer> VSLItotalBagsColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, Integer> VSLICarryOnBagsColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> VSLIpassengerIDcolumn;

    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
        VSLIpassengerIDcolumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        VSLItotalBagsColumn.setCellValueFactory(new PropertyValueFactory<>("totalNumOfBags"));
        VSLICarryOnBagsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfCarryOnBags"));

        for (Passenger passenger: passengerArrayList) {
            VSLItableview.getItems().add(passenger);
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/APBNScreeningOfficerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("APBN Screening Officer Dashboard");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }
}