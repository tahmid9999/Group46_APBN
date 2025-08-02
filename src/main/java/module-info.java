module com.groupfourtysix.group46_apbn {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.groupfourtysix.group46_apbn to javafx.fxml;
    exports com.groupfourtysix.group46_apbn;
}