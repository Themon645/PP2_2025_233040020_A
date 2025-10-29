package id.ac.unpas.hello.world.modul3;

public class ProgramBukuError {
    public static void main(String[] args) {
        Buku buku = new Buku("Pemrograman Java Dasar", "Andi", 150);

        // 10. Perbaikan: gunakan getter untuk mengakses jumlahHalaman
        System.out.println("Akses jumlahHalaman (via getter): " + buku.getHalaman());
    }
}
