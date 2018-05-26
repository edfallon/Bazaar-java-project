package models;

import javax.persistence.*;

@Entity
@Table(name="comments")
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

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
