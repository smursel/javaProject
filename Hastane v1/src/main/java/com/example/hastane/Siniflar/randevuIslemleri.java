package com.example.hastane.Siniflar;
import java.util.ArrayList;

public class randevuIslemleri {

    public ArrayList<Hastane> hastaneleriListele(String il) {
        ArrayList<Hastane> hastaneler = new ArrayList<Hastane>();
        App.Hastaneler.forEach(hastane -> {
            if (hastane.il.equals(il)) {
                hastaneler.add(hastane);
            }
        });
        return hastaneler;
    }
    public  ArrayList<String> klinikleriListele(String hastaneId){
        return Hastane.klinikler;
    }
    public ArrayList<Hekim> hekimleriListele(String hastaneId,String klinikAdi){
        ArrayList<Hekim> hekimler = new ArrayList<Hekim>();
        App.Hastaneler.forEach(hastane -> {
            if (hastane.hastaneId.equals(hastaneId)) {
                hastane.hekimler.forEach(hekim -> {
                    if (hekim.getKlinik().equals(klinikAdi)) {
                        hekimler.add(hekim);
                    }
                });
            }
        });

        ArrayList<Hekim> availableHekimler = new ArrayList<Hekim>();

        hekimler.forEach(hekim -> {
            //if (hekim.getRandevuSayisi() < 10) {
            //    availableHekimler.add(hekim);
            //}
        });

        return hekimler;
    }

}
