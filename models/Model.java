package models;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Observer;

public class Model {
    private HashMap<String, User> users = new HashMap<String, User>();

    public void addUser(User user) {
        if (user == null || user.getEmail() == null) return;

        this.users.put(user.getEmail(), user);
    }

    public void removeUser(String email) {
        if (email == null) return;

        this.users.remove(email);
    }

    public User getUser(String email) {
        if (email == null) return null;

        return this.users.get(email);
    }

    public boolean checkCredencials(String email, String password) {
        if (email == null || password == null) return false;

        User user = this.getUser(email);

        if (user != null && user.getPassword().equals(password)) return true;

        return false;
    }

    private HashMap<String, Event> events = new HashMap<String, Event>();

    public void addEvent(Event event) {
        if (event == null) return;

        this.events.put(event.getCode(), event);
        this.loggedUser.addEvent(event);
        
        this.notifyObservers();
    }

    public void removeEvent(String code) {
        if (code == null) return;

        this.events.remove(code);
    }

    public Event getEvent(String code) {
        if (code == null) return null;

        return this.events.get(code);
    }

    public ArrayList<Event> getEvents() {
        return new ArrayList<Event>(this.events.values());
    }

    private HashMap<String, Payment> payments = new HashMap<String, Payment>();

    public void addPayment(Payment payment) {
        if (payment == null) return;

        this.payments.put(payment.getCode(), payment);
    }

    public void removePayment(String code) {
        if (code == null) return;

        this.payments.remove(code);
    }

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User user) {
        this.loggedUser = user;
        this.notifyObservers();
    }

    public Model() {
        Participant participant = new Participant(
            "Participante",
            "participante@gmail.com",
            "(88) 99342-3244",
            "12345678"
        );

        this.addUser(participant);

        Admin admin = new Admin(
            "Admin",
            "admin@gmail.com",
            "(88) 54544-3244",
            "12345678"
        );

        this.addUser(admin);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void attachObserver(Observer observer) {
        if (observer == null) return;

        this.observers.add(observer);
    }

    public void detachObserver(Observer observer) {
        if (observer == null) return;

        this.observers.remove(observer);
    }
}
