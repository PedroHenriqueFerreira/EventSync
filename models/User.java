package models;

import java.util.ArrayList;

public abstract class User {
	protected String name;
	protected String email;
	protected String phone;
	protected String password;
	protected ArrayList<Event> myEvents = new ArrayList<Event>();

	public User(String name, String email, String phone, String password) {
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) return;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) return;
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null) return;
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) return;
		this.password = password;
	}

	public ArrayList<Event> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(ArrayList<Event> myEvents) {
		if (myEvents == null) return;
		this.myEvents = myEvents;
	}

	abstract public void addEvent(Event event);

    abstract public void removeEvent(Event event);
}
