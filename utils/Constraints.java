package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*
 *  Contém as constantes utilizadas no projeto para facilitar a manutenção e alteração de valores.
 */
public class Constraints {
    /*
     * Cores utilizadas no projeto.
     */
    public static final Color PRIMARY_COLOR = new Color(100, 98, 253);
    public static final Color PRIMARY_HOVER_COLOR = new Color(133, 132, 255);
    public static final Color BG_COLOR = new Color(34, 34, 41);
    public static final Color CONTAINER_COLOR = new Color(42, 42, 52);
    public static final Color GRAY_COLOR = new Color(169, 163, 181);
    public static final Color LIGHT_COLOR = new Color(255, 255, 255);

    /*
     * Fontes utilizadas no projeto.
     */
    public static final Font DEFAULT_FONT = CustomFont.load("fonts/Poppins-Regular.ttf", 18);
    public static final Font LARGE_FONT = CustomFont.load("fonts/Poppins-SemiBold.ttf", 27);

    /*
     * Ícones utilizados no projeto.
     */
    public static final ImageIcon LOGO_IMAGE_ICON = new ImageIcon("images/logo.png");

    /*
     * Borda utilizada no projeto.
     */
    public static final Border DEFAULT_PADDING_BORDER = new EmptyBorder(8, 12, 8, 12);
    public static final Border LARGE_PADDING_BORDER = new EmptyBorder(40, 25, 40, 25);
    
    public static final Border DEFAULT_LINE_BORDER = BorderFactory.createCompoundBorder(
        new LineBorder(PRIMARY_COLOR, 2), 
        DEFAULT_PADDING_BORDER
    );

    /*
     * Outras constantes utilizadas no projeto.
     */    
    public static final int SCROLL_WIDTH = 8;
    public static final int SCROLL_SPEED = 20;

    public static final int ICON_TEXT_GAP = 8;

    public static final int SMALL_COMPONENT_WIDTH = 200;
    public static final int DEFAULT_COMPONENT_WIDTH = 400;
    public static final int LARGE_COMPONENT_WIDTH = 700;

    public static final int DEFAULT_COMPONENT_HEIGHT = 45;

    /*
     * Dimensões utilizadas no projeto.
     */
    public static final Dimension SMALL_DIMENSION = new Dimension(
        SMALL_COMPONENT_WIDTH,
        DEFAULT_COMPONENT_HEIGHT
    );

    public static final Dimension DEFAULT_DIMENSION = new Dimension(
        DEFAULT_COMPONENT_WIDTH,
        DEFAULT_COMPONENT_HEIGHT
    );
    
    public static final Dimension LARGE_DIMENSION = new Dimension(
        LARGE_COMPONENT_WIDTH, 
        DEFAULT_COMPONENT_HEIGHT
    );

    /*
     * Espaçamentos utilizados no projeto.
     */
    
    public static final Insets DEFAULT_INSETS = new Insets(0, 0, 0, 0);

    public static final Insets CONTAINER_INSETS = new Insets(40, 0, 40, 0);
    public static final Insets CARD_INSETS = new Insets(14, 14, 14, 14);
    
    public static final Insets TEXT_INSETS = new Insets(5, 0, 5, 0);
    public static final Insets INPUT_INSETS = new Insets(10, 0, 10, 0);
    public static final Insets BUTTON_INSETS = new Insets(10, 0, 10, 0);
    public static final Insets IMAGE_INSETS = new Insets(20, 0, 40, 0);
}
