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

public class RegisterView extends JPanel {
    public RegisterView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        this.setLayout(new GridBagLayout());

        JPanel container = new JPanel();

        container.setLayout(new GridBagLayout());
        container.setBorder(UIComponents.containerBorder);
        container.setBackground(UIComponents.grayColor);
        
        this.add(container);

        JLabel nameText = UIComponents.createText("Nome completo:");
        JTextField nameInput = UIComponents.createInput("");

        JLabel emailText = UIComponents.createText("Email:");
        JTextField emailInput = UIComponents.createInput("");

        JLabel phoneText = UIComponents.createText("Telefone:");
        JTextField phoneInput = UIComponents.createMaskInput("", "(##) # ####-####");
        
        JLabel passwordText = UIComponents.createText("Senha:");
        JTextField passwordInput = UIComponents.createPasswordInput("");

        JButton registerButton = UIComponents.createButton("Fazer Registro");

        JButton loginButton = UIComponents.createLightButton("Já Possuo Conta");

        loginButton.addActionListener(e -> mainView.changeScreen("login"));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;
        
        JComponent[] components = {
            nameText, nameInput, 
            emailText, emailInput,
            phoneText, phoneInput,
            passwordText, passwordInput,
            registerButton, loginButton
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
