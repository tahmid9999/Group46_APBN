//package com.groupfourtysix.group46_apbn.Summy;
//
//import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class BoardingGateOfficerController
//{
//    @javafx.fxml.FXML
//    private Label verificationResult;
//    @javafx.fxml.FXML
//    private ComboBox<String> flightComboBox;
//    @javafx.fxml.FXML
//    private TableColumn<Passenger, String> colPassengerName;
//    @javafx.fxml.FXML
//    private TableColumn<Passenger, String> colBoardingPass;
//    @javafx.fxml.FXML
//    private TableView<Passenger> passengerTable;
//    @javafx.fxml.FXML
//    private TextField boardingPassInput;
//    @javafx.fxml.FXML
//    private TableColumn <Passenger, String>colStatus;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//        boardingService = new BoardingService();
//        flightComboBox.setItems(FXCollections.observableArrayList("FL123", "FL456", "FL789"));
//
//        colPassengerName.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
//        colBoardingPass.setCellValueFactory(new PropertyValueFactory<>("boardingPassNo"));
//        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
//
//        passengerList = FXCollections.observableArrayList();
//        passengerTable.setItems(passengerList);
//    }
//
//    @javafx.fxml.FXML
//    public void onVerifyBoardingPass(ActionEvent actionEvent) {
//
//        String passNo = boardingPassInput.getText();
//        if (boardingService.verifyBoardingPass(passNo, passengerList)) {
//            verificationResult.setText("Boarding Pass Verified:" + passNo);
//        } else {
//            verificationResult.setText("Invalid Boarding Pass");
//        }
//        boardingPassInput.clear();
//    }
//
//
//    @javafx.fxml.FXML
//    public void onGenerateReport(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void onFinalizeBoarding(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void onLoadManifest(ActionEvent actionEvent) {
//
//        String selectedFlight = flightComboBox.getValue();
//        if (selectedFlight != null) {
//            passengerList.setAll(boardingService.loadManifest(selectedFlight));
//            verificationResult.setText("Manifest loaded for"+selectedFlight);
//        } else {
//            verificationResult.setText("Please select a flight first");
//        }
//    }
//
//
//    @javafx.fxml.FXML
//    public void onDenyBoarding(ActionEvent actionEvent) {
//
//        Passenger selected = passengerTable.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            boardingService.denyBoarding(selected);
//            passengerTable.refresh();
//            verificationResult.setText("Denied boarding for " + selected.getPassengerName());
//        } else {
//            verificationResult.setText("Select a passenger first!");
//        }
//    }
//
//    @javafx.fxml.FXML
//    public void openPassengerList(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void openReportedPassengerList(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void openEditBoardingList(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void openReportPassenger(ActionEvent actionEvent) {
//    }
//}