/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksi;

/**
 *
 * @author USER
 */
public class IntegrasiPOS implements Transaksi {
    @Override
    public void prosesTransaksi() {
        System.out.println("Transaksi telah diproses oleh sistem POS.");
    }
}