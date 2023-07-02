package models;

public class Address {
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

    public Address(String state, String cidade, String rua, int numero){
        this.setState(state);
        this.setCity(cidade);
        this.setStreet(rua);
        this.setNumber(numero);        
    };

    public String toString(){
        return String.format("%s, N° %d, %s - %s", this.street, this.number, this.city, this.state);
    }
}
