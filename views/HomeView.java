package views;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class HomeView extends JPanel {
    public HomeView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        this.setBorder(Constraints.LARGE_PADDING_BORDER);
        
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(getBackground());
        
        JPanel options = new JPanel();
        options.setBackground(getBackground());

        JLabel logoLabel = new JLabel(Constraints.LOGO_IMAGE_ICON);
        JButton account = Components.createButton("Minha conta");
        account.setPreferredSize(Constraints.SMALL_DIMENSION);

        account.addActionListener(e -> mainView.changeScreen("account"));

        JButton logoutButton = Components.createLightButton("Sair");
        logoutButton.setPreferredSize(Constraints.SMALL_DIMENSION);

        logoutButton.addActionListener(e -> mainView.changeScreen("login"));

        options.add(account);
        options.add(logoutButton);
        
        header.add(logoLabel, BorderLayout.WEST);
        header.add(options, BorderLayout.EAST);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        this.add(header, gridBagConstraints);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(getBackground());

        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;

        this.add(mainPanel, gridBagConstraints);

        JPanel myEventsPanel = new JPanel();
        myEventsPanel.setBackground(getBackground());

        JPanel allEventsPanel = new JPanel();
        allEventsPanel.setBackground(getBackground());
        
        GridBagConstraints mainPanelConstraints = new GridBagConstraints();
        mainPanelConstraints.anchor = GridBagConstraints.NORTH;
        mainPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanelConstraints.weightx = 1.0;

        mainPanelConstraints.gridy = 0;
        mainPanel.add(Components.createScrollBar(myEventsPanel), mainPanelConstraints);
        mainPanelConstraints.gridy = 1;
        mainPanel.add(Components.createScrollBar(allEventsPanel), mainPanelConstraints);

        for (int i = 0; i < 20; i++) {
            JButton expandButton = Components.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> mainView.changeScreen("event"));
    
            ArrayList<JComponent> components = new ArrayList<JComponent>();

            components.add(Components.createTitle("Master Class resinas"));
            components.add(Components.createLightText("Venha se divertir aprendendo sobre resinas"));
            components.add(Components.createGrayText("Rua José de Alencar, 135, Cuiabá - MT"));
            components.add(Components.createGrayText("Quinta-feira, 29, junho"));
            components.add(expandButton);
    
            JPanel container = Components.createContainer(components);
            myEventsPanel.add(container);
        }

        for (int i = 0; i < 20; i++) {
            JButton expandButton = Components.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> mainView.changeScreen("event"));
    
            ArrayList<JComponent> components = new ArrayList<JComponent>();

            components.add(Components.createTitle("Master Class resinas"));
            components.add(Components.createLightText("Venha se divertir aprendendo sobre resinas"));
            components.add(Components.createGrayText("Rua José de Alencar, 135, Cuiabá - MT"));
            components.add(Components.createGrayText("Quinta-feira, 29, junho"));
            components.add(expandButton);
    
            JPanel container = Components.createContainer(components);
            allEventsPanel.add(container);
        }

    }
}
