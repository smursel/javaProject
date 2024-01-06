package com.example.hastane.Controllers;

import com.example.hastane.App;
import com.example.hastane.BorderPaneSayfaYonetimi;
import com.google.gson.JsonObject;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class SignInController implements BorderPaneSayfaYonetimi, Initializable {

    public TextField hastaIsmi;
    public TextField hastaTc;
    public TextField hastaEposta;
    public TextField hastaTel;
    public ChoiceBox<String> hastaKanChoiceBox;
    public ChoiceBox<String> hastaCinsiyetChoiceBox;
    public DatePicker hastaDogumDatePicker;
    public ComboBox hastaDogumYeri_comBox;
    public ComboBox hastaYasadigiSehir_comBox;
    public TextField hastaBoy;
    public TextField hastaKilo;
    public PasswordField hastaPassword;
    public Label sign_hata_label;


    @Override
    public void silMenu(Object pane) {
        ((AnchorPane) pane).getChildren().clear();
    }
    @Override
    public void yukleSayfa(Object pane, String fxml) {}     //kullanılmıyacak

    public void kayitOlButon(MouseEvent event) {
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

    //**********************************************************************
    public void datePicKisitla(){
        hastaDogumDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.isBefore(LocalDate.of(today.getYear() - 100, today.getMonth(), today.getDayOfMonth())) || date.isAfter(LocalDate.of(today.getYear() - 17, today.getMonth(), today.getDayOfMonth())) );
                //setDisable(empty || date.isBefore(today));
            }
        });
    }
    //**************************************************************************
    private void illerEkleComBox(){
        Gson gson = new Gson(); //gson nesnesi
        FileReader reader;
        try {
            reader = new FileReader("src/main/resources/Json/iller.json");    //dosya okuma
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        String jsonList = jsonObject.getAsJsonArray("iller").toString();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> list = gson.fromJson(jsonList, listType);

        hastaDogumYeri_comBox.setItems(FXCollections.observableArrayList(list));
        hastaYasadigiSehir_comBox.setItems(FXCollections.observableArrayList(list));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hastaKanChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        hastaCinsiyetChoiceBox.getItems().addAll("Erkek", "Kadın");
        illerEkleComBox();
        datePicKisitla();
    }
}
