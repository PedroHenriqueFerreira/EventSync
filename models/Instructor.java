package models;

public class Instructor {
    private String name;
    private String email;
    private String phone;

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

    public Instructor(String name, String email, String phone){
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }
}
