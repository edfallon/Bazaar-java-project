package models;

public class Comment {

    private int id;
    private String title;
    private String text;
    private User user;
    private Advert advert;

    public Comment(String title, String text, User user, Advert advert) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.advert = advert;
    }

    public Comment() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
