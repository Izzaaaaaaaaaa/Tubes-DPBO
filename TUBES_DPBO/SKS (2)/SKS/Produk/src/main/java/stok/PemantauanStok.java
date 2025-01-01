package stok;

import java.util.HashMap;
import java.util.Map;

public class PemantauanStok {
    private Map<String, Integer> stokBarang;
    private Map<String, Integer> stokMinimum;

    public PemantauanStok() {
        stokBarang = new HashMap<>();
        stokMinimum = new HashMap<>();

        // Contoh data awal
        stokBarang.put("Barang A", 50);
        stokBarang.put("Barang B", 30);
        stokBarang.put("Barang C", 5);

        stokMinimum.put("Barang A", 10);
        stokMinimum.put("Barang B", 20);
        stokMinimum.put("Barang C", 10);
    }

    public Map<String, Integer> getStokBarang() {
        return stokBarang;
    }

    public int getStokMinimum(String barang) {
        return stokMinimum.getOrDefault(barang, 0);
    }

    public void setStokMinimum(String barang, int minimum) {
        stokMinimum.put(barang, minimum);
    }

    public void tambahStok(String namaBarang, int stokAwal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
