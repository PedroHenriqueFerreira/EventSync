package controllers;

import java.util.ArrayList;

import models.Address;
import models.Admin;
import models.Event;
import models.Model;
import models.Participant;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Transform;
import utils.Validator;
import views.MainView;
import views.UpdateEventView;

public class UpdateEventController implements Observer {
    private Model model;
    private MainView mainView;
    private UpdateEventView view;

    public UpdateEventController(Model model, MainView mainView, UpdateEventView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }
    
    public void updateEvent() {
        ArrayList<String> errors = new ArrayList<String>();

        String name = this.view.getName();
        String description = this.view.getDescription();
        String category = this.view.getCategory();
        String time = this.view.getTime();
        String date = this.view.getDate();
        String state = this.view.getState();
        String city = this.view.getCity();
        String street = this.view.getStreet();
        String addressNumber = this.view.getAddressNumber();
        String price = this.view.getPrice();

        if (this.model.getLoggedUser() instanceof Participant) {
            errors.add("• Você não tem permissão para atualizar eventos");
        }

        if (!Validator.sizeValidator(name, 3, 32)) {
            errors.add("• O nome deve ter entre 3 e 32 caracteres");
        }

        if (!Validator.sizeValidator(description, 3, 256)) {
            errors.add("• A descrição deve ter entre 3 e 256 caracteres");
        }

        if (!Validator.sizeValidator(category, 3, 32)) {
            errors.add("• A categoria deve ter entre 3 e 32 caracteres");
        }

        if (!Validator.timeValidator(time)) {
            errors.add("• Hora inválida");
        }

        if (!Validator.dateValidator(date)) {
            errors.add("• Data inválida");
        }

        if (!Validator.sizeValidator(state, 3, 32)) {
            errors.add("• O estado deve ter entre 3 e 32 caracteres");
        }

        if (!Validator.sizeValidator(city, 3, 32)) {
            errors.add("• A cidade deve ter entre 3 e 32 caracteres");
        }

        if (!Validator.sizeValidator(street, 3, 64)) {
            errors.add("• A rua deve ter entre 3 e 64 caracteres");
        }

        if (!Validator.intValidator(addressNumber) || Transform.toInt(addressNumber) < 0) {
            errors.add("• O número deve ser maior que 0");
        }
    
        if (!Validator.floatValidator(price) || Transform.toFloat(price) < 0) {
            errors.add("• O preço deve ser maior que 0");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        Event event = this.model.getSelectedEvent();

        event.setName(name);
        event.setDescription(description);
        event.setCategory(category);
        event.setTime(Transform.toTime(time));
        event.setDate(Transform.toDate(date));
        event.getAddress().setState(state);
        event.getAddress().setCity(city);
        event.getAddress().setStreet(street);
        event.getAddress().setNumber(Transform.toInt(addressNumber));
        event.setPrice(Transform.toFloat(price));
        
        this.view.clearFields();

        this.model.notifyObservers();
        this.mainView.changeView("event");
    }

    public void viewEvent() {
        this.view.clearFields();
        this.mainView.changeView("event");
    }

    public void update() {}
}
