package id.ac.unpas.hello.world.modul3;

public class ProgramSiswa {
    public static void main(String[] args) {
        Siswa siswa1 = new Siswa("Budi", "10A", "12345");
        Siswa siswa2 = new Siswa("Siti", "10B", "67890");

        siswa1.infoSiswa();
        siswa2.infoSiswa();
    }
}
