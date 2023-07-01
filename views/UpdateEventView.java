package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.ComponentsFactory;
import utils.Constraints;

public class UpdateEventView extends JPanel {
    public UpdateEventView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton buyButton = ComponentsFactory.createButton("Atualizar evento");
        buyButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = ComponentsFactory.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));
        
        JPanel container = ComponentsFactory.createLargeContainer(
            new JLabel(Constraints.LOGO_IMAGE_ICON),
            ComponentsFactory.createTitle("Vizualizar evento"),
            ComponentsFactory.createGrayText("Código:"),
            ComponentsFactory.createInput("DF91A3G"),
            ComponentsFactory.createGrayText("Nome:"),
            ComponentsFactory.createInput("II Congresso Matogrossense de Fisioterapia"),
            ComponentsFactory.createGrayText("Descrição:"),
            ComponentsFactory.createInput("O II Congresso"),
            ComponentsFactory.createGrayText("Data:"),
            ComponentsFactory.createMaskInput("##:##h ##/##/####", "08:00h 12/07/2023"),
            ComponentsFactory.createGrayText("Endereço:"),
            ComponentsFactory.createLightButton("Endereço - Rua José de Alencar"),
            ComponentsFactory.createGrayText("Administrador:"),
            ComponentsFactory.createLightButton("Administrador - Pedro Henrique Ferreira"),
            ComponentsFactory.createGrayText("Atividades:"),
            ComponentsFactory.createLightButton("Atividade 1 - Mini curso python"),
            ComponentsFactory.createLightButton("Atividade 2 - Mini curso python"),
            ComponentsFactory.createLightButton("Atividade 3 - Mini curso python"),
            ComponentsFactory.createLightButton("Atividade 4 - Mini curso python"),
            ComponentsFactory.createLightButton("Atividade 5 - Mini curso python"),
            ComponentsFactory.createGrayText("Participantes:"),
            ComponentsFactory.createLightButton("Participante 1 - Joao Carlos Pereira"),
            ComponentsFactory.createLightButton("Participante 2 - Mário Gomes Costa"),
            ComponentsFactory.createLightButton("Participante 3 - Júlia Maria Monteiro"),
            ComponentsFactory.createLightButton("Participante 4 - Rosineide da Paz"),
            ComponentsFactory.createGrayText("Valor:"),
            ComponentsFactory.createCurrencyInput("35120.0"),
            buyButton,
            backButton
        );

        this.add(
            ComponentsFactory.createScrollBar(container), 
            ComponentsFactory.createScrollBarConstraints()
        );
    }
}
