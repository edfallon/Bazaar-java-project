package models;

import java.util.ArrayList;

public class Advert {

    private int id;
    private String title;
    private String description;
    private Category category;
    private double price;
    private String location;
    private User user;
    private String photourl;
    private ArrayList<Comment> comments;

    public Advert(String title, String description, Category category, double price, String location, User user, String photourl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.location = location;
        this.user = user;
        this.photourl = photourl;
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
