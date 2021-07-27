package erdal_nayir_19360859049;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
/**
 *
 * @author erdal
 */
public class Musteri extends Kisi{ //CLASS OLUSTURM
    
    private int musteriNumarasi =(int) (Math.random() * (9999 - 1000) + 1000); //MUSTERINUMARASI 9999 ILE 1000 ARASI BIR DEGER ALIYOR
    private ArrayList<BankaHesabi> hesaplar =new ArrayList<>(); // MUSTERININ BANKA HESAPLARINI DEPOLAYAN ARRAYLIST
    private ArrayList<KrediKarti> krediKartlari =new ArrayList<>(); //MUSTERININ KREDIKARTLARINI DEPOLAYAN ARRAYLIST

    public Musteri(String ad, String soyad, String email, BigInteger telefonNumarasi) { //CONSTRUCTOR
        super(ad, soyad, email, telefonNumarasi);
    }
    @Override
    public String toString() {  //TOSTRING METODU
        return "Musteri{" + "musteriNumarasi=" + musteriNumarasi + ", hesaplar=" + hesaplar + ", krediKartlari=" + krediKartlari + '}';
    }

    //GETTER VE SETTER METODLARI
    public int getMusteriNumarasi() {
        return musteriNumarasi;
    }

    public void setMusteriNumarasi(int musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }

    public ArrayList<BankaHesabi> getHesaplar() {
        return hesaplar;
    }

