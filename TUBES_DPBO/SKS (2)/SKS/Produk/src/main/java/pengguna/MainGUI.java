/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengguna;

import barang.PelacakanKadaluarsa;
import stok.PemantauanStok;
import laporan.Laporan;

import javax.swing.*;
import java.awt.*;

public class MainGUI {
    private Laporan laporan;
    private PelacakanKadaluarsa pelacakanKadaluarsa;
    private PemantauanStok pemantauanStok;

    public MainGUI(Laporan laporan, PelacakanKadaluarsa pelacakanKadaluarsa, PemantauanStok pemantauanStok) {
        this.laporan = laporan;
        this.pelacakanKadaluarsa = pelacakanKadaluarsa;
        this.pemantauanStok = pemantauanStok;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Sistem Pengelolaan Barang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel label = new JLabel("Selamat datang di Sistem Pengelolaan Barang", JLabel.CENTER);
        panel.add(label);

        // Tombol untuk melihat stok barang
        JButton lihatStokButton = new JButton("Lihat Stok Barang");
        lihatStokButton.addActionListener(e -> {
            StringBuilder detailStok = new StringBuilder("Stok Barang:\n");
            pemantauanStok.getStokBarang().forEach((barang, stok) -> detailStok.append("- ").append(barang).append(": ").append(stok).append("\n"));
            JOptionPane.showMessageDialog(frame, detailStok.toString(), "Stok Barang", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(lihatStokButton);

        // Tombol untuk menambah barang
        JButton tambahBarangButton = new JButton("Tambah Barang");
        tambahBarangButton.addActionListener(e -> {
            String namaBarang = JOptionPane.showInputDialog(frame, "Masukkan nama barang:");
            if (namaBarang != null && !namaBarang.trim().isEmpty()) {
                try {
                    int stokAwal = Integer.parseInt(JOptionPane.showInputDialog(frame, "Masukkan stok awal:"));
                    pemantauanStok.tambahStok(namaBarang, stokAwal);
                    JOptionPane.showMessageDialog(frame, "Barang \"" + namaBarang + "\" berhasil ditambahkan dengan stok awal: " + stokAwal);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukkan angka yang valid untuk stok!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(tambahBarangButton);

        // Tombol untuk menandai barang kadaluarsa
        JButton tambahKadaluarsaButton = new JButton("Tandai Barang Kadaluarsa");
        tambahKadaluarsaButton.addActionListener(e -> {
            String namaBarang = JOptionPane.showInputDialog(frame, "Masukkan nama barang yang kadaluarsa:");
            if (namaBarang != null && pemantauanStok.getStokBarang().containsKey(namaBarang)) {
                int stok = pemantauanStok.getStokBarang().get(namaBarang);
                pelacakanKadaluarsa.tambahBarangKadaluarsa(namaBarang, stok);
                JOptionPane.showMessageDialog(frame, "Barang \"" + namaBarang + "\" berhasil ditandai sebagai kadaluarsa.");
            } else {
                JOptionPane.showMessageDialog(frame, "Barang tidak ditemukan dalam stok!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(tambahKadaluarsaButton);

        // Tombol untuk melihat laporan kadaluarsa
        JButton lihatKadaluarsaButton = new JButton("Lihat Barang Kadaluarsa");
        lihatKadaluarsaButton.addActionListener(e -> {
            StringBuilder detailKadaluarsa = new StringBuilder("Barang Kadaluarsa:\n");
            pelacakanKadaluarsa.getBarangKadaluarsa().forEach((barang, stok) -> detailKadaluarsa.append("- ").append(barang).append(": ").append(stok).append("\n"));
            JOptionPane.showMessageDialog(frame, detailKadaluarsa.toString(), "Laporan Kadaluarsa", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(lihatKadaluarsaButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
