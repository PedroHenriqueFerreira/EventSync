package views;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Components;
import utils.Constraints;

public class AccountView extends JPanel {
    public AccountView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = Components.createButton("Atualizar");
        updateButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = Components.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Minha conta"));
        components.add(Components.createGrayText("Nome Completo:"));
        components.add(Components.createLightText("Pedro Henrique Ferreira da Silva"));
        components.add(Components.createGrayText("Email:"));
        components.add(Components.createLightText("HPedro09062004@gmail.com"));
        components.add(Components.createGrayText("Senha:"));
        components.add(Components.createLightText("********"));
        components.add(Components.createGrayText("Cargo:"));
        components.add(Components.createLightText("Sou participante"));
        components.add(updateButton);
        components.add(backButton);        

        this.add(
            Components.createScrollBar(Components.createContainer(components)), 
            Components.createScrollBarConstraints()
        );
    }
}
