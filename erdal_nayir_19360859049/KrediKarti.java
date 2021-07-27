package erdal_nayir_19360859049;

/**
 *
 * @author erdal
 */
public class KrediKarti { //Class oluşturma
    
    private int kartNumarasi = (int) (Math.random() * (999999 - 100000) + 100000); // kartNumarasi, 999999 ile 100000 arası rastgele bir değer alıyor.
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    public KrediKarti(double limit, double guncelBorc) { //constructor
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        
         this.kullanilabilirLimit= this.limit - this.guncelBorc;  // limit ve guncelBorc a göre kullanılabilirLimit oluşturuluyor
    }

    @Override
    public String toString() { //tosting metodu
        return "KrediKarti{" + "kartNumarasi=" + kartNumarasi + ", limit=" + limit + ", guncelBorc=" + guncelBorc + ", kullanilabilirLimit=" + kullanilabilirLimit + '}';
    }

    //GETTER VE SETTER METODLARI
    
    public int getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(int kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getGuncelBorc() {
        return guncelBorc;
    }

    public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
    }

    public double getKullanilabilirLimit() {
        return kullanilabilirLimit;
    }

    public void setKullanilabilirLimit(double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
    }
    
    
    
}
