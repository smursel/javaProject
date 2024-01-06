package com.example.hastane.Controllers.Client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HesabimController implements Initializable {

    public TextField hesabim_ismi_tfield;
    public ComboBox hesabim_dogumYeri_comBox;
    public TextField hesabim_tc_tfield;
    public ComboBox hesabim_yasadigiSehir_comBox;
    public TextField hesabim_ePosta_tfield;
    public TextField hesabim_boy_tfield;
    public TextField hesabim_kanGrubu_tfield;
    public TextField hesabim_kilo_tfield;
    public TextField hesabim_dogumTarihi_tfield;
    public TextField hesabim_yeniSifre_tfield;
    public Button hesabim_yeniSifre_Button;
    public Button hesabim_kaydet_button;
    public Label hesabim_hata_lbl;

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

        hesabim_dogumYeri_comBox.setItems(FXCollections.observableArrayList(list));
        hesabim_yasadigiSehir_comBox.setItems(FXCollections.observableArrayList(list));

       /* hesabim_dogumYeri_comBox.selectionModelProperty().setValue();
        hesabim_yasadigiSehir_comBox.selectionModelProperty().setValue();*/
    }

    public void sifreDegistir(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        illerEkleComBox();
    }
}
