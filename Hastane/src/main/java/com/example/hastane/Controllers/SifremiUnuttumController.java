package com.example.hastane.Controllers;

import com.example.hastane.Siniflar.App;
import com.example.hastane.BorderPaneSayfaYonetimi;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SifremiUnuttumController implements BorderPaneSayfaYonetimi {

    public TextField sifreUnuttum_isim;
    public TextField sifreUnuttum_tc;
    public TextField sifreUnuttum_telNumara;
    public PasswordField sifreUnuttum_yeniSifre;
    public PasswordField sifreUnuttum_yeniSifreTekrar;
    public Button sifreUnuttum_buton;
    public Label sifreUnuttum_hata_label;

    @Override
    public void silMenu(Object pane) {
        ((AnchorPane) pane).getChildren().clear();
    }
    @Override
    public void yukleSayfa(Object pane, String fxml) {}     //kullanılmıyacak

    public void sifreDegistirButon(MouseEvent event) {
        //silMenu(mainAnchorPane);    //login anchorunu sildik
        yukleSayfa("/Fxml/Login.fxml");
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


}
