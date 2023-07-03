package controllers;

import models.Event;
import models.Model;
import utils.Observer;
import views.HomeView;
import views.MainView;

/* 
 * Controller de home
*/
public class HomeController implements Observer {
    private Model model;
    private MainView mainView;
    private HomeView view;

    /*
     * Construtor
     */
    public HomeController(Model model, MainView mainView, HomeView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Muda para a view da minha conta
     */
    public void viewAccount() {
        this.mainView.changeView("account");
    }

    /*
     * Muda para a view de login e remove o usuário logado
     */
    public void logout() {  
        this.model.setLoggedUser(null);
        this.mainView.changeView("login");
    }
    
    /*
     * Muda para a view de criar evento
     */
    public void viewCreateEvent() {
        this.mainView.changeView("create_event");
    }

    /*
     * Seleciona um evento e muda para a view de evento
     */
    public void viewEvent(Event event) {
        this.model.setSelectedEvent(event);
        this.mainView.changeView("event");
    }

    public void update() {}
}
