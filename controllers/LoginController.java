package controllers;

import java.util.ArrayList;

import models.Model;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.LoginView;
import views.MainView;

/*
 * Controller de login
 */
public class LoginController implements Observer {
    private Model model;
    private MainView mainView;
    private LoginView view;

    /*
     * Construtor
     */
    public LoginController(Model model, MainView mainView, LoginView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Executada quando o usuário clica no botão de login
     */
    public void login() {
        /*
         * Lista de erros a serem exibidos no popup
         */
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

        /*
         * Exibe o popup de erros caso haja algum erro
         */
        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /*
         * Define o usuário logado
         */
        this.model.setLoggedUser(this.model.getUser(email));

        /*
         * Limpa os campos de texto e muda para a view de home
         */
        this.view.clearFields();
        this.mainView.changeView("home");
    }

    /*
     * Executada quando o usuário clica no botão "Não possuo conta"
     */
    public void viewRegister() {
        /*
         * Limpa os campos de texto e muda para a view de registro
         */
        this.view.clearFields();
        this.mainView.changeView("register");
    }

    public void update() {}
}
