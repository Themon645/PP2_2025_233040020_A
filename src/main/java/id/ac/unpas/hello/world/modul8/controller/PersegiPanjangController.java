package id.ac.unpas.hello.world.modul8.controller;

import id.ac.unpas.hello.world.modul8.model.PersegiPanjangModel;
import id.ac.unpas.hello.world.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
  // model dan view sebagai atribut kelas
  private PersegiPanjangModel model;
  private PersegiPanjangView view;

  public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
    this.model = model;
    this.view = view;

    // menhubungkan tombol di view dengan logic di controller
    this.view.addHitungListener(new HitungListener());
    this.view.addHitungKelilingListener(new HitungKelilingListener());
    this.view.addResetListener(new ResetListener());
  }
  
  //inner class untuk menangani event tombol 
  class HitungListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        // 1. ambil input dari view
        double panjang = view.getPanjang();
        double lebar = view.getLebar();

        // 2. kirim input ke model
        model.setPanjang(panjang);
        model.setLebar(lebar);

        // 3. jalankan proses perhitungan di model
        model.hitungLuas();

        // 4. ambil hasil dari model dan tampilkan di view
        double hasil = model.getLuas();
        view.setHasil(hasil);
      } catch (NumberFormatException ex) {
        // handle jika user memasukkan huruf
        view.showError("Masukan angka yang valid.");
      }
    }
  }

  //inner class untuk menangani event tombol hitung keliling
  class HitungKelilingListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        // 1. ambil input dari view
        double panjang = view.getPanjang();
        double lebar = view.getLebar();

        // 2. kirim input ke model
        model.setPanjang(panjang);
        model.setLebar(lebar);

        // 3. jalankan proses perhitungan keliling di model
        model.hitungKeliling();

        // 4. ambil hasil dari model dan tampilkan di view
        double keliling = model.getKeliling();
        view.setKeliling(keliling);
      } catch (NumberFormatException ex) {
        // handle jika user memasukkan huruf
        view.showError("Masukan angka yang valid.");
      }
    }
  }

  //inner class untuk menangani event tombol reset
  class ResetListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // reset semua field dan hasil di view
      view.resetFields();
    }
  }
}
