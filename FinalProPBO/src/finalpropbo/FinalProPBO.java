/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalpropbo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static finalpropbo.FinalProPBO.*;
import java.awt.BorderLayout;

//membuat class Container dengan hubungan inheritance atau extends dari javax
class Container extends javax.swing.JFrame{     
    public Container(){             //constructor untuk memanggil container
        super("Pembayaran Les Musik");
        //Local Variable 
        //untuk mengatur size frame
        int sizeW = 500;        
        int sizeH = 500;
        setSize(sizeW, sizeH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //Menambahkan gambar pada background program
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("Musik.jpg"));
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(new BorderLayout());
        setContentPane(background);
    }
}

//membuat class abstrak masukan untuk membuat suatu objek agar memiliki banyak bentuk
abstract class Masukkan{        //polymorphism
    String NamaAnggota;
    protected void labelMasukkan(){
    }
    protected void labelMasukkan(String NamaAnggota){ //Overloading
        this.NamaAnggota = NamaAnggota;
    }
}

//membuat class NoAnggota sebagai sub class dari Masukkan
class NoAnggota extends Masukkan{
    @Override
    protected void labelMasukkan(){         //protected sebagai access modifier. 
        //membuat variabel dengan JLabel dengan text "Nomor Anggota" dan penempatannya
        NoA = new JLabel("Nomor Anggota");       
        NoA.setBounds(50,50,150,150);  
    }
}

//membuat class NamaAnggota sebagai sub class dari Masukkan
class NamaAnggota extends Masukkan{
    @Override
    protected void labelMasukkan(){         //protected sebagai access modifier. 
        //membuat variabel dengan JLabel dengan text "Nama Anggota" dan penempatannya
        NA = new JLabel("Nama Anggota");
        NA.setBounds(50,100,150,150);       
    }
}

public class FinalProPBO extends Container{     //public juga sebagai access modifier

    //variable static untuk memanggil JLabel, JtextField, JList, JButton, JComboBox
    static JLabel NoA,NA,Pil,JP,Ju;       
    static JTextField tf1,tf2,tf3;  
    static JList pilihanList;
    static JButton proses, reset;
    static JComboBox<String> comboBox;

    public static void main(String[] args) {
        Container ct = new Container(); //Membuat objek baru dari Container dengan nama ct
        Encapsulation ec = new Encapsulation(); //Membuat objek baru dari Encapsulation dengan nama ec
        
        //Membuat objek baru dari NoAnggota dan NamaAnggota
        NoAnggota no = new NoAnggota(); 
        NamaAnggota nama = new NamaAnggota();
        
        //memanggil method labelMasukkan milik class Masukkan yang merupakan kelas Parents dari NoAnggota dan NamaAnggota
        no.labelMasukkan(); 
        nama.labelMasukkan();
        
        //membuat variabel dengan memanggil JTextField 
        tf1 = new JTextField(); //JTextField untuk Nomor Anggota
        tf2 = new JTextField(); //JTextField untuk Nama Anggota
        tf3 = new JTextField(); //JTextField untuk jumlah pertemuan
        //membuat JTextFeild dengan x yang sama yaitu 180 dan y yang disesuaikan 
        tf1.setBounds(180,110,270,30); 
        tf2.setBounds(180,160,270,30);
        tf3.setBounds(180,310,270,30);
        
        
        Pil = new JLabel("Pilihan");
        Pil.setBounds(50,150,150,150);
        Ju = new JLabel("Silahkan Cek Tagihan Les Bulan Ini");
        Ju.setBounds(150, 55, 300, 30);
        //membuat pilihan dengan menggunakan comboBox
        String[] pilihan = {
            "Piano",
            "Gitar",
            "Harpa",
            "Biola",
            "Drum",
            "Paduan Suara"
        };
        comboBox = new JComboBox<>(pilihan);
        comboBox.setBounds(180, 210, 150, 30);
       
        //membuat variabel untuk memanggil Jlabel dan penempatannya
        JP = new JLabel("Jumlah Pertemuan");
        JP.setBounds(50,250,150,150);
        
        //membuat variabel untuk memanggil JButton dan penempatannya
        proses = new JButton("Total");
        proses.setBounds(100,350,100,30);
        
        //membuat program proses yang dapat memproses sesuai yang diinginkan 
        proses.addActionListener(new ActionListener(){          
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nomorAnggota = Integer.parseInt(tf1.getText());
                    ec.setNoAnggota(nomorAnggota);
                    String NamaAnggota = tf2.getText();
                    String pilihanLes = (String) comboBox.getSelectedItem();
                    int hariMasuk = Integer.parseInt(tf3.getText());

                    int tagihan = 0;
                    if (pilihanLes.equals("Piano")) {
                        tagihan = 170000;
                    } else if (pilihanLes.equals("Gitar")) {
                        tagihan = 100000;
                    } else if (pilihanLes.equals("Harpa")) {
                        tagihan = 200000;
                    } else if (pilihanLes.equals("Biola")) {
                        tagihan = 250000;
                    } else if (pilihanLes.equals("Drum")) {
                        tagihan = 130000;
                    } else if (pilihanLes.equals("Paduan Suara")) {
                        tagihan = 1500000;
                    }

                    JOptionPane.showMessageDialog(ct,
                            "Nomor Anggota    : " + ec.getNoAnggota() + "\n" +
                                    "Nama Anggota      : " + NamaAnggota + "\n" +
                                    "Pilihan                    : " + pilihanLes + "\n" +
                                    "Total                       : " + hitungTagihan(hariMasuk, tagihan));
                } 
                // menampilkan message agar saat inputan No anggota dan hari masuk salah akan keluar message peringatan 
                catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ct, "Anda salah memasukkan Nomor Anggota."
                            + "Harap masukkan input yang valid.");
                    resetFrame();
                }
            }
        });

        reset = new JButton("Reset");
        reset.setBounds(300, 350, 100, 30);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFrame();
            }
        });

        ct.add(NoA);
        ct.add(NA);
        ct.add(Pil);
        ct.add(JP);
        ct.add(Ju);
        ct.add(tf1);
        ct.add(tf2);
        ct.add(tf3);
        ct.add(comboBox);
        ct.add(proses);
        ct.add(reset);
        ct.setLayout(null);
        ct.setVisible(true);
    }

    public static int hitungTagihan(int a, int b) {
        int result = a * b;
        // membuat limit inputan untuk hari masuk, 
        //jika memasukkan kurang dari 1 maka saat di run hasilnya akan tetap 0
        return Math.max(result, 0); 
    }

    public static void resetFrame() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        comboBox.setSelectedIndex(0);
        pilihanList.clearSelection();
    }
}

