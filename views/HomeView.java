package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

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

        JPanel myEventsPanel = new JPanel();
        myEventsPanel.setBackground(getBackground());
        
        JScrollPane scrollPane = Components.createScrollBar(myEventsPanel);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 1.0;

        this.add(scrollPane, gridBagConstraints);

        for (int i = 0; i < 20; i++) {
            JLabel name = Components.createTitle("Master Class resinas");
    
            JLabel description = Components.createLightText("Venha se divertir aprendendo sobre resinas wwwe wef wefwef wef wefwefwe wefwefwef");
    
            JLabel address = Components.createGrayText("Rua José de Alencar, 135, Cuiabá - MT");
            JLabel date = Components.createGrayText("Quinta-feira, 29, junho");
    
            JButton expandButton = Components.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> mainView.changeScreen("event"));
    
            ArrayList<JComponent> components = new ArrayList<JComponent>();

            components.add(name);
            components.add(description);
            components.add(address);
            components.add(date);
            components.add(expandButton);
    
            JPanel container = Components.createContainer(components);
            myEventsPanel.add(container);
        }

    }
}
