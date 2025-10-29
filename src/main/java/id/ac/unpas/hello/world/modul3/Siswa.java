package id.ac.unpas.hello.world.modul3;

public class Siswa {
  String nama;
  String kelas;
  String nis;

  public Siswa(String nama, String kelas, String nis) {
    this.nama = nama;
    this.kelas = kelas;
    this.nis = nis;
  }

  void infoSiswa() {
    System.out.println("Nama: " + nama + ", Kelas: " + kelas + ", NIS: " + nis);
  }
}
