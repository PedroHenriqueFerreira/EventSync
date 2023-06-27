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

        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createViews() {
        this.add(new HomeView(this), "home");
        this.add(new AccountView(this), "account");
        this.add(new LoginView(this), "login");
        this.add(new RegisterView(this), "register");
        this.add(new UpdateAccountView(this), "update_account");
    }

    public void changeScreen(String screen) {
        this.cardLayout.show(this.getContentPane(), screen);
    }
}