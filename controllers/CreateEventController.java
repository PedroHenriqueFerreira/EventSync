package controllers;

import models.Model;
import utils.Observer;
import views.CreateEventView;
import views.MainView;

public class CreateEventController implements Observer {
    private Model model;
    private MainView mainView;
    private CreateEventView view;

    public CreateEventController(Model model, MainView mainView, CreateEventView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void createEvent() {
    }

    public void viewHome() {
        this.mainView.changeView("home");
    }

    public void update() {}
}
