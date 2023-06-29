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

import utils.Components;
import utils.Constraints;

public class UpdateEventView extends JPanel {
    public UpdateEventView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton buyButton = Components.createButton("Atualizar evento");
        buyButton.addActionListener(e -> mainView.changeScreen("update_account"));

        JButton backButton = Components.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        ArrayList<JComponent> components = new ArrayList<JComponent>();
        
        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Vizualizar evento"));
        components.add(Components.createGrayText("Código:")); 
        components.add(Components.createInput("DF91A3G"));
        components.add(Components.createGrayText("Nome:"));
        components.add(Components.createInput("II Congresso Matogrossense de Fisioterapia"));
        components.add(Components.createGrayText("Descrição:"));
        components.add(Components.createInput("O II Congresso Matogrossensse de Fisioterapia será realizado nos dias 30.06 e 01.07.23 na cidade de Cuiabá"));
        components.add(Components.createGrayText("Data:"));
        components.add(Components.createMaskInput("##:##h ##/##/####", "08:00h 12/07/2023"));
        components.add(Components.createGrayText("Endereço:"));
        components.add(Components.createLightButton("Endereço - Rua José de Alencar, 135, Cuiabá, MT"));
        components.add(Components.createGrayText("Administrador:"));
        components.add(Components.createLightButton("Administrador - Pedro Henrique Ferreira"));
        components.add(Components.createGrayText("Atividades:"));
        components.add(Components.createLightButton("Atividade 1 - Mini curso python"));
        components.add(Components.createLightButton("Atividade 2 - Mini curso python"));
        components.add(Components.createLightButton("Atividade 3 - Mini curso python"));
        components.add(Components.createLightButton("Atividade 4 - Mini curso python"));
        components.add(Components.createLightButton("Atividade 5 - Mini curso python"));
        components.add(Components.createGrayText("Participantes:"));
        components.add(Components.createLightButton("Participante 1 - Joao Carlos Pereira"));
        components.add(Components.createLightButton("Participante 2 - Mário Gomes Costa"));
        components.add(Components.createLightButton("Participante 3 - Júlia Maria Monteiro"));
        components.add(Components.createLightButton("Participante 4 - Rosineide da Paz"));
        components.add(Components.createGrayText("Valor:"));
        components.add(Components.createCurrencyInput("35120.0"));
        components.add(buyButton);
        components.add(backButton);

        for(JComponent component : components) {
            component.setPreferredSize(
                new Dimension(
                    Constraints.LARGE_COMPONENT_WIDTH, 
                    component.getPreferredSize().height
                )
            );
        }

        JScrollPane container = Components.createContainer(components);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.weightx = 1.0;

        this.add(container, gridBagConstraints);
    }
}
