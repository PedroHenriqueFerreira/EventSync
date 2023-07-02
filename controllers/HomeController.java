package controllers;

import models.Model;
import utils.Observer;
import views.HomeView;
import views.MainView;

public class HomeController implements Observer {
    private Model model;
    private MainView mainView;
    private HomeView view;

    public HomeController(Model model, MainView mainView, HomeView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void viewAccount() {
        this.mainView.changeView("account");
    }

    public void logout() {  
        this.model.setLoggedUser(null);
        this.mainView.changeView("login");
    }
    
    public void viewCreateEvent() {
        this.mainView.changeView("create_event");
    }

    public void viewEvent() {
    }

    public void update() {}
}
