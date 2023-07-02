package models;

import java.util.ArrayList;

public class Activity {
    private String name;
    private String description;
    private Instructor instructor;
    private Date date;
    private Time time;
    private ArrayList<Participant> frequency = new ArrayList<Participant>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) return;

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) return;

        this.description = description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        if (instructor == null) return;

        this.instructor = instructor;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        if (time == null) return;

        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date == null) return;

        this.date = date;
    }

    public ArrayList<Participant> getFrequency() {
        return frequency;
    }

    public void setFrequency(ArrayList<Participant> frequency) {
        if (frequency == null) return;

        this.frequency = frequency;
    }

    public Activity(
        String name, 
        String description, 
        Instructor instructor, 
        Date date, 
        Time time
    ) {
        this.setName(name);
        this.setDescription(description);
        this.setInstructor(instructor);
        this.setDate(date);
        this.setTime(time);
    };

    public String toString() {
        return String.format("%s - %s às %s", this.name, this.date.toString(), this.time.toString());
    }
}