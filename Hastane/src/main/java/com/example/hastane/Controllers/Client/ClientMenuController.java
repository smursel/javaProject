package com.example.hastane.Controllers.Client;

import com.example.hastane.App;
import com.example.hastane.BorderPaneSayfaYonetimi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClientMenuController implements BorderPaneSayfaYonetimi, Initializable {

    @FXML
    public Button anaSayfa_btn;
    @FXML
    public Button randevuAl_btn;
    @FXML
    public Button ziyaretlerim_btn;
    @FXML
    public Button cikisYap_btn;
    @FXML
    public Button hesabim_btn;

    @FXML
    public BorderPane mainBorderPane;

    public void anaSayfaYukle(MouseEvent event){
        yukleSayfa(mainBorderPane, "/Fxml/Client/AnaSayfa.fxml");
    }
    public void randevuAlYukle(MouseEvent event){
        yukleSayfa(mainBorderPane, "/Fxml/Client/RandevuAl.fxml");
    }
    public void ziyaretlerimYukle(MouseEvent event){
        yukleSayfa(mainBorderPane, "/Fxml/Client/AnaSayfa.fxml");
    }
    public void hesabimYukle(MouseEvent event){
        yukleSayfa(mainBorderPane, "/Fxml/Client/Hesabim.fxml");
    }
    public void cikisYapYukle(MouseEvent event){
        silMenu(mainBorderPane);    //borderpane in left kısmını sildik (menüyü)
        yukleSayfa(mainBorderPane,"/Fxml/Login.fxml");
    }

    public void silMenu(Object pane){
        ((BorderPane) mainBorderPane).setLeft(null);
    }

    public void yukleSayfa(Object pane, String fxml){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((BorderPane)pane).setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // anaSayfa_btn.setOnAction(actionEvent -> );
    }


}

