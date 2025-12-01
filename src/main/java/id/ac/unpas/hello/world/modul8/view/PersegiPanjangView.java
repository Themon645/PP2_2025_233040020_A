package id.ac.unpas.hello.world.modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
  // komponen Ui sebagai atribut
  private JTextField txtPanjang = new JTextField(10);
  private JTextField txtLebar = new JTextField(10);
  private JLabel lblHasil = new JLabel("-");
  private JLabel lblKeliling = new JLabel("-");
  private JButton btnHitung = new JButton("Hitung Luas");
  private JButton btnHitungKeliling = new JButton("Hitung Keliling");
  private JButton btnReset = new JButton("Reset");

  public PersegiPanjangView() {
    // inisialisasi UI
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 280);
    this.setLayout(new GridLayout(6, 2, 10, 10));// 6 grid baris
    this.setTitle("MVC kalkulator");

    this.add(new JLabel("Panjang:"));
    this.add(txtPanjang);
    this.add(new JLabel("Lebar:"));
    this.add(txtLebar);
    this.add(new JLabel("Hasil Luas:"));
    this.add(lblHasil);
    this.add(new JLabel("Hasil Keliling:"));
    this.add(lblKeliling);
    this.add(btnHitung);
    this.add(btnHitungKeliling);
    this.add(new JLabel("")); //spacer kosong
    this.add(btnReset);
  }

  // mengambil nilai panjang dari text field
  public double getPanjang() {
    return Double.parseDouble(this.txtPanjang.getText());
  }

  // mengambil nilai lebar dari text field
  public double getLebar() {
    return Double.parseDouble(this.txtLebar.getText());
  }

  // menampilkan hasil ke label
  public void setHasil(double hasil) {
    this.lblHasil.setText(String.valueOf(hasil));
  }

  // menampilkan hasil keliling ke label
  public void setKeliling(double keliling) {
    this.lblKeliling.setText(String.valueOf(keliling));
  }

  // mereset semua field dan hasil
  public void resetFields() {
    this.txtPanjang.setText("");
    this.txtLebar.setText("");
    this.lblHasil.setText("-");
    this.lblKeliling.setText("-");
  }

  // menampilkan pesan error (jika input bukan angka)
  public void showError(String pesan) {
    JOptionPane.showMessageDialog(this, pesan);
  }

  // mendaftarkan listener untuk tombol hitung (controller yang akan memberikan aksi)
  public void addHitungListener(ActionListener listener) {
    btnHitung.addActionListener(listener);
  }

  // mendaftarkan listener untuk tombol hitung keliling
  public void addHitungKelilingListener(ActionListener listener) {
    btnHitungKeliling.addActionListener(listener);
  }

  // mendaftarkan listener untuk tombol reset
  public void addResetListener(ActionListener listener) {
    btnReset.addActionListener(listener);
  }
}
