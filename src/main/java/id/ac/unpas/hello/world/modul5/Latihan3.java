package id.ac.unpas.hello.world.modul5;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Latihan3 {
  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              JFrame frame = new JFrame("Label dan Tombol");
              frame.setSize(400, 300);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              // 1. Mengatur layout manager menjadi FlowLayout
              // flowLayout mengatur komponen dari kiri ke kanan.
              frame.setLayout(new FlowLayout());

              // 2. Membuat komponen GUI
              JLabel label = new JLabel("Teks Awal");
              JButton button = new JButton("Klik Saya!");

              /* 3. Tambahkan Aksi (actionListener) ke tombol
               * Penambahan ini menggunakan lambda untuk mempersingkat
               * penggunaan anonymous inner class
               */
              button.addActionListener(e -> {
                  // Aksi ini akan mengubah teks pada label
                  label.setText("Tombol berhasil diklik!");
              });

              /* 4. tambahkan komponen ke frame
               * karena kita menggunakan FlowLayout,
               * keduanya akan tampil berdampingan
               */
              frame.getContentPane().add(label);
              frame.getContentPane().add(button);

              frame.setVisible(true);
          }
      });
  }
}
