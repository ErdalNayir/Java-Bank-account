package erdal_nayir_19360859049;

import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author erdal
 */
public class YatirimHesabi extends BankaHesabi{
    
    private String hesapTuru = "Yatırım Hesabı";

    public YatirimHesabi(double bakiye) { //CONSTRUCTOR
        super(bakiye);
    }

    @Override
    public String toString() { //TOSTRING METODU
        return hesapTuru;
    }
   
     //GETTER VE SETTER METODU
    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }
    
    public  void paraEkle(Musteri musteri){
        
        Scanner scanner = new Scanner(System.in);
        
        int i =1;
        
        
        ListIterator<BankaHesabi> iterator = musteri.getHesaplar().listIterator();
        
        while(iterator.hasNext()){
                 //MUSTERININ HESAPLARI LISTELENIYOR
                        BankaHesabi hesap =iterator.next();
               
                        System.out.println(i + ".Banka hesabı: ");
                        System.out.println("");
                        System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                        System.out.println(i+".Banka hesabı bakiye: "+hesap.getBakiye());
                        System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                        System.out.println("\n");
                        i++;
                        
                      }
        System.out.print("Para eklemek istediğiniz Yatırım hesabını seçiniz: ");
        
        int yatirimHesabi = scanner.nextInt(); // YAITIM HESABI INDEKSI KULLANICDAN ALINIYOR
        System.out.println("");
        
        if(yatirimHesabi<=musteri.getHesaplar().size() && yatirimHesabi>0){//ARALIK KONTROLU
            
            yatirimHesabi=yatirimHesabi-1;
            
            if(musteri.getHesaplar().get(yatirimHesabi).toString().equals("Yatırım Hesabı")){ //SECILEN HESAP YATIRIM HESABI OLMALI
                
                System.out.print("Yatırmak istediğiniz tutarı giriniz: ");
                
                int yatirimMiktar = scanner.nextInt();//TUTAT KULLANICIDAN ALINIYOR
                System.out.println("");
                
                if(yatirimMiktar>0){ //YATIRILMAK ISTENILEN TUTAR 0 DAN BUYUK OLMALI
                    
                    musteri.getHesaplar().get(yatirimHesabi).setBakiye(musteri.getHesaplar().get(yatirimHesabi).getBakiye()+yatirimMiktar); //PARA HESABA EKLENDI
                    System.out.println("Para hesabınıza eklendi\n");
                    
                }
                else{
                    System.out.println("Para miktarı 0 dan büyük olmalı\n");
                }
            }
            else{
                System.out.println("Sadece yatırım hesabı seçebilirsiniz.\n");
            }
        }
        else{
            System.out.println("Böyle bir hesap listede bulunmamakta\n");
        }
        
        
    }
    
    public void paraCek(Musteri musteri,BankaPersoneli personel){
        
        Scanner scanner = new Scanner(System.in);
        
        int i =1;
        
        
        ListIterator<BankaHesabi> iterator = musteri.getHesaplar().listIterator();
        
        while(iterator.hasNext()){
                 
                        BankaHesabi hesap =iterator.next();
                 //MUSTERININ HESAPLARI LISTELENIYOR
                        System.out.println(i + ".Banka hesabı: ");
                        System.out.println("");
                        System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                        System.out.println(i+".Banka hesabı bakiye: "+hesap.getBakiye());
                        System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                        System.out.println("\n");
                        i++;
                        
                      }
   
              System.out.print("Para çekmek istediğiniz Yatırım hesabını seçiniz: ");    
              
              int yatirimHesabi = scanner.nextInt();//PARA CEKILMEK ISTENILEN HESABIN INDEKSI KULLANICIDAN ALINIYOR
              System.out.println("");
              
              if(yatirimHesabi<=musteri.getHesaplar().size() && yatirimHesabi>0){ //ARALIK KONTROLU
                  
                  yatirimHesabi=yatirimHesabi-1;
                  
                   if(musteri.getHesaplar().get(yatirimHesabi).toString().equals("Yatırım Hesabı")){ // yATIRIM HESASBI OLMALI
                       
                       System.out.print("Çekmek istediğiniz tutarı giriniz: ");
                
                        int cekimMiktar = scanner.nextInt(); // CEKILMEK ISTENEN TUTAR KULLANICIDAN ALINIYOR
                        System.out.println("");
                        
                        if(cekimMiktar>0 && cekimMiktar<= musteri.getHesaplar().get(yatirimHesabi).getBakiye()){ // CEKILEN BAKIYE HESAB BAKIYESINDEN COK OLMAMALI
                            
                                System.out.println("Çektiğiniz parayı kendi hesablarınızdan birine mi yoksa başka birinin mi hesabına mı aktarmak istersiniz \n");
                                System.out.println("1.Kişisel hesaplar");
                                System.out.println("2.Yabancı hesaplar\n");
                            
                                System.out.print("Lütfen ikisinden birini seçiniz: ");
                                
                                int secili = scanner.nextInt(); // KULLANICDAN ISLEM ALINIYOR
                                
                                System.out.println("");
                                
                                if(secili==1){
                                    i=1;
                                    
                                  iterator = musteri.getHesaplar().listIterator();
                                    while(iterator.hasNext()){
                 
                                    BankaHesabi hesap =iterator.next();
                                    //KULLANICNIN BANKA HESAPLARI LİSTELENİYOR
                                    System.out.println(i + ".Banka hesabı: ");
                                    System.out.println("");
                                    System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                                    System.out.println(i+".Banka hesabı bakiye: "+hesap.getBakiye());
                                    System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                                    System.out.println("\n");
                                    i++;
                        
                                    }
                                    
                                    System.out.print("Lütfen çektiğiniz parayı yatırmak için vadesiz banka hesaplarınızdan birini seçiniz: ");
                                    
                                    int bankaVadesiz= scanner.nextInt(); //INDEKS ALINIYOR
                                    System.out.println("");
                                    
                                    if(bankaVadesiz<=musteri.getHesaplar().size() && bankaVadesiz>0){ //ARALIK KONTROLU
                                        
                                        bankaVadesiz=bankaVadesiz-1;
                                        
                                         if(musteri.getHesaplar().get(bankaVadesiz).toString().equals("Vadesiz Hesap")){ // PARANIN YATIRILACAGI HESAP VADESIZ OLMALI
                                             
                                              musteri.getHesaplar().get(bankaVadesiz).setBakiye(musteri.getHesaplar().get(bankaVadesiz).getBakiye()+cekimMiktar);
                                              musteri.getHesaplar().get(yatirimHesabi).setBakiye(musteri.getHesaplar().get(yatirimHesabi).getBakiye()-cekimMiktar);
                                              
                                              System.out.println("Çekim işlemi Tamamlandı\n");
                                              
                                              
                                         }
                                    }
                                }
                                else if(secili==2){
                                    
                                     i=1;
                             
                                    ListIterator<Musteri> iter = personel.getMusteriler().listIterator();



                                   while(iter.hasNext()){

                                   Musteri uye =iter.next();
                                   //MUSTERILER LISTELENIYOR
                                   System.out.println(i+".Müşteri: ");
                                   System.out.println("Ad: "+uye.getAd());
                                   System.out.println("Soyad: "+uye.getSoyad());
                                   System.out.println("Email: "+uye.getEmail());
                                   System.out.println("Telefon: "+uye.getTelefonNumarasi());
                                   System.out.println("\n");

                                   i++;

                                   }
                                   
                                    System.out.print("Para Göndermek istediğiniz kişiyi seçiniz:  ");
                                    
                                    int gonderilenKisi = scanner.nextInt(); // HEDEF MUSTERI KULLANICI TARAFINDAN SECILIYOR
                                    System.out.println("");
                                    
                                    if(gonderilenKisi<=personel.getMusteriler().size() && gonderilenKisi>0){ // ARALIK KONTROLU
                                        
                                        i=1;
                                        
                                        gonderilenKisi=gonderilenKisi-1;
                                        
                                        System.out.println("Seçtiğiniz kişinin Banka Hesapları: \n");
                                        
                                        ListIterator<BankaHesabi> bankaIter = personel.getMusteriler().get(gonderilenKisi).getHesaplar().listIterator();
        
                                        while(bankaIter.hasNext()){
                                            // SECILEN KISININ BANKA HESAPLARI LISTELENIYOR
                                        BankaHesabi hesap =bankaIter.next();

                                        System.out.println(i + ".Banka hesabı: ");
                                        System.out.println("");
                                        System.out.println(i+".Banka hesabı iban: "+hesap.getIban());
                                        System.out.println(i+".Banka hesabı bakiye: "+hesap.getBakiye());
                                        System.out.println(i+".Banka hesabı türü: "+hesap.toString());
                                        System.out.println("\n");
                                        i++;
                        
                                        }
                                        
                                        System.out.print("Lütfen çektiğiniz parayı göndermek istediğiniz kişinin vadesiz banka hesaplarından birini seçiniz: ");
                                        
                                        int gonderilenHesap =  scanner.nextInt(); //CEKILEN PARANIN GONDERILECEGI HESAP KULLANICI TARAFINDAN SECILIYOR 
                                        System.out.println("");
                                        
                                        if(gonderilenHesap<= personel.getMusteriler().get(gonderilenKisi).getHesaplar().size() && gonderilenHesap>0){ // ARALIK KONTROLU
                                            
                                            gonderilenHesap=gonderilenHesap-1;
                                            
                                            if(personel.getMusteriler().get(gonderilenKisi).getHesaplar().get(gonderilenHesap).toString().equals("Vadesiz Hesap")){//SECILEN HESABIN VADESIZ OLUP OLMADIGI KONTROL EDILIYOR
                                                
                                                //PARA GONDERME ISLEMI
 personel.getMusteriler().get(gonderilenKisi).getHesaplar().get(gonderilenHesap).setBakiye(personel.getMusteriler().get(gonderilenKisi).getHesaplar().get(gonderilenHesap).getBakiye()+cekimMiktar);
 musteri.getHesaplar().get(yatirimHesabi).setBakiye(musteri.getHesaplar().get(yatirimHesabi).getBakiye()-cekimMiktar);
 
                                                System.out.println("İşlem Tamamlandı\n");
                                            }
                                            else{
                                                System.out.println("Sadece Vadesiz Hesaba para gönderebilirsiniz.");
                                            }
                                        }
                                        else{
                                            System.out.println("Listelenen hesaplardan biriniz seçiniz.");
                                        }
                                    }
                                    else{
                                        System.out.println("Listelenen kişilerden biriniz seçiniz.");
                                    }
                                    
                              }
                                else{
                                    System.out.println("Yanlış seçenek");
                                }
                            
                        }
                        else{
                             System.out.println("Çekim miktarı 0 dan büyük ve parayı çektiğiniz hesabın bakiyesine eşit veya küçük olmalıdır");
                        }
                     
                   }
                   else{
                        System.out.println("Parayı Yatırım hesabından çekebilirsiniz");
                   }
                  
              }
              else{
                  System.out.println("Listenen hesaplardan birini seçiniz.");
              }
             
    }
    
}
