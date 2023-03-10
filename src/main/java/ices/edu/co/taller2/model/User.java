package ices.edu.co.taller2.model;

public class User {

    private String id;
    private String email;
    private String pass;
    private String username;

    public User() {
    }

    public User(String id, String email, String pass, String username) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        //this y obj
        if(obj instanceof User){
            User other = (User) obj;
            return other.email.equals(this.email) || other.id.equals(this.id);
        }
        return false;
    }
}

