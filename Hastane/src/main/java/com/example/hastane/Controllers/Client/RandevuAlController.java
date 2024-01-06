package com.example.hastane.Controllers.Client;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datePicTarihKisitla();
    }
}
