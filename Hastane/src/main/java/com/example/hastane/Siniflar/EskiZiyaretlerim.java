package com.example.hastane.Siniflar;
import java.time.LocalDate;

public class EskiZiyaretlerim {
    private LocalDate tarihCol;
    private String hastaneCol;
    private String hekimCol;
    private String ilacCol;
    private String kullanimSekliCol;
    private String dozCol;
    private String kacGunCol;

    public EskiZiyaretlerim(LocalDate tarih, String hastane, String hekim, String ilacAdi, String kullanımSekli, String gunlukDoz, String kacGun){
        this.tarihCol = tarih;
        this.hastaneCol = hastane;
        this.hekimCol = hekim;
        this.ilacCol = ilacAdi;
        this.kullanimSekliCol = kullanımSekli;
        this.dozCol = gunlukDoz;
        this.kacGunCol = kacGun;
    }

    public String getHastaneCol() {
        return hastaneCol;
    }

    public String getHekimCol() {
        return hekimCol;
    }

    public String getIlacCol() {
        return ilacCol;
    }

    public String getKullanimSekliCol() {
        return kullanimSekliCol;
    }

    public String getDozCol() {
        return dozCol;
    }

    public String getKacGunCol() {
        return kacGunCol;
    }

    public LocalDate getTarihCol() {
        return tarihCol;
    }
}
