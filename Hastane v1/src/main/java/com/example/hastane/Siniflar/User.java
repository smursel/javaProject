package com.example.hastane.Siniflar;

import java.time.LocalDate;

enum Grup{
   A,
   B,
   AB,
   O
}
class KanGrubu{

   public Grup harf;

   boolean isRhPositive;
}

public abstract class User {
   public String ad;
   public String ePosta;
   public Boolean isDead;
   public Cinsiyet cinsiyet;
   public String kanGrubu;
   public String dogumYeri;
   public LocalDate dogumTarihi;
   public double kilo;
   public double boy;
   public String TC;
   public String yasadigiSehir;
   public String telNo;
   public String sifre;
}
