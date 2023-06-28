package utils;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Components {
    private static void createButtonStyle(JButton button) {
        button.setFont(Constraints.DEFAULT_FONT);
        button.setBorder(Constraints.DEFAULT_LINE_BORDER);
        button.setPreferredSize(Constraints.DEFAULT_DIMENSION);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }

    public static JButton createButton(String value) {
        JButton button = new JButton(value);

        createButtonStyle(button);

        button.setBackground(Constraints.PRIMARY_COLOR);
        button.setForeground(Constraints.BG_COLOR);

        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                button.setBackground(Constraints.PRIMARY_HOVER_COLOR);
            }

            public void focusLost(FocusEvent e) {
                button.setBackground(Constraints.PRIMARY_COLOR);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Constraints.PRIMARY_HOVER_COLOR);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(Constraints.PRIMARY_COLOR);
            }
        });

        return button;
    }

    public static JButton createLightButton(String value) {
        JButton button = new JButton(value);

        createButtonStyle(button);

        button.setBackground(Constraints.CONTAINER_COLOR);
        button.setForeground(Constraints.PRIMARY_COLOR);

        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                button.setForeground(Constraints.PRIMARY_HOVER_COLOR);
            }

            public void focusLost(FocusEvent e) {
                button.setForeground(Constraints.PRIMARY_COLOR);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Constraints.PRIMARY_HOVER_COLOR);
            }

            public void mouseExited(MouseEvent e) {
                button.setForeground(Constraints.PRIMARY_COLOR);
            }
        });

        return button;
    }

    private static void createInputStyle(JTextField input) {
        input.setFont(Constraints.DEFAULT_FONT);
        input.setBorder(Constraints.DEFAULT_PADDING_BORDER);
        input.setPreferredSize(Constraints.DEFAULT_DIMENSION);
        input.setBackground(Constraints.BG_COLOR);
        input.setForeground(Constraints.LIGHT_COLOR);
        input.setCaretColor(Constraints.LIGHT_COLOR);

        input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                input.setBackground(Constraints.CONTAINER_COLOR);
                input.setBorder(Constraints.DEFAULT_LINE_BORDER);
            }
            
            public void focusLost(FocusEvent e) {
                input.setBackground(Constraints.BG_COLOR);
                input.setBorder(Constraints.DEFAULT_PADDING_BORDER);
            }
        });
    }

    public static JTextField createInput(String value) {
        JTextField input = new JTextField(value);

        createInputStyle(input);

        return input;
    }

    public static JPasswordField createPasswordInput(String value) {
        JPasswordField input = new JPasswordField(value);

        createInputStyle(input);

        return input;
    }

    public static JFormattedTextField createCurrencyInput(String value) {
        DecimalFormat decimalFormatter = new DecimalFormat("#,##0.00");

        NumberFormatter formatter = new NumberFormatter(decimalFormatter);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        JFormattedTextField input = new JFormattedTextField(formatter);
        input.setText(value);

        createInputStyle(input);

        return input;
    }

    public static JFormattedTextField createMaskInput(String mask, String value) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter(mask);
            maskFormatter.setPlaceholderCharacter(' ');
    
            JFormattedTextField input = new JFormattedTextField(maskFormatter);
            input.setText(value);

            createInputStyle(input);

            return input;
        } catch (ParseException e) {
            e.printStackTrace();

            return null;
        }
    }

    private static void createScrollBarStyle(JScrollPane scrollBar) {
        JButton emptyButton = createButton("");
        emptyButton.setPreferredSize(new Dimension(0, 0));
        
        scrollBar.getHorizontalScrollBar().setUnitIncrement(Constraints.SCROLL_SPEED);

        scrollBar.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Constraints.PRIMARY_COLOR;
                this.trackColor = Constraints.CONTAINER_COLOR;
                this.scrollBarWidth = Constraints.SCROLL_WIDTH;
            }

            protected JButton createDecreaseButton(int orientation) {
                return emptyButton;
            }

            protected JButton createIncreaseButton(int orientation) {
                return emptyButton;
            }
        });

        scrollBar.setBackground(Constraints.CONTAINER_COLOR);

        scrollBar.getVerticalScrollBar().setUnitIncrement(Constraints.SCROLL_SPEED);
        scrollBar.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                this.thumbColor = Constraints.PRIMARY_COLOR;
                this.trackColor = Constraints.CONTAINER_COLOR;
                this.scrollBarWidth = Constraints.SCROLL_WIDTH;
            }

            protected JButton createDecreaseButton(int orientation) {
                return emptyButton;
            }

            protected JButton createIncreaseButton(int orientation) {
                return emptyButton;
            }
        });

        scrollBar.setBorder(null);
        scrollBar.getVerticalScrollBar().setBorder(null);

        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public static JScrollPane createScrollBar(Component component) {
        JScrollPane scrollBar = new JScrollPane(component);

        createScrollBarStyle(scrollBar);

        return scrollBar;
    }

    public static JLabel createTitle(String value) {
        JLabel title = new JLabel(value);

        title.setFont(Constraints.LARGE_FONT);
        title.setForeground(Constraints.LIGHT_COLOR);

        Dimension dimension = new Dimension(
            Constraints.DEFAULT_COMPONENT_WIDTH, 
            title.getPreferredSize().height
        );
        
        title.setPreferredSize(dimension);        

        return title;
    }

    private static void createTextStyle(JLabel text) {
        text.setFont(Constraints.DEFAULT_FONT);
        
        Dimension dimension = new Dimension(
            Constraints.DEFAULT_COMPONENT_WIDTH, 
            text.getPreferredSize().height
        );

        text.setPreferredSize(dimension);
    }

    public static JLabel createGrayText(String value) {
        JLabel text = new JLabel(value);

        text.setForeground(Constraints.GRAY_COLOR);
        createTextStyle(text);

        return text;
    }

    public static JLabel createLightText(String value) {
        JLabel text = new JLabel(value);

        text.setForeground(Constraints.LIGHT_COLOR);
        createTextStyle(text);

        return text;
    }
    
    public static JRadioButton createRadioButton(String value) {
        JRadioButton button = new JRadioButton(value);

        button.setBackground(Constraints.CONTAINER_COLOR);
        button.setForeground(Constraints.LIGHT_COLOR);
        button.setFont(Constraints.DEFAULT_FONT);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setIconTextGap(Constraints.ICON_TEXT_GAP);

        button.setIcon(new ImageIcon("images/radio_button.png"));
        button.setSelectedIcon(new ImageIcon("images/radio_button_selected.png"));

        return button;
    }

    public static JScrollPane createContainer(ArrayList<JComponent> components) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Constraints.BG_COLOR);

        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.insets = Constraints.CONTAINER_INSETS;
        
        JPanel container = new JPanel(new GridBagLayout());

        panel.add(container, panelConstraints);
        
        JScrollPane scrollBar = Components.createScrollBar(panel);

        container.setBorder(Constraints.LARGE_PADDING_BORDER);
        container.setBackground(Constraints.CONTAINER_COLOR);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridx = 0;

        for (int i = 0; i < components.size(); i++) {
            JComponent component = components.get(i);

            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                if (label.getIcon() == null) {
                    gridBagConstraints.insets = Constraints.TEXT_INSETS;
                } else {
                    gridBagConstraints.insets = Constraints.IMAGE_INSETS;
                }
            } else if (component instanceof JTextField) {
                gridBagConstraints.insets = Constraints.INPUT_INSETS;
            } else if (component instanceof JButton) {
                gridBagConstraints.insets = Constraints.BUTTON_INSETS;
            }

            gridBagConstraints.gridy = i;
            container.add(component, gridBagConstraints);
        }

        return scrollBar;
    }
}
