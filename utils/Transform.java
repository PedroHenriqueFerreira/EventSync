package utils;

import models.Time;
import models.Date;

/*
 * Classe que contém métodos para transformar tipos de dados.
 */
public class Transform {
    /*
     * Transforma uma string no formato "HH:mmh" em um objeto Time.
     */
    public static Time toTime(String time) {
        if (time == null) return null;

        String[] timeArray = time.split(":");

        if (timeArray.length != 2) return null;

        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1].split("h")[0]);        

        return new Time(hour, minute);
    }

    /*
     * Transforma uma string no formato "dd/MM/yyyy" em um objeto Date.
     */
    public static Date toDate(String date) {
        if (date == null) return null;

        String[] dateArray = date.split("/");

        if (dateArray.length != 3) return null;

        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);

        return new Date(day, month, year);
    }

    /*
     * Transforma uma string no formato "0.00" em um float.
     */
    public static float toFloat(String price) {
        try {
            if (price == null) return 0;
    
            return Float.parseFloat(price.replace(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /*
     * Transforma uma string no formato "0" em um int.
     */
    public static int toInt(String number) {
        try {
            if (number == null) return 0;
    
            return Integer.parseInt(number.replace(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
