package utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class UIComponents {
    public static final Color bgColor = new Color(34, 34, 41);
    public static final Color containerColor = new Color(42, 42, 52);
    public static final Color primaryColor = new Color(100, 98, 253);
    public static final Color secondaryColor = new Color(133, 132, 255);
    public static final Color lightColor = new Color(255, 255, 255);
    public static final Color grayColor = new Color(169, 163, 181);

    public static final Font defaultFont = loadFont("assets/Poppins-Regular.ttf", 18);
    public static final Font largeFont = loadFont("assets/Poppins-SemiBold.ttf", 27);

    public static final Dimension defaultDimension = new Dimension(400, 45);
    public static final Dimension smallDimension = new Dimension(175, 45);
    
    public static final Border defaultLineBorder = new LineBorder(primaryColor, 2);
    
    public static final Border largePaddingBorder = new EmptyBorder(40, 25, 40, 25);
    public static final Border defaultPaddingBorder = new EmptyBorder(8, 12, 8, 12);

    public static final Border compoundBorder = BorderFactory.createCompoundBorder(
        defaultLineBorder, 
        defaultPaddingBorder
    );

    public static final Insets textInsets = new Insets(0, 0, 10, 0);
    public static final Insets inputInsets = new Insets(0, 0, 20, 0);
    public static final Insets buttonInsets = new Insets(20, 0, 0, 0);
    public static final Insets imageInsets = new Insets(20, 0, 40, 0);

    public static JLabel createText(String value) {
        JLabel text = new JLabel(value);

        text.setFont(defaultFont);
        text.setForeground(lightColor);

        int width = (int) defaultDimension.getWidth();
        int height = (int) text.getPreferredSize().getHeight();
        
        text.setPreferredSize(new Dimension(width, height));

        return text;
    }

    public static JLabel createTitle(String value) {
        JLabel title = new JLabel(value);

        title.setFont(largeFont);
        title.setForeground(lightColor);

        int width = (int) defaultDimension.getWidth();
        int height = (int) title.getPreferredSize().getHeight();
        
        title.setPreferredSize(new Dimension(width, height));        

        return title;
    }

    private static void createInputStyle(JTextField input) {
        input.setFont(defaultFont);
        input.setBorder(defaultPaddingBorder);
        input.setPreferredSize(defaultDimension);
        input.setBackground(bgColor);
        input.setForeground(lightColor);
        input.setCaretColor(lightColor);

        input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                input.setBackground(containerColor);
                input.setBorder(compoundBorder);
            }
            
            public void focusLost(FocusEvent e) {
                input.setBackground(bgColor);
                input.setBorder(defaultPaddingBorder);
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

    public static JFormattedTextField createMaskInput(String value, String mask) {
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

    private static void createButtonStyle(JButton button) {
        button.setFont(defaultFont);
        button.setBorder(compoundBorder);
        button.setPreferredSize(defaultDimension);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }

    public static JButton createButton(String value) {
        JButton button = new JButton(value);
        createButtonStyle(button);
        
        button.setBackground(primaryColor);
        button.setForeground(bgColor);

        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                button.setBackground(secondaryColor);
            }

            public void focusLost(FocusEvent e) {
                button.setBackground(primaryColor);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(secondaryColor);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(primaryColor);
            }
        });

        return button;
    }

    public static JButton createLightButton(String value) {
        JButton button = new JButton(value);
        createButtonStyle(button);

        button.setBackground(containerColor);
        button.setForeground(primaryColor);

        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                button.setForeground(secondaryColor);
            }
            
            public void focusLost(FocusEvent e) {
                button.setForeground(primaryColor);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(secondaryColor);
            }
            
            public void mouseExited(MouseEvent e) {
                button.setForeground(primaryColor);
            }
        });

        return button;
    }    

    public static JRadioButton createRadioButton(String value) {
        JRadioButton button = new JRadioButton(value);
        button.setBackground(containerColor);
        button.setForeground(lightColor);
        button.setFont(defaultFont);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setIconTextGap(8);

        button.setIcon(new ImageIcon("assets/radio_button.png"));
        button.setSelectedIcon(new ImageIcon("assets/radio_button_selected.png"));

        return button;
    }

    public static JPanel createContainer(JComponent components[]) {
        JPanel container = new JPanel();

        container.setLayout(new GridBagLayout());
        container.setBorder(largePaddingBorder);
        container.setBackground(containerColor);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridx = 0;

        for (int i = 0; i < components.length; i++) {
            JComponent component = components[i];

            Insets insets = new Insets(0, 0, 0, 0);

            if (component instanceof JTextField) {
                insets = UIComponents.inputInsets;
            } else if (component instanceof JLabel) {
                JLabel jLabel = (JLabel) component;
                if (jLabel.getIcon() == null) {
                    insets = UIComponents.textInsets;
                } else {
                    insets = UIComponents.imageInsets;
                }
            } else if (component instanceof JButton) {
                insets = UIComponents.buttonInsets;
            }

            gridBagConstraints.gridy = i;
            gridBagConstraints.insets = insets;
            container.add(component, gridBagConstraints);
        }

        return container;
    }

    public static Font loadFont(String path, int size) {
        try {
            File fontFile = new File(path);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);

            return font.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();

            return null;
        }
        
    }
}
