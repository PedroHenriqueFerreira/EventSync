package views;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Components;
import utils.Constraints;


public class EventView extends JPanel {
    public EventView(MainView mainView) {
        this.setBackground(Constraints.BG_COLOR);
        this.setLayout(new GridBagLayout());

        JButton buyButton = Components.createButton("Atualizar evento");
        buyButton.addActionListener(e -> mainView.changeScreen("update_event"));

        JButton backButton = Components.createLightButton("Voltar");
        backButton.addActionListener(e -> mainView.changeScreen("home"));

        ArrayList<JComponent> components = new ArrayList<JComponent>();
        
        components.add(new JLabel(Constraints.LOGO_IMAGE_ICON));
        components.add(Components.createTitle("Vizualizar evento"));
        components.add(Components.createGrayText("Código:")); 
        components.add(Components.createLightText("DF91A3G"));
        components.add(Components.createGrayText("Nome:"));
        components.add(Components.createLightText("II Congresso Matogrossense de Fisioterapia"));
        components.add(Components.createGrayText("Descrição:"));
        components.add(Components.createLightText("O II Congresso Matogrossensse de Fisioterapia será realizado nos dias 30.06 e 01.07.23 na cidade de Cuiabá"));
        components.add(Components.createGrayText("Data:"));
        components.add(Components.createLightText("08:00h 12/07/2023"));
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
        components.add(Components.createLightText("R$ 120,00"));
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

        this.add(
            Components.createScrollBar(Components.createContainer(components)), 
            Components.createScrollBarConstraints()
        );
    }
}
