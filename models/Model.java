package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Observer;

/* 
 * O modelo é responsável por armazenar os dados da aplicação
 * Além disso, ele é responsável por notificar os observadores quando os dados são alterados
 */
public class Model {
    /* 
     * Os dados são armazenados em HashMaps, onde a chave é o código do objeto ou o email do usuário
     */
    private HashMap<String, User> users = new HashMap<String, User>();
    private HashMap<String, Event> events = new HashMap<String, Event>();
    private HashMap<String, Payment> payments = new HashMap<String, Payment>();

    /* 
     * Os observadores são armazenados em um ArrayList
     */
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    /*
     * O loggedUser é o usuário que está logado no momento
     * O selectedEvent é o evento que está selecionado no momento
     * O selectedActivity é a atividade que está selecionada no momento 
     */
    private User loggedUser;
    private Event selectedEvent;
    private Activity selectedActivity;

    /* 
     * Adiciona um usuário ao HashMap de usuários e notifica os observadores
     */
    public void addUser(User user) {
        if (user == null || user.getEmail() == null) return;

        this.notifyObservers();
        this.users.put(user.getEmail(), user);
    }

    /* 
     * Remove um usuário do HashMap de usuários e notifica os observadores
     */
    public void removeUser(String email) {
        if (email == null) return;

        this.notifyObservers();
        this.users.remove(email);
    }

    /* 
     * Retorna um usuário do HashMap de usuários a partir do email
     */
    public User getUser(String email) {
        if (email == null) return null;

        return this.users.get(email);
    }

    /* 
     * Checa se as credenciais passadas do usuário estão corretas e retorna um booleano
     */
    public boolean checkCredencials(String email, String password) {
        if (email == null || password == null) return false;

        User user = this.getUser(email);

        if (user != null && user.getPassword().equals(password)) return true;

        return false;
    }

    /* 
     * Adiciona um evento ao HashMap de eventos e notifica os observadores
     */
    public void addEvent(Event event) {
        if (event == null) return;

        this.events.put(event.getCode(), event);
        this.loggedUser.addEvent(event);
        
        this.notifyObservers();
    }

    /* 
     * Remove um evento do HashMap de eventos e notifica os observadores
     */
    public void removeEvent(String code) {
        if (code == null) return;

        this.loggedUser.removeEvent(this.getEvent(code));

        for (Participant participant : this.getEvent(code).getParticipants()) {
            participant.removeEvent(this.getEvent(code));
        }

        this.events.remove(code);

        this.notifyObservers();
    }

    /*
     * Retorna um evento do HashMap de eventos a partir do código do evento
     */
    public Event getEvent(String code) {
        if (code == null) return null;

        return this.events.get(code);
    }

    /* 
     * Retorna um Map de eventos a partir da categoria do evento
     */
    public Map<String, List<Event>> getEventsByCategory() {
        Map<String, List<Event>> eventsByCategory = this.getEvents().stream().collect(
            Collectors.groupingBy(Event::getCategory)
        );

        return eventsByCategory;
    }

    /* 
     * Retorna um ArrayList de todos os eventos
     */
    public ArrayList<Event> getEvents() {
        return new ArrayList<Event>(this.events.values());
    }

    /* 
     * Adiciona um pagamento ao HashMap de pagamentos e notifica os observadores
     */
    public void addPayment(Payment payment) {
        if (payment == null) return;

        this.payments.put(payment.getCode(), payment);

        this.notifyObservers();
    }

    /* 
     * Remove um pagamento do HashMap de pagamentos e notifica os observadores
     */
    public void removePayment(String code) {
        if (code == null) return;

        this.payments.remove(code);

        this.notifyObservers();
    }

    /* 
     * Retorna um ArrayList de todos os pagamentos
     */
    public ArrayList<Payment> getPayments() {
        return new ArrayList<Payment>(this.payments.values());
    }

    /* 
     * Retorna o usuário logado no momento
     */
    public User getLoggedUser() {
        return loggedUser;
    }

    /* 
     * Atualiza o usuário logado do momento e notifica os observadores
     */
    public void setLoggedUser(User user) {
        this.loggedUser = user;
        this.notifyObservers();
    }

    /* 
     * Retorna o evento selecionado no momento
     */
    public Event getSelectedEvent() {
        return selectedEvent;
    }

    /* 
     * Atualiza o evento selecionado no momento e notifica os observadores
     */
    public void setSelectedEvent(Event event) {
        this.selectedEvent = event;
        this.notifyObservers();
    }
    
    /* 
     * Retorna a atividade selecionada no momento
     */
    public Activity getSelectedActivity() {
        return selectedActivity;
    }

    /* 
     * Atualiza a atividade selecionada no momento e notifica os observadores
     */
    public void setSelectedActivity(Activity activity) {
        this.selectedActivity = activity;
        this.notifyObservers();
    }

    /*
     * Carrega os dados iniciais da aplicação
     */
    public void loadData() {
        Participant participant = new Participant(
            "Participante",
            "participante@gmail.com",
            "(12) 34567-8910",
            "12345678"
        );

        Participant joao = new Participant(
            "Joao",
            "joao@gmail.com",
            "(12) 34567-8910",
            "12345678"
            );
            
        this.addUser(participant);
        this.addUser(joao);

        Admin admin = new Admin(
            "Admin",
            "admin@gmail.com",
            "(12) 34567-8910",
            "12345678"
        );
            
        this.addUser(admin);
        this.setLoggedUser(admin);

        Event event = new Event(
            admin,
            "Evento 1",
            "Descrição do evento 1",
            "Categoria 1",
            new Date(1, 1, 2023),
            new Time(0, 0),
            new Address("Estado", "Cidade", "Rua", 0),
            0
        );

        Activity activity = new Activity(
            "Atividade 1", 
            "Descrição da atividade 1",
            new Instructor("Instrutor", "instrutor@gmail.com", "(12) 34567-8910"),
            new Date(1, 1, 2023),
            new Time(0, 0)
        );

        event.addActivity(activity);

        this.addEvent(event);

        Event sesComp = new Event(
            admin,
            "SesComp 2023",
            "Semana da Computação 2023",
            "Tecnologia",
            new Date(1, 1, 2023),
            new Time(0, 0),
            new Address("Ceará", "Russas", "Felipe Santiago", 0),
            0
        );

        Activity cursoPython = new Activity(
            "Curso de Python",
            "Curso de Python para iniciantes",
            new Instructor("Instrutor", "instrutor@gmail.com", "(12) 34567-8910"),
            new Date(1, 1, 2023),
            new Time(0, 0)
        );

        sesComp.addActivity(cursoPython);

        this.addEvent(sesComp);
        this.setLoggedUser(null);
    }
    
    /*
     * Notifica todos os observadores
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /*
     * Adiciona um observador
     */
    public void attachObserver(Observer observer) {
        if (observer == null) return;

        this.observers.add(observer);
    }

    /*
     * Remove um observador
     */
    public void detachObserver(Observer observer) {
        if (observer == null) return;

        this.observers.remove(observer);
    }
}
