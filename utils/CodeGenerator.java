package utils;

import java.security.SecureRandom;
import java.util.Random;

public class CodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;

    public static String generate() {
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        Random random = new SecureRandom();
    
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
    
        return sb.toString();
    }
}
