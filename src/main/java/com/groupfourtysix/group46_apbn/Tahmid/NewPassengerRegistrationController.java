package com.groupfourtysix.group46_apbn.Tahmid;

import com.groupfourtysix.group46_apbn.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class NewPassengerRegistrationController
{
    @javafx.fxml.FXML
    private ComboBox<String> nationalityComboInput;
    @javafx.fxml.FXML
    private TextField passportNumberTextfield;
    @javafx.fxml.FXML
    private TextField passengerNameTextfield;
    @javafx.fxml.FXML
    private DatePicker passengerDateOfBirth;
    @javafx.fxml.FXML
    private Label NPRvdVrLabel;
    @javafx.fxml.FXML
    private Label flightNoPasIDLabel;

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        nationalityComboInput.getItems().addAll("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Côte d’Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");

        //read file
        File file = new File("passengerInfo.bin");

        if (!file.exists()) {
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try{
            while (true){
                Passenger passenger = (Passenger) ois.readObject();
                passengerArrayList.add(passenger);
            }
        } catch (EOFException eof){
            System.out.println("End of file reached");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found");
        }

    }

    ArrayList<Passenger> passengerArrayList = new ArrayList<>();

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(message);
        a.showAndWait();
    }

    private String generateUniquePassengerID() {
        String prefix = "PID";
        int Num = (int)(Math.random() * 90000) + 10000;
        String psID = prefix + Num;

        for (Passenger ps : passengerArrayList) {
            if (ps.getPassengerID().equals(psID)) {
                return generateUniquePassengerID(); // recursion
            }
        }

        return psID;
    }

    @javafx.fxml.FXML
    public void newPassengerRegSaveButton (ActionEvent actionEvent) throws IOException {
        if (passengerNameTextfield.getText().trim().isEmpty()) {
            NPRvdVrLabel.setText("Please enter name properly.");
            return;
        }

        String pasName = passengerNameTextfield.getText();
        for (int i=0; i < pasName.length(); i++) {
            char j = pasName.charAt(i);
            if (!((j >= 'A' && j <= 'Z') || (j >= 'a' && j <= 'z') || j == ' ')) {
                NPRvdVrLabel.setText("Your name mustn't include special characters or numbers");
                return;
            }
        }

        if (passengerDateOfBirth.getValue() == null) {
            NPRvdVrLabel.setText("Please select your date of birth.");
            return;
        }

        if (passportNumberTextfield.getText().trim().isEmpty()) {
            NPRvdVrLabel.setText("Please enter your passport number properly.");
            return;
        }

        if (nationalityComboInput.getValue() == null) {
            NPRvdVrLabel.setText("Please select your nationality.");
            return;
        }

        for (Passenger ps: passengerArrayList) {
            if (ps.getPassportNumber().equals(passportNumberTextfield.getText())) {
                NPRvdVrLabel.setText("This passenger already exists");
                return;
            }
        }

        String passengerID = generateUniquePassengerID();

        String airlineCode = "BG";
        int number = (int)(Math.random() * 900) + 100;
        String flightNumber = airlineCode + number;

        Passenger ps = new Passenger(
                passengerNameTextfield.getText(),
                passengerDateOfBirth.getValue(),
                passportNumberTextfield.getText(),
                nationalityComboInput.getValue(),
                passengerID,
                flightNumber
                );

        //write file
        File file = new File("passengerInfo.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        if (file.exists()) {
            fos = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fos);
        }

        oos.writeObject(ps);
        oos.close();

        passengerArrayList.add(ps);
        NPRvdVrLabel.setText("Passenger info has been saved successfully");
        flightNoPasIDLabel.setText("Your Flight Number is " + flightNumber + " & your Passenger ID is " + passengerID);

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tahmid/PassengerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Hello!");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }
}