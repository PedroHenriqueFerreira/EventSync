package controllers;

import java.util.ArrayList;

import models.Address;
import models.Admin;
import models.Date;
import models.Event;
import models.Model;
import models.Participant;
import models.Time;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Transform;
import utils.Validator;
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
        ArrayList<String> errors = new ArrayList<String>();

        if (this.model.getLoggedUser() instanceof Participant) {
            errors.add("• Você não tem permissão para criar eventos");
        }

        if (!Validator.sizeValidator(this.view.getName(), 3, 32)) {
            errors.add("• Nome inválido");
        }

        if (!Validator.sizeValidator(this.view.getDescription(), 3, 256)) {
            errors.add("• Descrição inválida");
        }

        if (!Validator.timeValidator(this.view.getTime())) {
            errors.add("• Hora inválida");
        }

        if (!Validator.dateValidator(this.view.getDate())) {
            errors.add("• Data inválida");
        }

        if (!Validator.sizeValidator(this.view.getState(), 3, 32)) {
            errors.add("• Estado inválido");
        }

        if (!Validator.sizeValidator(this.view.getCity(), 3, 32)) {
            errors.add("• Cidade inválida");
        }

        if (!Validator.sizeValidator(this.view.getStreet(), 3, 64)) {
            errors.add("• Rua inválida");
        }

        String addressNumber = this.view.getAddressNumber();
        if (!Validator.intValidator(addressNumber) || Integer.parseInt(addressNumber) < 0) {
            errors.add("• Número inválido");
        }
    
        if (!Validator.floatValidator(this.view.getPrice())) {
            errors.add("• Preço inválido");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }
        
        Address address = new Address(
            this.view.getState(),
            this.view.getCity(),
            this.view.getStreet(),
            Integer.parseInt(addressNumber)
        );

        Event event = new Event(
            (Admin) this.model.getLoggedUser(),
            this.view.getName(),
            this.view.getDescription(),
            Transform.toDate(this.view.getDate()),
            Transform.toTime(this.view.getTime()),
            address,
            Transform.toFloat(this.view.getPrice())
        );

        this.model.addEvent(event);
        
        this.view.clearFields();
        this.mainView.changeView("home");
    }

    public void viewHome() {
        this.mainView.changeView("home");
    }

    public void update() {}
}
