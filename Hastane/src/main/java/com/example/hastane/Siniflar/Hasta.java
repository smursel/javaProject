package com.example.hastane.Siniflar;

import javax.swing.plaf.IconUIResource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

class Randevu{
    public Hastane hastane;
    public String secilenKlinik;
    static public long Counter;
    public String randevuId;
    public LocalDate tarih;
    public LocalTime saat;
    public boolean gidildiMi = false;
    public boolean iptalMi = false;
    public Hekim hekim;

    public Randevu(){
        ++Counter;
        randevuId= Counter + "";
    }

    public Randevu(String randevuId) {
        this.randevuId = randevuId;
    }

}
class Ziyaretlerim extends Randevu{
public String hastalik;
public String recete;
public String ilacCol;
public String kullanimSekliCol;
public String dozCol;
public String kacGunCol;


public Ziyaretlerim(String randevuId){
    super(randevuId);
}
}
class KrediKarti{
    private String kartNo;
    private LocalDate expDate;
    private short cvc;
    public boolean isValid = true;
    KrediKarti(String kartNo,LocalDate expDate,short cvc){
        if(kartNo.length() != 12){
            isValid =false;
            return;
        }
        this.kartNo = kartNo;
        this.expDate = expDate;
        this.cvc = cvc;
    }
}
public class Hasta extends User{
   private final long Id;
   private static long count= 0;
   private long borc;
   //private KrediKarti krediKarti;

   private ArrayList<Randevu> randevular = new ArrayList<Randevu>();
   private ArrayList<Ziyaretlerim> ziyaretlerim = new ArrayList<Ziyaretlerim>();
    public long getId() {
        return Id;
    }
    public void setBorc(long borc){
        this.borc = borc;
    }

    /*public void setKrediKarti(KrediKarti krediKarti) {
        this.krediKarti = krediKarti;
    }*/

    /*public KrediKarti getKrediKarti() {
        return krediKarti;
    }*/

    public long getBorc() {
        return borc;
    }

    public Randevu randevuBul(String id){
        return randevular.stream().filter(c-> c.randevuId == id).findFirst().get();
    }
    public Ziyaretlerim ziyaretBul(String id){
        return ziyaretlerim.stream().filter(c-> c.randevuId == id).findFirst().get();
    }

    public void randevuEkle(Randevu randevu){
        randevular.add(randevu);

    }
    public void ziyaretEkle(Ziyaretlerim ziyaret){
        ziyaretlerim.add(ziyaret);
    }
    public void randevuSil(String id){
        randevular.remove(randevuBul(id));
    }
    public void ziyaretSil(String id){
        ziyaretlerim.remove(ziyaretBul(id));
    }
    public ArrayList<Randevu> getRandevular() {
        return randevular;
    }

    public ArrayList<Ziyaretlerim> getZiyaretlerim() {
        return ziyaretlerim;
    }

    public Hasta(long borc, String ad, String ePosta, Boolean isDead, Cinsiyet cinsiyet, String kanGrubu, String dogumYeri, LocalDate dogumTarihi, double kilo, double boy, String TC, String yasadigiSehir, String telNo, String sifre) {
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
        this.yasadigiSehir = yasadigiSehir;
        this.telNo = telNo;
        /*this.krediKarti = krediKarti;*/
        this.borc = borc;
        count++;
        this.Id = count;
        this.sifre = sifre;
    }


}
