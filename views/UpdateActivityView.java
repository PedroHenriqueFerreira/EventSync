package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.UpdateActivityController;
import models.Activity;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de atualização de atividade
 */
public class UpdateActivityView extends JPanel implements Observer {
    private Model model;
    private UpdateActivityController controller;

    private JTextField nameTextField = ComponentsFactory.createInput("");
    private JTextField descriptionTextField = ComponentsFactory.createInput("");
    private JTextField instructorNameTextField = ComponentsFactory.createInput("");
    private JTextField instructorEmailTextField = ComponentsFactory.createInput("");
    private JTextField instructorPhoneTextField = ComponentsFactory.createMaskInput("(##) # ####-####", "");
    private JTextField dateTextField = ComponentsFactory.createMaskInput("##/##/####", "");
    private JTextField timeTextField = ComponentsFactory.createMaskInput("##:##h", "");

    /*
     * Retorna os valores dos campos de texto
     */
    public String getName() {
        return this.nameTextField.getText();
    }

    public String getDescription() {
        return this.descriptionTextField.getText();
    }

    public String getInstructorName() {
        return this.instructorNameTextField.getText();
    }

    public String getInstructorEmail() {
        return this.instructorEmailTextField.getText();
    }

    public String getInstructorPhone() {
        return this.instructorPhoneTextField.getText();
    }

    public String getDate() {
        return this.dateTextField.getText();
    }

    public String getTime() {
        return this.timeTextField.getText();
    }

    /*
     * Limpa os campos de texto
     */
    public void clearFields() {
        this.nameTextField.setText("");
        this.descriptionTextField.setText("");
        this.instructorNameTextField.setText("");
        this.instructorEmailTextField.setText("");
        this.instructorPhoneTextField.setText("");
        this.dateTextField.setText("");
        this.timeTextField.setText("");
    }

    /*
     * Construtor
     */
    public UpdateActivityView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new UpdateActivityController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        JButton updateButton = ComponentsFactory.createButton("Atualizar atividade");
        updateButton.addActionListener(e -> this.controller.updateActivity());

        JButton activityButton = ComponentsFactory.createLightButton("Voltar");
        activityButton.addActionListener(e -> this.controller.viewActivity());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Atualizar atividade"),
            ComponentsFactory.createGrayText("Nome:"),
            this.nameTextField,
            ComponentsFactory.createGrayText("Descrição:"),
            this.descriptionTextField,
            ComponentsFactory.createGrayText("Nome do instrutor:"),
            this.instructorNameTextField,
            ComponentsFactory.createGrayText("Email do instrutor:"),
            this.instructorEmailTextField,
            ComponentsFactory.createGrayText("Telefone do instrutor:"),
            this.instructorPhoneTextField,
            ComponentsFactory.createGrayText("Hora:"),
            this.timeTextField,
            ComponentsFactory.createGrayText("Data:"),
            this.dateTextField,
            ComponentsFactory.createLightText(" "),
            updateButton,
            activityButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    /*
     * Atualiza a view
     */
    public void update() {
        /*
         * Atualiza os campos de texto com os dados da atividade selecionada
         */
        Activity activity = this.model.getSelectedActivity();

        if (activity == null) return;

        this.nameTextField.setText(activity.getName());
        this.descriptionTextField.setText(activity.getDescription());
        this.instructorNameTextField.setText(activity.getInstructor().getName());
        this.instructorEmailTextField.setText(activity.getInstructor().getEmail());
        this.instructorPhoneTextField.setText(activity.getInstructor().getPhone());
        this.dateTextField.setText(activity.getDate().toString());
        this.timeTextField.setText(activity.getTime().toString());
    }
}