    public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
        this.hesaplar = hesaplar;
    }

    public ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }

    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
        this.krediKartlari = krediKartlari;
    }
    
    public void hesapEkle(String hesapTür){ //HESAPLEKLE FONKSIYONU
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Hesap oluşturmaya hoşgeldiniz "+this.getAd()+" "+this.getSoyad());
        System.out.println("");
       
        if(hesapTür.equals("Vadesiz Hesap")){
            System.out.println("Vadesiz Banka hesabınız oluşturuluyor...");
            System.out.println("");
            System.out.println("Hesabı açmak yeni hesabınıza para yüklemeniz gerekiyor");
            System.out.println("");
            System.out.print("Yüklenecek Bakiyeyi Giriniz: ");
            
            double ilk_bakiye = scanner.nextInt(); // HESABIN ACILMASI ICIN GEREKEN ILK MIKTAR
            
            if (ilk_bakiye>0.0){// BAKIYE SIFIRDAN BUYUK OLURSA HESAP OLUSTURULUYO
                
                System.out.println("");
                VadesizHesap vadesiz = new VadesizHesap(ilk_bakiye);
            
                this.hesaplar.add(vadesiz);
            
                System.out.println("");
                System.out.println("Hesap oluşturuldu"); 
                
            }
            
            else{ // 0 DAN KUCUKSE OLUTURULAMIYOR
                System.out.println("Yükleyeceğiniz bakiye 0 ya da negatif sayı olamaz.");
            }
              
        } 
        else if(hesapTür.equals("Yatırım Hesabı")){
            System.out.println("Yatırım banka hesabınız oluşturuluyor...");
            System.out.println("");
            System.out.println("Hesabı açmak yeni hesabınıza para yüklemeniz gerekiyor");
            System.out.println("");
            System.out.print("Yüklenecek Bakiyeyi Giriniz: ");
            
            double ilk_bakiye = scanner.nextInt(); // ILK BAKIYE 
            
            if (ilk_bakiye>0.0){ //AYNI ISLEMLER TEKRARLANIYOR
                
                System.out.println("");
                YatirimHesabi yatirim = new YatirimHesabi(ilk_bakiye);
            
            
                this.hesaplar.add(yatirim);
            
                System.out.println("");
                System.out.println("Hesap oluşturuldu");
                
            }
            
            else{
                System.out.println("Yükleyeceğiniz bakiye 0 ya da negatif sayı olamaz.");
            }
            
        } 
        else{//VADESİZ VE YA YATIRIM HESABINDAN FARKLI BIR SEY GIRILIMIS ISE HESAP ACILAMIYOR.
            System.out.println("Açmak istediğiniz banka hesabı türü sistemimizde bulunmamaktadır.");
            System.out.println("Lütfen Tekrar deneyiniz.");
        }          
    } 
    public void krediKartıEkle(){
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Banka hesabına kredi kartı ekleme talebiniz alındı "+this.getAd()+" bey.");
        System.out.println("Gireceğiniz bilgilerin doğruluğu ilerde yapacağınız işlemler için çok önemlidir.");
        System.out.println("");
        
        System.out.print("Lütfen eklemek istediğiniz kredi kartınızın limitini giriniz: ");
        
        double limit =scanner.nextInt(); //KARTIN LIMITI ALINIYOR
        
        System.out.println("");
        System.out.print("Lütfen eklemek istediğiniz kredi kartınızın güncel borcunu giriniz: ");
        
        double borc =scanner.nextInt(); //KARTIN GUNCEL BORCU ALINIYOR
        
        if(limit-borc<=0){ //LIMIT-BORC <=0 ISE HESAP ACILAMIYOR
            System.out.println("Güncel borcu limitinden yüksek olan kartlar banka hesabına eklenemez");
            
        }
        else if(limit-borc>0){ //LIMIT-BORC>0 ISE HESAP ACILIYOR
            
            KrediKarti kredi =new KrediKarti(limit, borc);
            
            this.krediKartlari.add(kredi);
            System.out.println("");
            System.out.println("Kredi kartınız hesabınıza eklendi.");
        }      
    }
    
    public void hesapSil(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Banka hesabı sildirme işlemleri.");
        System.out.println("");
        
        int i =1;
        
        if (this.hesaplar.isEmpty()){ // ONCE KULLANICININ HESABININ OLUP OLMADIGINA BAKILIYOR EGER YOK ISE ISLEM GERCEKLESTIRILEMIYOR
            
            System.out.println("Hiç Banka hesabınız bulunmamaktadır.");
        }
        else{ // KULLANICIN EN AZ 1 DEN FAZLA HESABI VAR ISE
            
             ListIterator<BankaHesabi> iterator = this.hesaplar.listIterator(); // LISTITERATOR YAPISI ILE ARRAYLIST ICINDEKI HER ELEMENT TEK TEK CEKILIP BILGILER BASTIRILIYOR 
             
             while(iterator.hasNext()){ // EGER KULLANICININ BANKA HESABI ARRAYLISTI ICINDE NESNE VARSA BU DONGU CALISMAYA DEVAM EDECEK
                 
               BankaHesabi hesap =iterator.next(); // ILE BIR SONRAKI NESNE KULLANILIYOR
               
                System.out.println(i + ".Banka hesabınız: ");
                System.out.println("");
                System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                System.out.println(i+".Banka hesabı iban: "+hesap.getBakiye());
                System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                System.out.println("\n");
                i++;
            }
             
             
            System.out.print("Hangi hesabınızı sildirtmek istersiniz ? : ");
            // BURDA SIRAYLA BASTIRILAN HESAPLARA SIRAYLA ARDISIK SAYILAR VERILIYOR BU SAYIYA GORE KULLANICI SILMEK ISTEDIGI HESABINI SECIYOR
            int indeks;
            
            indeks= scanner.nextInt(); //SILMEK ISTEDI HESABIN SIRA NUMARASI KULLANICIDAN ALINIYOR
            
            if(indeks<=this.hesaplar.size() && indeks>0){ //ALINAN NUMARA ARRAYLISTIN SINRLARI ICINDE MI KONTROL EDILIYOR BU SART SSAGLANIR ISE ALTTAKI ISLEMLER GERCEKLESIYOR
                
                indeks=indeks-1; //JAVADA ELEMENTLER 0 DAN BASLANARAK NUMARALANDIGINDAN 1 CIKARTILIYOR YANI KULLANICI 1.SIRADAKI HESABI SECTIYSE BU ARRAYLISTE 0. INDEKSE DENK GELIYOR
                
                this.hesaplar.get(indeks);
                
                if(this.hesaplar.get(indeks).getBakiye()>0){ //HESABIN YUKLU PARASI VAR MI KONTROL EDILIYOR 
                    
                    System.out.println("Silmek istediğiniz hesapta para bulunmaktadır.");
                    System.out.println("Lütfen önce hesaptaki parayı başka hesaba aktarınız.");
                    
                }
                else if (this.hesaplar.get(indeks).getBakiye()==0.0){ //EGER SECTIGI HESABIN PARASI YOKSA HESAP SILINIYOR
                    
                    this.hesaplar.remove(indeks);
                    System.out.println("");
                    System.out.println("Seçtiğiniz banka hesabınız silinmiştir "+this.getAd()+" "+this.getSoyad());
                }
               
            }
            else{
                System.out.println("Yanlış aralıkta sayı girdiniz.");
            }
            
            
        }
    }
    
    public void krediKartiSil(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Kredi kartı sildirme işlemleri.");
        System.out.println("");
        
        int i =1;
        
        if (this.krediKartlari.isEmpty()){ //ONCE KULLANICININ KREDI KARI OLUP OLMADIGINA BAKILIYOR EGER YOK ISE ISLEM GERCEKLESTIRILEMIYOR
            
            System.out.println("Hiç kredi kartınız bulunmamaktadır.");
        }
        else{
            
             ListIterator<KrediKarti> iterator = this.krediKartlari.listIterator(); //BIR ONCEKI KISIMDA ANLATILAN AYNI ISLEM GERCEKLESTIRILIYOR
             
             while(iterator.hasNext()){
                 
               KrediKarti kredi =iterator.next();
               
                System.out.println(i + ".Kredi kartınız: ");
                System.out.println("");
                System.out.println(i+".Kredi kartı Numarası: "+kredi.getKartNumarasi());
                System.out.println(i+".Kredi kartı limti: "+kredi.getLimit());
                System.out.println(i+".Kredi kartı güncel borcu: "+kredi.getGuncelBorc());
                System.out.println(i+".Kredi kartı kullanılabilir limiti: "+kredi.getKullanilabilirLimit());
                System.out.println("\n");
                i++;
            }
             
            System.out.print("Hangi kredi kartınızı sildirtmek istersiniz ? : ");
            
            int indeks;
            
            indeks= scanner.nextInt(); //SILDIRMEK ISTEDI KERDI KARTI KULLANICIDAN ALINIYOR
            
            if(indeks<=this.krediKartlari.size() && indeks>0){ //ARALIK KONTROL ETME
                
                indeks=indeks-1; //ONCEKI METODAKI AYNI OLAY
                
                this.krediKartlari.get(indeks);
                
                if(this.krediKartlari.get(indeks).getGuncelBorc()>0){ //KARTIN GUNCEL BORCU VARSA KART SILINEMIYOR
                    
                    System.out.println("Silmek istediğiniz kredi kartının borcu bulunmaktadır");
                    System.out.println("Lütfen kartı silmeden önce borcunu ödeyiniz..");
                    
                }
                else if (this.krediKartlari.get(indeks).getGuncelBorc()==0.0){ //GUNCEL BORC SIFIR ISE KART SILINIYOR
                    
                    this.krediKartlari.remove(indeks);
                    System.out.println("");
                    System.out.println("Seçtiğiniz kredi kartı silinmiştir "+this.getAd()+" "+ this.getSoyad());
                }
               
            }
            else{
                System.out.println("Yanlış aralıkta sayı girdiniz.");
            }
            
            
        }
        
        
        
    }
    
}
