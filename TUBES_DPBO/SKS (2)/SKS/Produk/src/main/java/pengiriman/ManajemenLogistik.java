/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengiriman;

import java.util.HashMap;

public class ManajemenLogistik {
    private HashMap<String, String> rutePengiriman = new HashMap<>();

    public void tambahPengiriman(String barang, String rute) {
        rutePengiriman.put(barang, rute);
    }

    public HashMap<String, String> getRutePengiriman() {
        return rutePengiriman;
    }
}
