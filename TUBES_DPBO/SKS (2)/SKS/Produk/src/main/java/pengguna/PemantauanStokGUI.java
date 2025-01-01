package pengguna;

import barang.PelacakanKadaluarsa;
import stok.PemantauanStok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PemantauanStokGUI {
    private PemantauanStok pemantauanStok;
    private PelacakanKadaluarsa pelacakanKadaluarsa;
    private JPanel panel;

    public PemantauanStokGUI(PemantauanStok pemantauanStok, PelacakanKadaluarsa pelacakanKadaluarsa) {
        this.pemantauanStok = pemantauanStok;
        this.pelacakanKadaluarsa = pelacakanKadaluarsa;

        panel = new JPanel(new BorderLayout());

        // Label di atas
        JLabel label = new JLabel("Modul Pemantauan Stok", JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Tabel untuk menampilkan stok barang
        String[] columns = {"Barang", "Stok", "Stok Minimum", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        pemantauanStok.getStokBarang().forEach((barang, stok) -> {
            int stokMinimum = pemantauanStok.getStokMinimum(barang);
            String status = stok < stokMinimum 
                    ? "Stok Rendah" 
                    : pelacakanKadaluarsa.getBarangKadaluarsa().containsKey(barang) 
                        ? "Kadaluarsa" 
                        : "Baik";
            model.addRow(new Object[]{barang, stok, stokMinimum, status});
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol untuk mengatur stok minimum
        JButton aturStokButton = new JButton("Atur Stok Minimum");
        aturStokButton.addActionListener(e -> {
            String barang = JOptionPane.showInputDialog(panel, "Masukkan nama barang:");
            if (barang != null && pemantauanStok.getStokBarang().containsKey(barang)) {
                String stokMinimumStr = JOptionPane.showInputDialog(panel, "Masukkan stok minimum untuk \"" + barang + "\":");
                try {
                    int stokMinimum = Integer.parseInt(stokMinimumStr);
                    pemantauanStok.setStokMinimum(barang, stokMinimum);
                    JOptionPane.showMessageDialog(panel, "Stok minimum untuk \"" + barang + "\" berhasil diperbarui.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Input stok minimum tidak valid.");
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Barang tidak ditemukan.");
            }
        });

        // Tombol kembali ke dashboard
        JButton kembaliButton = new JButton("Kembali ke Dashboard");
        kembaliButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) panel.getParent().getLayout();
            cardLayout.show(panel.getParent(), "Dashboard");
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(aturStokButton);
        buttonPanel.add(kembaliButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
