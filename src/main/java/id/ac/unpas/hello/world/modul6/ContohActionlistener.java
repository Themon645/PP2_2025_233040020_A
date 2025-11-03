package id.ac.unpas.hello.world.modul6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContohActionlistener {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Contoh ActionListener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

    // 1. buat komponen label dan tombol (event source dan komponen lain)
    JLabel label = new JLabel("Tekan tombol di bawah");
    JButton button = new JButton("Klik Saya!");

    // 2. tambahkan ActionListener ke tombol
    // kita menggunakan kelas anonim untuk ActionListener
    ActionListener listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 3. logika yang dieksekusi saat event terjadi
        label.setText("Tombol telah diklik!");
      }
    };

    // 4. daftarkan listener ke source (tombol)
    button.addActionListener(listener);

    // tambahkan komponen ke frame
    frame.add(label);
    frame.add(button);
    frame.setVisible(true);
  }
}
