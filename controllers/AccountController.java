package controllers;

import models.Model;
import utils.Observer;
import views.AccountView;
import views.MainView;

public class AccountController implements Observer {
    private Model model;
    private MainView mainView;
    private AccountView view;

    public AccountController(Model model, MainView mainView, AccountView view) {
        this.model = model;

        this.mainView = mainView;
        this.view = view;
    }

    public void viewHome() {
        this.mainView.changeView("home");
    }

    public void viewUpdateAccount() {
        this.mainView.changeView("update_account");
    }

    public void update() {}
}
