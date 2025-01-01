package pengguna;

import pesanan.PengelolaanPesanan;

import javax.swing.*;
import java.awt.*;

public class PemesananGUI {
    private PengelolaanPesanan pengelolaanPesanan;
    private JPanel panel;

    public PemesananGUI(PengelolaanPesanan pengelolaanPesanan) {
        this.pengelolaanPesanan = pengelolaanPesanan;
        panel = new JPanel(new BorderLayout());

        // Label dan tombol lainnya di modul Pemesanan
        JLabel label = new JLabel("Modul Pemesanan Barang", JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Tambah Pesanan
        JButton tambahPesananButton = new JButton("Tambah Pesanan");
        tambahPesananButton.addActionListener(e -> {
            String barang = JOptionPane.showInputDialog(panel, "Masukkan nama barang yang ingin dipesan:");
            if (barang != null && !barang.trim().isEmpty()) {
                pengelolaanPesanan.tambahPesanan(barang);
                JOptionPane.showMessageDialog(panel, "Barang \"" + barang + "\" berhasil dipesan.");
            }
        });
        panel.add(tambahPesananButton, BorderLayout.CENTER);

        // Tombol Kembali
        JButton kembaliButton = new JButton("Kembali ke Dashboard");
        kembaliButton.addActionListener(e -> {
            // Kembali ke dashboard utama
            CardLayout cardLayout = (CardLayout) panel.getParent().getLayout();
            cardLayout.show(panel.getParent(), "Dashboard");
        });
        panel.add(kembaliButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
