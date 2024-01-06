package com.example.hastane.Siniflar;

public interface Yonetim {

    Object KullaniciBul(String id);
    void Yarat(Object kullanici);
    void KullaniciGuncelle(String mevcutKullaniciId ,Object KullaniciYeniHali);
    void KullaniciSil(String id);

}
