package com.example.hastane.Siniflar;
import java.time.LocalDate;
import java.util.ArrayList;

class Yogunluk{
    public LocalDate tarih;
    public int KisiSayisi;

    public Yogunluk(LocalDate tarih,int kisiSayisi){
        this.tarih = tarih;
        this.KisiSayisi = kisiSayisi;
    }
}
public class Hekim extends User {
    private String klinik;//enum
    private Hastane hastane;
    private ArrayList<Yogunluk> yogunluk = new ArrayList<Yogunluk>();
    private static final int auth = 1;

    public Yogunluk getYogunluk(LocalDate tarih){
        return yogunluk.stream().filter(yogunluk -> yogunluk.tarih.equals(tarih)).findFirst().orElse(null);
    }
    public void setyogunluk(Yogunluk yogunluk){
        //this.yogunluk.stream().filter(c-> c.tarih.equals(yogunluk.tarih)) = yogunluk;
    }

    public void arttirYogunluk(){
        //this.yogunluk.KisiSayisi++;
    }

    public static int getAuth() {
        return auth;
    }
    private static long count = 0;

    private final String Id;

    public String getId() {
        return Id;
    }

    public Hastane getHastane() {
        return hastane;
    }

    public String getKlinik() {
        return klinik;
    }

    public void setHastane(Hastane hastane) {
        this.hastane = hastane;
    }

    public void setKlinik(String klinik) {
        this.klinik = klinik;
    }

    public Hekim(String klinik, Hastane hastane, String TC, String ad, String soyad, String ePosta, boolean isDead, Cinsiyet cinsiyet, String kanGrubu, String dogumYeri, double kilo, double boy, LocalDate dogumTarihi)  {
        this.ad = ad;
        this.ePosta = ePosta;
        this.isDead = isDead;
        this.cinsiyet = cinsiyet;
        this.kanGrubu = kanGrubu;
        this.dogumYeri = dogumYeri;
        this.dogumTarihi = dogumTarihi;
        this.kilo = kilo;
        this.boy = boy;
        this.TC = TC;

        this.klinik = klinik;
        this.hastane = hastane;
        count++;
        this.Id = count + "";

    }
}