package models;

public class Participant extends User {
    public Participant(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public void addEvent(Event event) {
        if (event == null) return;
        
        this.myEvents.add(event);
        event.addParticipant(this);
    }

	public void removeEvent(Event event) {
		if (event == null) return;

		this.myEvents.remove(event);
        event.removeParticipant(this);
	}
}
