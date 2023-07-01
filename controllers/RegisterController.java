package controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Model;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.RegisterView;

public class RegisterController implements Observer {
    private Model model;
    private RegisterView view;

    public void initialize(Model model, RegisterView view) {
        this.model = model;
        this.view = view;
    }

    public void registerUser() {
        ArrayList<String> errors = new ArrayList<String>();

        if (!Validator.emailValidator(this.view.getEmail())) {
            errors.add("• Email inválido");
        }
            
        if (!Validator.phoneValidator(this.view.getPhone())) {
            errors.add("• Telefone inválido");
        }

        if (!Validator.sizeValidator(this.view.getPassword(), 8, 32)) {
            errors.add("• A senha deve ter entre 8 e 32 caracteres");
        } 

        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
        }
    }

    public void loginUser() {
        
    }

    public void update() {}
}
