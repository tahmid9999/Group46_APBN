package com.groupfourtysix.group46_apbn.Summy;


import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;




public class BaggageHandlerController
{
    @javafx.fxml.FXML
    private TextField tagIdField;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String>passengerCol;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String>luggageIdCol;
    @javafx.fxml.FXML
    private TableColumn<Passenger, String> flightCol;
    @javafx.fxml.FXML
    private TextArea issueDescriptionField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableView <Passenger>luggageTable;
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

    @javafx.fxml.FXML
    public void initialize() {
        passengerCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        luggageIdCol.setCellValueFactory(new PropertyValueFactory<>("boardingPassID"));
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

    public TableColumn<Passenger, String> getPassengerCol() {
        return passengerCol;
    }

    public void setPassengerCol(TableColumn<Passenger, String> passengerCol) {
        this.passengerCol = passengerCol;
    }

    public TableColumn<Passenger, String> getLuggageIdCol() {
        return luggageIdCol;
    }

    public void setLuggageIdCol(TableColumn<Passenger, String> luggageIdCol) {
        this.luggageIdCol = luggageIdCol;
    }

    public TableColumn<Passenger, String> getFlightCol() {
        return flightCol;
    }

    public void setFlightCol(TableColumn<Passenger, String> flightCol) {
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

    public TableView<Passenger> getLuggageTable() {
        return luggageTable;
    }

    public void setLuggageTable(TableView<Passenger> luggageTable) {
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

        try{
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/GenerateDailyReport.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Daily Report");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to open report view.");
            confirmationLabel.setVisible(true);
        }




    }

    @javafx.fxml.FXML
    public void openEditBaggageView(ActionEvent actionEvent) {

        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/EditBaggageView.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Edit Baggage");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to open Edit Baggage view.");
            confirmationLabel.setVisible(true);
        }
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
        Passenger foundPassenger = BaggageHandler.readPassengerInfo(passengerID, "passengerinfo.bin");
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
                totalBags == 2 ? Double.parseDouble(secondWeightText) : 0.0,
                issueDescription
        );



        BaggageHandler.saveBaggage(baggage, "baggage_data.bin");

        if (!luggageTable.getItems().contains(foundPassenger)) {
            luggageTable.getItems().add(foundPassenger);
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




    @javafx.fxml.FXML
    public void DeleteSpecificBaggageInformation(ActionEvent actionEvent) {

        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/DeleteSpecificBaggageInformation.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Delete Baggage Info");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to open Delete Baggage Info view.");
            confirmationLabel.setVisible(true);
        }
    }

    @javafx.fxml.FXML
    public void openManualCheckView(ActionEvent actionEvent) {

        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/ManualCheck.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Manual Check");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to open Manual Check view.");
            confirmationLabel.setVisible(true);
        }
    }

    @javafx.fxml.FXML
    public void openSearch(ActionEvent actionEvent) {

        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/groupfourtysix/group46_apbn/Summy/SearchLuggage.fxml"));
            javafx.scene.Parent root = fxmlLoader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Search Luggage");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to open Search Luggage view.");
            confirmationLabel.setVisible(true);
        }
    }
}