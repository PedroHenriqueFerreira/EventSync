package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ActivityController;
import models.Activity;
import models.Admin;
import models.Model;
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

    private JButton updateButton = ComponentsFactory.createButton("Atualizar atividade");
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
        
        this.updateButton.addActionListener(e -> this.controller.updateActivity());
        this.deleteButton.addActionListener(e -> this.controller.deleteActivity());
        
        JButton eventButton = ComponentsFactory.createLightButton("Voltar");
        eventButton.addActionListener(e -> this.controller.viewEvent());

        JPanel container = ComponentsFactory.createLargeContainer(
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
            ComponentsFactory.createLightText(" "),
            this.updateButton,
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
        Activity activity = this.model.getSelectedActivity();

        if (activity == null) return;

        this.nameLabel.setText(activity.getName());
        this.descriptionLabel.setText(activity.getDescription());
        this.instructorNameLabel.setText(activity.getInstructor().getName());
        this.instructorEmailLabel.setText(activity.getInstructor().getEmail());
        this.instructorPhoneLabel.setText(activity.getInstructor().getPhone());
        this.dateTimeLabel.setText(activity.getDate().toString() + " às " + activity.getTime().toString());

        if (this.model.getLoggedUser() instanceof Admin) {
            this.updateButton.setVisible(true);
            this.deleteButton.setVisible(true);
        } else {
            this.updateButton.setVisible(false);
            this.deleteButton.setVisible(false);
        }
    }
}
