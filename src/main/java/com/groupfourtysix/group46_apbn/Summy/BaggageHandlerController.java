package com.groupfourtysix.group46_apbn.Summy;

import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;




public class BaggageHandlerController
{
    @javafx.fxml.FXML
    private TextField tagIdField;
    @javafx.fxml.FXML
    private TableColumn<BaggageModel, String>passengerCol;
    @javafx.fxml.FXML
    private TableColumn<BaggageModel, String>luggageIdCol;
    @javafx.fxml.FXML
    private TableColumn<BaggageModel, String> flightCol;
    @javafx.fxml.FXML
    private TextArea issueDescriptionField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableView <BaggageModel>luggageTable;
    @javafx.fxml.FXML
    private ComboBox<String> flagIDComboBox;
    @javafx.fxml.FXML
    private TextField firstbagweight;
    @javafx.fxml.FXML
    private Button btndailyeport;
    @javafx.fxml.FXML
    private TextField secondbagweight;
    @javafx.fxml.FXML
    private ComboBox<Integer> TotalBagsComboBox;
    @javafx.fxml.FXML
    private Button SearchLuggageButton;
    @javafx.fxml.FXML
    private Button editBaggageButton;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Button manualcheckbtn;
    @javafx.fxml.FXML
    private Button DelteButton;


    private final ObservableList<BaggageModel> baggageData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        passengerCol.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
        luggageIdCol.setCellValueFactory(new PropertyValueFactory<>("luggageID"));
        flightCol.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

        flagIDComboBox.getItems().addAll("Cleared", "Flagged");
        TotalBagsComboBox.getItems().addAll(1,2);

