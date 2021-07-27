package erdal_nayir_19360859049;

import java.util.ListIterator;
import java.util.Scanner;

public class VadesizHesap extends BankaHesabi{ //CLASS OLUSTURMA
    
       private String hesapTuru = "Vadesiz Hesap";

    public VadesizHesap(double bakiye) { //CONSTRUCCTOR
        super(bakiye);
    }

    @Override
    public String toString() { //TOSTRING METODU
         return hesapTuru ;
    }

    //GETTER VE SETTER METODLARI
    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }
    
    double par= getBakiye();
    
  
    public  void paraTransferi(BankaPersoneli personel, Musteri musteri,BankaHesabi bankahesap ,int indeks,int islem, int tutar){
        
        System.out.println("Para transferi işlemleri.");
        System.out.println("");
        
        if(islem==1){ // BU KOSUL PARANIN KISISEL HESAPLAR DA MI YOKSA BIR BIREYDEN BASKA BIREYE MI PARA TRANSFERI OLACAGINI KONTROL EDIYR(1== KISISEL)
            
                System.out.println("Banka Hesapları arası para transferi");
                System.out.println("");
                
            if(indeks<=musteri.getHesaplar().size()){ //TRANSFERIN YAPILACAGI HESABIN INDEKSININ DORU ARALIKTA OLUP OLMADIGI KORTROL EDILIYOR
            
                if (bankahesap.getBakiye()>0){ //PARA GONDEREN HESABIN BAKIYESI KONTROL EDILIYOR
                
                
                
               if (musteri.getHesaplar().get(indeks).toString().equals("Vadesiz Hesap") && bankahesap.toString().equals("Vadesiz Hesap")){ //VADESIZDEN VADESIZE PARA GONDERILEBILIR
                   
                   if(tutar<= bankahesap.getBakiye()){ //GONDERILECEK TUTAR BAKIYEYE ESIT YADA KUCUK OLMALI
                       
                       musteri.getHesaplar().get(indeks).setBakiye(musteri.getHesaplar().get(indeks).getBakiye()+tutar);
                       
                       bankahesap.setBakiye(bankahesap.getBakiye()-tutar);
                       System.out.println("Transfer tamamlandı.");
                       
                   }
                   else{
                       
                       System.out.println("Göndermek istediğiniz para gönderici hesabın bakiyesine eşit yada düşük olmalı.");
                   }
                   
               }
               else{
                   System.out.println("Sadece vadesiz hesaplar arası  para transfer edebilirsiniz.");
               }
                
            }
            else{
                System.out.println("Bu hesabın bakiyesi 0 lütfen başka hesap seçiniz.");
            }
            }
            else{
                System.out.println("Bu seçtiğiniz numarada banka hesabı bulunamadı.");
            }
            
        }
        if(islem==2){
            
            int i =1;
            
            Scanner scanner = new Scanner(System.in);
            
            
            
             if(indeks<=personel.getMusteriler().size() && indeks>0){
                 
                 if(bankahesap.getBakiye()>0){
                     
                     //SECILEN KISININ BANKA HESAPLARI LISTELENIYOR
                     
                     indeks=indeks-1;
                     
                     ListIterator<BankaHesabi> iterator = personel.getMusteriler().get(indeks).getHesaplar().listIterator();
                     
                     System.out.println("Seçtiğiniz kişinin banka hesapları: ");
                     
                     while(iterator.hasNext()){
                 
                        BankaHesabi hesap =iterator.next();
               
                        System.out.println(i + ".Banka hesabı: ");
                        System.out.println("");
                        System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                        System.out.println(i+".Banka hesabı bakiye: "+hesap.getBakiye());
                        System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                        System.out.println("\n");
                        i++;
                        
                      }
                     
                     
                     
                     int bankaHesap;
                     System.out.print("Para transfer etmek istediğiniz hesap:  ");
                     
                     bankaHesap=scanner.nextInt(); // KULLANICIDAN PARAYI GONDERMEK ISTEDIGI KISNIN HESAPLARINDAN BIRININ SECMESI ISTENIYOR
                     System.out.println("");
                     
                     if(bankaHesap<=personel.getMusteriler().get(indeks).getHesaplar().size() && bankaHesap>0){ // INDEKSIN DOGRU ARALIKTA OLUP OLMADIGI KONTROLU
                         
                         bankaHesap=bankaHesap-1;
                         
                         if (personel.getMusteriler().get(indeks).getHesaplar().get(bankaHesap).toString().equals("Vadesiz Hesap") && bankahesap.toString().equals("Vadesiz Hesap")){//VADESIZ OLMALILAR
                             
                             if(tutar<= bankahesap.getBakiye()){
                       
                                personel.getMusteriler().get(indeks).getHesaplar().get(bankaHesap).setBakiye(
                                                                     personel.getMusteriler().get(indeks).getHesaplar().get(bankaHesap).getBakiye()+tutar);

                                bankahesap.setBakiye(bankahesap.getBakiye()-tutar);  // TRANSFER YAPILDI
                                 System.out.println("Transfer tamamlandı.");
                       
                            }
                             else{
                                 
                                 System.out.println("Gönderilecek tutarın bakiyenize eşit ya da daha düşük olmalıdır.");
                             }
                             
                         }
                         else{
                             
                             System.out.println("Sadece vadesiz bir hesaba para aktarabilirsiniz");
                         }
                         
                     }
                     else{
                         
                         System.out.println("Bu seçtiğiniz müşterinin böyle bir hesabı bulunmamaktadır");
                     }
                     
                     
                 }
                 else{
                     System.out.println("Bu hesabın bakiyesi 0 lütfen başka hesap seçiniz.");
                 }
                 
             }
             else{
                 
                 System.out.println("Bu numaradaki bir kişi bulunamadı.");
             }
            
            
        }
        
    }
    
    public void krediKartiBorcOdeme(Musteri musteri){ // BORC ODEME
        
        Scanner scanner = new Scanner(System.in);
        
        int i=1;
        
         ListIterator<KrediKarti> iterator = musteri.getKrediKartlari().listIterator();
             
             while(iterator.hasNext()){
                 
               KrediKarti kredi =iterator.next();
               //KULLANICIN KARTLARI EKRANA BASILIYOR
                System.out.println(i + ".Kredi kartınız: ");
                System.out.println("");
                System.out.println(i+".Kredi kartı Numarası: "+kredi.getKartNumarasi());
                System.out.println(i+".Kredi kartı limti: "+kredi.getLimit());
                System.out.println(i+".Kredi kartı güncel borcu: "+kredi.getGuncelBorc());
                System.out.println(i+".Kredi kartı kullanılabilir limiti: "+kredi.getKullanilabilirLimit());
                System.out.println("\n");
                i++;
            }
             System.out.print("Borcunu ödemek istediğiniz kardı seçiniz: ");
             int kartNo = scanner.nextInt(); // BORCUNU ODEMEK ISTEDIGI KARDIN INDEKSI KULLANICIDAN ALINIYOR
             System.out.println("");
             
             if(kartNo<=musteri.getKrediKartlari().size() && kartNo>0){ // INDEKSIN DOGRU ARALIKTA OLUP OLMAMA KONTROLU
                 
                 kartNo=kartNo-1;
                 
                 i=1;
                 
                ListIterator<BankaHesabi> hesapiterator = musteri.getHesaplar().listIterator();
             
                while(hesapiterator.hasNext()){
                 // KULLANICININ BANKA HESAPLARI LISTELENIYOR
                BankaHesabi hesap =hesapiterator.next();
               
                System.out.println(i + ".Banka hesabınız: ");
                System.out.println("");
                System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                System.out.println(i+".Banka hesabı iban: "+hesap.getBakiye());
                System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                System.out.println("\n");
                i++;
            }
                
                 System.out.print("Borcunuzu hangi hesabınızla ödemek istersiniz?(Sadece vadesiz hesap seçebilirsiniz): ");
                 
                 int odeyecekHesap=scanner.nextInt(); //KULLANICIDAN BORCU HANGI HESAPLA ODEMEK ISTEDIGI SORULUP KULLANICIDAN INPUT OLARAK ALINIYOR
                 System.out.println("");
                 
                 if(odeyecekHesap<= musteri.getHesaplar().size() && odeyecekHesap>0){ // HESAP INDEKSININ DOGRU ARALIKTA OLUP OLMADIGI KONTROL EDILIYOR
                     
                     odeyecekHesap=odeyecekHesap-1;
                     
                     if(musteri.getHesaplar().get(odeyecekHesap).getBakiye()>=musteri.getKrediKartlari().get(kartNo).getGuncelBorc()){ // HESAP BAKIYESI BORCTAN YUKSEK OLMALI
                         
                         if(musteri.getHesaplar().get(odeyecekHesap).toString().equals("Vadesiz Hesap")){ // BORCU ODEYECEK HESAP VADESIZ OLMALI
                             
                  musteri.getHesaplar().get(odeyecekHesap).setBakiye(musteri.getHesaplar().get(odeyecekHesap).getBakiye()-musteri.getKrediKartlari().get(kartNo).getGuncelBorc()); // HESAPTAN GUNCEL BORC KADAR PARA CEKILIYOR
                  musteri.getKrediKartlari().get(kartNo).setKullanilabilirLimit(musteri.getKrediKartlari().get(kartNo).getKullanilabilirLimit()+musteri.getKrediKartlari().get(kartNo).getGuncelBorc()); //KULLANILABILIR LIMIT BORC KADAR YUKSELTILIYOR
                  musteri.getKrediKartlari().get(kartNo).setGuncelBorc(0); // GUNCEL BORC SIFIRLANIYOR
               
                             System.out.println("Kart borcunuz ödendi.\n");
                             
                         }
                         else{
                             System.out.println("Sadece vadesiz hesaplarla borç ödemesi yapabilirsiniz.\n");
                         }
                         
                         
                     }
                     else{
                         System.out.println("Hesabınızdaki paranın kredi kartınızdaki borca eşit ya da daha yüksek olmalı.\n");
                     }
                     
                 }
                 else{
                     System.out.println("Böyle bir hesap listede yok");
                     System.out.println("");
                 }
             }
             else{
                 System.out.println("Bu kart listede yok!");
                 System.out.println("");
             }
             
    }
       
}
