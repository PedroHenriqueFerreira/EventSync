package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.UpdateAccountController;
import models.Model;
import models.User;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de atualização de conta
 */
public class UpdateAccountView extends JPanel implements Observer {
    private Model model;
    private UpdateAccountController controller;

    private JTextField nameTextField = ComponentsFactory.createInput("");
    private JTextField emailTextField = ComponentsFactory.createInput("");
    private JTextField phoneTextField = ComponentsFactory.createMaskInput("(##) # ####-####", "");
    private JTextField passwordTextField = ComponentsFactory.createPasswordInput("");

    /*
     * Retorna os valores dos campos de texto
     */
    public String getName() {
        return this.nameTextField.getText();
    }

    public String getEmail() {
        return this.emailTextField.getText();
    }

    public String getPhone() {
        return this.phoneTextField.getText();
    }

    public String getPassword() {
        return this.passwordTextField.getText();
    }

    /*
     * Construtor
     */
    public UpdateAccountView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new UpdateAccountController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = ComponentsFactory.createButton("Atualizar conta");
        updateButton.addActionListener(e -> this.controller.updateAccount());

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> this.controller.viewAccount());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Atualizar conta"),
            ComponentsFactory.createGrayText("Nome Completo:"),
            this.nameTextField,
            ComponentsFactory.createGrayText("Email:"),
            this.emailTextField,
            ComponentsFactory.createGrayText("Telefone:"),
            this.phoneTextField,
            ComponentsFactory.createGrayText("Senha:"),
            this.passwordTextField,
            updateButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {
        /*
         * Atualiza os campos de texto com os dados do usuário logado
         */
        User user = this.model.getLoggedUser();

        if (user == null) return;
        
        this.nameTextField.setText(user.getName());
        this.emailTextField.setText(user.getEmail());
        this.passwordTextField.setText(user.getPassword());
        this.phoneTextField.setText(user.getPhone());
    }
}
