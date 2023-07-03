package controllers;

import models.Model;
import utils.Observer;
import views.AccountView;
import views.MainView;

/*
 * Controller de minha conta
 */
public class AccountController implements Observer {
    private Model model;
    private MainView mainView;
    private AccountView view;

    /*
     * Construtor
     */
    public AccountController(Model model, MainView mainView, AccountView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    /*
     * Muda para a view de home
     */
    public void viewHome() {
        this.mainView.changeView("home");
    }

    /*
     * Muda para a view de atualizar conta
     */
    public void viewUpdateAccount() {
        this.mainView.changeView("update_account");
    }

    public void update() {}
}
