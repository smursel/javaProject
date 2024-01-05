import java.time.LocalDate;

enum Cinsiyet {
   ERKEK(0),
   KADIN(1);

   private final int deger;

   Cinsiyet(int deger) {
      this.deger = deger;
   }

   public int getDeger() {
      return deger;
   }
}

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
   public String soyad;
   public   String ePosta;
   public   Boolean isDead;
   public Cinsiyet cinsiyet;
   public KanGrubu kanGrubu;
   public String dogumYeri;
   public LocalDate dogumTarihi;
   public double kilo;
   public double boy;
   public String TC;
   public String yasadigiUlke;
   public String telNo;
}
