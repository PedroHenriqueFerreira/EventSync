package models;

public class Instructor {
    /*
     * Os atributos de um usuário são:
     * - name: nome do instrutor
     * - email: email do instrutor
     * - phone: telefone do instrutor
     */
    private String name;
    private String email;
    private String phone;

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

    /*
     * Construtor da classe
     */
    public Instructor(String name, String email, String phone){
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }
}
