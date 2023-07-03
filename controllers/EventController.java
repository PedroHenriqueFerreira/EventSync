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

        /*
         * Notifica os observadores
         */
        this.model.notifyObservers();
    }

    /*
     * Cria um pagamento e adiciona o evento ao usuário logado
     */
    public void buyEvent() {
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

        /*
         * Cria um array de erros
         */
        ArrayList<String> errors = new ArrayList<String>();

        User loggedUser = this.model.getLoggedUser();
        Event selectedEvent = this.model.getSelectedEvent();

        if (loggedUser instanceof Admin) {
            errors.add("• Apenas usuários podem comprar eventos");
        }

        if (selectedEvent == null) {
            errors.add("• Selecione um evento");
        } 

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

    public void update() {}
}
