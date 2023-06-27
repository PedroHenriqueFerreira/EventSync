package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utils.UIComponents;

public class UpdateAccountView extends JPanel {
    public UpdateAccountView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        this.setLayout(new GridBagLayout());
        
        ImageIcon logo = new ImageIcon("assets/logo.png");
        JLabel logoLabel = new JLabel(logo);

        JLabel title = UIComponents.createTitle("Atualizar conta");

        JLabel nameText = UIComponents.createText("Nome completo:");
        JTextField nameInput = UIComponents.createInput("Pedro Henrique Fereira");

        JLabel emailText = UIComponents.createText("Email:");
        JTextField emailInput = UIComponents.createInput("HPedro09062004@gmail.com");

        JLabel phoneText = UIComponents.createText("Telefone:");
        JTextField phoneInput = UIComponents.createMaskInput("(88) 9 9349-3909", "(##) # ####-####");
        
        JLabel passwordText = UIComponents.createText("Senha:");
        JTextField passwordInput = UIComponents.createPasswordInput("AAAAAAAAAAA");

        JButton updateButton = UIComponents.createButton("Atualizar");

        JButton backButton = UIComponents.createLightButton("Voltar");

        backButton.addActionListener(e -> mainView.changeScreen("account"));
        
        JComponent[] components = {
            logoLabel,
            title,
            nameText, nameInput, 
            emailText, emailInput,
            phoneText, phoneInput,
            passwordText, passwordInput,
            updateButton, backButton
        };

        JPanel container = UIComponents.createContainer(components);        
        this.add(container);
    }
}
