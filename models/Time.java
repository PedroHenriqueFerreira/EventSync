package models;

public class Time {
    private int hour;
    private int minute;

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

    public Time(int hour, int minute){
        this.setHour(hour);
        this.setMinute(minute);
    }

    public String toString(){
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}
