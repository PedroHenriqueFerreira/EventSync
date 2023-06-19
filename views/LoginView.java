package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.UIComponents;

public class LoginView extends JPanel {
    public LoginView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        this.setLayout(new GridBagLayout());
        
        JLabel emailText = UIComponents.createText("Email:");
        JTextField emailInput = UIComponents.createInput("");

        JLabel passwordText = UIComponents.createText("Senha:");
        JTextField passwordInput = UIComponents.createPasswordInput("");

        JButton loginButton = UIComponents.createButton("Fazer login");

        JButton registerButton = UIComponents.createLightButton("Não possuo conta");
        
        registerButton.addActionListener(e -> mainView.changeScreen("register"));
        
        JComponent[] components = {
            emailText, emailInput,
            passwordText, passwordInput,
            loginButton, registerButton
        };

        JPanel container = UIComponents.createContainer(components);
        this.add(container);
    }
}
