module com.groupfourtysix.group46_apbn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.groupfourtysix.group46_apbn to javafx.fxml;

    opens com.groupfourtysix.group46_apbn.Tahmid to javafx.fxml;
    exports com.groupfourtysix.group46_apbn.Tahmid;
    exports com.groupfourtysix.group46_apbn.Summy;
    opens com.groupfourtysix.group46_apbn.Summy to javafx.fxml;
    exports com.groupfourtysix.group46_apbn;
    opens com.groupfourtysix.group46_apbn.Habib to javafx.fxml;
    exports com.groupfourtysix.group46_apbn.Habib;
}