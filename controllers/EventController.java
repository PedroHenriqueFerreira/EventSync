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

public class EventController implements Observer {
    private Model model;
    private MainView mainView;
    private EventView view;

    public EventController(Model model, MainView mainView, EventView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }        

    public void viewCreateActivity() {
        this.mainView.changeView("create_activity");
    }

    public void viewActivity(Activity activity) {
        this.model.setSelectedActivity(activity);
        this.mainView.changeView("activity");
    }

    public void viewUpdateEvent() {
        this.mainView.changeView("update_event");
    }

    public void viewBuyEvent() {
        Time time = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());

        Date date = new Date(
            LocalDate.now().getDayOfMonth(), 
            LocalDate.now().getMonthValue(), 
            LocalDate.now().getYear()
        );

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

    public void viewHome() {
        this.mainView.changeView("home");
    }

    public void update() {}
}
