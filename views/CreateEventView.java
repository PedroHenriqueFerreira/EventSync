package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CreateEventController;
import models.Model;
import utils.ComponentsFactory;
import utils.Constraints;
import utils.Observer;

/*
 * View de criação de evento
 */
public class CreateEventView extends JPanel implements Observer {
    private Model model;
    private CreateEventController controller;

    private JTextField nameTextField = ComponentsFactory.createInput("");
    private JTextField descriptionTextField = ComponentsFactory.createInput("");
    private JTextField categoryTextField = ComponentsFactory.createInput("");
    private JTextField timeTextField = ComponentsFactory.createMaskInput("##:##h", "");
    private JTextField dateTextField = ComponentsFactory.createMaskInput("##/##/####", "");
    private JTextField stateTextField = ComponentsFactory.createInput("");
    private JTextField cityTextField = ComponentsFactory.createInput("");
    private JTextField streetTextField = ComponentsFactory.createInput("");
    private JTextField addressNumberTextField = ComponentsFactory.createNumberInput("0");
    private JTextField priceTextField = ComponentsFactory.createCurrencyInput("0");

    /*
     * Retorna os valores dos campos de texto
     */

    public String getName() {
        return this.nameTextField.getText();
    }

    public String getDescription() {
        return this.descriptionTextField.getText();
    }

    public String getCategory() {
        return this.categoryTextField.getText();
    }

    public String getTime() {
        return this.timeTextField.getText();
    }

    public String getDate() {
        return this.dateTextField.getText();
    }

    public String getState() {
        return this.stateTextField.getText();
    }

    public String getCity() {
        return this.cityTextField.getText();
    }

    public String getStreet() {
        return this.streetTextField.getText();
    }

    public String getAddressNumber() {
        return this.addressNumberTextField.getText();
    }

    public String getPrice() {
        return this.priceTextField.getText();
    }

    /*
     * Limpam os campos de texto
     */
    public void clearFields() {
        this.nameTextField.setText("");
        this.descriptionTextField.setText("");
        this.categoryTextField.setText("");
        this.timeTextField.setText("");
        this.dateTextField.setText("");
        this.stateTextField.setText("");
        this.cityTextField.setText("");
        this.streetTextField.setText("");
        this.addressNumberTextField.setText("0");
        this.priceTextField.setText("0");
    }

    /* 
     * Construtor
     */
    public CreateEventView(Model model, MainView mainView) {
        this.model = model;
        this.controller = new CreateEventController(model, mainView, this);

        this.model.attachObserver(this);    

        this.display();
    }

    /*
     * Exibe a view
     */
    private void display() {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton createButton = ComponentsFactory.createButton("Criar evento");
        createButton.addActionListener(e -> this.controller.createEvent());

        JButton homeButton = ComponentsFactory.createLightButton("Voltar");
        homeButton.addActionListener(e -> this.controller.viewHome());

        JPanel container = ComponentsFactory.createLargeContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Criar evento"),
            ComponentsFactory.createGrayText("Nome:"),
            nameTextField,
            ComponentsFactory.createGrayText("Descrição:"),
            descriptionTextField,
            ComponentsFactory.createGrayText("Categoria:"),
            categoryTextField,
            ComponentsFactory.createGrayText("Hora:"),
            timeTextField,
            ComponentsFactory.createGrayText("Data:"),
            dateTextField,
            ComponentsFactory.createGrayText("Estado:"),
            stateTextField,
            ComponentsFactory.createGrayText("Cidade:"),
            cityTextField,
            ComponentsFactory.createGrayText("Rua:"),
            streetTextField,
            ComponentsFactory.createGrayText("Número:"),
            addressNumberTextField,
            ComponentsFactory.createGrayText("Preço:"),
            priceTextField,
            ComponentsFactory.createLightText(" "),
            createButton,
            homeButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }

    public void update() {}
}
