<<<<<<< HEAD
package id.ac.unpas.hello.world.modul6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContohFlowLayout {
  public static void main(String[] args) {
    // 1. untuk frame (window)
    JFrame frame = new JFrame("Contoh FlowLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    // 2. untuk panel (tempat komponen)
    //Jpanel secara default sunah menggunakan FlowLayout
    JPanel panel = new JPanel();
    // anda juga bisa mengaturnya secara eksplisit
    // panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //CENTER, LEFT atau RIGHT

    //3. Buat dan tambahkan kkomponen ke panel
    panel.add(new JButton("Tombol 1"));
    panel.add(new JButton("Tombol 2"));
    panel.add(new JButton("Tombol Tiga"));
    panel.add(new JButton("Tombol Empat Panjang"));
    panel.add(new JButton("Tombol 5"));

    //4. tambahkan panel ke frame
    frame.add(panel);

    //5. tampilkan frame
    frame.setVisible(true);
  }
}
=======
package id.ac.unpas.hello.world.modul6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContohFlowLayout {
  public static void main(String[] args) {
    // 1. untuk frame (window)
    JFrame frame = new JFrame("Contoh FlowLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    // 2. untuk panel (tempat komponen)
    //Jpanel secara default sunah menggunakan FlowLayout
    JPanel panel = new JPanel();
    // anda juga bisa mengaturnya secara eksplisit
    // panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //CENTER, LEFT atau RIGHT

    //3. Buat dan tambahkan kkomponen ke panel
    panel.add(new JButton("Tombol 1"));
    panel.add(new JButton("Tombol 2"));
    panel.add(new JButton("Tombol Tiga"));
    panel.add(new JButton("Tombol Empat Panjang"));
    panel.add(new JButton("Tombol 5"));

    //4. tambahkan panel ke frame
    frame.add(panel);

    //5. tampilkan frame
    frame.setVisible(true);
  }
}
>>>>>>> 479be1fe31276ba48918b2a0a6f9a9c8340d2902
