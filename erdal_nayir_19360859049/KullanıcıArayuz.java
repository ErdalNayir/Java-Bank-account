package erdal_nayir_19360859049;

//GEREKLI KUTUPHANELERIN IMPORT EDILMESI
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

/*

ARAYUZ ICIN BU DOSYA CALISTIRILMALIDIR.
*/

public class KullanıcıArayuz extends JFrame{ //BIR KULLANICI ARAYUZ OLUSTURULUYOR
    
    //GEREKLI COMPENENT LAR TANIMLANIYOR.
    private JButton MusteriEkle;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField musteriAd;
    private JTextField musteriEmail;
    private JTextField musteriSoyad;
    private JTextField musteriTel;
    private JMenuBar jMenuBar2; //MENU BAR OLUSTUMAK ICIN MENUBAR COMPENENT'I TANIMLANIYOR
    private JMenuItem musteriBilgileri; // MENU ITEMI OLUTURMAK ICIN MENUITEM COMPENENT'I TANIMLANIYOR
    private JMenu bilgiler; //MENULER
    private JLabel basari;

    public KullanıcıArayuz() {
         
        ekran(); //CONSTRUCTOR CALISTIRILDIGINDA BU FONKSIYON CALISACAK
        
    }
    
    public void ekran(){
        
        
        //TANIMLANAN COMPENENTLAR OLUSTURULUYOR
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        musteriAd = new javax.swing.JTextField();
        musteriSoyad = new javax.swing.JTextField();
        musteriEmail = new javax.swing.JTextField();
        musteriTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        MusteriEkle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        bilgiler = new javax.swing.JMenu();
        musteriBilgileri = new javax.swing.JMenuItem();
        basari = new javax.swing.JLabel();
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //CARPIYA BASINCA KAPATMA
        setTitle("Müşteri Kayıt");  //ACILAN PENCERENIN BASLIGI
        setSize(350,400); //EKRAN BOYUTU

        
        //FONT AYARLAMALARI
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabel1.setText("Ad:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabel2.setText("Soyad:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabel4.setText("Telefon:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel6.setText("Eklemek isteğiniz müşterinin bilgilerini giriniz.");

        MusteriEkle.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        MusteriEkle.setText("Müşteri Ekle");
        
        //DUGME ICIN ACTIONLISTENER EKLENIYOR
        MusteriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                  musteriEkle();    //DUGMEYE TIKLANDIGINDA BU METOD CALISCAK          
            }
        });

        //FONT AYARLAMALRI
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Ad/Soyad: Erdal Nayir");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Okul Numarası: 19360859049");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        bilgiler.setText("Bilgileri Göster");

        musteriBilgileri.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK)); //MENUDEKI DUGME ICIN KISAYOL TANIMLANIYOR
        musteriBilgileri.setText("Müşteri Bilgileri");
        
        //MENU DEKİ DUGME ICIN ACTIONLISTENER OLUSTURULUYOR
        musteriBilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                musteriBilgiGoster(personel); //MENUDEKI MUSTERI BILGILERINE TIKLANDIGINDA BU METOD CALISCAK BANKA PERSONELI BU METODA PARAMETRE OLARAK VERILIYOR
               
            }
        });
        
        //MENU EKLEME OLUSTURMA
        bilgiler.add(musteriBilgileri);

        jMenuBar2.add(bilgiler);

        setJMenuBar(jMenuBar2);

        // EKRANIN TASARIMI ICIN JAVA TARAFINDAN OLUTURULAN KOD PARCASI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MusteriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(musteriTel))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(34, 34, 34)
                                    .addComponent(musteriEmail))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(26, 26, 26)
                                    .addComponent(musteriSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(48, 48, 48)
                                    .addComponent(musteriAd, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(musteriAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(musteriSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(musteriEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(musteriTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(MusteriEkle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(77, Short.MAX_VALUE))
        );

    }
    
    
    public static void main(String[] args) { // MAIN METODU
         KullanıcıArayuz arayuz = new KullanıcıArayuz();
         
         arayuz.setVisible(true); //EKRAN GORUNUR YAPILIYOR
            
    }
    
    BankaPersoneli personel = new BankaPersoneli("Emre", "Nayir", "emre@gmail.com", new BigInteger("5678901234512")); //OLUSTURULAN MUSTERILERIN SAKLANMASI ICIN BANKA PERSONELI OLUSTURULUYOR
 
    public void musteriBilgiGoster(BankaPersoneli person){
         
        sonucBastirArayuz sonucArayuz = new sonucBastirArayuz(person);  // BU KOD SATIRI BASKA BIR CLASSTA SONUCLARI BASTIRIYOR
    }
      
     public void  musteriEkle(){ //MUSTERI EKLE METODU
         
         //GIRILEN INPUTLAR STRIN OLARAK DEPOLANIYOR
         String ad = musteriAd.getText();
         String soyad = musteriSoyad.getText();
         String email = musteriEmail.getText();
         String telNo = musteriTel.getText();
         
         if(ad.isEmpty() || soyad.isEmpty() || email.isEmpty() || telNo.isEmpty()){ //DEĞERLERDEN BIRI BILE BOS ISE HATA MESAJI OLUSTURULUYOR
             
            JOptionPane.showMessageDialog(null, "Müşteri Bilgileri Boş Bırakılamaz", "Hata",JOptionPane.ERROR_MESSAGE); //HATA MESAJI
            
            //BILGILERIN GIRILDIGI TEXTFIELD'LER TMUSTERI SONRAKI MUSTERI BILGILERINI RAHAT GRISIN DIYE TEMIZLENIYOR.
            musteriAd.setText("");
            musteriSoyad.setText("");
            musteriEmail.setText("");
            musteriTel.setText("");
            
         }
         else{ //EGER TUM MUSTERI BILGILERI GIRILMIS ISE MUSTERI NESNESI OLUSTURULUP BANKA PERSONELINDEKI ARRAYLIST'E EKLENEIYOR
             
            Musteri musteri = new Musteri(ad, soyad, email, new BigInteger(telNo));
         
            personel.getMusteriler().add(musteri);// OLUSTURULAN MUSTERI ARRAYLIST'E KAYDEDILIYOR

             //BILGILERIN GIRILDIGI TEXTFIELD'LER TMUSTERI SONRAKI MUSTERI BILGILERINI RAHAT GRISIN DIYE TEMIZLENIYOR.
            musteriAd.setText("");
            musteriSoyad.setText("");
            musteriEmail.setText("");
            musteriTel.setText("");
             
            JOptionPane.showMessageDialog(null, "Müşteri Eklendi", "Eklendi",JOptionPane.INFORMATION_MESSAGE); //MUSTERI BILGILERININ KAYDEDILDIGINE DAIR BILGI MESAJI VERILIYOR
             
         }

     }
}

