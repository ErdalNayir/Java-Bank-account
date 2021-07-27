package erdal_nayir_19360859049;

import java.math.BigInteger;
import java.util.ArrayList;



/**
 *
 * @author erdal
 */
public class BankaPersoneli extends Kisi{  // Banka Personeli oluşturma  (Kisi sinifindan miras alıyor)
    
    
    
    private int personelId = (int) (Math.random() * (99999 - 10000) + 10000);  //personel ID 99999 ile 10000 arası rastgele bir değer alıyor
    private ArrayList<Musteri> musteriler =new ArrayList<>(); // musterı nesnesı depolayan arraylİst

    public BankaPersoneli(String ad, String soyad, String email, BigInteger telefonNumarasi) {  // BankaPersoneli classının constructor u
        super(ad, soyad, email, telefonNumarasi);
    }

    @Override
    public String toString() { // toString metodu
        return "BankaPersoneli{" + "personelId=" + personelId + ", musteriler=" + musteriler + '}';
    }
    
    //GETTER VE SETTER METODLARI

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }

    public void setMusteriler(ArrayList<Musteri> musteriler) {
        this.musteriler = musteriler;
    }
    
    
}
