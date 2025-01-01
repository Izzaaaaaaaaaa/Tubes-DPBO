/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barang;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class PelacakanKadaluarsa implements Barang {
    private HashMap<String, Integer> barangKadaluarsa = new HashMap<>(); // Barang dan stoknya

    public void tambahBarangKadaluarsa(String barang, int stok) {
        barangKadaluarsa.put(barang, stok);
    }

    public HashMap<String, Integer> getBarangKadaluarsa() {
        return barangKadaluarsa;
    }

    public void ubahBarangKadaluarsa(String barang, int stokBaru) {
        if (barangKadaluarsa.containsKey(barang)) {
            barangKadaluarsa.put(barang, stokBaru);
        }
    }

    public void hapusBarangKadaluarsa(String barang) {
        barangKadaluarsa.remove(barang);
    }

    @Override
    public void cekKadaluarsa() {
        System.out.println("Barang kadaluarsa telah diidentifikasi.");
    }
}
