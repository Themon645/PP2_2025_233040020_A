package id.ac.unpas.hello.world.modul3;
public class DemoOperator {
     public static void main(String[] args) {
 int a = 10;
 int b = 4;
 // Aritmatika
 System.out.println("a + b = " + (a + b)); // 14
 System.out.println("a - b = " + (a - b)); // 6
 System.out.println("a * b = " + (a * b)); // 40
 System.out.println("a / b = " + (a / b)); // 2 (Pembagian integer, desimal
//diabaikan)
 System.out.println("a % b = " + (a % b)); // 2 (Sisa bagi 10 dibagi 4)
 // Pembanding
 int umur = 20;

 boolean cukupUmur = umur >= 17;
 System.out.println("Apakah cukup umur (>= 17)? " + cukupUmur); // true
 // Logika
 boolean punyaSIM = true;
 boolean bolehMenyetir = cukupUmur && punyaSIM;
 System.out.println("Bolehkah dia menyetir? " + bolehMenyetir); // true
 }
}

