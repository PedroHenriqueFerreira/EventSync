package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controllers.HomeController;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

public class HomeView extends JPanel implements Observer {
    private Model model;
    private HomeController controller;

    public HomeView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new HomeController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    private void display() {
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
        accountButton.addActionListener(e -> this.controller.viewAccount());

        JButton logoutButton = ComponentsFactory.createLightButton("Sair");
        logoutButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        logoutButton.addActionListener(e -> this.controller.logout());

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

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        scrollBarConstraints.gridy = 1;
        this.add(ComponentsFactory.createScrollBar(mainPanel), scrollBarConstraints);
        
        gridBagConstraints.gridy = 0;
    
        JPanel myEventsTitlePanel = new JPanel(new BorderLayout());
        myEventsTitlePanel.setBackground(getBackground());
        myEventsTitlePanel.add(ComponentsFactory.createTitle("Meus eventos"), BorderLayout.WEST);

        JButton createEventButton = ComponentsFactory.createLightButton("Criar evento");
        createEventButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        createEventButton.addActionListener(e -> this.controller.viewCreateEvent());

        myEventsTitlePanel.add(createEventButton, BorderLayout.EAST);

        gridBagConstraints.insets = Constraints.TEXT_INSETS;
        mainPanel.add(myEventsTitlePanel, gridBagConstraints);
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);

        JPanel myEventsPanel = new JPanel(new GridBagLayout());
        myEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 1;
        mainPanel.add(myEventsPanel, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = Constraints.TEXT_INSETS;
        mainPanel.add(ComponentsFactory.createTitle("Todos os eventos"), gridBagConstraints);
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);

        JPanel allEventsPanel = new JPanel(new GridBagLayout());
        allEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 3;
        mainPanel.add(allEventsPanel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0;

        for (int i = 0; i < 10; i++) {
            JButton expandButton = ComponentsFactory.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> this.controller.viewEvent());

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
            expandButton.addActionListener(e -> this.controller.viewEvent());

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

    public void update() {}
}
