package views;

import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controllers.RegisterController;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de registro
 */
public class RegisterView extends JPanel implements Observer {
    private Model model;
    private RegisterController controller;

    /*
     * Campos de texto
     */
    private JTextField nameTextField = ComponentsFactory.createInput("");
    private JTextField emailTextField = ComponentsFactory.createInput("");
    private JTextField phoneTextField = ComponentsFactory.createMaskInput("(##) # ####-####", "");
    private JTextField passwordTextField = ComponentsFactory.createPasswordInput("");

    private JRadioButton adminRadioButton = ComponentsFactory.createRadioButton("Sou organizador");
    private JRadioButton userRadioButton = ComponentsFactory.createRadioButton("Sou participante");

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

    public boolean getIsAdmin() {
        return this.adminRadioButton.isSelected();
    }

    public boolean getIsUser() {
        return this.userRadioButton.isSelected();
    }

    /*
     * Limpa os campos de texto
     */
    public void clearFields() {
        this.nameTextField.setText("");
        this.emailTextField.setText("");
        this.phoneTextField.setText("");
        this.passwordTextField.setText("");
        this.adminRadioButton.setSelected(false);
        this.userRadioButton.setSelected(false);
    }

    /*
     * Construtor
     */
    public RegisterView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new RegisterController(model, mainView, this);

        this.model.attachObserver(this);

        this.display();
    }

    /*
     * Exibe a view
     */
    public void display() {
        this.setBackground(getBackground());
        this.setLayout(new GridBagLayout());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.adminRadioButton);
        buttonGroup.add(this.userRadioButton);
        
        JPanel radioButtons = new JPanel();
        radioButtons.setBackground(Constraints.CONTAINER_COLOR);
        radioButtons.add(this.adminRadioButton);
        radioButtons.add(this.userRadioButton);

        JButton registerButton = ComponentsFactory.createButton("Fazer registro");
        registerButton.addActionListener(e -> this.controller.register());
        JButton loginButton = ComponentsFactory.createLightButton("Já possuo conta");
        loginButton.addActionListener(e -> this.controller.viewLogin());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Realize seu cadastro!"),
            ComponentsFactory.createGrayText("Nome completo:"),
            nameTextField,
            ComponentsFactory.createGrayText("Email:"),
            emailTextField,
            ComponentsFactory.createGrayText("Telefone:"),
            phoneTextField,
            ComponentsFactory.createGrayText("Senha:"),
            passwordTextField,
            radioButtons,
            registerButton,
            loginButton
        );
        
        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {}
}
