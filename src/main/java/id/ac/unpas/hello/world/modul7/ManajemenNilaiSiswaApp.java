package id.ac.unpas.hello.world.modul7;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ManajemenNilaiSiswaApp extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    public ManajemenNilaiSiswaApp() {
        // 1. konfigurasi Frame utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // posisi di tengah layar

        // 2. inisialisasi tabbed pane
        tabbedPane = new JTabbedPane();

        // Penting: buat panel tabel dulu agar tableModel tidak null saat tombol Simpan ditekan
        // Panel input
        JPanel inputPanel = createInputPanel();
        tabbedPane.addTab("Input Data", inputPanel);

        JPanel tablePanel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", tablePanel);


        // menambahkan tabbedpane ke frame
        add(tabbedPane);
    }

    // Method untuk memuat desain tab input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // komponen nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // komponen mata pelajaran (combobox)
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] Matkul = {"Matematika Dasar", "Bahasa Indonesia", "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(Matkul);
        panel.add(cmbMatkul);

        // komponen nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // tombol simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel("")); // Placeholder kosong agar tombol di kanan
        panel.add(btnSimpan);

        // tombol reset
        JButton btnReset = new JButton("Reset");
        panel.add(new JLabel("")); // Placeholder kosong agar tombol di kanan
        panel.add(btnReset);

        // event handling tombol disimpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        // event handling tombol reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
                txtNama.requestFocus();
            }
        });

        return panel;
    }

    // method untuk membuat tabel desain tab tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // setup model tabel (kolom)
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        // membungkus tabel dengan scrollpane (agar bisa discroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel tombol di bagian bawah
        JPanel buttonPanel = new JPanel();
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        buttonPanel.add(btnHapus);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Event handler tombol hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow();
                if (selectedRow > -1) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(
                        ManajemenNilaiSiswaApp.this,
                        "Data berhasil dihapus!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        ManajemenNilaiSiswaApp.this,
                        "Pilih baris yang ingin dihapus terlebih dahulu!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        return panel;
    }

    // logika validasi dan penyimpanan data
    private void prosesSimpan() {
        // 1. ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String nilaiStr = txtNilai.getText();

        // 2. validasi input

        // validasi 1: Cek apakah nama kosong
        if (nama == null || nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; // hentikan proses
        }

        // validasi 1b: Cek apakah nama minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; // hentikan proses
        }

        // validasi 2: cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(nilaiStr.trim());
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 hingga 100!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
                return; // hentikan proses
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; // hentikan proses
        }

        // 3. logika bisnis (Menentukan grade) menggunakan switch-case pada kelompok nilai
        int bucket = nilai / 10; // 0-10
        String grade;
        switch (bucket) {
            case 10: // nilai == 100
            case 9:  // 90-99
            case 8:  // 80-89
                grade = "A"; break;
            case 7:  // 70-79
                grade = "AB"; break;
            case 6:  // 60-69
                grade = "B"; break;
            case 5:  // 50-59
                grade = "BC"; break;
            case 4:  // 40-49
                grade = "C"; break;
            case 3:  // 30-39
                grade = "D"; break;
            default: // <30
                grade = "E"; break;
        }

                // String grade;
        // if (nilai >= 80) {
        //     grade = "A";
        // } else if (nilai >= 70) {
        //     grade = "AB";
        // } else if (nilai >= 60) {
        //     grade = "B";
        // } else if (nilai >= 50) {
        //     grade = "BC";
        // } else if (nilai >= 40) {
        //     grade = "C";
        // } else if (nilai >= 30) {
        //     grade = "D";
        // } else {
        //     grade = "E";
        // }

        // 4. masukan ke tabel (update Model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan Pindah Tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        tabbedPane.setSelectedIndex(1); // otomatis pindah ke tab tabel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}
