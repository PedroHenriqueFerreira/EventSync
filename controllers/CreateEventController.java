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
import views.CreateEventView;
import views.MainView;

/*
 * Controller de criar evento
 */
public class CreateEventController implements Observer {
    private Model model;
    private MainView mainView;
    private CreateEventView view;

    /*
     * Construtor
     */
    public CreateEventController(Model model, MainView mainView, CreateEventView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }
    
    /*
     * Cria um evento
     */
    public void createEvent() {
        /*
         * Validação dos dados
         */
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
            errors.add("• Você não tem permissão para criar eventos");
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

        /*
         * Exibição dos erros encontrados
         */
        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }
        
        /*
         * Criação do evento
         */

        Address address = new Address(
            state,
            city,
            street,
            Transform.toInt(addressNumber)
        );

        Event event = new Event(
            (Admin) this.model.getLoggedUser(),
            name,
            description,
            category,
            Transform.toDate(date),
            Transform.toTime(time),
            address,
            Transform.toFloat(price)
        );

        /* 
         * Adiciona o evento ao model e retorna para a home
         */
        this.model.addEvent(event);
        
        this.view.clearFields();
        this.mainView.changeView("home");
    }

    /*
     * Volta para a home
     */
    public void viewHome() {
        this.view.clearFields();
        this.mainView.changeView("home");
    }

    public void update() {}
}
