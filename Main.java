import javax.swing.SwingUtilities;

import views.MainView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}