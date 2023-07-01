import javax.swing.SwingUtilities;

import models.Model;
import views.MainView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                MainView mainView = new MainView();

                mainView.registerView.initialize(model);
            }
        });
    }
}