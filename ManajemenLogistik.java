/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengiriman;

class ManajemenLogistik implements Pengiriman {
    @Override
    public void kelolaPengiriman() {
        System.out.println("Pengiriman dijadwalkan dan dikelola.");
    }

    @Override
    public void monitorPengiriman() {
        System.out.println("Memantau status pengiriman untuk memastikan kualitas dan ketepatan waktu.");
    }
}
