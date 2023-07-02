package models;

import java.util.*;

public class Event {
    private String code;
    private Admin admin;
    private String name;
    private String description;
    private Date date;
    private Time time;
    private Address address;
    private float price;

    private ArrayList<Participant> participants = new ArrayList<Participant>();
    private ArrayList<Activity> atividades = new ArrayList<Activity>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) return;

        this.code = code;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        if (admin == null) return;

        this.admin = admin;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null) return;

        this.address = address;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) return;

        this.price = price;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        if (participants == null) return;

        this.participants = participants;
    }

    public ArrayList<Activity> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Activity> atividades) {
        if (atividades == null) return;

        this.atividades = atividades;
    }

    public void addParticipant(Participant participant) {
        if (participant == null) return;

        this.participants.add(participant);
    }
  
    public void removeParticipant(Participant participant){
        if (participant == null) return;

        this.participants.remove(participant);
    }
}