package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class CustomFont {
    public static Font load(String filepath, int size) {
        try {
            File fontFile = new File(filepath);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);

            return font.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();

            return null;
        }
        
    }
}
