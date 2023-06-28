package views;

import java.awt.Container;
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

public class LoginView extends JPanel {
    public LoginView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        JButton loginButton = Components.createButton("Fazer login");
        loginButton.addActionListener(e -> mainView.changeScreen("home"));

        JButton registerButton = Components.createLightButton("Não possuo conta");
        registerButton.addActionListener(e -> mainView.changeScreen("register"));
        
        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Seja bem-vindo de volta!"));
        components.add(Components.createLightText("Email:"));
        components.add(Components.createInput(""));
        components.add(Components.createLightText("Senha:"));
        components.add(Components.createPasswordInput(""));
        components.add(loginButton);
        components.add(registerButton);

        JScrollPane container = Components.createContainer(components);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.weightx = 1.0;

        this.add(container, gridBagConstraints);
    }
}
