package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.LoginController;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de login
 */
public class LoginView extends JPanel implements Observer {
    private Model model;
    private LoginController controller;

    /*
     * Campos de texto
     */
    private JTextField emailTextField = ComponentsFactory.createInput("");
    private JTextField passwordTextField = ComponentsFactory.createPasswordInput("");

    public String getEmail() {
        return this.emailTextField.getText();
    }

    public String getPassword() {
        return this.passwordTextField.getText();
    }

    /*
     * Limpa os campos de texto
     */
    public void clearFields() {
        this.emailTextField.setText("");
        this.passwordTextField.setText("");
    }

    /*
     * Construtor
     */
    public LoginView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new LoginController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        JButton loginButton = ComponentsFactory.createButton("Fazer login");
        loginButton.addActionListener(e -> this.controller.login());

        JButton registerButton = ComponentsFactory.createLightButton("Não possuo conta");
        registerButton.addActionListener(e -> this.controller.viewRegister());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Seja bem-vindo de volta!"),
            ComponentsFactory.createGrayText("Email:"),
            emailTextField,
            ComponentsFactory.createGrayText("Senha:"),
            passwordTextField,
            ComponentsFactory.createLightText(" "),
            loginButton,
            registerButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {}
}
