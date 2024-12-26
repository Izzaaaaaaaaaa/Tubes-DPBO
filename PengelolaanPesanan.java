/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pesanan;

class PengelolaanPesanan implements Pesanan {
    @Override
    public void kelolaPesanan() {
        System.out.println("Pesanan ulang telah dibuat berdasarkan ambang batas stok.");
    }

    @Override
    public void lacakStatusPesanan() {
        System.out.println("Melacak status pemesanan dari pembuatan hingga pengiriman.");
    }
}

