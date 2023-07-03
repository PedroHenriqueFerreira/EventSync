package models;

public class Admin extends User {
    /*
     * Construtor da classe
     */
    public Admin(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public Admin() {}
}
