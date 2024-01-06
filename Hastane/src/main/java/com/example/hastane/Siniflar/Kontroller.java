package com.example.hastane.Siniflar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kontroller {
    public ArrayList<String> hatalar = new ArrayList<String>();

    public boolean gecerliTelefonNo(String telNo) {
        boolean isGecerli = true;
        if (telNo.length() != 10) {
            hatalar.add("Geçersiz numara uzunluğu");
            isGecerli = false;
        }
        if (!telNo.startsWith("5")) {
            hatalar.add("Numara 5 ile başlamalıdır");
            isGecerli = false;
        }
        return isGecerli;
    }

    public boolean gecerliSifre(String sifre) {
        boolean isGecerli = true;
        if (sifre.length() < 5) {
            hatalar.add("Sifre kısa");
            isGecerli = false;
        } else if (sifre.length() > 35) {
            hatalar.add("Şifre çok uzun");
            isGecerli = false;
        }

            Pattern ozelKarakterDeseni = Pattern.compile("[!@#\\$%\\^&\\*\\(\\)_\\+=\\-\\[\\]{}|;':\",./<>?~]");
            Pattern sayiDeseni = Pattern.compile("[0-9]");
            Pattern buyukHarfDeseni = Pattern.compile("[A-Z]");

            if (!ozelKarakterDeseni.matcher(sifre).find()) {
                hatalar.add("Özel karakter yok!");
                isGecerli = false;

            }
            if (!sayiDeseni.matcher(sifre).find()) {
                hatalar.add("Sayı yok!");
                isGecerli = false;

            }
            if (!buyukHarfDeseni.matcher(sifre).find()) {
                hatalar.add("Büyük harf yok!");
                isGecerli = false;

            }

        return isGecerli;

        }

        public boolean gecerliTC(String TC){
            boolean isGecerli = true;

            if(TC.length() != 11){
                hatalar.add("Geçersiz TC");
            isGecerli = false;
        }
            return isGecerli;
        }
    public boolean isEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            hatalar.add("Geçersiz mail");
            return false;
        }

        return matcher.matches();
    }

    public boolean adSoyadKontrol(String adSoyad){
        boolean isGecerli = true;

        if (!adSoyad.trim().contains(" ")){
            hatalar.add("AdSoyad girilmedi");
            isGecerli = false;
        }

        String[] adSoyadList = adSoyad.trim().split(" ");

        for (int i = 0;i < adSoyadList.length;i++ ){
            String s = adSoyadList[i];

            if(s.length() < 2){
                hatalar.add("Geçersiz isim");
                isGecerli = false;
                break;
            }
        }

        return isGecerli;
    }

    public boolean KanGrubuKontrol(String kanGrubu){
        boolean isGecerli = true;

        if(kanGrubu == null){
        hatalar.add("Bir kan grubu seçilmelidir!");
        isGecerli = false;
        }
        return isGecerli;
    }

    public boolean CinsiyetKontrol(String cinsiyet){
        boolean isGecerli = true;

        if(cinsiyet == null){
            hatalar.add("Bir cinsiyet seçilmelidir!");
            isGecerli = false;
        }

        return isGecerli;
    }

    public boolean dateTimeKontrol(LocalDate dogumTarihi) {
        boolean isGecerli = true;

        if (dogumTarihi == null) {
            hatalar.add("Doğum tarihi girilmelidir.");
            isGecerli = false;
        } else {
            LocalDate simdi = LocalDate.now();
            if (dogumTarihi.isAfter(simdi)) {
                hatalar.add("Doğum tarihi şu anki tarihten sonra olamaz.");
                isGecerli = false;
            }
        }

        return isGecerli;
    }
    public boolean kiloKontrol(String kilo) {
        if(kilo.isEmpty()){
            hatalar.add("Bir kilo girilmelidir!");
            return false;
        }
        kilo = kilo.trim().replace(",",".");

        try {
            double deger = Double.parseDouble(kilo);
            return true;

        } catch (NumberFormatException e) {
            hatalar.add("Kilo bir sayı olmalıdır");
            return false;

        }
    }
    public boolean boyKontrol(String boy) {
        if(boy.isEmpty()){
            hatalar.add("Bir boy girilmelidir!");
            return false;
        }
        boy = boy.trim().replace(",",".");
        try {
            double deger = Double.parseDouble(boy);
            return true;

        } catch (NumberFormatException e) {
            hatalar.add("Boy bir sayı olmalıdır");
            return false;

        }
    }

    public boolean SehirKontrol(String Sehir){
        if(Sehir.isEmpty()){
            hatalar.add("Şehir boş olamaz");
            return false;
        }
        return true;
    }

    }

