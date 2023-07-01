package models;

import java.util.ArrayList;

public abstract class User {
	private String name;
	private String email;
	private String phone;
	private String password;
	private ArrayList<Event> myEvents = new ArrayList<Event>();

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

	public void addEvent(Event event) {
		if (event == null) return;
		this.myEvents.add(event);
	}

	public void removeEvent(Event event) {
		if (event == null) return;
		this.myEvents.remove(event);
	}
}
