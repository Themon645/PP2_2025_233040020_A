package id.ac.unpas.hello.world.modul10;

import id.ac.unpas.hello.world.modul10.view.MahasiswaApp;
import javax.swing.SwingUtilities;

public class main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MahasiswaApp().setVisible(true));
	}
}
