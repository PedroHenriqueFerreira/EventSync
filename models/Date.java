package models;

public class Date {
    /*
     * Os atributos de um usuário são:
     * - day: dia da data
     * - month: mês da data
     * - year: ano da data
     */
    int day;
    int month;
    int year;

    /*
     * Getters e setters
     */
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

    /*
     * Construtor da classe
     */
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /* 
     * Retorna a data no formato dd/mm/aaaa
     */
    public String toString(){
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
}
