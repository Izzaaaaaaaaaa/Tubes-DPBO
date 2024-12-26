/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laporan;

import java.util.Scanner;

abstract class Laporan {
    public abstract void buatLaporan();
}

class LaporanKeuangan extends Laporan {
    @Override
    public void buatLaporan() {
        System.out.println("Menyediakan laporan analitik dan keuangan:");
        System.out.println("- Harian, mingguan, bulanan.");
        System.out.println("- Prediksi untuk menghindari overstocking atau understocking.");
    }
}

