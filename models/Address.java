package models;

public class Address {
    /*
     * Os atributos de um usuário são:
     * - state: estado do endereço
     * - city: cidade do endereço
     * - street: rua do endereço
     * - number: número do endereço
     */
    private String state;
    private String city;
    private String street;
    private int number;
  
    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state == null) return;

        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null) return;

        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {  
        if (street == null) return;

        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 0) return;

        this.number = number;
    }

    /*
     * Construtor da classe
     */
    public Address(String state, String city, String street, int number){
        this.setState(state);
        this.setCity(city);
        this.setStreet(street);
        this.setNumber(number);        
    };

    /*
     * Retorna uma string com o endereço formatado
     */
    public String toString(){
        return String.format("%s, N° %d, %s - %s", this.street, this.number, this.city, this.state);
    }
}
