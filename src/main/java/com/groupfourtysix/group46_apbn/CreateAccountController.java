package com.groupfourtysix.group46_apbn;

import com.groupfourtysix.group46_apbn.Tahmid.AppendableObjectOutputStream;
import com.groupfourtysix.group46_apbn.Tahmid.Passenger;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private ComboBox<String> CNAuserComboInput;
    @javafx.fxml.FXML
    private TextField CNAemailAdressTextfield;
    @javafx.fxml.FXML
    private TextField CNApasswordTextfield;
    @javafx.fxml.FXML
    private Label CNAalertsLabel;

    List<Account> accountArrayList = AccountFileHandler.readFile("AccountInfo.bin");

    @javafx.fxml.FXML
    public void initialize() {
        CNAuserComboInput.getItems().addAll("Passenger", "APBN Screening Officer", "Airport check-in staff", "Security Scanner Operator", "Baggage Handler", "Boarding Gate Officer", "Flight Scheduler", "Incident Logger");

        //read file
//        File file = new File("passengerAccountInfo.bin");
//
//        if (!file.exists()) {
//            return;
//        }
//
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        try{
//            while (true){
//                Account account = (Account) ois.readObject();
//                Account.accountPassengerArrayList.add(account);
//            }
//        } catch (EOFException eof){
//            System.out.println("End of file reached");
//        } catch (ClassNotFoundException cnf) {
//            System.out.println("Class not found");
//        }
    }



    @javafx.fxml.FXML
    public void createNewAccountButton(ActionEvent actionEvent) {
//        if (CNAuserComboInput.getValue() == null) {
//            CNAalertsLabel.setText("Please select user type.");
//        }
//
//        if(CNAemailAdressTextfield.getText().trim().isEmpty()) {
//            CNAalertsLabel.setText("Please enter your email address properly.");
//            return;
//        }

//        for (int i = 0; i < CNAemailAdressTextfield.getText().length(); i++) {
//            boolean atSignFound;
//            if (CNAemailAdressTextfield.getText().charAt(i) == '@') {
//                atSignFound = true;
//            }
//            else {
//                atSignFound = false;
//                return;
//            }
//        }

//        for (int i = 0; i < CNAemailAdressTextfield.getText().length(); i++) {
//            boolean dotFound;
//            if (CNAemailAdressTextfield.getText().charAt(i) == '.') {
//                dotFound = true;
//            }
//            else {
//                dotFound = false;
//                return;
//            }
//        }

        for (Account ac: accountArrayList) {
//            if(ac.getAccountUserType().equalsIgnoreCase("Ba")){
                System.out.println(ac);
//            }
        }

//        if(CNApasswordTextfield.getText().trim().isEmpty()) {
//            CNAalertsLabel.setText("Please enter your password properly.");
//            return;
//        }
//
//        if (CNApasswordTextfield.getText().length() < 9) {
//            CNAalertsLabel.setText("Password must be of at least 8 characters.");
//            return;
//        }

        Account ac = new Account(
                CNAuserComboInput.getValue(),
                CNAemailAdressTextfield.getText(),
                CNApasswordTextfield.getText()
        );

        //Write
        AccountFileHandler.createFile(ac, "AccountInfo.bin");

        //write file
//        File file = new File("AccountInfo.bin");
//        FileOutputStream fos;
//        ObjectOutputStream oos;
//
//        if (file.exists()) {
//            fos = new FileOutputStream(file, true);
//            oos = new AppendableObjectOutputStream(fos);
//        } else {
//            fos = new FileOutputStream(file, true);
//            oos = new ObjectOutputStream(fos);
//        }
//
//        oos.writeObject(psAC);
//        oos.close();
//
//        Account.accountPassengerArrayList.add(psAC);
//        CNAalertsLabel.setText("Account has been created successfully");

//        ArrayList<> accountArrayList = Login.accountPassengerArrayList;

    }
}