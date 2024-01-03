package com.example.hastane.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    public TextField hastaIsmi;
    public TextField hastaTc;
    public TextField hastaEposta;
    public TextField hastaTel;
    public ChoiceBox<String> hastaKanChoiceBox;
    public ChoiceBox<String> hastaCinsiyetChoiceBox;
    public DatePicker hastaDatePicker;
    public TextField hastaDogumYeri;
    public TextField hastaYasadıgıUlke;
    public TextField hastaBoy;
    public TextField hastaKilo;
    public PasswordField hastaPassword;
    public Label sign_hata_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hastaKanChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        hastaCinsiyetChoiceBox.getItems().addAll("Erkek", "Kadın");
    }
}
