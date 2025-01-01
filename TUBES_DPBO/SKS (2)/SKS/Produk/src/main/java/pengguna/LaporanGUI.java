package pengguna;

import pesanan.PengelolaanPesanan;
import barang.PelacakanKadaluarsa;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanGUI {
    private PengelolaanPesanan pesanan;
    private PelacakanKadaluarsa pelacakanKadaluarsa;
    private JPanel panel;

    public LaporanGUI(PengelolaanPesanan pesanan, PelacakanKadaluarsa pelacakanKadaluarsa) {
        this.pesanan = pesanan;
        this.pelacakanKadaluarsa = pelacakanKadaluarsa;
        panel = new JPanel(new BorderLayout());

        // Label dan komponen lainnya di modul Laporan
        JLabel label = new JLabel("Modul Laporan", JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Tabel laporan
        String[] columns = {"Barang", "Stok", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        pesanan.getRiwayatPesanan().forEach(barang -> {
            String status = pelacakanKadaluarsa.getBarangKadaluarsa().containsKey(barang) ? "Kadaluarsa" : "Baik";
            model.addRow(new Object[]{barang, 10, status}); // Misal stok 10
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

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
