package com.example.hastane.Controllers.Doctor;

import com.example.hastane.BorderPaneSayfaYonetimi;
import com.example.hastane.Siniflar.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorMenuController implements BorderPaneSayfaYonetimi, Initializable {
    public Button cikisYap_btn;
    public Button hastalarım_btn;
    public Button hesabim_btn;
    public Button receteYaz_btn;

    public BorderPane docBorderpane;

    @Override
    public void silMenu(Object pane){
        ((BorderPane) docBorderpane).setLeft(null);
    }

    @Override
    public void yukleSayfa(Object pane, String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((BorderPane)pane).setCenter(root);
    }

    public void hastalarimYukle(MouseEvent event){
        yukleSayfa(docBorderpane, "/Fxml/Doctor/Hastalarim.fxml");
    }

    public void receteYazYukle(MouseEvent event){
        yukleSayfa(docBorderpane, "/Fxml/Doctor/ReceteYaz.fxml");
    }

    public void hesabimYukle(MouseEvent event){ yukleSayfa(docBorderpane, "/Fxml/Client/Hesabim.fxml"); }

    public void cikisYapYukle(MouseEvent event){
        silMenu(docBorderpane);    //borderpane in left kısmını sildik (menüyü)
        yukleSayfa(docBorderpane,"/Fxml/Login.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
