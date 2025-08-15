package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReviewFlaggedItemsReportController
{
    @javafx.fxml.FXML
    private TableColumn<Content, String> RFIRflagReasonColumn;
    @javafx.fxml.FXML
    private TableView<Content> RFIRflaggedItemReasonTableview;
    @javafx.fxml.FXML
    private TableColumn<Content, String> RFIRflaggedItemColumn;
    @javafx.fxml.FXML
    private TableColumn<Content, String> RFIRluggageIDcolumn;
    @javafx.fxml.FXML
    private TableColumn<Content, String> RFIRpassengerIDcolumn;

    @javafx.fxml.FXML
    public void initialize() {
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