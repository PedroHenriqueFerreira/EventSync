package controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import models.Activity;
import models.Admin;
import models.Date;
import models.Event;
import models.Model;
import models.Participant;
import models.Payment;
import models.Time;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import views.EventView;
import views.MainView;

/*
 * Controller de eventos
 */
public class EventController implements Observer {
    private Model model;
    private MainView mainView;
    private EventView view;

    /*
     * Construtor
     */
    public EventController(Model model, MainView mainView, EventView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }        

    /*
     * Muda para a view de criar atividade
     */
    public void viewCreateActivity() {
        this.mainView.changeView("create_activity");
    }

    /* 
     * Seleciona uma atividade e muda para a view de atividade
     */
    public void viewActivity(Activity activity) {
        this.model.setSelectedActivity(activity);
        this.mainView.changeView("activity");
    }

    /*
     * Muda para a view de atualizar evento
     */
    public void viewUpdateEvent() {
        this.mainView.changeView("update_event");
    }

    /*
     * Remove o pagamento do usuário logado e remove o evento do usuário logado
     */
    public void unbuyEvent() {
        User loggedUser = this.model.getLoggedUser();
        Event selectedEvent = this.model.getSelectedEvent();

        ArrayList<String> errors = new ArrayList<String>();

        if (loggedUser == null || selectedEvent == null) {
            errors.add("• Não foi possível remover o evento");
        }

        if (loggedUser instanceof Admin) {
            errors.add("• Você não tem permissão para remover o evento");
        }
        
        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        loggedUser.removeEvent(selectedEvent);
        
        ArrayList<Payment> payments = this.model.getPayments();

        for (Payment payment : payments) {
            if (payment.getEvent() == selectedEvent && payment.getParticipant() == loggedUser) {
                this.model.removePayment(payment.getCode());
                break;
            }
        }

        /*
         * Remove o usuário logado do evento
         */
        selectedEvent.removeParticipant((Participant) loggedUser);

        for (Activity activity : selectedEvent.getActivities()) {
            activity.removeParticipant((Participant) loggedUser);
        }

        /*
         * Notifica os observadores
         */
        this.model.notifyObservers();
    }

    /*
     * Cria um pagamento e adiciona o evento ao usuário logado
     */
    public void buyEvent() {
        User loggedUser = this.model.getLoggedUser();
        Event selectedEvent = this.model.getSelectedEvent();

        /*
         * Cria um array de erros
         */
        ArrayList<String> errors = new ArrayList<String>();

        if (loggedUser == null || selectedEvent == null) {
            errors.add("• Não foi possível comprar o evento");
        }

        if (loggedUser instanceof Admin) {
            errors.add("• Você não tem permissão para comprar o evento");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /* 
         * Cria um objeto Time com a hora e minuto atual
         */
        Time time = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());

        /*
         * Cria um objeto Date com o dia, mês e ano atual
         */
        Date date = new Date(
            LocalDate.now().getDayOfMonth(), 
            LocalDate.now().getMonthValue(), 
            LocalDate.now().getYear()
        );

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        Payment payment = new Payment(
            date,
            time,
            this.model.getSelectedEvent(),
            (Participant) loggedUser
        );

        this.model.addPayment(payment);

        loggedUser.addEvent(selectedEvent);
        
        this.model.notifyObservers();
    }

    /*
     * Muda para a view home
     */
    public void viewHome() {
        this.mainView.changeView("home");
    }

    /*
     * Deleta o evento selecionado
     */
    public void deleteEvent() {
        Event event = this.model.getSelectedEvent();
        User user = this.model.getLoggedUser();

        ArrayList<String> errors = new ArrayList<String>();

        if (event == null || user == null) {
            errors.add("Não foi possível deletar o evento");
        }

        if (user instanceof Participant) {
            errors.add("Você não tem permissão para deletar o evento");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /*
         * Remove o evento
         */
        this.model.removeEvent(event.getCode());

        this.mainView.changeView("home");
    }

    public void update() {}
}
