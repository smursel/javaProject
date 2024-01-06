package com.example.hastane.Siniflar;
import java.util.ArrayList;
import java.util.List;


public class Hastane {
    public String hastaneAdi;
    public String hastaneId;
    public String il;
    private static long Counter;
    public static ArrayList<String> klinikler = new ArrayList<String>(){
        {
            add("Kardiyoloji");
            add("Dermatoloji");
            add("Ortopedi");
            add("Göz Hastalıkları");
            add("Kulak Burun Boğaz");
            add("Nöroloji");
            add("Üroloji");
            add("Kadın Hastalıkları ve Doğum");
            add("Çocuk Sağlığı ve Hastalıkları");
            add("Genel Cerrahi");
            add("İç Hastalıkları");
            add("Radyoloji");
            add("Göğüs Hastalıkları");
            add("Plastik Cerrahi");
            add("Fizik Tedavi ve Rehabilitasyon");
            add("Enfeksiyon Hastalıkları");
            add("Gastroenteroloji");
            add("Göğüs Cerrahisi");
            add("Kadın Hastalıkları ve Doğum");
            add("Çocuk Cerrahisi");
            add("Çocuk Endokrinolojisi");
            add("Çocuk Enfeksiyon Hastalıkları");
            add("Çocuk Gastroenterolojisi");
            add("Çocuk Hematolojisi");
            add("Çocuk Kardiyolojisi");
            add("Çocuk Nefrolojisi");
            add("Çocuk Nörolojisi");
            add("Çocuk Psikiyatrisi");
            add("Çocuk Romatolojisi");
            add("Çocuk Sağlığı ve Hastalıkları");
            add("Çocuk Ürolojisi");
            add("Dermatoloji");
            add("Endokrinoloji ve Metabolizma Hastalıkları");
            add("Enfeksiyon Hastalıkları");
            add("Fiziksel Tıp ve Rehabilitasyon");
            add("Gastroenteroloji");
            add("Genel Cerrahi");
            add("Geriatri");
            add("Göğüs Cerrahisi");
            add("Göğüs Hastalıkları");
            add("Göz Hastalıkları");
            add("Hematoloji");
            add("İç");
    }}; // 50 tane klinik var
    public ArrayList<Hekim> hekimler = new ArrayList<Hekim>();

    public Hastane(String hastaneAdi,ArrayList<Hekim> hekimler){
        this.hastaneAdi = hastaneAdi;
        this.hekimler = hekimler;
        Counter++;
        hastaneId = Counter + "";
    }

}
