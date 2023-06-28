package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

import utils.UIComponents;

public class HomeView extends JPanel {
    public HomeView(MainView mainView) {
        this.setLayout(new GridBagLayout());
        this.setBackground(UIComponents.bgColor);
        this.setBorder(UIComponents.largePaddingBorder);
        
        JPanel header = new JPanel();
        header.setBackground(getBackground());
        header.setLayout(new BorderLayout());
        
        JPanel options = new JPanel();
        options.setBackground(getBackground());

        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel logoLabel = new JLabel(logo);
        JButton account = UIComponents.createButton("Minha conta");
        account.setPreferredSize(UIComponents.smallDimension);

        account.addActionListener(e -> mainView.changeScreen("account"));

        JButton logoutButton = UIComponents.createLightButton("Sair");
        logoutButton.setPreferredSize(UIComponents.smallDimension);

        logoutButton.addActionListener(e -> mainView.changeScreen("login"));

        options.add(account);
        options.add(logoutButton);
        
        header.add(logoLabel, BorderLayout.WEST);
        header.add(options, BorderLayout.EAST);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        this.add(header, gridBagConstraints);

        JPanel myEventsPanel = new JPanel();
        myEventsPanel.setBackground(getBackground());

        myEventsPanel.setLayout(new GridLayout(0, 4, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane(myEventsPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Color.gray;
                this.trackColor = Color.lightGray;
                this.scrollBarWidth = 10;
            }
        });
        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 1.0;

        this.add(scrollPane, gridBagConstraints);

        for (int i = 0; i < 20; i++) {
            JLabel name = UIComponents.createTitle("Master Class resinas");
    
            JLabel description = UIComponents.createText("Venha se divertir aprendendo sobre resinas wwwe wef wefwef wef wefwefwe wefwefwef");
    
            JLabel address = UIComponents.createText("Rua José de Alencar, 135, Cuiabá - MT");
            address.setForeground(UIComponents.grayColor);
    
            JLabel date = UIComponents.createText("Quinta-feira, 29, junho");
            date.setForeground(UIComponents.grayColor);
    
            JButton expandButton = UIComponents.createLightButton("Ver mais detalhes");
    
            expandButton.addActionListener(e -> mainView.changeScreen("event"));
    
            ArrayList<JComponent> components = new ArrayList<JComponent>();

            components.add(name);
            components.add(description);
            components.add(address);
            components.add(date);
            components.add(expandButton);
    
            JPanel container = UIComponents.createContainer(components);
            myEventsPanel.add(container);
        }

    }
}
