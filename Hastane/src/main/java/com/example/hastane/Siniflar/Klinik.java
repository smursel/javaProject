package com.example.hastane.Siniflar;
import java.util.ArrayList;

public class Klinik{
    public String klinikAdi ="";
    public ArrayList<String> branslar = new ArrayList<String>();

    public Klinik(String klinikAdi, ArrayList<String> branslar){
        this.klinikAdi = klinikAdi;
        this.branslar = branslar;
    }
}