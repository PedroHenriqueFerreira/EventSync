package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.ComponentsFactory;
import utils.Constraints;

public class HomeView extends JPanel {
    public HomeView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        this.setBorder(Constraints.LARGE_PADDING_BORDER);
        
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(getBackground());
        
        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(getBackground());

        JLabel logo = new JLabel(Constraints.LOGO_IMAGE_ICON);

        JButton accountButton = ComponentsFactory.createButton("Minha conta");
        accountButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        accountButton.addActionListener(e -> mainView.changeScreen("account"));

        JButton logoutButton = ComponentsFactory.createLightButton("Sair");
        logoutButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        logoutButton.addActionListener(e -> mainView.changeScreen("login"));

        optionsPanel.add(accountButton);
        optionsPanel.add(logoutButton);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(getBackground());

        JButton searchButton = ComponentsFactory.createButton("Pesquisar");
        searchButton.setPreferredSize(Constraints.SMALL_DIMENSION);

        searchPanel.add(ComponentsFactory.createSearchInput(""));
        searchPanel.add(searchButton);

        
        header.add(logo, BorderLayout.WEST);
        header.add(searchPanel, BorderLayout.CENTER);
        header.add(optionsPanel, BorderLayout.EAST);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;

        this.add(header, gridBagConstraints);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(getBackground());

        GridBagConstraints scrollBarConstraints = ComponentsFactory.createScrollBarConstraints();
        scrollBarConstraints.gridy = 1;

        this.add(ComponentsFactory.createScrollBar(mainPanel), scrollBarConstraints);
        
        
        gridBagConstraints.gridy = 0;
        mainPanel.add(ComponentsFactory.createTitle("Meus eventos"), gridBagConstraints);

        JPanel myEventsPanel = new JPanel(new GridBagLayout());
        myEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 1;
        mainPanel.add(myEventsPanel, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        mainPanel.add(ComponentsFactory.createTitle("Todos os eventos"), gridBagConstraints);

        JPanel allEventsPanel = new JPanel(new GridBagLayout());
        allEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 3;
        mainPanel.add(allEventsPanel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0;

        for (int i = 0; i < 10; i++) {
            JButton expandButton = ComponentsFactory.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> mainView.changeScreen("event"));

            JPanel container = ComponentsFactory.createContainer(
                ComponentsFactory.createTitle("Master Class resinas"),
                ComponentsFactory.createLightText("Venha se divertir..."),
                ComponentsFactory.createGrayText("Rua José de Alencar, 135, Cuiabá - MT"),
                ComponentsFactory.createGrayText("Quinta-feira, 29, junho"),
                expandButton
            );

            gridBagConstraints.gridx = i % 4;
            gridBagConstraints.gridy = i / 4;

            if (gridBagConstraints.gridx == 0) {
                gridBagConstraints.insets = new Insets(
                    Constraints.CARD_INSETS.top, 
                    0, 
                    Constraints.CARD_INSETS.bottom, 
                    Constraints.CARD_INSETS.right
                );
            } else if (gridBagConstraints.gridx == 3) {
                gridBagConstraints.insets = new Insets(
                    Constraints.CARD_INSETS.top, 
                    Constraints.CARD_INSETS.left,
                    Constraints.CARD_INSETS.bottom, 
                    0
                );
            } else {
                gridBagConstraints.insets = Constraints.CARD_INSETS;
            }

            myEventsPanel.add(container, gridBagConstraints);
        }

        for (int i = 0; i < 10; i++) {
            JButton expandButton = ComponentsFactory.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> mainView.changeScreen("event"));

            JPanel container = ComponentsFactory.createContainer(
                ComponentsFactory.createTitle("Master Class resinas"),
                ComponentsFactory.createLightText("Venha se divertir..."),
                ComponentsFactory.createGrayText("Rua José de Alencar, 135, Cuiabá - MT"),
                ComponentsFactory.createGrayText("Quinta-feira, 29, junho"),
                expandButton
            );

            gridBagConstraints.gridx = i % 4;
            gridBagConstraints.gridy = i / 4;

            if (gridBagConstraints.gridx == 0) {
                gridBagConstraints.insets = new Insets(
                    Constraints.CARD_INSETS.top, 
                    0, 
                    Constraints.CARD_INSETS.bottom, 
                    Constraints.CARD_INSETS.right
                );
            } else if (gridBagConstraints.gridx == 3) {
                gridBagConstraints.insets = new Insets(
                    Constraints.CARD_INSETS.top, 
                    Constraints.CARD_INSETS.left,
                    Constraints.CARD_INSETS.bottom, 
                    0
                );
            } else {
                gridBagConstraints.insets = Constraints.CARD_INSETS;
            }

            allEventsPanel.add(container, gridBagConstraints);
        }
    }
}
