package id.ac.unpas.hello.world.modul4;

public class kendaraan {
  protected String merk;
  protected int tahun;
  protected String pintu;

  public kendaraan(String merk, int tahun, String pintu) {
    this.merk = merk;
    this.tahun = tahun;
    this.pintu = pintu;
  }

  public void klakson() {
    System.out.println("Tin Tin!");
  }

  public void info() {
    System.out.println("Merk: " + merk + ", Tahun: " + tahun);
    System.out.println("Jumlah Pintu: " + pintu);
  }
}
