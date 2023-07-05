package controllers;

import java.util.ArrayList;

import models.Activity;
import models.Event;
import models.Model;
import models.Participant;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Transform;
import utils.Validator;
import views.MainView;
import views.UpdateActivityView;

public class UpdateActivityController implements Observer {
    private Model model;
    private MainView mainView;
    private UpdateActivityView view;
    
    public UpdateActivityController(Model model, MainView mainView, UpdateActivityView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }
    
    public void updateActivity() {
        Activity activity = this.model.getSelectedActivity();
        Event event = this.model.getSelectedEvent();
        User user = this.model.getLoggedUser();

        ArrayList<String> errors = new ArrayList<String>();        

        String name = this.view.getName();
        String description = this.view.getDescription();
        String instructorName = this.view.getInstructorName();
        String instructorEmail = this.view.getInstructorEmail();
        String instructorPhone = this.view.getInstructorPhone();
        String date = this.view.getDate();
        String time = this.view.getTime();

        if (user == null || event == null || activity == null) {
            errors.add("• Não foi possível atualizar a atividade");
        } else if (event.getAdmin() != user) {
            errors.add("• Você não tem permissão para atualizar atividades");
        }

        if (this.model.getLoggedUser() instanceof Participant) {
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

        activity.setName(name);
        activity.setDescription(description);
        activity.getInstructor().setName(instructorName);
        activity.getInstructor().setEmail(instructorEmail);
        activity.getInstructor().setPhone(instructorPhone);
        activity.setDate(Transform.toDate(date));
        activity.setTime(Transform.toTime(time));
    
        this.model.notifyObservers();
        this.mainView.changeView("activity");   
    }

    public void viewActivity() {
        this.model.notifyObservers();
        this.mainView.changeView("activity");
    }

    public void update() {}
}
