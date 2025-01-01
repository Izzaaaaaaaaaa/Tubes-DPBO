package pengguna;

import barang.PelacakanKadaluarsa;
import pengiriman.ManajemenLogistik;
import pesanan.PengelolaanPesanan;
import stok.PemantauanStok;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    private JPanel panel;
    private CardLayout cardLayout;
    private JPanel dashboardPanel;

    private PengelolaanPesanan pesanan;
    private PelacakanKadaluarsa pelacakanKadaluarsa;
    private ManajemenLogistik logistik;
    private PemantauanStok pemantauanStok;

    public MainApp() {
        // Inisialisasi objek
        pesanan = new PengelolaanPesanan();
        pelacakanKadaluarsa = new PelacakanKadaluarsa();
        logistik = new ManajemenLogistik();
        pemantauanStok = new PemantauanStok();

        // Setup GUI
        JFrame frame = new JFrame("Dashboard Utama");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Panel dengan CardLayout untuk navigasi antar modul
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);

        // Tambahkan panel dashboard
        setupDashboard(frame);

        // Tambahkan semua modul ke panel
        panel.add(dashboardPanel, "Dashboard");
        panel.add(new PemesananGUI(pesanan).getPanel(), "Pemesanan");
        panel.add(new LaporanGUI(pesanan, pelacakanKadaluarsa).getPanel(), "Laporan");
        panel.add(new LogistikGUI(logistik).getPanel(), "Logistik");
        panel.add(new PemantauanStokGUI(pemantauanStok, pelacakanKadaluarsa).getPanel(), "PemantauanStok");

        frame.add(panel);
        cardLayout.show(panel, "Dashboard");

        frame.setVisible(true);
    }

    private void setupDashboard(JFrame frame) {
        // Panel Dashboard
        dashboardPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        JLabel label = new JLabel("Dashboard Utama", JLabel.CENTER);
        dashboardPanel.add(label);

        // Tombol Modul Pemesanan
        JButton pemesananButton = new JButton("Modul Pemesanan");
        pemesananButton.addActionListener(e -> cardLayout.show(panel, "Pemesanan"));
        dashboardPanel.add(pemesananButton);

        // Tombol Modul Laporan
        JButton laporanButton = new JButton("Modul Laporan");
        laporanButton.addActionListener(e -> cardLayout.show(panel, "Laporan"));
        dashboardPanel.add(laporanButton);

        // Tombol Modul Logistik
        JButton logistikButton = new JButton("Modul Logistik");
        logistikButton.addActionListener(e -> cardLayout.show(panel, "Logistik"));
        dashboardPanel.add(logistikButton);

        // Tombol Modul Pemantauan Stok
        JButton stokButton = new JButton("Modul Pemantauan Stok");
        stokButton.addActionListener(e -> cardLayout.show(panel, "PemantauanStok"));
        dashboardPanel.add(stokButton);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
