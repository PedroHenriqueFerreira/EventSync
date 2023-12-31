package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.EventController;
import models.Activity;
import models.Admin;
import models.Event;
import models.Model;
import models.User;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de visualização de evento
 */
public class EventView extends JPanel implements Observer {
    private Model model;
    private EventController controller;

    private JLabel codeTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel nameTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel descriptionTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel categoryTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel dateTimeTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel addressTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel priceTextLabel = ComponentsFactory.createLightText(" ");
    private JLabel participantsTextLabel = ComponentsFactory.createLightText(" ");

    private JPanel activitiesPanel = new JPanel(
        new GridLayout(
            10, 
            1, 
            0, 
            Constraints.BUTTON_INSETS.top
        )
    );

    private JButton createActivity = ComponentsFactory.createButton("Criar atividade");

    private JButton updateOrBuyButton = ComponentsFactory.createButton("Atualizar evento");

    private JButton deleteButton = ComponentsFactory.createLightButton("Deletar evento");

    /*
     * Construtor
     */
    public EventView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new EventController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> this.controller.viewHome());

        this.createActivity.addActionListener(e -> this.controller.viewCreateActivity());
        this.deleteButton.addActionListener(e -> this.controller.deleteEvent());

        this.activitiesPanel.setBackground(Constraints.CONTAINER_COLOR);
        this.activitiesPanel.setPreferredSize(
            new Dimension(
                Constraints.LARGE_COMPONENT_WIDTH, 
                Constraints.DEFAULT_COMPONENT_HEIGHT * 10 + Constraints.BUTTON_INSETS.top * 9
            )
        );

        JPanel container = ComponentsFactory.createLargeContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Visualizar evento"),
            ComponentsFactory.createGrayText("Código:"),
            this.codeTextLabel,
            ComponentsFactory.createGrayText("Nome:"),
            this.nameTextLabel,
            ComponentsFactory.createGrayText("Descrição:"),
            this.descriptionTextLabel,
            ComponentsFactory.createGrayText("Categoria:"),
            this.categoryTextLabel,
            ComponentsFactory.createGrayText("Data e Hora:"),
            this.dateTimeTextLabel,
            ComponentsFactory.createGrayText("Endereço:"),
            this.addressTextLabel,
            ComponentsFactory.createGrayText("Preço:"),
            this.priceTextLabel,
            ComponentsFactory.createGrayText("Participantes:"),
            this.participantsTextLabel,
            ComponentsFactory.createGrayText("Atividades:"),
            this.activitiesPanel,
            this.createActivity,
            ComponentsFactory.createLightText(" "),
            this.updateOrBuyButton,
            this.deleteButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );   

        this.update();
    }

    public void update() {
        User user = this.model.getLoggedUser();

        if (user == null) return;

        /*
         * Se o usuário logado for um administrador, exibe o botão de criar atividade
         */
        if (user instanceof Admin) {
            this.createActivity.setVisible(true);
            this.deleteButton.setVisible(true);
        } else {
            this.createActivity.setVisible(false);
            this.deleteButton.setVisible(false);
        }

        /*
         * Se não houver evento selecionado, não exibe nada
         */
        Event event = this.model.getSelectedEvent();

        if (event == null) return;

        /*
         * Exibe as informações do evento selecionado
         */

        this.codeTextLabel.setText(event.getCode());
        this.nameTextLabel.setText(event.getName());
        this.descriptionTextLabel.setText(event.getDescription());
        this.categoryTextLabel.setText(event.getCategory());
        this.dateTimeTextLabel.setText(event.getDate() +" às " + event.getTime());
        this.addressTextLabel.setText(event.getAddress().toString());
        this.priceTextLabel.setText(String.format("R$ %.2f", event.getPrice()));
        this.participantsTextLabel.setText(event.getParticipants().size() + "");

        /* 
         * Exibe as atividades do evento selecionado
         */

        this.activitiesPanel.removeAll();

        ArrayList<Activity> activities = event.getActivities();

        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);

            JButton button = ComponentsFactory.createLightButton(activity.toString());
            button.setPreferredSize(Constraints.LARGE_DIMENSION);
            
            button.addActionListener(e -> this.controller.viewActivity(activity));
            
            this.activitiesPanel.add(button);
        }

        /*
         * Exibe o botão de atualizar evento ou comprar ingresso
         */
        
        ActionListener[] listeners = this.updateOrBuyButton.getActionListeners();

        for (ActionListener listener : listeners) {
            this.updateOrBuyButton.removeActionListener(listener);
        }

        if (user instanceof Admin) {
            this.updateOrBuyButton.setText("Atualizar evento");
            this.updateOrBuyButton.addActionListener(e -> this.controller.viewUpdateEvent());
        } else {
            if (user.getMyEvents().contains(event)) {
                this.updateOrBuyButton.setText("Estornar ingresso");
                this.updateOrBuyButton.addActionListener(e -> this.controller.unbuyEvent());
            } else {
                this.updateOrBuyButton.setText("Comprar");
                this.updateOrBuyButton.addActionListener(e -> this.controller.buyEvent());
            }
        }
    }
}
