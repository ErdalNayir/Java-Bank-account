package erdal_nayir_19360859049;

import  javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author erdal
 */
public class sonucBastirArayuz extends JFrame{
    
    //GEREKLI YAPILAR'LAR TANIMLANIYOR
    private BankaPersoneli kisi;
    private JLabel baslik;
    private JScrollPane jScrollPane1;
    private JTextArea sonucEkrani;
    private JLabel basari;
    

    public sonucBastirArayuz(BankaPersoneli person) { //CONSTRUCTOR
        
        this.kisi=person;
        
        pencere();
        
    }
    
    
    public void pencere(){ 
        
        // GEREKLI YAPILAR OLUSTURULUYOR
        jScrollPane1 = new javax.swing.JScrollPane();
        sonucEkrani = new javax.swing.JTextArea();
        baslik = new javax.swing.JLabel();
        basari = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //CARPIYA BASINCA KAPATMA ISLEMI
        setTitle("Müşteriler"); // PENCERE BASLIGI
        setSize(406, 539); // PENCERE BOYUTU

        //TEXTAREA ICIN BAZI AYARLAMALAR YAPILIYOR
        sonucEkrani.setColumns(20);
        sonucEkrani.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        sonucEkrani.setRows(5);
        jScrollPane1.setViewportView(sonucEkrani);

        baslik.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        baslik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        baslik.setText("Kayıtlı Müşteri Bilgileri:");

        //JAVANIN OLUSTURDUGU EKRAN DUZENI ICIN KOD
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(baslik, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(baslik)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        
        bastir(kisi);
        
    }
    public void bastir(BankaPersoneli person){
        
        if(person.getMusteriler().size()>0){
            
            int i=1;
                ListIterator<Musteri> iterator = person.getMusteriler().listIterator();
                
                 while(iterator.hasNext()){
                 
                    Musteri musteri =iterator.next();
                //MUSTERILER BANKA PERSONELINDEN TEK TEK ALINIYOR APPEND KOMUTU ILE TEXTAREA YA BASILIYOR
                     sonucEkrani.append(i+".Müşteri Ad: "+musteri.getAd()+"\n");
                     sonucEkrani.selectAll();
                     sonucEkrani.setCaretPosition(sonucEkrani.getDocument().getLength());
                     
                     sonucEkrani.append(i+".Müşteri Soyad: "+musteri.getSoyad()+"\n");
                     sonucEkrani.selectAll();
                     sonucEkrani.setCaretPosition(sonucEkrani.getDocument().getLength());
                     
                     sonucEkrani.append(i+".Müşteri Email: "+musteri.getEmail()+"\n");
                     sonucEkrani.selectAll();
                     sonucEkrani.setCaretPosition(sonucEkrani.getDocument().getLength());
                     
                     sonucEkrani.append(i+".Müşteri Telefon Numara: "+musteri.getTelefonNumarasi()+"\n\n\n");
                     sonucEkrani.selectAll();
                     sonucEkrani.setCaretPosition(sonucEkrani.getDocument().getLength());
               
                     i++;
            }
                 
                sonucEkrani.setEditable(false); //BU SAYEDE KULLANICILAR EKRANDAKI TEXTLERI SILEMIYOR YA DA DUZENLEME YAPAMIYOR
         
                basari.setFont(new java.awt.Font("Tahoma", 1, 13)); //BASILACAK METIN ICIN FONT AYARI
                basari.setText("Sistemdeki Kayıtlı Müşteri Sayısı: "+person.getMusteriler().size()); // basılacak metın
                
                setVisible(true);
                
                JOptionPane.showMessageDialog(null, basari, "Müşteri Sayısı",JOptionPane.INFORMATION_MESSAGE);  
                
                
          
        }
        else{
            
         JOptionPane.showMessageDialog(null, "Hiç Kayıtlı Müşteri Yok !", "Müşteri Bulunamadı",JOptionPane.WARNING_MESSAGE);   //MUSTERI BULUNAMADIĞINDA VERILECEK MESAJ
        }
         
                
    }
    
   }
