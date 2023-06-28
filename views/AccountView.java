package views;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.UIComponents;

public class AccountView extends JPanel {
    public AccountView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        this.setLayout(new GridBagLayout());

        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel logoLabel = new JLabel(logo);

        JLabel title = UIComponents.createTitle("Minha conta");
        
        JLabel nameTitle = UIComponents.createText("Nome Completo:");
        nameTitle.setForeground(UIComponents.grayColor);
        JLabel nameText = UIComponents.createText("Pedro Henrique Ferreira da Silva");

        JLabel emailTitle = UIComponents.createText("Email:");
        emailTitle.setForeground(UIComponents.grayColor);
        JLabel emailText = UIComponents.createText("HPedro09062004@gmail.com");

        JLabel passwordTitle = UIComponents.createText("Senha:");
        passwordTitle.setForeground(UIComponents.grayColor);
        JLabel passwordText = UIComponents.createText("********");

        JLabel typeTitle = UIComponents.createText("Cargo:");
        typeTitle.setForeground(UIComponents.grayColor);
        JLabel typeText = UIComponents.createText("Sou participante");

        JButton updateButton = UIComponents.createButton("Atualizar");

        updateButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = UIComponents.createLightButton("Voltar");
        
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(logoLabel);
        components.add(title);
        components.add(nameTitle);
        components.add(nameText);
        components.add(emailTitle);
        components.add(emailText);
        components.add(passwordTitle);
        components.add(passwordText);
        components.add(typeTitle);
        components.add(typeText);
        components.add(updateButton);
        components.add(backButton);        

        JPanel container = UIComponents.createContainer(components);
        this.add(container);
    }
}
