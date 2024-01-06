package com.example.hastane.Controllers.Client;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RandevuAlController implements Initializable {
    public AnchorPane randevuAl_anchorPane;
    public ComboBox randevu_iller_comBox;
    public ComboBox randevu_klinikler_comBox;
    public ComboBox randevu_hastaneler_comBox;
    public ComboBox randevu_hekimler_comBox;
    public DatePicker randevu_tarihi_datePicer;
    public Button randevu_al_button;
    public Label randevuAL_hata_lbl;

    public void datePicTarihKisitla(){
        randevu_tarihi_datePicer.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.isBefore(today) || date.isAfter(LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth() + 15)));
            }
        });
    }
    private void illerEkleComBox(){
        Gson gson = new Gson(); //gson nesnesi
        FileReader reader;
        try {
            reader = new FileReader("src/main/resources/Json/iller.json");    //dosya okuma
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //jsondaki diziyi list tipine dönüştürdük
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        String jsonList = jsonObject.getAsJsonArray("iller").toString();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> list = gson.fromJson(jsonList, listType);

        randevu_iller_comBox.setItems(FXCollections.observableArrayList(list));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datePicTarihKisitla();
        illerEkleComBox();
    }
}
