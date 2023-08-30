package marius_project.prog2.model;

import java.time.LocalDate;

public class Users {
    private int id_users;
    private String username;
    private String email;
    private String password;

    public Users(int id_users, String username, String email, String password) {
        this.id_users = id_users;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_users=" + id_users +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}
