package models;

public class Date {
    int day;
    int month;
    int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) return;

        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) return;

        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2023 || year > 2100) return;

        this.year = year;
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
}
