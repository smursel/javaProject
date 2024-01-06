package com.example.hastane.Controllers.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ZiyaretlerimController implements Initializable {

    public TableView<EskiZiyaretlerim> table;
    public TableColumn<EskiZiyaretlerim, LocalDate> tarihCol;
    public TableColumn<EskiZiyaretlerim, String> hastaneCol;
    public TableColumn<EskiZiyaretlerim, String> hekimCol;
    public TableColumn<EskiZiyaretlerim, String> ilacCol;
    public TableColumn<EskiZiyaretlerim, String> kullanimSekliCol;
    public TableColumn<EskiZiyaretlerim, String> dozCol;
    public TableColumn<EskiZiyaretlerim, String> kacGunCol;

    ObservableList<EskiZiyaretlerim> ziyaretlerimData(){
        EskiZiyaretlerim p1 = new EskiZiyaretlerim(LocalDate.now(),"Ahastane", "AHekim", "Aİlaç", "Oral", "1", "20");
        EskiZiyaretlerim p2 = new EskiZiyaretlerim(LocalDate.now(),"Bhastane", "BHekim", "Aİlaç", "Oral", "1", "20");
        EskiZiyaretlerim p3 = new EskiZiyaretlerim(LocalDate.now(),"Chastane", "CHekim", "Aİlaç", "Oral", "1", "20");
        return FXCollections.observableArrayList(p1, p2, p3);
    }

    /*public void tabloyaDataEkle(ActionEvent event){
        if ( !yeniLocalDate.getValue().isEmpty() || !txthastane){
                date ve doktorun çalıştığı hastane otomatik gelsin
        }else{

        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tarihCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, LocalDate>("tarihCol"));
        hastaneCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("hastaneCol"));
        hekimCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("hekimCol"));
        ilacCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("ilacCol"));
        kullanimSekliCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("kullanimSekliCol"));
        dozCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("dozCol"));
        kacGunCol.setCellValueFactory(new PropertyValueFactory<EskiZiyaretlerim, String>("kacGunCol"));

        table.setItems(ziyaretlerimData());
    }

}
