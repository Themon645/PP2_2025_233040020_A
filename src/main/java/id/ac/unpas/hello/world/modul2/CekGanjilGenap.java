package id.ac.unpas.hello.world.modul2;

public class CekGanjilGenap {
    public static void main(String[] args) {
        // 1. Buat variabel int bernama angka dan beri nilai (misalnya, 7)
        int angka = 7;

        // 2 & 3. Gunakan operator modulo (%) dan pernyataan if-else
        if (angka % 2 == 0) {
            System.out.println("Angka " + angka + " adalah genap.");
        } else {
            System.out.println("Angka " + angka + " adalah ganjil.");
        }
    }
}
