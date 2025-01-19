/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpropbo;

/**
 *
 * @author adlsa
 */
//mengubah noAnggota yang sebelumnya string menjadi bentuk int
public class Encapsulation {
    private int noAnggota; //variable instance, yaitu variable yang berada diluar kelas
    
    public int getNoAnggota(){       // Encapsulation (set dan get)
        return noAnggota;
    }
    public void setNoAnggota(int noAnggota){
        this.noAnggota = noAnggota;
    }
}

