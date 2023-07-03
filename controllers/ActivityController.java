package controllers;

import models.Activity;
import models.Event;
import models.Model;
import utils.Observer;
import views.ActivityView;
import views.MainView;

/*
 * Controller de atividades
 */
public class ActivityController implements Observer {
    private Model model;
    private MainView mainView;
    private ActivityView view;

    /*
     * Construtor
     */
    public ActivityController(Model model, MainView mainView, ActivityView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Deleta uma atividade e volta para a view de evento
     */
    public void deleteActivity() {
        Event event = this.model.getSelectedEvent();
        Activity activity = this.model.getSelectedActivity();

        if (event == null || activity == null) return;

        /*
         * Remove a atividade do evento
         */
        event.removeActivity(activity);

        /*
         * Notifica os observadores e muda para a view de evento
         */
        this.model.notifyObservers();
        this.mainView.changeView("event");
    }

    /*
     * Muda para a view de atualizar atividade
     */
    public void updateActivity() {
        this.mainView.changeView("update_activity");
    }

    /*
     * Muda para a view de evento
     */
    public void viewEvent() {
        this.mainView.changeView("event");
    }

    public void update() {}
}
