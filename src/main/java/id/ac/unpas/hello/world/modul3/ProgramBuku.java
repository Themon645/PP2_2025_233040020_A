package id.ac.unpas.hello.world.modul3;

public class ProgramBuku {
    public static void main(String[] args) {
        Buku buku = new Buku("Pemrograman Java Dasar", "Andi", 150);

        // 7. Coba panggil getInfoBuku()
        buku.getInfoBuku();

        // Tampilkan halaman saat ini
        System.out.println("Halaman (awal): " + buku.getHalaman());

        // 8. Coba panggil setHalaman(300)
        buku.setHalaman(300);
        System.out.println("Halaman (setelah set 300): " + buku.getHalaman());

        // 9. Coba panggil setHalaman(-50)
        buku.setHalaman(-50); // akan menampilkan pesan error
        System.out.println("Halaman (setelah set -50): " + buku.getHalaman());

        // Catatan: Akses langsung jumlahHalaman ada di ProgramBukuError.java
        // untuk mendemonstrasikan error kompilasi sesuai butir (10).
    }
}
