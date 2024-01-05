import java.util.ArrayList;
import java.util.List;


public class Hastane {
    public String hastaneAdi;
    public static ArrayList<Klinik> klinikler = new ArrayList<Klinik>();
    public ArrayList<Hekim> hekimler = new ArrayList<Hekim>();

    public Hastane(String hastaneAdi,ArrayList<Hekim> hekimler){
        this.hastaneAdi = hastaneAdi;
        this.hekimler = hekimler;
    }

}
