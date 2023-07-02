package controllers;

import models.Activity;
import models.Event;
import models.Model;
import utils.Observer;
import views.ActivityView;
import views.HomeView;
import views.MainView;

public class ActivityController implements Observer {
    private Model model;
    private MainView mainView;
    private ActivityView view;

    public ActivityController(Model model, MainView mainView, ActivityView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void deleteActivity() {
        Event event = this.model.getSelectedEvent();
        Activity activity = this.model.getSelectedActivity();

        if (event == null || activity == null) return;

        event.removeActivity(activity);

        this.model.notifyObservers();
        this.mainView.changeView("event");
    }

    public void updateActivity() {
        this.mainView.changeView("update_activity");
    }

    public void viewEvent() {
        this.mainView.changeView("event");
    }

    public void update() {}
}
