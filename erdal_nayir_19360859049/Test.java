package erdal_nayir_19360859049;

import java.math.BigInteger;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author erdal
 */

/*
ARAYUZDE KULLANILMAYAN METODLARIN KONSOLDA KULLANILMASI ICIN BU CLASSI CALISTIRIN!!! 
BU CLASS BIR NEVI KULLANICININ ARKA PLANDAKI METODLARLA ETKILESIME GECMESINI SAGLAYAN SINIFTIR.

*/


public class Test { 
    public static void main(String[] args) {
        
        
        
        
        BankaPersoneli Emre =new BankaPersoneli("Emre", "Nayir", "bahsjsjbanan9968@gmail.com", new BigInteger("5054716311")); // banka personeli oluşturuldu
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) { // oop oluşturuluyor

            System.out.println("1- Müşteri ekle\n"+
                               "2-çıkış\n"+
                               "3-Müşteri işlemleri\n");
            
            System.out.print("Ne yapmak istersiniz: ");
            
            
            int islem;
            
            islem =scanner.nextInt(); //ISLEM KULLANICIDAN ALINIYOR
            
            System.out.println("");
            
            scanner.nextLine();
            
            if(islem==1){ //KULLANICI EKLEME ISLEMI
                
                
                System.out.print("Ad: ");
                String isim = scanner.nextLine();
                
                
                
                System.out.print("Soyad: ");
                String soyad= scanner.nextLine();
                
                
                System.out.print("Email: ");
                String e_mail= scanner.nextLine();
                
               
                
                System.out.print("Telefon No: ");
                String telefon= scanner.nextLine();
                
             
                
                Musteri musteri= new Musteri(isim, soyad, e_mail, new BigInteger(telefon));
                
                Emre.getMusteriler().add(musteri);
                
                System.out.println("Müşteri eklendi\n");
                
                
                
            }
            
            else if(islem==2){ // PROGRAMDAN CIKIS ISLEMI
                
                System.out.println("Hoşçakalın..");
                break;
            }
            
            else if(islem==3){ // MUSTERI ISLEMLERI
                
                if(Emre.getMusteriler().size()>0){ //BANKA PERSONELINDE MUSTERI VAR MI DIYE KOSUL YAZILDI
                    
                    int i=1;
                ListIterator<Musteri> iterator = Emre.getMusteriler().listIterator(); //VAR OLAN TUM MUSTERILER KONSOLDA GOSTERILIYOR
                
                 while(iterator.hasNext()){
                 
                    Musteri musteri =iterator.next();
                
                     System.out.println(i+".Müşteri: ");
                     System.out.println("Ad: "+musteri.getAd());
                     System.out.println("Soyad: "+musteri.getSoyad());
                     System.out.println("Email: "+musteri.getEmail());
                     System.out.println("Telefon: "+musteri.getTelefonNumarasi());
                     System.out.println("\n");
               
                     i++;
            }
                System.out.print("İşlem yapmak istediğiniz Kişiyi seçiniz: ");  
                
                int kisi=scanner.nextInt();
                
                System.out.println("");
                
                 if (kisi<=Emre.getMusteriler().size() && kisi>0) {  //SECILEN NUMARANIN LISTEDE ARALIGINDA OLUP OLMADIGI KONTROL EDILIYOR
                     
                     kisi=kisi-1;
                     
                     //SECILEN MUSTERI ILE ILGILI YAPILABILECEK ISLEMLER
                     System.out.println("1.Banka hesabı ekle");
                     System.out.println("2.Banka hesabı sil");
                     System.out.println("3.Kredi kartı ekle");
                     System.out.println("4.Kredi kartı sil");
                     System.out.println("5.Para Transferi yap");
                     System.out.println("6.Kredi kardı borcu öde"); 
                     System.out.println("7.Yatırım Hesabına Para Ekle");
                     System.out.println("8.Yatırım Hesabından Para Çek");
                     System.out.println("0.Çıkış");
                     
                     System.out.print("Bu kişiyle ne işlemi yapmak istersiniz: ");
                     
                     int secenek = scanner.nextInt(); // ISLEM KULLANICIDAN ALINIYOR
                     System.out.println("");
                     
                     if(secenek==0){ //CIKIS YAPILIYOR
                         System.out.println("Çıkış yapıldı");
                     }
                     
                     else if(secenek==1){ // HESAP ACMA KOSULU
                            System.out.println("1. Vadesiz Hesap");
                            System.out.println("2.Yatırım hesabı");

                            System.out.println("");
                            System.out.print("Hangi tür hesap eklemek istiyorsunuz: ");
                     
                            int tur=scanner.nextInt(); // HESAP TURU KULLANICIDAN ALINIYOR
                            System.out.println("");
                     
                    switch (tur) {
                        case 1:
                            Emre.getMusteriler().get(kisi).hesapEkle("Vadesiz Hesap"); // VADESIS HESAP ACMA
                            break;
                        case 2:
                            Emre.getMusteriler().get(kisi).hesapEkle("Yatırım Hesabı"); //YATIRIM HESABI ACMA
                            break;
                        default:
                            System.out.println("Böyle bir hesap türü yoktur");
                            System.out.println("");
                            break;
                    }
                         
                    
                        
                     }
                    
                     else if (secenek==2){// HESAP SILME KOSULU
                         
                         Emre.getMusteriler().get(kisi).hesapSil();
                     }
                     
                     else if( secenek==3){ //KREDI KARTI EKLEME KOSULU
                         
                         Emre.getMusteriler().get(kisi).krediKartıEkle();
                     }
                     
                     else if(secenek==4){ //KREDI KARTI SILME KOSULU
                         
                         Emre.getMusteriler().get(kisi).krediKartiSil();
                         
                     }
                     else if(secenek==5){ //PARATRANSFERI KOSULU
                         
                         System.out.println("Kendi hesaplarınızdan birisine mi(1) yoksa başka birnin hesabına mı para aktaracaksınız(2)");
                         System.out.print("Lütfen seçiniz: ");
                         
                         int karar=scanner.nextInt();// KULLANICIDAN SECENEKLER ALINIYOR
                         System.out.println("");
                         
                         
                         if(karar==1){ // KISISEL HESAPLARDAN BIRINE TRANSFER KOSULU
                             
                             i=1;
                         //KISININ BANKA HESAPLARI BASILIYOR
                         ListIterator<BankaHesabi> iterHesaplar = Emre.getMusteriler().get(kisi).getHesaplar().listIterator();
             
                          while(iterHesaplar.hasNext()){
                 
                         BankaHesabi hesap =iterHesaplar.next();

                         System.out.println(i + ".Banka hesabınız: ");
                         System.out.println("");
                         System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                         System.out.println(i+".Banka hesabı iban: "+hesap.getBakiye());
                         System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                         System.out.println("\n");
                         i++;
                         
                            }
                          System.out.println("Sadece vadesiz hesaplar arası transfer olabilir.");
                          System.out.println("");
                          
                          System.out.println("Para transfer edecek olan hesabı seçiniz: ");
                          int transfer=scanner.nextInt(); //PARA TRANSFER EDECEK OLAN HESABIN LİSTEDEKİ KONUMU KULLANICIDAN ALINIYOR
                          
                          System.out.println("Paranın aktarılacağı Hesabı seçiniz: ");
                          int alici=scanner.nextInt();// PARAMIM TRANSFER EDİLECEGI HESAP KULLNICIDAN ALINIYOR
                          
                     
                          
                          if(transfer<=Emre.getMusteriler().get(kisi).getHesaplar().size() && transfer>0){ // TRANSFER EDEN HESABIN İNDEKSİNIN ARALIGI KONTROL EDILIYOR
                              if(alici<=Emre.getMusteriler().get(kisi).getHesaplar().size() && alici>0){ // ALICI HESABIN INDEKSININ ARALIGI KONTROL EDILIYOR
                                  if(transfer!=alici){ // ALICIYLA TRANSFER EDEN  AYNI OLAMAZ
                                  
                                      transfer=transfer-1;
                                      alici=alici-1;
                                
                                        VadesizHesap para =new  VadesizHesap(1000);
                                        
                                        System.out.println("Tutarı giriniz");
                                        
                                        int miktar=scanner.nextInt();//MIKTAR KULLANICIDAN ALINIYOR
                                
                                //ALINAN DEGERLER PARATRANSFERI METODUNA PARAMETRE OLARAK VERILIYOR
                             para.paraTransferi(Emre, Emre.getMusteriler().get(kisi), Emre.getMusteriler().get(kisi).getHesaplar().get(transfer), alici,1, miktar);
                                        
                                      
                                  
                                  }
                                   else{
                                        System.out.println("Aynı hesap seçilemez");
                                  }
                                  
                                 
                              }
                              else{
                                  System.out.println("Böyle bir hesap seçenekte yok");
                              }
                              
                              
                              
                          }
                          else{
                              System.out.println("Böyle bir hesap seçeneklerde yok");
                          }
                             
                         }
                         else if(karar==2){ // BIR BASKA BIRININ HESABINA PARA TRANSFERI
                             
                             i=1;
                             
                             ListIterator<Musteri> iter = Emre.getMusteriler().listIterator();
                     
                          //SISTEMDEKI KAYITLI KULLANICILAR LISTELENIYOR

                            while(iter.hasNext()){
                 
                            Musteri uye =iter.next();

                            System.out.println(i+".Müşteri: ");
                            System.out.println("Ad: "+uye.getAd());
                            System.out.println("Soyad: "+uye.getSoyad());
                            System.out.println("Email: "+uye.getEmail());
                            System.out.println("Telefon: "+uye.getTelefonNumarasi());
                            System.out.println("\n");
               
                            i++;
                        
                      }
                            
                             System.out.print("Para transfer etmek istediğiniz kişiyi seçiniz "+Emre.getMusteriler().get(kisi).getAd()+" bey: ");
                             
                             int hedef =scanner.nextInt(); // PARA TRANSFER EDILMEK ISTENEN KULLANICI SECILIYOR
                             System.out.println("");
                             
                             if(hedef<= Emre.getMusteriler().size() && hedef>0){ //HEDEF BIREYIN INDEKSININ DOGRU ARALIKTA OLUP OLMADIGI KONTROL EDILIYOR
                                 
                                 if(!Emre.getMusteriler().get(kisi).getAd().equals(Emre.getMusteriler().get(hedef-1).getAd())){ //GONDEREN HESAP SAHIBI ILE ALICI HESAP SAHIBIN ISIMLERININ AYNI OLMAMASI LAZIM NE DE OLSA BOYLE BIR SECENEKTE KISI KENDISINE PARA GONDEREMEZ
                                     
                                     VadesizHesap para =new  VadesizHesap(1000); // VADESIZ HESAPTAKI FONKSIYONU KULLANABILMEK ICIN VADESIZ HESAPTAN NESNE OLUSTURULUYOR
                                 
                                     
                                    i=1;
                         
                                    ListIterator<BankaHesabi> iterHesaplar = Emre.getMusteriler().get(kisi).getHesaplar().listIterator();
             
                                    while(iterHesaplar.hasNext()){ // GONDEREN KISININ HESAPLARI LISTELENIYOR

                                    BankaHesabi hesap =iterHesaplar.next();

                                    System.out.println(i + ".Banka hesabınız: ");
                                    System.out.println("");
                                    System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                                    System.out.println(i+".Banka hesabı iban: "+hesap.getBakiye());
                                    System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                                    System.out.println("\n");
                                    i++;
                                    
                                    }
                                    
                                    System.out.print("hangi hesabınızdan para transfer etmek istersiniz: ");
                                    int hesabınız=scanner.nextInt(); // HESAP INDEKSI KULLANICIDAN ALINIYOR 
                                     System.out.println("");
                                        
                                        if(hesabınız<=Emre.getMusteriler().get(kisi).getHesaplar().size() && hesabınız>0){ // INDEKSIN DOGRU ARALIKTA OLUP OLMADIGI KONTROL EDILIYOR
                                            
                                            if(Emre.getMusteriler().get(kisi).getHesaplar().get(hesabınız-1).toString().equals("Vadesiz Hesap")){ // HESABIN VADESIZ HESAP OLUP OLMADIGI KONTROL EDILIYOR (HESAP VADESIZ OLMALI)
                                                
                                                System.out.println("Transfer etmek istediğiniz tutarı giriniz: ");
                                                int liras = scanner.nextInt();// KULLANICIDAN MIKTAR ALINIYOR
                                                 //PARA TRANSFER METODUNA  ALINAN DEGERLER PARAMETRE OLARAK GONDERILIYOR.
                                                para.paraTransferi(Emre, Emre.getMusteriler().get(kisi), Emre.getMusteriler().get(kisi).getHesaplar().get(hesabınız-1), hedef,2, liras);
                                                
                                            }
                                            else{
                                                
                                                  System.out.println("Sadece Vadesiz hesaplar arasında para transferi yapılabilir.");
                                            }
                                            
                                          
                                        
                                        }
                                        else{
                                            
                                              System.out.println("Böyle bir hesap bulunmamakta");
                                        }
                             
                                 
                                 
                                  
                                     
                                 }
                                 else{
                                     System.out.println("Kendinizi seçemezsiniz");
                                 }
                                 
                                 
                                 
                             }
                             else{
                                 System.out.println("Böyle biri yok");
                             }
                             
                         }
                         else{
                             System.out.println("Böyle bir işlem bulunmamaktadır.");
                                     
                         }
                          
                     }
                     else if(secenek==6){// KERDI KARTI BORC ODEME KOSULU
                         
                         VadesizHesap vade =new VadesizHesap(10);
                         
                         vade.krediKartiBorcOdeme(Emre.getMusteriler().get(kisi));
                     }
                     else if(secenek==7){ // PARA EKLEME KOSULU
                         
                         YatirimHesabi yatirim = new YatirimHesabi(100);
                         
                         yatirim.paraEkle(Emre.getMusteriler().get(kisi));
                     }
                     else if(secenek==8){ //PARA CEKLEM KOSULU
                         
                         YatirimHesabi yatirim = new YatirimHesabi(100);
                         
                         yatirim.paraCek(Emre.getMusteriler().get(kisi),Emre);
                         
                     }
                     else{
                         System.out.println("Böyle bir işlem Yok!\n");
                     }
                    
                }
                 else{
                     System.out.println("Böyle bir kişi yok");
                 }
                    
                    
                }
                else{
                    System.out.println("Hiç müşteri yok");
                }
                
                
                 
            }
            else{
                System.out.println("Böyle bir işlem gerçekleştirilemez");
            }
            
           
        }
        
    }
}
