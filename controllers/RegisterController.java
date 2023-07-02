package controllers;

import java.util.ArrayList;

import models.Admin;
import models.Model;
import models.Participant;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.MainView;
import views.RegisterView;

public class RegisterController implements Observer {
    private Model model;
    private MainView mainView;
    private RegisterView view;

    public RegisterController(Model model, MainView mainView, RegisterView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void register() {
        ArrayList<String> errors = new ArrayList<String>();

        if (!Validator.sizeValidator(this.view.getName(), 3, 50)) {
            errors.add("• O nome deve ter entre 3 e 50 caracteres");
        }

        if (!Validator.emailValidator(this.view.getEmail())) {
            errors.add("• Email inválido");
        }
            
        if (!Validator.phoneValidator(this.view.getPhone())) {
            errors.add("• Telefone inválido");
        }

        if (!Validator.sizeValidator(this.view.getPassword(), 8, 32)) {
            errors.add("• A senha deve ter entre 8 e 32 caracteres");
        }

        if (!this.view.getIsAdmin() && !this.view.getIsUser()) {
            errors.add("• Selecione uma opção de usuário");
        }

        if (errors.size() == 0 && this.model.getUser(this.view.getEmail()) != null) {
            errors.add("• Email já cadastrado");
        }

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        if (this.view.getIsAdmin()) {
            this.registerAdmin();
        } else {
            this.registerParticipant();
        }

        this.view.clearFields();
        this.mainView.changeView("login");
    }

    private void registerAdmin() {
        Admin admin = new Admin(
            this.view.getName(),
            this.view.getEmail(),
            this.view.getPhone(),
            this.view.getPassword()
        );

        this.model.addUser(admin);
    }

    private void registerParticipant() {
        Participant participant = new Participant(
            this.view.getName(),
            this.view.getEmail(),
            this.view.getPhone(),
            this.view.getPassword()
        );

        this.model.addUser(participant);
    }

    public void viewLogin() {
        this.view.clearFields();
        this.mainView.changeView("login");
    }

    public void update() {}
}
