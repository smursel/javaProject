import javax.swing.plaf.IconUIResource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Locale;

class Randevu{
    public Hastane hastane;
    public Klinik secilenKlinik;
    static private long Counter;
    public String randevuId;
    public LocalDate tarih;
    public LocalTime saat;
    public Randevu(){
        ++Counter;
        randevuId= Counter + "";


    }
}
class Ziyaretlerim extends Randevu{
public String hastalik;
public String recete;


public Ziyaretlerim(){
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
    private int Id;
    private static int count= 0;
    private long borc;
    private KrediKarti krediKarti;


    public Hasta(String ad, String soyad, String ePosta, Boolean isDead, Cinsiyet cinsiyet, KanGrubu kanGrubu, String dogumYeri, LocalDate dogumTarihi, double kilo, double boy, String TC, String yasadigiUlke, String telNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.ePosta = ePosta;
        this.isDead = isDead;
        this.cinsiyet = cinsiyet;
        this.kanGrubu = kanGrubu;
        this.dogumYeri = dogumYeri;
        this.dogumTarihi = dogumTarihi;
        this.kilo = kilo;
        this.boy = boy;
        this.TC = TC;
        this.yasadigiUlke = yasadigiUlke;
        this.telNo = telNo;
    }


}
