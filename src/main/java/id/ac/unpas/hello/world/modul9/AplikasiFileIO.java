package id.ac.unpas.hello.world.modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

  // komponen UI
  private JTextArea textArea;
  private JButton btnOpenText, btnSaveText, btnAppendText;
  private JButton btnSaveBinary, btnLoadBinary;
  private JFileChooser fileChooser;

  public AplikasiFileIO() {
    super("Tutorial File IO & Exception Handling");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // inisialisasi komponen
    textArea = new JTextArea();
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    fileChooser = new JFileChooser();

    // panel tombol
    JPanel panelButtons = new JPanel();
    btnOpenText = new JButton("Buka File");
    btnSaveText = new JButton("Simpan File");
    btnAppendText = new JButton("Tambah ke File");
    btnSaveBinary = new JButton("Simpan Config (Binary)");
    btnLoadBinary = new JButton("Muat Config (Binary)");

    panelButtons.add(btnOpenText);
    panelButtons.add(btnSaveText);
    panelButtons.add(btnAppendText);
    panelButtons.add(btnSaveBinary);
    panelButtons.add(btnLoadBinary);

    add(new JScrollPane(textArea), BorderLayout.CENTER);
    add(panelButtons, BorderLayout.SOUTH);

    // --- event handling ---

    // 1. membaca file teks (text stream)
    btnOpenText.addActionListener(e -> bukaFileText());

    // 2. menulis file teks (text stream)
    btnSaveText.addActionListener(e -> simpanFileText());

    // 2b. menambahkan text ke file teks (text stream dengan append)
    btnAppendText.addActionListener(e -> tambahKeFileText());

    // 3. menulis file binary (Object stream)
    btnSaveBinary.addActionListener(e -> simpanConfigBinary());

    // 4. membaca file binary (Object stream)
    btnLoadBinary.addActionListener(e -> muatConfigBinary());

    // latihan 2 : automatis muat config saat startup
    muatLastNotes();
    
  }

  // contoh: membaca file text degan try-catch-finally konvensional
  private void bukaFileText() {
    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      BufferedReader reader = null; // deklarasi di luar try agar bisa diakses di finally
      try {
        reader = new BufferedReader(new FileReader(file));
        textArea.setText(""); // kosongkan area

        String line;
        // baca baris demi baris
        while ((line = reader.readLine()) != null) {
          textArea.append(line + "\n");
        }

        JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

      } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
      } finally {
        // blok finally: selalu dijalankan untuk menutup resource
        try {
          if (reader != null) {
            reader.close(); // PENTING: menutup stream
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  //contoh: menulis file text dengan try-with-resources (lebih modern)
  private void simpanFileText() {
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      // try-with-resources: otomatis menutup stream
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(textArea.getText());
        JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
      }
    }
  }

  // contoh: menambahkan text ke file (append) dengan FileWriter(File, boolean append)
  private void tambahKeFileText() {
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      // try-with-resources dengan FileWriter(file, true) untuk append
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        writer.write(textArea.getText());
        writer.newLine(); // tambahkan baris baru setelah text ditambahkan
        JOptionPane.showMessageDialog(this, "Text berhasil ditambahkan ke file!");
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan text ke file: " + ex.getMessage());
      }
    }
  }

  // Menyimpan objek UserConfig menggunakan ObjectOutputStream
  private void simpanConfigBinary() {
    // minta username dari pengguna sebelum menyimpan
    String username = JOptionPane.showInputDialog(this, "Masukkan username:", "Input Username", JOptionPane.QUESTION_MESSAGE);
    if (username == null) {
      return; // dibatalkan
    }
    username = username.trim();
    if (username.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Username tidak boleh kosong", "Validasi", JOptionPane.WARNING_MESSAGE);
      return;
    }

    UserConfig cfg = new UserConfig();
    cfg.setUsername(username);
    cfg.setFontSize(textArea.getFont().getSize());

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Config.bin"))) {
      oos.writeObject(cfg);
      JOptionPane.showMessageDialog(this, "Config disimpan (username: " + cfg.getUsername() + ", fontSize: " + cfg.getFontSize() + ")");
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Gagal menyimpan config: " + ex.getMessage());
    }
  }

  // Membaca objek UserConfig menggunakan ObjectInputStream dengan casting
  private void muatConfigBinary() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Config.bin"))) {
      // Membaca dan casting objek
      UserConfig cfg = (UserConfig) ois.readObject();
      
      // Terapkan ke aplikasi
      textArea.setFont(new Font("Monospaced", Font.PLAIN, cfg.getFontSize()));
      JOptionPane.showMessageDialog(this, "Config dimuat: username=" + cfg.getUsername() + ", fontSize=" + cfg.getFontSize());
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "File Config.bin tidak ditemukan: " + ex.getMessage());
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Gagal memuat config: " + ex.getMessage());
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "Kelas UserConfig tidak ditemukan: " + ex.getMessage());
    }
  }

  // Membaca file last_notes.txt (jika ada) saat startup dan menaruhnya ke textArea
  private void muatLastNotes() {
    File f = new File("last_notes.txt");
    if (!f.exists()) {
      return; // tidak ada file, abaikan
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
      }
      textArea.setText(sb.toString());
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Gagal memuat last_notes.txt: " + ex.getMessage());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      AplikasiFileIO app = new AplikasiFileIO();
      app.setVisible(true);
    });
  }
}