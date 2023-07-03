package models;

import java.util.*;

import utils.CodeGenerator;

public class Event {
    /* 
     * Os atributos de um evento são:
     * - code: código do evento
     * - admin: administrador do evento
     * - name: nome do evento
     * - description: descrição do evento
     * - category: categoria do evento
     * - date: data do evento
     * - time: horário do evento
     * - address: endereço do evento
     * - price: preço do evento
     * - participants: lista de participantes do evento
     * - activities: lista de atividades do evento
    */
    private String code;
    private Admin admin;
    private String name;
    private String description;
    private String category;
    private Date date;
    private Time time;
    private Address address;
    private float price;
    private ArrayList<Participant> participants = new ArrayList<Participant>();
    private ArrayList<Activity> activities = new ArrayList<Activity>();

    /*
     * Construtor da classe
     */
    public Event(
        Admin admin,
        String name,
        String description,
        String category,
        Date date,
        Time time,
        Address address,
        float price
    ) {
        this.setCode(CodeGenerator.generate());
        this.setAdmin(admin);
        this.setName(name);
        this.setDescription(description);
        this.setCategory(category);
        this.setDate(date);
        this.setTime(time);
        this.setAddress(address);
        this.setPrice(price);
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null) return;

        this.category = category;
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

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        if (activities == null) return;

        this.activities = activities;
    }

    /*
     * Adiciona um participante à lista de participantes do evento
     */
    public void addParticipant(Participant participant) {
        if (participant == null) return;

        this.participants.add(participant);
    }
  
    /*
     * Remove um participante da lista de participantes do evento
     */
    public void removeParticipant(Participant participant){
        if (participant == null) return;

        this.participants.remove(participant);
    }

    /*
     * Adiciona uma atividade à lista de atividades do evento
     */
    public void addActivity(Activity activity) {
        if (activity == null) return;

        this.activities.add(activity);
    }

    /*
     * Remove uma atividade da lista de atividades do evento
     */
    public void removeActivity(Activity activity) {
        if (activity == null) return;

        this.activities.remove(activity);
    }
}