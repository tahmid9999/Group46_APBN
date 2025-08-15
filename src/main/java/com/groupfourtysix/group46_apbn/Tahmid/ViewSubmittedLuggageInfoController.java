package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewSubmittedLuggageInfoController
{

    @javafx.fxml.FXML
    private TableView<LuggageInfo> VSLItableview;
    @javafx.fxml.FXML
    private TableColumn<LuggageInfo, String> VSLIbagContentsColumn;
    @javafx.fxml.FXML
    private TableColumn<LuggageInfo, Integer> VSLItotalBagsColumn;
    @javafx.fxml.FXML
    private TableColumn<LuggageInfo, Integer> VSLICarryOnBagsColumn;
    @javafx.fxml.FXML
    private TableColumn<LuggageInfo, String> VSLIpassengerIDcolumn;

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