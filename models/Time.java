package models;

public class Time {
    /*
     * Os atributos de um horário são:
     * - hour: hora do horário
     * - minute: minuto do horário
     */
    private int hour;
    private int minute;

    /*
     * Getters e setters
     */
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) return;

        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) return;
        
        this.minute = minute;
    }

    /*
     * Construtor da classe
     */
    public Time(int hour, int minute){
        this.setHour(hour);
        this.setMinute(minute);
    }

    /*
     * Retorna uma string com o horário no formato HH:MMh
     */
    public String toString(){
        return String.format("%02d:%02dh", this.hour, this.minute);
    }
}
