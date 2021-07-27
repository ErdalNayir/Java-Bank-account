package erdal_nayir_19360859049;


public class BankaHesabi { //Class oluşturma
    
    private int iban = (int) (Math.random() * (9999999 - 1000000) + 1000000);  // ibana, 9999999 ile 1000000 arası rastgele bir değer atanıyor
    private double bakiye;

    public BankaHesabi(double bakiye) { //Constructor
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {  //toString metodu
        return "BankaHesabi{" + "iban=" + iban + ", bakiye=" + bakiye + '}';
    }
    
    //GETTER VE SETTER METODLARI

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
    
    
}
