package com.example.hastane.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<String> acc_selector;
    public Label tc_label;
    public TextField tc_field;
    public Label password_label;
    public TextField password_field;
    public Button login_button;
    public Label hata_label;
    public Label signInLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setValue("Hasta");
        acc_selector.getItems().addAll("Admin", "Hekim", "Hasta");
    }
}
