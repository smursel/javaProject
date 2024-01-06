package com.example.hastane.Controllers;

import com.example.hastane.Siniflar.App;
import com.example.hastane.BorderPaneSayfaYonetimi;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
        yukleSayfa(mainAnchorPane, "/Fxml/Signin.fxml");    //kayıt ol sayfasını yükledi
    }

    public void sifremiUnuttumYukle(MouseEvent event){
        silMenu(mainAnchorPane);
        yukleSayfa("/Fxml/SifremiUnuttum.fxml");
    }

    @Override
    public void silMenu(Object pane) {((AnchorPane) pane).getChildren().clear();}

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

    //GİRİŞ YAP butonuna basildiğiğnda border pane e atmak için

    public void girisYapButon(MouseEvent event) {
        if(acc_selector.getValue().equals("Hasta")) {
            silMenu(mainAnchorPane);    //login anchorunu sildik
            yukleSayfa("/Fxml/Client/BorderPane.fxml");
        }else{
            silMenu(mainAnchorPane);    //login anchorunu sildik
            yukleSayfa("/Fxml/Doctor/DocBorderPane.fxml");
        }
    }
    public void yukleSayfa(String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //pane.setCenter(root);
        Scene scene = new Scene(root);
        App.stage.setScene(scene);  //mevcut stage
        App.stage.show();   //mevcut stage
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setValue("Hasta");
        acc_selector.getItems().addAll("Hekim", "Hasta");
    }

}
