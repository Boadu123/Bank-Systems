 module com.example.banking_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;


    opens com.example.banking_system to javafx.fxml;
    exports com.example.banking_system;
}