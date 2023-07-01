package models;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Observer;

public class Model {
    private HashMap<String, User> users = new HashMap<String, User>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private User loggedUser;

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
    
    public void addUser(User user) {
        if (user == null || user.getEmail() == null) return;

        this.users.put(user.getEmail(), user);
    }

    public void removeUser(User user) {
        if (user == null || user.getEmail() == null) return;

        this.users.remove(user.getEmail());
    }

    public User getUser(String email) {
        if (email == null) return null;

        return this.users.get(email);
    }

    public void loginUser(User user) {
        if (user == null) return;

        this.loggedUser = user;
    }

    public void logoutUser() {
        this.loggedUser = null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
