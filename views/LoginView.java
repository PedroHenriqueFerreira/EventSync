package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

        JPanel container = new JPanel();

        container.setLayout(new GridBagLayout());
        container.setBorder(UIComponents.containerBorder);
        container.setBackground(UIComponents.grayColor);
        
        this.add(container);
        JLabel emailText = UIComponents.createText("Email:");
        JTextField emailInput = UIComponents.createInput("");

        JLabel passwordText = UIComponents.createText("Senha:");
        JTextField passwordInput = UIComponents.createPasswordInput("");

        JButton loginButton = UIComponents.createButton("Fazer Login");

        JButton registerButton = UIComponents.createLightButton("Não Possuo Conta");

        registerButton.addActionListener(e -> mainView.changeScreen("register"));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        
        JComponent[] components = {
            emailText, emailInput,
            passwordText, passwordInput,
            loginButton, registerButton
        };

        for (int i = 0; i < components.length; i++) {
            JComponent component = components[i];

            Insets insets = null;

            if (component instanceof JTextField) {
                insets = UIComponents.inputInsets;
            } else if (component instanceof JLabel) {
                insets = UIComponents.textInsets;
            } else if (component instanceof JButton) {
                insets = UIComponents.buttonInsets;
            }

            gridBagConstraints.gridy = i;
            gridBagConstraints.insets = insets;
            container.add(component, gridBagConstraints);
        }
    }
}
