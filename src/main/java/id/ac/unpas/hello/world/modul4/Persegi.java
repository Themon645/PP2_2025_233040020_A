package id.ac.unpas.hello.world.modul4;

public class Persegi extends BangunDatar implements DapatDiwarnai {
	private double sisi;
	private String warna = "Hitam";

	public Persegi(double sisi) {
		this.sisi = sisi;
	}

	public Persegi(double sisi, String warna) {
		this.sisi = sisi;
		this.warna = warna;
	}

	@Override
	public double hitungLuas() {
		return sisi * sisi;
	}

	@Override
	public void warnai(String warna) {
		System.out.println("Persegi diwarnai " + warna);
	}

	@Override
	public void cetakInfo() {
		System.out.println("Ini adalah Persegi, Warna: " + warna + ", Sisi: " + sisi);
	}

	private static String formatLuas(double luas, boolean withEllipsis) {
		String formatted;
		// Tampilkan 1 desimal untuk bilangan bulat .0, atau 3 desimal untuk lainnya
		if (Math.abs(luas - Math.rint(luas)) < 1e-9) {
			formatted = String.format("%.1f", luas);
		} else {
			formatted = String.format("%.3f", luas);
		}
		return withEllipsis ? formatted + "..." : formatted;
	}

	public static void main(String[] args) {
		System.out.println("--- Info Bangun Datar (Polimorfisme) ---");

		BangunDatar b1 = new Persegi(5, "Hitam");
		BangunDatar b2 = new Lingkaran(3);

		// Persegi
		b1.cetakInfo();
		System.out.println("Luas: " + formatLuas(b1.hitungLuas(), false));
		if (b1 instanceof DapatDiwarnai) {
			((DapatDiwarnai) b1).warnai("Merah");
		}
		System.out.println("--------------------");

		// Lingkaran
		b2.cetakInfo();
		System.out.println("Luas: " + formatLuas(b2.hitungLuas(), true));
		System.out.println("--------------------");
	}
}
