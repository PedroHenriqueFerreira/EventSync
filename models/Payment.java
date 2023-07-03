package models;

import utils.CodeGenerator;

public class Payment {
    /*
     * Os atributos de um pagamento são:
     * - code: código do pagamento
     * - date: data do pagamento
     * - time: horário do pagamento
     * - event: evento que o pagamento está relacionado
     * - participant: participante que realizou o pagamento
     * - price: preço do pagamento
     */
    private String code;
    private Date date;
    private Time time;
    private Event event;
    private Participant participant;
    private float price;

    /*
     * Construtor da classe
     */
    public Payment( 
        Date date, 
        Time time, 
        Event event, 
        Participant participant
    ) {
        this.setCode(CodeGenerator.generate());
        
        this.setDate(date);
        this.setTime(time);
        this.setEvent(event);
        this.setParticipant(participant);

        setPrice(this.getEvent().getPrice());
    }

    /*
     * Getters e setters
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) return;
        
        this.code = code;
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
