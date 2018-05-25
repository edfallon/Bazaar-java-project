package models;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private String email;
    private ArrayList<Advert> adverts;
    private ArrayList<Comment> comments;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.adverts = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(ArrayList<Advert> adverts) {
        this.adverts = adverts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
