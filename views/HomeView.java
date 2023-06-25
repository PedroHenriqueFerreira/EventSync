package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import utils.UIComponents;

public class HomeView extends JPanel {
    public HomeView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);
        
        JPanel header = new JPanel();
        header.setBackground(getBackground());
        header.setLayout(new BorderLayout());
        header.setMinimumSize(new Dimension(1300, 0));
        
        JPanel options = new JPanel();
        options.setBackground(getBackground());

        ImageIcon logo = new ImageIcon("assets/logo.png");
        JLabel logoLabel = new JLabel(logo);
        JButton account = UIComponents.createButton("Ver perfil");
        JButton logout = UIComponents.createLightButton("Sair");

        options.add(account);
        options.add(logout);
        
        header.add(logoLabel, BorderLayout.WEST);
        header.add(options, BorderLayout.EAST);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(300, 0));
        space.setBackground(getBackground());

        header.add(space, BorderLayout.CENTER);
        
        this.add(header);

        for (int i = 0; i < 0; i++) {
            JLabel name = UIComponents.createText("Master Class resinas");
            name.setFont(UIComponents.largeFont);
            name.setForeground(UIComponents.primaryColor);
    
            JLabel description = UIComponents.createText("Venha se divertir aprendendo sobre resinas wwwe wef wefwef wef wefwefwe wefwefwef");
            // description.setForeground(UIComponents.grayColor);
    
            JLabel address = UIComponents.createText("Rua José de Alencar, 135, Cuiabá - MT");
            address.setForeground(UIComponents.grayColor);
    
            JLabel date = UIComponents.createText("12/05/22 08:00");
            date.setForeground(UIComponents.grayColor);
    
            JButton expandButton = UIComponents.createLightButton("Ver mais detalhes");
    
            expandButton.addActionListener(e -> mainView.changeScreen("login"));
    
            JComponent[] components = {
                name,
                description,
                address,
                date,
                expandButton
            };
    
            JPanel container = UIComponents.createContainer(components);       
            this.add(container);
        }
    }
}
