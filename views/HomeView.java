package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.HomeController;
import models.Admin;
import models.Event;
import models.Model;
import models.User;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de home
 */
public class HomeView extends JPanel implements Observer {
    private Model model;
    private HomeController controller;

    /*
     * Painéis de eventos
     */
    private JPanel myEventsPanel = new JPanel(
        new GridLayout(
            0, 4, 
            Constraints.CARD_INSETS.left, 
            Constraints.CARD_INSETS.top
        )
    );
    
    private JPanel allEventsPanel = new JPanel(new GridBagLayout());

    /*
     * Botões de ação
     */
    private JButton createEventButton = ComponentsFactory.createLightButton("Criar evento");

    /*
     * Construtor
     */
    public HomeView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new HomeController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Cria o cabeçalho da view
     */
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(getBackground());

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
        header.add(optionsPanel, BorderLayout.EAST);

        return header;
    }

    /*
     * Cria o painel de eventos do usuário
     */
    private JPanel createMyEventsTitlePanel() {
        JPanel myEventsTitlePanel = new JPanel(new BorderLayout());
        myEventsTitlePanel.setBackground(getBackground());

        this.createEventButton.setPreferredSize(Constraints.SMALL_DIMENSION);
        this.createEventButton.addActionListener(e -> this.controller.viewCreateEvent());

        myEventsTitlePanel.add(createEventButton, BorderLayout.EAST);
        myEventsTitlePanel.add(ComponentsFactory.createTitle("Meus eventos"), BorderLayout.WEST);

        return myEventsTitlePanel;
    }

    /*
     * Cria um container para um evento
     */
    private JPanel createContainer(Event event) {
        JButton expandButton = ComponentsFactory.createLightButton("Ver mais detalhes");
        expandButton.addActionListener(e -> this.controller.viewEvent(event));

        JPanel container = ComponentsFactory.createContainer(
            ComponentsFactory.createTitle(event.getName()),
            ComponentsFactory.createLightText(event.getDescription()),
            ComponentsFactory.createGrayText(event.getAddress().toString()),
            ComponentsFactory.createGrayText(
                event.getDate().toString() + " às " + event.getTime().toString()
            ),
            expandButton
        );

        return container;
    }
    
    /*
     * Exibe a view
     */
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
        
        gridBagConstraints.insets = Constraints.CARD_INSETS;
        mainPanel.add(createMyEventsTitlePanel(), gridBagConstraints);
        gridBagConstraints.insets = Constraints.DEFAULT_INSETS;

        this.myEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 1;
        mainPanel.add(myEventsPanel, gridBagConstraints);

        this.allEventsPanel.setBackground(getBackground());
        gridBagConstraints.gridy = 2;
        mainPanel.add(allEventsPanel, gridBagConstraints);

        this.update();
    }

    /*
     * Atualiza os eventos do usuário
     */
    private void updateMyEvents() {
        this.myEventsPanel.removeAll();
        
        User user = this.model.getLoggedUser();

        if (user == null) return;

        ArrayList<Event> userEvents = user.getMyEvents();

        for (Event userEvent: userEvents) {
            this.myEventsPanel.add(this.createContainer(userEvent));
        }
    }

    /*
     * Atualiza todos os eventos
     */
    private void updateAllEvents() {
        this.allEventsPanel.removeAll();

        /*
         * Se o usuário for admin, não exibe os eventos de outros admins
         */
        if (this.model.getLoggedUser() instanceof Admin) return;

        GridBagConstraints allEventsConstraints = new GridBagConstraints();
        allEventsConstraints.fill = GridBagConstraints.HORIZONTAL;
        allEventsConstraints.weightx = 1.0;

        Map<String, List<Event>> eventsByCategory = this.model.getEventsByCategory();

        int gridy = 0;

        for (String category : eventsByCategory.keySet()) {
            allEventsConstraints.gridy = gridy;

            allEventsConstraints.insets = Constraints.CARD_INSETS;
            this.allEventsPanel.add(ComponentsFactory.createTitle(category), allEventsConstraints);
            allEventsConstraints.insets = Constraints.DEFAULT_INSETS;

            gridy++;

            List<Event> eventsInCategory = eventsByCategory.get(category);

            GridLayout gridLayout = new GridLayout(
                0, 4, 
                Constraints.CARD_INSETS.left, 
                Constraints.CARD_INSETS.top
            );

            JPanel categoryPanel = new JPanel(gridLayout);
            categoryPanel.setBackground(getBackground());

            allEventsConstraints.gridy = gridy;
            this.allEventsPanel.add(categoryPanel, allEventsConstraints);

            gridy++;

            for (Event eventInCategory: eventsInCategory) {
                categoryPanel.add(this.createContainer(eventInCategory));
            }
        }
    }

    /*
     * Atualiza a view de acordo com o modelo
     */
    public void update() {        
        if (this.model.getLoggedUser() instanceof Admin) {
            this.createEventButton.setVisible(true);
        } else {
            this.createEventButton.setVisible(false);
        }

        this.updateMyEvents();
        this.updateAllEvents();
    }
}
