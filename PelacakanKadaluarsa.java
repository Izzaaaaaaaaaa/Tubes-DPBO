/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barang;

import java.util.ArrayList;

class PelacakanKadaluarsa implements Barang {
    private ArrayList<String> barangKadaluarsa = new ArrayList<>();

    public void tambahBarangKadaluarsa(String barang) {
        barangKadaluarsa.add(barang);
    }

    public ArrayList<String> getBarangKadaluarsa() {
        return barangKadaluarsa;
    }

    @Override
    public void cekKadaluarsa() {
        System.out.println("Barang kadaluarsa telah diidentifikasi.");
        for (String barang : barangKadaluarsa) {
            System.out.println("- " + barang);
        }
        System.out.println("Rekomendasi: Diskon atau penghapusan barang.");
    }
}
