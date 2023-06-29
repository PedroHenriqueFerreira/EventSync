package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.Components;
import utils.Constraints;

public class UpdateAccountView extends JPanel {
    public UpdateAccountView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton updateButton = Components.createButton("Atualizar");
        updateButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = Components.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Atualizar conta"));
        components.add(Components.createGrayText("Nome Completo:"));
        components.add(Components.createInput("Pedro Henrique Ferreira da Silva"));
        components.add(Components.createGrayText("Email:"));
        components.add(Components.createInput("HPedro09062004@gmail.com"));
        components.add(Components.createGrayText("Senha:"));
        components.add(Components.createPasswordInput("********"));
        components.add(Components.createGrayText("Cargo:"));
        components.add(Components.createInput("Sou participante"));
        components.add(updateButton);
        components.add(backButton);        

        JScrollPane container = Components.createContainer(components);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.weightx = 1.0;

        this.add(container, gridBagConstraints);
    }
}
