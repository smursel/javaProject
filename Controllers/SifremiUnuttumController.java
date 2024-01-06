package com.example.hastane.Controllers;

import com.example.hastane.Siniflar.App;
import com.example.hastane.BorderPaneSayfaYonetimi;
import com.example.hastane.Siniflar.Kontroller;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
    public FontAwesomeIconView sifreBasarili_icon;
    public Label sifreBasarili_label;

    @Override
    public void silMenu(Object pane) {
        ((AnchorPane) pane).getChildren().clear();
    }
    @Override
    public void yukleSayfa(Object pane, String fxml) {}     //kullanılmıyacak

    public void sifreDegistirButon(MouseEvent event) {
        Kontroller kontrol = new Kontroller();
        kontrol.adSoyadKontrol(sifreUnuttum_isim.getText());
        kontrol.gecerliTC(sifreUnuttum_tc.getText());
        kontrol.gecerliTelefonNo(sifreUnuttum_telNumara.getText());
        kontrol.gecerliSifre(sifreUnuttum_yeniSifre.getText());

        //arraydeki hataları stringe ekliyoroum
        StringBuilder tumHatalar = new StringBuilder();
        for (String s:kontrol.hatalar) {
            tumHatalar.append("\n");
            tumHatalar.append(s);
        }

        //hata varsa label a yazdırır yoksa hasta oluşturur kaydeder
        if (tumHatalar.isEmpty()){
            kontrol.sifreGuncelle(sifreUnuttum_isim.getText(), sifreUnuttum_tc.getText(), sifreUnuttum_telNumara.getText(), sifreUnuttum_yeniSifre.getText(), sifreUnuttum_yeniSifreTekrar.getText());
            sifreUnuttum_hata_label.setVisible(false);
            sifreBasarili_label.setVisible(true);
            sifreBasarili_icon.setVisible(true);
        }else{
            sifreUnuttum_hata_label.setVisible(true);
            sifreUnuttum_hata_label.setText(tumHatalar.toString());
        }

    }

    public void girisYaplbl(){
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
