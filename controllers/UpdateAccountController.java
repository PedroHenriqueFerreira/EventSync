package controllers;

import java.util.ArrayList;

import models.Model;
import models.User;
import utils.ComponentsFactory;
import utils.Observer;
import utils.Validator;
import views.MainView;
import views.UpdateAccountView;

/*
 * Controller de atualização de conta
 */
public class UpdateAccountController implements Observer {
    private Model model;
    private MainView mainView;
    private UpdateAccountView view;

    /*
     * Construtor
     */
    public UpdateAccountController(Model model, MainView mainView, UpdateAccountView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Atualiza a conta do usuário
     */
    public void updateAccount() {
        /*
         * Validação dos campos
         */
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

        /*
         * Exibe os erros encontrados no popup
         */
        if (errors.size() > 0) {
            ComponentsFactory.createPopup(errors);
            return;
        }

        User user = this.model.getLoggedUser();

        /*
         * Remove o usuário antigo e adiciona o novo
         */

        this.model.removeUser(user.getEmail());

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        this.model.addUser(user);

        /*
         * Volta para a tela de conta
         */
        this.mainView.changeView("account");
    }

    /*
     * Volta para a tela de conta
     */
    public void viewAccount() {
        this.mainView.changeView("account");
    }

    public void update() {}
}
