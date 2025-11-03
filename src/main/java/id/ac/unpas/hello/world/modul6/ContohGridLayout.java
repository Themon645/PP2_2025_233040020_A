<<<<<<< HEAD
package id.ac.unpas.hello.world.modul6;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ContohGridLayout {
  public static void main(String[] args) {
    // 1. membuat frame
    JFrame frame = new JFrame("Contoh GridLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    // 2. atur layout framme menjadi GridLayout 3 baris 2 kolom
    // kita juga bisa menambahkan jarak antar(gap) sel(komponen)
    frame.setLayout(new GridLayout(3, 2, 5, 5)); //3 baris, 2 kolom, horizontal gap 5px, vertical gap 5px

    //3. tambahkan 6 komponen (3x2=6)
    frame.add(new JLabel("Label 1:"));
    frame.add(new JTextField());
    frame.add(new JLabel("Label 2:"));
    frame.add(new JPasswordField());
    frame.add(new JLabel("Login:"));
    frame.add(new JButton("Batal"));

    //4. tampilkan frame
    frame.setVisible(true);
}
}
=======
package id.ac.unpas.hello.world.modul6;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ContohGridLayout {
  public static void main(String[] args) {
    // 1. membuat frame
    JFrame frame = new JFrame("Contoh GridLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    // 2. atur layout framme menjadi GridLayout 3 baris 2 kolom
    // kita juga bisa menambahkan jarak antar(gap) sel(komponen)
    frame.setLayout(new GridLayout(3, 2, 5, 5)); //3 baris, 2 kolom, horizontal gap 5px, vertical gap 5px

    //3. tambahkan 6 komponen (3x2=6)
    frame.add(new JLabel("Label 1:"));
    frame.add(new JTextField());
    frame.add(new JLabel("Label 2:"));
    frame.add(new JPasswordField());
    frame.add(new JLabel("Login:"));
    frame.add(new JButton("Batal"));

    //4. tampilkan frame
    frame.setVisible(true);
}
}
>>>>>>> 479be1fe31276ba48918b2a0a6f9a9c8340d2902
