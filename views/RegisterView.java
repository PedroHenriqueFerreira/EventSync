package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utils.UIComponents;

public class RegisterView extends JPanel {
    public RegisterView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        this.setLayout(new GridBagLayout());
        
        JLabel nameText = UIComponents.createText("Nome completo:");
        JTextField nameInput = UIComponents.createInput("");

        JLabel emailText = UIComponents.createText("Email:");
        JTextField emailInput = UIComponents.createInput("");

        JLabel phoneText = UIComponents.createText("Telefone:");
        JTextField phoneInput = UIComponents.createMaskInput("", "(##) # ####-####");
        
        JLabel passwordText = UIComponents.createText("Senha:");
        JTextField passwordInput = UIComponents.createPasswordInput("");

        JButton registerButton = UIComponents.createButton("Fazer registro");

        JRadioButton organizer = UIComponents.createRadioButton("Sou organizador");
        JRadioButton participant = UIComponents.createRadioButton("Sou participante");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(organizer);
        buttonGroup.add(participant);
        
        JPanel radioButtons = new JPanel();
        radioButtons.setBackground(UIComponents.containerColor);

        radioButtons.add(organizer);
        radioButtons.add(participant);

        JButton loginButton = UIComponents.createLightButton("Já possuo conta");

        loginButton.addActionListener(e -> mainView.changeScreen("login"));
        
        JComponent[] components = {
            nameText, nameInput, 
            emailText, emailInput,
            phoneText, phoneInput,
            passwordText, passwordInput,
            radioButtons,
            registerButton, loginButton
        };

        JPanel container = UIComponents.createContainer(components);        
        this.add(container);
    }
}
