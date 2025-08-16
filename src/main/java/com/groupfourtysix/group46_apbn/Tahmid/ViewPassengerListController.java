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

import java.time.LocalDate;
import java.util.ArrayList;

public class ViewPassengerListController
{

    @javafx.fxml.FXML
    private TableColumn<Passenger, Integer> VPLageColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> VPLnameColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> VPLpassportNumberColumn;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> VPLnationalityColumn;
    @javafx.fxml.FXML
    private TableView<Passenger> VPLtableview;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> VPLpassengerIDColumn;

    ArrayList<Passenger> passengerArrayList = PassengerFileHandler.readFile("passengerInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
        VPLtableview.getItems().clear();

        VPLnameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        VPLageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        VPLpassportNumberColumn.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        VPLnationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        VPLpassengerIDColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));

        for (Passenger passenger: passengerArrayList) {
            VPLtableview.getItems().add(passenger);
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