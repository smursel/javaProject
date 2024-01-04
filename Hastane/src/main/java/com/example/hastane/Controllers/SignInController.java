package com.example.hastane.Controllers;

import com.example.hastane.App;
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
    public ComboBox hastaDogumYeri_comBox;
    public ComboBox hastaYasadigiSehir_comBox;
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
