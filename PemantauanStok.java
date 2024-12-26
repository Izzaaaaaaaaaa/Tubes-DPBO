/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stok;

class PemantauanStok implements Stok {
    private int stok;
    private int batasMinimum;

    public PemantauanStok(int stok, int batasMinimum) {
        this.stok = stok;
        this.batasMinimum = batasMinimum;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setBatasMinimum(int batasMinimum) {
        this.batasMinimum = batasMinimum;
    }

    public int getBatasMinimum() {
        return batasMinimum;
    }

    @Override
    public void updateStok() {
        System.out.println("Stok diperbarui secara real-time.");
    }

    @Override
    public void tampilkanDashboard() {
        System.out.println("Menampilkan dashboard interaktif:");
        System.out.println("- Visualisasi stok di seluruh toko dan pusat distribusi.");
    }

    @Override
    public void kirimPeringatan() {
        if (stok < batasMinimum) {
            System.out.println("Peringatan: Stok mendekati batas minimum!");
        } else {
            System.out.println("Stok dalam kondisi aman.");
        }
    }
}
