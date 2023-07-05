package controllers;

import java.util.ArrayList;

import models.Activity;
import models.Event;
import models.Instructor;
import models.Model;
import models.Participant;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Transform;
import utils.Validator;
import views.CreateActivityView;
import views.MainView;

public class CreateActivityController implements Observer {
    private Model model;
    private MainView mainView;
    private CreateActivityView view;

    public CreateActivityController(Model model, MainView mainView, CreateActivityView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void createActivity() {
        ArrayList<String> errors = new ArrayList<String>();        

        User loggedUser = this.model.getLoggedUser();
        Event event = this.model.getSelectedEvent();

        String name = this.view.getName();
        String description = this.view.getDescription();
        String instructorName = this.view.getInstructorName();
        String instructorEmail = this.view.getInstructorEmail();
        String instructorPhone = this.view.getInstructorPhone();
        String date = this.view.getDate();
        String time = this.view.getTime();

        if (loggedUser == null || event == null) {
            errors.add("• Não foi possível criar a atividade");
        } else if (event.getAdmin() != loggedUser) {
            errors.add("• Você não tem permissão para atualizar atividades");
        }

        if (loggedUser instanceof Participant) {
            errors.add("• Você não tem permissão para atualizar atividades");
        }

        if (!Validator.sizeValidator(name, 3, 64)) {
            errors.add("• O nome deve ter entre 3 e 64 caracteres");
        }

        if (!Validator.sizeValidator(description, 3, 256)) {
            errors.add("• A descrição deve ter entre 3 e 256 caracteres");
        }

        if (!Validator.sizeValidator(instructorName, 3, 64)) {
            errors.add("• O nome do instrutor deve ter entre 3 e 64 caracteres");
        }

        if (!Validator.emailValidator(instructorEmail)) {
            errors.add("• Email inválido");
        }

        if (!Validator.phoneValidator(instructorPhone)) {
            errors.add("• Telefone inválido");
        }

        if (!Validator.dateValidator(date)) {
            errors.add("• Data inválida");
        }

        if (!Validator.timeValidator(time)) {
            errors.add("• Hora inválida");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        Activity activity = new Activity(
            name,
            description,
            new Instructor(instructorName, instructorEmail, instructorPhone),
            Transform.toDate(date),
            Transform.toTime(time)
        );

        event.addActivity(activity);
    
        this.model.notifyObservers();
        
        this.view.clearFields();
        this.mainView.changeView("event");   
    }

    public void viewEvent() {
        this.mainView.changeView("event");
    }

    public void update() {}
}
