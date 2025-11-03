<<<<<<< HEAD
package id.ac.unpas.hello.world.modul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContohMouseListener {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Contoh MouseListener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);

    // 1. buat komponen (event source)
    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setPreferredSize(new Dimension(200, 200));
    

    //2. buat event Listener (menggunakan mouseAdapter)
    MouseAdapter adapter = new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        // saat mouse masuk , ubah warna menjadi biru
        panel.setBackground(Color.CYAN);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // saat mouse keluar , kembalikan warna
        panel.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // saat dikilik, tampilkan koordinat mouse
        System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
      }
    };

    //3. daftarkan listener ke source (panel)
    panel.addMouseListener(adapter);

    frame.add(panel);
    frame.setVisible(true);
  }
}
=======
package id.ac.unpas.hello.world.modul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContohMouseListener {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Contoh MouseListener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);

    // 1. buat komponen (event source)
    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setPreferredSize(new Dimension(200, 200));
    

    //2. buat event Listener (menggunakan mouseAdapter)
    MouseAdapter adapter = new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        // saat mouse masuk , ubah warna menjadi biru
        panel.setBackground(Color.CYAN);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // saat mouse keluar , kembalikan warna
        panel.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // saat dikilik, tampilkan koordinat mouse
        System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
      }
    };

    //3. daftarkan listener ke source (panel)
    panel.addMouseListener(adapter);

    frame.add(panel);
    frame.setVisible(true);
  }
}
>>>>>>> 479be1fe31276ba48918b2a0a6f9a9c8340d2902