        confirmationLabel.setVisible(false);
        luggageTable.getItems().clear();





    }



    @Deprecated
    public void submitIncidentReport(ActionEvent actionEvent) {

        String passengerID = tagIdField.getText();
        Integer totalBags = TotalBagsComboBox.getValue();
        String flag = flagIDComboBox.getValue();
        String firstWeight = firstbagweight.getText();
        String secondWeight = secondbagweight.getText();


        if (passengerID == null){
            confirmationLabel.setText("Please enter a valid Passenger ID");
            confirmationLabel.setVisible(true);
            return;
        }
        if (passengerID.isEmpty()) {
            confirmationLabel.setText("Please enter a valid Passenger ID");
            confirmationLabel.setVisible(true);
            return;
        }


    }

    public TextField getTagIdField() {
        return tagIdField;
    }

    public void setTagIdField(TextField tagIdField) {
        this.tagIdField = tagIdField;
    }

    public TableColumn<BaggageModel, String> getPassengerCol() {
        return passengerCol;
    }

    public void setPassengerCol(TableColumn<BaggageModel, String> passengerCol) {
        this.passengerCol = passengerCol;
    }

    public TableColumn<BaggageModel, String> getLuggageIdCol() {
        return luggageIdCol;
    }

    public void setLuggageIdCol(TableColumn<BaggageModel, String> luggageIdCol) {
        this.luggageIdCol = luggageIdCol;
    }

    public TableColumn<BaggageModel, String> getFlightCol() {
        return flightCol;
    }

    public void setFlightCol(TableColumn<BaggageModel, String> flightCol) {
        this.flightCol = flightCol;
    }

    public TextArea getIssueDescriptionField() {
        return issueDescriptionField;
    }

    public void setIssueDescriptionField(TextArea issueDescriptionField) {
        this.issueDescriptionField = issueDescriptionField;
    }

    public Label getConfirmationLabel() {
        return confirmationLabel;
    }

    public void setConfirmationLabel(Label confirmationLabel) {
        this.confirmationLabel = confirmationLabel;
    }

    public TableView<BaggageModel> getLuggageTable() {
        return luggageTable;
    }

    public void setLuggageTable(TableView<BaggageModel> luggageTable) {
        this.luggageTable = luggageTable;
    }

    public ComboBox<String> getFlagIDComboBox() {
        return flagIDComboBox;
    }

    public void setFlagIDComboBox(ComboBox<String> flagIDComboBox) {
        this.flagIDComboBox = flagIDComboBox;
    }

    public TextField getFirstbagweight() {
        return firstbagweight;
    }

    public void setFirstbagweight(TextField firstbagweight) {
        this.firstbagweight = firstbagweight;
    }

    public Button getBtndailyeport() {
        return btndailyeport;
    }

    public void setBtndailyeport(Button btndailyeport) {
        this.btndailyeport = btndailyeport;
    }

    public TextField getSecondbagweight() {
        return secondbagweight;
    }

    public void setSecondbagweight(TextField secondbagweight) {
        this.secondbagweight = secondbagweight;
    }

    public ComboBox<Integer> getTotalBagsComboBox() {
        return TotalBagsComboBox;
    }

    public void setTotalBagsComboBox(ComboBox<Integer> totalBagsComboBox) {
        TotalBagsComboBox = totalBagsComboBox;
    }

    public Button getSearchLuggageButton() {
        return SearchLuggageButton;
    }

    public void setSearchLuggageButton(Button searchLuggageButton) {
        SearchLuggageButton = searchLuggageButton;
    }

    public Button getEditBaggageButton() {
        return editBaggageButton;
    }

    public void setEditBaggageButton(Button editBaggageButton) {
        this.editBaggageButton = editBaggageButton;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public Button getManualcheckbtn() {
        return manualcheckbtn;
    }

    public void setManualcheckbtn(Button manualcheckbtn) {
        this.manualcheckbtn = manualcheckbtn;
    }

    public Button getDelteButton() {
        return DelteButton;
    }

    public void setDelteButton(Button delteButton) {
        DelteButton = delteButton;
    }

    @Deprecated
    public void openIncidentReporting(ActionEvent actionEvent) {
    }

    @Deprecated
    public void openLuggageManagement(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleTagSubmission(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void opendownloadreport(ActionEvent actionEvent) {
        openScene("GenerateDailyReport.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void openEditBaggageView(ActionEvent actionEvent) {
        openScene("EditBaggageView.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void Matchpassenger(ActionEvent actionEvent) {
        String passengerID = tagIdField.getText();
        Integer totalBags = TotalBagsComboBox.getValue();
        String flag = flagIDComboBox.getValue();
        String firstWeightText = firstbagweight.getText();
        String secondWeightText = secondbagweight.getText();
        String issueDescription = issueDescriptionField.getText();

        if (isInputInvalid(passengerID, totalBags, flag, firstWeightText, secondWeightText, issueDescription)) {
            return;
        }
        Passenger foundPassenger = findPassengerById(passengerID);
        if (foundPassenger == null) {
            setErrorMessage("Passenger not found");
            return;
        }


        int randomNumber = 100 + (int) (Math.random() * 900);
        String luggageID = passengerID + foundPassenger.getFlightNumber() + randomNumber;
        foundPassenger.setBoardingPassID(luggageID);



        BaggageModel baggage = new BaggageModel(
                foundPassenger,
                totalBags,
                flag,
                Double.parseDouble(firstWeightText),
                totalBags == 2 ? Double.parseDouble(secondWeightText) : 0,
                issueDescription
        );

        BaggageHandler.saveBaggage(baggage, "baggage_data.bin");
        if (!luggageTable.getItems().contains(baggage)) {
            luggageTable.getItems().add(baggage);
        } else {
            luggageTable.refresh();
        }

        confirmationLabel.setText("Passenger info updated. Luggage ID: "+luggageID);
        confirmationLabel.setVisible(true);
        clearFields();




    }
    private boolean isValidDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    private boolean isInputInvalid(String passengerID, Integer totalBags, String flag, String firstWeightText, String secondWeightText, String issueDescription) {
        if (passengerID == null || passengerID.isEmpty()) {
            setErrorMessage("Enter Passenger ID");
            return true;
        }

        if (totalBags == null) {
            setErrorMessage("Please select total bags");
            return true;
        }

        if (flag == null) {
            setErrorMessage("Check Suspicious or Clear");
            return true;
        }

        if (firstWeightText == null || firstWeightText.trim().isEmpty()) {
            setErrorMessage("Enter first bag weight");
            return true;
        }

        if (!isValidDouble(firstWeightText)) {
            setErrorMessage("Invalid first baggage weight");
            return true;
        }

        double firstWeight = Double.parseDouble(firstWeightText);

        if (firstWeight > 40) {
            setErrorMessage("First bag over 40KG");
            return true;
        }

        if (totalBags == 2) {
            if (secondWeightText == null || secondWeightText.trim().isEmpty()) {
                setErrorMessage("Enter second bag weight");
                return true;
            }

            if (!isValidDouble(secondWeightText)) {
                setErrorMessage("Invalid second baggage weight");
                return true;
            }

            double secondWeight = Double.parseDouble(secondWeightText);
            if (secondWeight > 40) {
                setErrorMessage("Second bag over 40KG");
                return true;
            }
        }

        if (issueDescription == null || issueDescription.trim().isEmpty()) {
            setErrorMessage("Enter issue description");
            return true;
        }

        return false;
    }

    private Passenger findPassengerById(String passengerID) {
        for (Passenger p : Passenger.passengerArrayList) {
            if (p.getPassengerID().equals(passengerID)) {
                return p;
            }
        }
        return null;
    }

    private void setErrorMessage(String message) {
        confirmationLabel.setText(message);
        confirmationLabel.setVisible(true);
    }

    private void clearFields() {
        tagIdField.clear();
        firstbagweight.clear();
        secondbagweight.clear();
        TotalBagsComboBox.getSelectionModel().clearSelection();
        flagIDComboBox.getSelectionModel().clearSelection();
        issueDescriptionField.clear();
    }

    private void openScene(String fxmlFile, ActionEvent event) {
        try {
            Scene scene = new Scene(
                    FXMLLoader.load(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/" + fxmlFile)));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    @javafx.fxml.FXML
    public void DeleteSpecificBaggageInformation(ActionEvent actionEvent) {
        openScene("DeleteSpecificBaggageInformation.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void openManualCheckView(ActionEvent actionEvent) {
        openScene("openManualCheckView.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void openSearch(ActionEvent actionEvent) {
        openScene("SearchLuggage.fxml", actionEvent);

    }
}