package views;

import javax.swing.JFrame;

import models.Model;
import utils.Constraints;

import java.awt.CardLayout;

/*
 * View principal que contém todas as outras views
 */
public class MainView extends JFrame {
    /*
     * Layout de cartas
     */
    private CardLayout cardLayout;

    private Model model;

    /*
     * Construtor
     */ 
    public MainView(Model model) {
        super("Sistema de eventos");

        this.cardLayout = new CardLayout();
        this.model = model;

        this.setSize(1920, 1080);
        this.setBackground(Constraints.BG_COLOR);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(this.cardLayout);

        /*
         * Adiciona as views passando o model e a view principal
         */
        this.add(new LoginView(this.model, this), "login");
        this.add(new RegisterView(this.model, this), "register");
        this.add(new HomeView(this.model, this), "home");
        this.add(new AccountView(this.model, this), "account");
        this.add(new UpdateAccountView(this.model, this), "update_account");
        this.add(new CreateEventView(this.model, this), "create_event");
        this.add(new EventView(this.model, this), "event");
        this.add(new UpdateEventView(this.model, this), "update_event");
        this.add(new ActivityView(this.model, this), "activity");
        this.add(new CreateActivityView(this.model, this), "create_activity");
        this.add(new UpdateActivityView(this.model, this), "update_activity");
    }

    /*
     * Troca a view atual pela a view com o nome passado
     */
    public void changeView(String screen) {
        this.cardLayout.show(this.getContentPane(), screen);
    }
}