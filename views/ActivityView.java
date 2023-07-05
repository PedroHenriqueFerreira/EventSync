package views;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ActivityController;
import models.Activity;
import models.Admin;
import models.Event;
import models.Model;
import models.User;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de visualização de atividade
 */
public class ActivityView extends JPanel implements Observer {
    private Model model;
    private ActivityController controller;

    private JLabel nameLabel = ComponentsFactory.createLightText(" ");
    private JLabel descriptionLabel = ComponentsFactory.createLightText(" ");
    private JLabel instructorNameLabel = ComponentsFactory.createLightText(" ");
    private JLabel instructorEmailLabel = ComponentsFactory.createLightText(" ");
    private JLabel instructorPhoneLabel = ComponentsFactory.createLightText(" ");
    private JLabel dateTimeLabel = ComponentsFactory.createLightText(" ");
    private JLabel frequencyLabel = ComponentsFactory.createLightText(" ");

    private JButton updateOrJoinButton = ComponentsFactory.createButton("Atualizar atividade");
    private JButton deleteButton = ComponentsFactory.createLightButton("Apagar atividade");

    /*
     * Retorna o valor dos campos
     */
    public ActivityView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new ActivityController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        this.deleteButton.addActionListener(e -> this.controller.deleteActivity());
        
        JButton eventButton = ComponentsFactory.createLightButton("Voltar");
        eventButton.addActionListener(e -> this.controller.viewEvent());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Visualizar atividade"),
            ComponentsFactory.createGrayText("Nome:"),
            this.nameLabel,
            ComponentsFactory.createGrayText("Descrição:"),
            this.descriptionLabel,
            ComponentsFactory.createGrayText("Nome do instrutor:"),
            this.instructorNameLabel,
            ComponentsFactory.createGrayText("Email do instrutor:"),
            this.instructorEmailLabel,
            ComponentsFactory.createGrayText("Telefone do instrutor:"),
            this.instructorPhoneLabel,
            ComponentsFactory.createGrayText("Data e Hora:"),
            this.dateTimeLabel,
            ComponentsFactory.createGrayText("Frequência:"),
            this.frequencyLabel,
            ComponentsFactory.createLightText(" "),
            this.updateOrJoinButton,
            this.deleteButton,
            eventButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {
        /*
         * Atualiza os campos com os valores do evento selecionado
         */

        User loggedUser = this.model.getLoggedUser();
        Event event = this.model.getSelectedEvent();
        Activity activity = this.model.getSelectedActivity();

        if (loggedUser == null || event == null || activity == null) return;

        this.nameLabel.setText(activity.getName());
        this.descriptionLabel.setText(activity.getDescription());
        this.instructorNameLabel.setText(activity.getInstructor().getName());
        this.instructorEmailLabel.setText(activity.getInstructor().getEmail());
        this.instructorPhoneLabel.setText(activity.getInstructor().getPhone());
        this.dateTimeLabel.setText(activity.getDate().toString() + " às " + activity.getTime().toString());
        this.frequencyLabel.setText(activity.getFrequency().size() + " de " + event.getParticipants().size());

        ActionListener[] listeners = this.updateOrJoinButton.getActionListeners();

        for (ActionListener listener : listeners) {
            this.updateOrJoinButton.removeActionListener(listener);
        }
        
        if (loggedUser instanceof Admin) {
            this.updateOrJoinButton.setText("Atualizar atividade");
            this.updateOrJoinButton.addActionListener(e -> this.controller.updateActivity());
            this.updateOrJoinButton.setVisible(true);

            this.deleteButton.setVisible(true);
        } else {
            if (event.getParticipants().contains(loggedUser)) {
                this.updateOrJoinButton.setVisible(true);
                
                if (activity.getFrequency().contains(loggedUser)) {
                    this.updateOrJoinButton.setText("Sair");
                    this.updateOrJoinButton.addActionListener(e -> this.controller.leaveActivity());
                } else {
                    this.updateOrJoinButton.setText("Participar");
                    this.updateOrJoinButton.addActionListener(e -> this.controller.joinActivity());
                }
            } else {
                this.updateOrJoinButton.setVisible(false);
            }

            this.deleteButton.setVisible(false);
        }
    }
}
