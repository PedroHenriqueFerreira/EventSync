package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

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
        
        ImageIcon logo = new ImageIcon("images/logo.png");
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
        
        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(logoLabel);
        components.add(title);
        components.add(nameText); 
        components.add(nameInput); 
        components.add(emailText); 
        components.add(emailInput);
        components.add(phoneText); 
        components.add(phoneInput);
        components.add(passwordText); 
        components.add(passwordInput);
        components.add(updateButton); 
        components.add(backButton);

        JPanel container = UIComponents.createContainer(components);        
        this.add(container);
    }
}
