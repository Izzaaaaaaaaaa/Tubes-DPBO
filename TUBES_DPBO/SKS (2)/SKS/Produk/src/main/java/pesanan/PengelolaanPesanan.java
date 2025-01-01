/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pesanan;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class PengelolaanPesanan {
    private ArrayList<String> riwayatPesanan = new ArrayList<>();
    private HashMap<String, String> statusPengiriman = new HashMap<>();

    public void tambahPesanan(String barang) {
        riwayatPesanan.add(barang);
        statusPengiriman.put(barang, "Belum Dikirim");
    }

    public ArrayList<String> getRiwayatPesanan() {
        return riwayatPesanan;
    }

    public HashMap<String, String> getStatusPengiriman() {
        return statusPengiriman;
    }

    public void ubahStatusPengiriman(String barang, String status) {
        if (statusPengiriman.containsKey(barang)) {
            statusPengiriman.put(barang, status);
        }
    }
}
