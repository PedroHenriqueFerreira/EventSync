package controllers;

import java.util.ArrayList;

import models.Admin;
import models.Model;
import models.Participant;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.MainView;
import views.UpdateAccountView;

public class UpdateAccountController implements Observer {
    private Model model;
    private MainView mainView;
    private UpdateAccountView view;

    public UpdateAccountController(Model model, MainView mainView, UpdateAccountView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void edit() {
        ArrayList<String> errors = new ArrayList<String>();

        String name = this.view.getName();
        String email = this.view.getEmail();
        String phone = this.view.getPhone();
        String password = this.view.getPassword();

        if (!Validator.sizeValidator(name, 3, 50)) {
            errors.add("• O nome deve ter entre 3 e 50 caracteres");
        }

        if (!Validator.emailValidator(email)) {
            errors.add("• Email inválido");
        }
            
        if (!Validator.phoneValidator(phone)) {
            errors.add("• Telefone inválido");
        }

        if (!Validator.sizeValidator(password, 8, 32)) {
            errors.add("• A senha deve ter entre 8 e 32 caracteres");
        }

        if (
            errors.size() == 0 && 
            this.model.getUser(email) != null && 
            this.model.getUser(email) != this.model.getLoggedUser()
        ) {
            errors.add("• Email já cadastrado");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        User user = this.model.getLoggedUser();

        this.model.removeUser(user.getEmail());

        user.setName(this.view.getName());
        user.setEmail(this.view.getEmail());
        user.setPhone(this.view.getPhone());
        user.setPassword(this.view.getPassword());

        this.model.addUser(user);

        this.model.notifyObservers();
        this.mainView.changeView("account");
    }

    public void viewAccount() {
        this.mainView.changeView("account");
    }

    public void update() {}
}
