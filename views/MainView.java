package views;

import javax.swing.JFrame;

import java.awt.CardLayout;

public class MainView extends JFrame {
    private CardLayout cardLayout;

    public RegisterView registerView = new RegisterView();

    public MainView() {
        super("Sistema de eventos");
        
        this.cardLayout = new CardLayout();

        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(this.cardLayout);

        this.add(this.registerView,  "register");
    }
    
    public void createViews() {
        // this.add(new LoginView(this), "login");
        // this.add(new UpdateEventView(this), "update_event");
        // this.add(new HomeView(this), "home");
        // this.add(new UpdateAccountView(this), "update_account");
        // this.add(new AccountView(this), "account");
        // this.add(new EventView(this), "event");
    }

    public void changeView(String screen) {
        this.cardLayout.show(this.getContentPane(), screen);
    }
}