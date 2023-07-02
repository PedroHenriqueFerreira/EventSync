package controllers;

import java.util.ArrayList;

import models.Model;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.LoginView;
import views.MainView;

public class LoginController implements Observer {
    private Model model;
    private MainView mainView;
    private LoginView view;

    public LoginController(Model model, MainView mainView, LoginView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void login() {
        ArrayList<String> errors = new ArrayList<String>();

        String email = this.view.getEmail();
        String password = this.view.getPassword();

        if (!Validator.emailValidator(email)) {
            errors.add("• Email inválido");
        }

        if (!Validator.sizeValidator(password, 8, 32)) {
            errors.add("• A senha deve ter entre 8 e 32 caracteres");
        }

        if (errors.size() == 0 && !this.model.checkCredencials(email, password)) {
            errors.add("• Email ou senha inválidos");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        this.model.setLoggedUser(this.model.getUser(email));

        this.view.clearFields();
        this.mainView.changeView("home");
    }

    public void viewRegister() {
        this.view.clearFields();
        this.mainView.changeView("register");
    }

    public void update() {}
}
