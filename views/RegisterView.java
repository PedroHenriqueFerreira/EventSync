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
        components.add(Components.createLightText("Nome completo:")); 
        components.add(Components.createInput("")); 
        components.add(Components.createLightText("Email:")); 
        components.add(Components.createInput(""));
        components.add(Components.createLightText("Telefone:")); 
        components.add(Components.createMaskInput("(##) # ####-####", ""));
        components.add(Components.createLightText("Senha:")); 
        components.add(Components.createPasswordInput(""));
        components.add(radioButtons);
        components.add(registerButton); 
        components.add(loginButton);
        
        JScrollPane container = Components.createContainer(components);        

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.weightx = 1.0;

        this.add(container, gridBagConstraints);
    }
}
