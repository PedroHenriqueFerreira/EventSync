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
import views.RegisterView;

/*
 * Controller de registro
 */
public class RegisterController implements Observer {
    private Model model;
    private MainView mainView;
    private RegisterView view;

    /*
     * Construtor
     */
    public RegisterController(Model model, MainView mainView, RegisterView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Executada quando o usuário clica no botão de registro
     */
    public void register() {
        /*
         * Lista de erros a serem exibidos no popup
         */
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

        /*
         * Exibe o popup de erros caso haja algum erro
         */
        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        /*
         * Cadastra o usuário ou administrador no sistema
         */
        User user = this.view.getIsAdmin() ? new Admin() : new Participant();

        /*
         * Seta os atributos do usuário
         */
        user.setName(this.view.getName());
        user.setEmail(this.view.getEmail());
        user.setPhone(this.view.getPhone());
        user.setPassword(this.view.getPassword());
        
        /*
         * Adiciona o usuário no sistema
         */
        this.model.addUser(user);

        /*
         * Limpa os campos do formulário e muda para a tela de login
         */
        this.view.clearFields();
        this.mainView.changeView("login");
    }

    /*
     * Executada quando o usuário clica no botão "Possuo uma conta"
     */
    public void viewLogin() {
        /*
         * Limpa os campos do formulário e muda para a tela de login
         */
        this.view.clearFields();
        this.mainView.changeView("login");
    }

    public void update() {}
}
