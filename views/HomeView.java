package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controllers.HomeController;
import models.Event;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

public class HomeView extends JPanel implements Observer {
    private Model model;
    private HomeController controller;

    private JPanel myEventsPanel = new JPanel(new GridBagLayout());

    public HomeView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new HomeController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(getBackground());

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(getBackground());

        JButton searchButton = ComponentsFactory.createButton("Pesquisar");
        searchButton.setPreferredSize(Constraints.SMALL_DIMENSION);

        searchPanel.add(ComponentsFactory.createSearchInput(""));
        searchPanel.add(searchButton);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(getBackground());

        JButton accountButton = ComponentsFactory.createButton("Minha conta");
        accountButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        accountButton.addActionListener(e -> this.controller.viewAccount());

        JButton logoutButton = ComponentsFactory.createLightButton("Sair");
        logoutButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        logoutButton.addActionListener(e -> this.controller.logout());

        optionsPanel.add(accountButton);
        optionsPanel.add(logoutButton);

        header.add(new JLabel(Constraints.LOGO_IMAGE_ICON), BorderLayout.WEST);
        header.add(searchPanel, BorderLayout.CENTER);
        header.add(optionsPanel, BorderLayout.EAST);

        return header;
    }

    private JPanel createMyEventsTitlePanel() {
        JPanel myEventsTitlePanel = new JPanel(new BorderLayout());
        myEventsTitlePanel.setBackground(getBackground());
        
        myEventsTitlePanel.add(ComponentsFactory.createTitle("Meus eventos"), BorderLayout.WEST);

        JButton createEventButton = ComponentsFactory.createLightButton("Criar evento");
        createEventButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        createEventButton.addActionListener(e -> this.controller.viewCreateEvent());

        myEventsTitlePanel.add(createEventButton, BorderLayout.EAST);

        return myEventsTitlePanel;
    }
    
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        this.setBorder(Constraints.LARGE_PADDING_BORDER);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;

        this.add(createHeader(), gridBagConstraints);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(getBackground());
        
        GridBagConstraints scrollBarConstraints = ComponentsFactory.createScrollBarConstraints();
        scrollBarConstraints.gridy = 1;
        
        this.add(ComponentsFactory.createScrollBar(mainPanel), scrollBarConstraints);
        
        mainPanel.add(createMyEventsTitlePanel(), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        this.myEventsPanel.setBackground(getBackground());
        mainPanel.add(myEventsPanel, gridBagConstraints);
        
        gridBagConstraints.gridy = 2;
        mainPanel.add(ComponentsFactory.createTitle("Todos os eventos"), gridBagConstraints);

        // JPanel allEventsPanel = new JPanel(new GridBagLayout());
        // allEventsPanel.setBackground(getBackground());
        // gridBagConstraints.gridy = 3;
        // mainPanel.add(allEventsPanel, gridBagConstraints);
    }

    public void update() {
        System.out.println("------------------");

        ArrayList<Event> events = this.model.getEvents();

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);

            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            gridBagConstraints.insets = Constraints.CARD_INSETS;

            JButton expandButton = ComponentsFactory.createLightButton("Ver mais detalhes");
            expandButton.addActionListener(e -> this.controller.viewEvent());

            JPanel container = ComponentsFactory.createContainer(
                ComponentsFactory.createTitle(event.getName()),
                ComponentsFactory.createLightText(event.getDescription()),
                ComponentsFactory.createGrayText(event.getAddress().toString()),
                ComponentsFactory.createGrayText(
                    event.getDate().toString() + " às " + event.getTime().toString()
                ),
                expandButton
            );

            gridBagConstraints.gridx = i % 4;
            gridBagConstraints.gridy = i / 4;

            this.myEventsPanel.add(container, gridBagConstraints);
        }
    }
}
