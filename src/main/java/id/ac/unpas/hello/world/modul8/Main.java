package id.ac.unpas.hello.world.modul8;

import id.ac.unpas.hello.world.modul8.controller.PersegiPanjangController;
import id.ac.unpas.hello.world.modul8.model.PersegiPanjangModel;
import id.ac.unpas.hello.world.modul8.view.PersegiPanjangView;

public class Main {
  public static void main(String[] args) {
    // 1. instalasi model
    PersegiPanjangModel model = new PersegiPanjangModel();

    //2. instalasi view
    PersegiPanjangView view = new PersegiPanjangView();

    //3. instalasi controller (hubungkan model dan view)
    PersegiPanjangController controller = new PersegiPanjangController(model, view);

    // 4. tampilkan UI
    view.setVisible(true);
  }
}
