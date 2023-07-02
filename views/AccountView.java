package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.AccountController;
import models.Admin;
import models.Model;
import models.Participant;
import models.User;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

public class AccountView extends JPanel implements Observer {
    private Model model;
    private AccountController controller;

    private JLabel nameLabel = ComponentsFactory.createLightText(" ");
    private JLabel emailLabel = ComponentsFactory.createLightText(" ");
    private JLabel phoneLabel = ComponentsFactory.createLightText(" ");
    private JLabel passwordLabel = ComponentsFactory.createLightText(" ");
    private JLabel roleLabel = ComponentsFactory.createLightText(" ");

    public AccountView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new AccountController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = ComponentsFactory.createButton("Atualizar");
        updateButton.addActionListener(e -> this.controller.viewUpdateAccount());

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> this.controller.viewHome());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Minha conta"),
            ComponentsFactory.createGrayText("Nome Completo:"),
            this.nameLabel,
            ComponentsFactory.createGrayText("Email:"),
            this.emailLabel,
            ComponentsFactory.createGrayText("Telefone:"),
            this.phoneLabel,
            ComponentsFactory.createGrayText("Senha:"),
            this.passwordLabel,
            ComponentsFactory.createGrayText("Cargo:"),
            this.roleLabel,
            updateButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {
        if (this.model.getLoggedUser() == null) return;
        
        User user = this.model.getLoggedUser();
        
        this.nameLabel.setText(user.getName());
        this.emailLabel.setText(user.getEmail());
        this.passwordLabel.setText(user.getPassword());
        this.phoneLabel.setText(user.getPhone());
        this.roleLabel.setText(user instanceof Admin ? "Sou administrador" : "Sou participante");
    }
}
