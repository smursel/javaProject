package com.example.hastane.Controllers;

import com.example.hastane.Siniflar.*;
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

    public void girisYapLbl(){
        yukleSayfa("/Fxml/Login.fxml");
    }
    public void kayitOlButon(MouseEvent event) {
        //Geceerli kontolleri yapar
        Kontroller kontol = new Kontroller();
        kontol.adSoyadKontrol(hastaIsmi.getText());
        kontol.gecerliTC(hastaTc.getText());
        kontol.isEmail(hastaEposta.getText());
        kontol.gecerliTelefonNo(hastaTel.getText());
        kontol.KanGrubuKontrol(hastaKanChoiceBox.getValue());
        kontol.CinsiyetKontrol(hastaCinsiyetChoiceBox.getValue());
        kontol.dateTimeKontrol(hastaDogumDatePicker.getValue());
        kontol.SehirKontrol(hastaDogumYeri_comBox.selectionModelProperty().getName());
        kontol.SehirKontrol(hastaYasadigiSehir_comBox.selectionModelProperty().getName());
        kontol.boyKontrol(hastaBoy.getText());
        kontol.kiloKontrol(hastaKilo.getText());
        kontol.gecerliSifre(hastaPassword.getText());
        
        //arraydeki hataları stringe ekliyoroum
        StringBuilder tumHatalar = new StringBuilder();
        for (String s:kontol.hatalar) {
            tumHatalar.append("\n");
            tumHatalar.append(s);
        }

        //hata varsa label a yazdırır yoksa hasta oluşturur kaydeder
        if (tumHatalar.isEmpty()){
            sign_hata_label.setVisible(false);
            Hasta hasta = new Hasta(0,
                    hastaIsmi.getText(),
                    hastaEposta.getText(),
                    false,
                    hastaCinsiyetChoiceBox.getValue().equals("E") ? Cinsiyet.ERKEK : Cinsiyet.KADIN,
                    hastaKanChoiceBox.getValue(),
                    hastaDogumYeri_comBox.selectionModelProperty().getName(),
                    hastaDogumDatePicker.getValue(),
                    Double.parseDouble(hastaKilo.getText()),
                    Double.parseDouble(hastaBoy.getText()),
                    hastaTc.getText(),
                    hastaYasadigiSehir_comBox.selectionModelProperty().getName(),
                    hastaTel.getText(),
                    hastaPassword.getText());

            App.hastalar.add(hasta);

            hastaIsmi.clear(); hastaEposta.clear(); hastaCinsiyetChoiceBox.getSelectionModel().clearSelection(); hastaKanChoiceBox.getSelectionModel().clearSelection();
            hastaDogumYeri_comBox.getSelectionModel().clearSelection(); hastaKilo.clear(); hastaBoy.clear(); hastaTc.clear();
            hastaYasadigiSehir_comBox.getSelectionModel().clearSelection(); hastaTel.clear(); hastaPassword.clear();
        }else{
            sign_hata_label.setVisible(true);
            sign_hata_label.setText(tumHatalar.toString());
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

        //jsondaki diziyi list tipine dönüştürdük
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
