package com.example.hastane.Controllers;

import com.example.hastane.BorderPaneSayfaYonetimi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements BorderPaneSayfaYonetimi, Initializable {
    public ChoiceBox<String> acc_selector;
    public Label tc_label;
    public TextField tc_field;
    public Label password_label;
    public TextField password_field;
    public Button login_button;
    public Label hata_label;
    public Label signInLabel;
    public AnchorPane mainAnchorPane;
    public Label login_sifreDegistir_lbl;

    public void kayitOlYukle(MouseEvent event){
        silMenu(mainAnchorPane);    //login anchorunu sildik
        yukleSayfa(mainAnchorPane, "/Fxml/Signin.fxml");
    }

    @Override
    public void silMenu(Object pane) {
        ((AnchorPane) pane).getChildren().clear();
    }

    @Override
    public void yukleSayfa(Object pane, String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((AnchorPane)pane).getChildren().add(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setValue("Hasta");
        acc_selector.getItems().addAll("Admin", "Hekim", "Hasta");
    }

}
