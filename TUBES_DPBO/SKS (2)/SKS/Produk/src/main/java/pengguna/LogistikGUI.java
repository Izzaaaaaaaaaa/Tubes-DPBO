package pengguna;

import pengiriman.ManajemenLogistik;

import javax.swing.*;
import java.awt.*;

public class LogistikGUI {
    private ManajemenLogistik manajemenLogistik;
    private JPanel panel;

    public LogistikGUI(ManajemenLogistik manajemenLogistik) {
        this.manajemenLogistik = manajemenLogistik;
        panel = new JPanel(new BorderLayout());

        // Label dan komponen lainnya di modul Logistik
        JLabel label = new JLabel("Modul Pengelolaan Logistik", JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Tambah Pengiriman
        JButton tambahRuteButton = new JButton("Tambah Rute Pengiriman");
        tambahRuteButton.addActionListener(e -> {
            String barang = JOptionPane.showInputDialog(panel, "Masukkan nama barang:");
            String rute = JOptionPane.showInputDialog(panel, "Masukkan rute pengiriman:");
            if (barang != null && rute != null) {
                manajemenLogistik.tambahPengiriman(barang, rute);
                JOptionPane.showMessageDialog(panel, "Rute pengiriman untuk \"" + barang + "\" berhasil ditambahkan.");
            }
        });
        panel.add(tambahRuteButton, BorderLayout.CENTER);

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
