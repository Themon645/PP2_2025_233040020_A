package id.ac.unpas.hello.world.modul5;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan2 {
  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              JFrame frame = new JFrame("Jendela dengan Label");
              frame.setSize(400, 300);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              // 1. Membuat komponen JLabel
              JLabel label = new JLabel("Ini adalah Jlabel");

              // 2. Menambahkan JLabel ke JFrame
              // secara default, JFrame memiliki layout BorderLayout
              // dan .add() menambahkan komponen ke posisi CENTER
              frame.getContentPane().add(label);

              frame.setVisible(true);
          }
      });
  }
  
}
