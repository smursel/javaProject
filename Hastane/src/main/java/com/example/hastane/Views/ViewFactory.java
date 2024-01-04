package com.example.hastane.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewFactory implements Initializable {
    @FXML
    public Button anaSayfa_btn;

    @FXML
    public Button cikisYap_btn;

    @FXML
    public Button hesabim_btn;

    @FXML
    public Button randevuAl_btn;

    @FXML
    public Button ziyaretlerim_btn;

    @FXML
    public StackPane centerPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("BorderPane.fxml"));
            centerPane.getChildren().removeAll();
            centerPane.getChildren().setAll(fxml);
        }catch (Exception e){
            System.out.println("hata");
        }
    }

    public void yukleAnaSayfa(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AnaSayfa.fxml"));
        centerPane.getChildren().removeAll();
        centerPane.getChildren().setAll(fxml);
    }
}
