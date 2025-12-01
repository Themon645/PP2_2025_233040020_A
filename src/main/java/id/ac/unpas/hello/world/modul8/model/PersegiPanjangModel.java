package id.ac.unpas.hello.world.modul8.model;

public class PersegiPanjangModel {
  private double panjang;
  private double lebar;
  private double luas;
  private double keliling;

  // Menghitung luas (logika bisnis)
  public void hitungLuas() {
    this.luas = this.panjang * this.lebar;
  }

  // Menghitung keliling (logika bisnis)
  public void hitungKeliling() {
    this.keliling = 2 * (this.panjang + this.lebar);
  }

  // Getter dan Setter
  public void setPanjang(double panjang) {
    this.panjang = panjang;
  }

  public void setLebar(double lebar) {
    this.lebar = lebar;
  }

  public double getLuas() {
    return this.luas;
  }

  public double getKeliling() {
    return this.keliling;
  }
}
