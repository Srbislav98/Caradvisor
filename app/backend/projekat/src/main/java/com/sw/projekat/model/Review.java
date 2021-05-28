package com.sw.projekat.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Automobil auto;

    @Column
    private int rating;

    public Review() {
    }

    public Review(Long id, User user, Automobil auto, int rating) {
        this.id = id;
        this.user = user;
        this.auto = auto;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Automobil getAuto() {
        return auto;
    }

    public void setAuto(Automobil auto) {
        this.auto = auto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
