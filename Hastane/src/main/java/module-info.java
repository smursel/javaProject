module com.example.hastane {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.example.hastane to javafx.fxml;
    exports com.example.hastane;
    exports com.example.hastane.Controllers;
    exports com.example.hastane.Controllers.Admin;
    exports com.example.hastane.Controllers.Client;
    exports com.example.hastane.Controllers.Doctor;
    exports com.example.hastane.Models;
    exports com.example.hastane.Views;

}