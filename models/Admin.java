package models;

public class Admin extends User {
    public Admin(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public void addEvent(Event event) {
        if (event == null) return;

        this.myEvents.add(event);
    }

    public void removeEvent(Event event) {
        if (event == null) return;

        this.myEvents.remove(event);
    }
}
