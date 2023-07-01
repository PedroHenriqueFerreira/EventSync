package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ComponentsFactory;
import utils.Constraints;

public class LoginView extends JPanel {
    public LoginView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        JButton loginButton = ComponentsFactory.createButton("Fazer login");
        loginButton.addActionListener(e -> mainView.changeScreen("home"));

        JButton registerButton = ComponentsFactory.createLightButton("Não possuo conta");
        registerButton.addActionListener(e -> mainView.changeScreen("register"));

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Seja bem-vindo de volta!"),
            ComponentsFactory.createGrayText("Email:"),
            ComponentsFactory.createInput(""),
            ComponentsFactory.createGrayText("Senha:"),
            ComponentsFactory.createPasswordInput(""),
            ComponentsFactory.createLightText(" "),
            loginButton,
            registerButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }
}
