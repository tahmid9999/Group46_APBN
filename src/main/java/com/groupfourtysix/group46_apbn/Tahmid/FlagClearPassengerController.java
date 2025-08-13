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

public class FlagClearPassengerController
{

    @javafx.fxml.FXML
    private TableColumn<Content, String> FCflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Content, String> FCstatusColumn;
    @javafx.fxml.FXML
    private TableView<Content> FCtableview;

    @javafx.fxml.FXML
    public void initialize() {
        FCflaggedItemColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        FCstatusColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
    }

    public void clearButton(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void FCsubmitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FCflagAsSuspiciousButton(ActionEvent actionEvent) {
        Content selectedSlot = FCtableview.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            Content updatedSlot = new Content(selectedSlot.getItemName(), selectedSlot.getFlagReason(), selectedSlot.getItemDetails(), "Flagged");

            FCtableview.getItems().remove(selectedSlot);
            FCtableview.getItems().add(updatedSlot);
        }
    }

    @javafx.fxml.FXML
    public void FCclearButton(ActionEvent actionEvent) {
        Content selectedSlot = FCtableview.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            Content updatedSlot = new Content(selectedSlot.getItemName(), selectedSlot.getFlagReason(), selectedSlot.getItemDetails(), "Cleared");

            FCtableview.getItems().remove(selectedSlot);
            FCtableview.getItems().add(updatedSlot);
        }
    }
}