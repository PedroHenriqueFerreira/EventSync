package controllers;

import java.util.ArrayList;

import models.Activity;
import models.Admin;
import models.Event;
import models.Model;
import models.Participant;
import models.User;
import utils.ComponentsFactory;
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
        User user = this.model.getLoggedUser();

        ArrayList<String> errors = new ArrayList<String>();

        if (event == null || activity == null || user == null) {
            errors.add("• Não foi possível deletar a atividade");
        }

        if (user instanceof Participant) {
            errors.add("• Você não tem permissão para deletar a atividade");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

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
     * Participa de uma atividade
     */
    public void joinActivity() {
        User user = this.model.getLoggedUser();
        Activity activity = this.model.getSelectedActivity();
        
        /*
         * Verifica se o usuário e a atividade existem e se o usuário não é um admin
         */
        ArrayList<String> errors = new ArrayList<String>();

        if (user == null || activity == null) {
            errors.add("• Não foi possível participar da atividade");
        }

        if (user instanceof Admin) {
            errors.add("• Você não tem permissão para participar da atividade");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /*
         * Adiciona o usuário na atividade
         */
        activity.addParticipant((Participant) user);

        /*
         * Notifica os observadores e muda para a view de evento
         */
        this.model.notifyObservers();
    }

    /*
     * Sai de uma atividade
     */
    public void leaveActivity() {
        User user = this.model.getLoggedUser();
        Activity activity = this.model.getSelectedActivity();
        
        /*
         * Verifica se o usuário e a atividade existem e se o usuário não é um admin
         */
        ArrayList<String> errors = new ArrayList<String>();

        if (user == null || activity == null) {
            errors.add("• Não foi possível deixar a atividade");
        }

        if (user instanceof Admin) {
            errors.add("• Você não tem permissão para deixar a atividade");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /*
         * Remove o usuário da atividade
         */
        activity.removeParticipant((Participant) user);
        
        /*
         * Notifica os observadores e muda para a view de evento
         */
        this.model.notifyObservers();
    }

    /*
     * Muda para a view de evento
     */
    public void viewEvent() {
        this.mainView.changeView("event");
    }

    public void update() {}
}
