package models;

import utils.CodeGenerator;

public class Payment {
    private String code;
    private String status;
    private String method;
    private Date date;
    private Time time;
    private Event event;
    private Participant participant;
    private float price;

    public Payment( 
        String status, 
        String method, 
        Date date, 
        Time time, 
        Event event, 
        Participant participant
    ) {
        this.setCode(CodeGenerator.generate());
        
        this.setStatus(status);
        this.setMethod(method);
        this.setDate(date);
        this.setTime(time);
        this.setEvent(event);
        this.setParticipant(participant);

        setPrice(this.getEvent().getPrice());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) return;
        
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null) return;

        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        if (method == null) return;

        this.method = method;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date == null) return;

        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        if (time == null) return;

        this.time = time;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        if (event == null) return;

        this.event = event;
    }

    public Participant getParticipant() {    
        return participant;
    }

    public void setParticipant(Participant participant) {
        if (participant == null) return;

        this.participant = participant;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) return;

        this.price = price;
    }
}
