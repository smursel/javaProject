package com.example.hastane.Siniflar;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HastaYonetimi implements Yonetim {
    public Hasta hastaBul(String id){
        return (Hasta)KullaniciBul(id);
    }
    @Override
    public Object KullaniciBul(String id) {
        return App.hastalar.stream().filter(c-> c.getId() == Integer.parseInt(id));
    }

    public void hastaYarat(Hasta hasta){
        Yarat(hasta);
    }
    @Override
    public void Yarat(Object kullanici) {
        App.hastalar.add((Hasta) kullanici );
    }

    @Override
    public void KullaniciGuncelle(String mevcutKullaniciId, Object KullaniciYeniHali) {
        int id = Integer.parseInt(mevcutKullaniciId);
        Hasta guncellenmisHasta = (Hasta) KullaniciYeniHali;

        var mevcutHasta =hastaBul(mevcutKullaniciId);
        mevcutHasta = guncellenmisHasta;
    }

        @Override
    public void KullaniciSil(String id) {
        var hasta = hastaBul(id);
        App.hastalar.remove(hasta);
    }

}
