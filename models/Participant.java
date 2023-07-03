package models;

public class Participant extends User {
    /*
     * Construtor da classe
     */
    public Participant(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public Participant() {}

    /*
     * Adiciona um evento à lista de eventos do usuário
     */
    public void addEvent(Event event) {
        if (event == null) return;

        super.addEvent(event);
        event.addParticipant(this);
    }

    /*
     * Remove um evento da lista de eventos do usuário
     */
	public void removeEvent(Event event) {
		if (event == null) return;

        super.removeEvent(event);
        event.removeParticipant(this);
	}
}
