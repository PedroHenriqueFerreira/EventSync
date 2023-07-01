package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.ComponentsFactory;
import utils.Constraints;

public class UpdateAccountView extends JPanel {
    public UpdateAccountView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = ComponentsFactory.createButton("Atualizar");
        updateButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Atualizar conta"),
            ComponentsFactory.createGrayText("Nome Completo:"),
            ComponentsFactory.createInput("Pedro Henrique Ferreira da Silva"),
            ComponentsFactory.createGrayText("Email:"),
            ComponentsFactory.createInput("HPedro09062004@gmail.com"),
            ComponentsFactory.createGrayText("Senha:"),
            ComponentsFactory.createPasswordInput("********"),
            ComponentsFactory.createGrayText("Cargo:"),
            ComponentsFactory.createInput("Sou participante"),
            updateButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }
}
