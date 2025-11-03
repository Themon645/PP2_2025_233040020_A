package id.ac.unpas.hello.world.modul3;

public class Buku {
    private String judul;
    private String penulis;
    private int jumlahHalaman; // harus private

    public Buku(String judul, String penulis, int jumlahHalaman) {
        this.judul = judul;
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
    }

    // Getter-style method: mencetak judul dan penulis
    public void getInfoBuku() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis);
    }

    // Getter jumlahHalaman
    public int getHalaman() {
        return jumlahHalaman;
    }

    // Setter jumlahHalaman dengan validasi
    public void setHalaman(int halamanBaru) {
        if (halamanBaru > 0) {
            this.jumlahHalaman = halamanBaru;
        } else {
            System.out.println("Error: jumlah halaman harus lebih besar dari 0.");
        }
    }
}
