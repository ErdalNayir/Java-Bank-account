package erdal_nayir_19360859049;

import java.math.BigInteger;

/**
 *
 * @author erdal
 */
public class Kisi {   //Kisi classı oluşturma 
    
    private String ad;
    private String soyad;
    private String email;
    private BigInteger telefonNumarasi;

    public Kisi(String ad, String soyad, String email, BigInteger telefonNumarasi) {  //Constructor oluşturma
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    @Override
    public String toString() {  // tostring fonksiyonu oluşturma
        return "Kisi{" + "ad=" + ad + ", soyad=" + soyad + ", email=" + email + ", telefonNumarasi=" + telefonNumarasi + '}';
    }
    
    //GETTER VE SETTER FONKSİYONLARI

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(BigInteger telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    
   
    
}
