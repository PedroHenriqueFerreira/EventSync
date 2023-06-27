package views;

import java.awt.GridBagLayout;

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

        ImageIcon logo = new ImageIcon("assets/logo.png");
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

        JComponent[] components = {
            logoLabel,
            title,
            nameTitle,
            nameText,
            emailTitle,
            emailText,
            passwordTitle,
            passwordText,
            typeTitle,
            typeText,
            updateButton,
            backButton
        };

        JPanel container = UIComponents.createContainer(components);
        this.add(container);
    }
}
