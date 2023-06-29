package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import utils.Components;
import utils.Constraints;

public class RegisterView extends JPanel {
    public RegisterView(MainView mainView) {
        this.setBackground(getBackground());
        this.setLayout(new GridBagLayout());
    
        JRadioButton adminRadioButton = Components.createRadioButton("Sou organizador");
        JRadioButton participantRadioButton = Components.createRadioButton("Sou participante");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(adminRadioButton);
        buttonGroup.add(participantRadioButton);
        
        JPanel radioButtons = new JPanel();
        radioButtons.setBackground(Constraints.CONTAINER_COLOR);
        radioButtons.add(adminRadioButton);
        radioButtons.add(participantRadioButton);

        JButton registerButton = Components.createButton("Fazer registro");
        registerButton.addActionListener(e -> mainView.changeScreen("login"));

        JButton loginButton = Components.createLightButton("Já possuo conta");
        loginButton.addActionListener(e -> mainView.changeScreen("login"));
        
        ArrayList<JComponent> components = new ArrayList<JComponent>();

        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Realize seu cadastro!"));
        components.add(Components.createGrayText("Nome completo:")); 
        components.add(Components.createInput("")); 
        components.add(Components.createGrayText("Email:")); 
        components.add(Components.createInput(""));
        components.add(Components.createGrayText("Telefone:")); 
        components.add(Components.createMaskInput("(##) # ####-####", ""));
        components.add(Components.createGrayText("Senha:")); 
        components.add(Components.createPasswordInput(""));
        components.add(radioButtons);
        components.add(registerButton); 
        components.add(loginButton);
        
        this.add(
            Components.createScrollBar(Components.createContainer(components)), 
            Components.createScrollBarConstraints()
        );
    }
}
