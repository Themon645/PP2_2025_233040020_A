package id.ac.unpas.hello.world.modul6;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ContohBorderLayout {
    public static void main(String[] args) {
      // 1. membuat frame
      JFrame frame = new JFrame("Contoh BorderLayout");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);
      // Jframe sudah menggunakan BorderLayout secara default

      //2. buat dan tambahkan komponen ke 5 wilayah
      frame.add(new JButton("NORTH"), BorderLayout.NORTH);
      frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
      frame.add(new JButton("EAST"), BorderLayout.EAST);
      frame.add(new JButton("WEST"), BorderLayout.WEST);
      frame.add(new JButton("CENTER"), BorderLayout.CENTER);

      // 3. tampilkan frame
      frame.setVisible(true);
    }
}
