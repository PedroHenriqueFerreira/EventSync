package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

        ImageIcon logo = new ImageIcon("assets/logo.png");
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

        JScrollPane scrollPane = new JScrollPane(myEventsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 500));

        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridy = 1;
        this.add(myEventsPanel, gridBagConstraints);

        for (int i = 0; i < 20; i++) {
            JLabel name = UIComponents.createTitle("Master Class resinas");
    
            JLabel description = UIComponents.createText("Venha se divertir aprendendo sobre resinas wwwe wef wefwef wef wefwefwe wefwefwef");
            // description.setForeground(UIComponents.grayColor);
    
            JLabel address = UIComponents.createText("Rua José de Alencar, 135, Cuiabá - MT");
            address.setForeground(UIComponents.grayColor);
    
            JLabel date = UIComponents.createText("Quinta-feira, 29, junho");
            date.setForeground(UIComponents.grayColor);
    
            JButton expandButton = UIComponents.createLightButton("Ver mais detalhes");
    
            expandButton.addActionListener(e -> mainView.changeScreen("login"));
    
            JComponent[] components = {
                name,
                description,
                address,
                date,
                expandButton
            };
    
            JPanel container = UIComponents.createContainer(components);       
            myEventsPanel.add(container);
        }

    }
}
