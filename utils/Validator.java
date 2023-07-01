package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String PHONE_PATTERN = "\\(\\d{2}\\) \\d \\d{4}-\\d{4}";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean phoneValidator(String phone) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean emailValidator(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean sizeValidator(String string, int min, int max) {
        return string.length() >= min && string.length() <= max;
    }
}