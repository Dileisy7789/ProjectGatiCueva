module com.example.proyectogaticueva {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.datatype.jsr310;

    requires org.kordamp.bootstrapfx.core;
    requires jbcrypt;
    requires com.fasterxml.jackson.databind;

    //opens com.example.proyectogaticueva to javafx.fxml;
    opens com.example.proyectogaticueva.controller to javafx.fxml;
    opens com.example.proyectogaticueva.domain to com.fasterxml.jackson.databind;
    exports com.example.proyectogaticueva;
}