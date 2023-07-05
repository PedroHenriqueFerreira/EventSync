package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CreateActivityController;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

public class CreateActivityView extends JPanel implements Observer {
    private Model model;
    private CreateActivityController controller;

    private JTextField nameTextField = ComponentsFactory.createInput("");
    private JTextField descriptionTextField = ComponentsFactory.createInput("");
    private JTextField instructorNameTextField = ComponentsFactory.createInput("");
    private JTextField instructorEmailTextField = ComponentsFactory.createInput("");
    private JTextField instructorPhoneTextField = ComponentsFactory.createMaskInput("(##) # ####-####", "");
    private JTextField dateTextField = ComponentsFactory.createMaskInput("##/##/####", "");
    private JTextField timeTextField = ComponentsFactory.createMaskInput("##:##h", "");

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

    public void clearFields() {
        this.nameTextField.setText("");
        this.descriptionTextField.setText("");
        this.instructorNameTextField.setText("");
        this.instructorEmailTextField.setText("");
        this.instructorPhoneTextField.setText("");
        this.dateTextField.setText("");
        this.timeTextField.setText("");
    }

    public CreateActivityView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new CreateActivityController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());
        
        JButton updateButton = ComponentsFactory.createButton("Criar atividade");
        updateButton.addActionListener(e -> this.controller.createActivity());

        JButton activityButton = ComponentsFactory.createLightButton("Voltar");
        activityButton.addActionListener(e -> this.controller.viewEvent());

        JPanel container = ComponentsFactory.createContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Criar atividade"),
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

    public void update() {}
}
