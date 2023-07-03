package models;

import java.util.ArrayList;

public abstract class User {
	/*
	 * Os atributos de um usuário são:
	 * - name: nome do usuário
	 * - email: email do usuário
	 * - phone: telefone do usuário
	 * - password: senha do usuário
	 * - myEvents: lista de eventos do usuário
	 */
	protected String name;
	protected String email;
	protected String phone;
	protected String password;
	protected ArrayList<Event> myEvents = new ArrayList<Event>();

	/*
	 * Construtor da classe
	 */
	public User(String name, String email, String phone, String password) {
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setPassword(password);
	}

	public User() {}

	/*
	 * Getters e setters
	 */
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

	/* 
	 * Adiciona um evento à lista de eventos do usuário
	 */
	public void addEvent(Event event) {
		if (event == null) return;
		this.myEvents.add(event);
	}

	/*
	 * Remove um evento da lista de eventos do usuário
	 */
    public void removeEvent(Event event) {
		if (event == null) return;
		this.myEvents.remove(event);
	}

	/*
	 * Retorna uma string com o nome e o email do usuário
	 */
	public String toString() {
		return String.format("%s - %s", this.name, this.email);
	}
}
