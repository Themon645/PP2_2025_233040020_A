package id.ac.unpas.hello.world.modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan4 {
  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              JFrame frame = new JFrame("Contoh BorderLayout");
              frame.setSize(400, 300);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              // 1. Mengatur layout manager menjadi BorderLayout
              //sebenarnya ini tidak perlu
              //karena BorderLayout adalah manajer default
              frame.setLayout(new BorderLayout());

              // 2. Membuat komponen 
              JLabel label = new JLabel("Label ada di Atas (NORTH)");
              JButton button = new JButton("tombol ada di bawah (SOUTH)");

              // 3. tambahkan Aksi (actionListener) ke tombol
              button.addActionListener(e -> {
                  label.setText("Tombol di SOUTH diklik!");
              });

              // 4. tambahkan komponen ke frame DENGAN POSISI
              frame.add(label, BorderLayout.NORTH);
              frame.add(button, BorderLayout.SOUTH);
              
        //kita bisa tambahkan komponen lain dan beri aksi
        JButton buttonWest = new JButton("WEST");
  buttonWest.addActionListener(e -> { e.getActionCommand(); label.setText("Tombol di WEST diklik!"); });
        frame.add(buttonWest, BorderLayout.WEST);

        JButton buttonEast = new JButton("EAST");
  buttonEast.addActionListener(e -> { e.getActionCommand(); label.setText("Tombol di EAST diklik!"); });
        frame.add(buttonEast, BorderLayout.EAST);

        JButton buttonCenter = new JButton("CENTER");
  buttonCenter.addActionListener(e -> { e.getActionCommand(); label.setText("Tombol di CENTER diklik!"); });
        frame.add(buttonCenter, BorderLayout.CENTER);


              frame.setVisible(true);
          }
      });
  }
}
