package views;

import javax.swing.JFrame;

import java.awt.CardLayout;

public class MainView extends JFrame {
    private CardLayout cardLayout;

    public MainView() {
        super("SISTEMA DE EVENTOS");
        
        this.cardLayout = new CardLayout();

        this.setLayout(this.cardLayout);

        this.createViews();

        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createViews() {
        this.add(new RegisterView(this), "register");
        this.add(new LoginView(this), "login");
    }

    public void changeScreen(String screen) {
        this.cardLayout.show(this.getContentPane(), screen);
    }
}