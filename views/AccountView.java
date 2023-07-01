package views;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ComponentsFactory;
import utils.Constraints;

public class AccountView extends JPanel {
    public AccountView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = ComponentsFactory.createButton("Atualizar");
        updateButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Minha conta"),
            ComponentsFactory.createGrayText("Nome Completo:"),
            ComponentsFactory.createLightText("Pedro Henrique Ferreira da Silva"),
            ComponentsFactory.createGrayText("Email:"),
            ComponentsFactory.createLightText("HPedro09062004@gmail.com"),
            ComponentsFactory.createGrayText("Senha:"),
            ComponentsFactory.createLightText("********"),
            ComponentsFactory.createGrayText("Cargo:"),
            ComponentsFactory.createLightText("Sou participante"),
            updateButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }
}
