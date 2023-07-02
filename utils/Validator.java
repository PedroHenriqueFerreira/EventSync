package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String PHONE_PATTERN = "\\(\\d{2}\\) \\d \\d{4}-\\d{4}";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";
    private static final String TIME_PATTERN = "\\d{2}:\\d{2}h";

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

    public static boolean dateValidator(String date) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);

        if (!matcher.matches()) {
            return false;
        } else {
            String[] dateParts = date.split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            if (day < 1 || day > 31) return false;
            if (month < 1 || month > 12) return false;
            if (year < 2023 || year > 2100) return false;

            return true;
        }
    }

    public static boolean timeValidator(String time) {
        Pattern pattern = Pattern.compile(TIME_PATTERN);
        Matcher matcher = pattern.matcher(time);
        if (!matcher.matches()) {
            return false;
        } else {
            String[] timeParts = time.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1].split("h")[0]);

            if (hour < 0 || hour > 23) return false;
            if (minute < 0 || minute > 59) return false;

            return true;
        }
    }

    public static boolean sizeValidator(String string, int min, int max) {
        return string.length() >= min && string.length() <= max;
    }

    public static boolean floatValidator(String price) {
        try {
            Float.parseFloat(price.replace(",", ""));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean intValidator(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}