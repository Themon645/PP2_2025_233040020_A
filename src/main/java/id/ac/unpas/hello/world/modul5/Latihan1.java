package id.ac.unpas.hello.world.modul5;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Latihan1 {
    public static void main(String[] args) {
          //menjalankan kode GUI di event dispatch thread (EDT)
          //ini adalah praktik terbaik untuk menghindari masalah thread
          //akan dijelaskan lebih detail nanti
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Membuat objek JFrame
                JFrame frame = new JFrame("Jendela Pertamaku");

                // 2. mengatur ukuran jendela (lebar: 400, tinggi: 300)
                frame.setSize(400, 300);

                // 3. mengatur aksi saat tombol close (x) ditekan
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 4. buat jendela terlihat
                frame.setVisible(true);
            }
        });
    }
  
}
