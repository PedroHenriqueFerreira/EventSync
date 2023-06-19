package views;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.UIComponents;

public class HomeView extends JPanel {
    public HomeView(MainView mainView) {
        this.setBackground(UIComponents.bgColor);

        for (int i = 0; i < 4; i++) {
            JLabel name = UIComponents.createText("Master Class resinas");
            name.setFont(UIComponents.largeFont);
            name.setForeground(UIComponents.primaryColor);
    
            JLabel description = UIComponents.createText("Venha se divertir aprendendo sobre resinas wwwe wef wefwef wef wefwefwe wefwefwef");
            // description.setForeground(UIComponents.grayColor);
    
            JLabel address = UIComponents.createText("Rua José de Alencar, 135, Cuiabá - MT");
            address.setForeground(UIComponents.grayColor);
    
            JLabel date = UIComponents.createText("12/05/22 08:00");
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
            this.add(container);
        }
    }
}
