package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Observer;

public class Model {
    private HashMap<String, User> users = new HashMap<String, User>();

    public void addUser(User user) {
        if (user == null || user.getEmail() == null) return;

        this.notifyObservers();
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

    public Map<String, List<Event>> getEventsByCategory() {
        Map<String, List<Event>> eventsByCategory = this.getEvents().stream().collect(
            Collectors.groupingBy(Event::getCategory)
        );

        return eventsByCategory;
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

    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User user) {
        this.loggedUser = user;
        this.notifyObservers();
    }

    private Event selectedEvent;

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event event) {
        this.selectedEvent = event;
        this.notifyObservers();
    }
    
    private Activity selectedActivity;

    public Activity getSelectedActivity() {
        return selectedActivity;
    }

    public void setSelectedActivity(Activity activity) {
        this.selectedActivity = activity;
        this.notifyObservers();
    }

    public void loadData() {
        Participant participant = new Participant(
            "Participante",
            "participante@gmail.com",
            "(88) 99342-3244",
            "12345678"
        );

        Participant participant2 = new Participant(
            "Participante 2",
            "participante2@gmail.com",
            "(88) 99342-3244",
            "12345678"
        );

        this.addUser(participant);
        this.addUser(participant2);

        Admin admin = new Admin(
            "Admin",
            "admin@gmail.com",
            "(88) 54544-3244",
            "12345678"
        );

        this.addUser(admin);

        this.setLoggedUser(admin);

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 2; j++) {
                Event event = new Event(
                    admin,
                    "Evento " + i,
                    "Descrição do evento " + i,
                    "Categoria " + i,
                    new Date(1, 1, 2023),
                    new Time(12, 30),
                    new Address("CE", "Russas", "Felipe Santiago", 10),
                    10.0f
                );

                Activity activity = new Activity(
                    "Atividade " + j, 
                    "Descrição da atividade " + j,
                    new Instructor("Joao", "Joao@gmail.com", "(88) 99342-3244"),
                    new Date(1, 1, 2023),
                    new Time(12, 30)
                );

                event.addActivity(activity);
    
                this.addEvent(event);
            }
        }
    }
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();

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
