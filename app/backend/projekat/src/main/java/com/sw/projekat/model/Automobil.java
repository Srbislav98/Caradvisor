package com.sw.projekat.model;

import com.sw.projekat.model.enums.Boja;
import com.sw.projekat.model.enums.Gorivo;
import com.sw.projekat.model.enums.Karoserija;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "automobil")
public class Automobil implements Comparable{

    @Id
    private String naziv;

    @Column
    private String marka;

    @Column
    @Enumerated(EnumType.STRING)
    private Karoserija karoserija;

    @Column
    private int cena;

    @Column
    private int godiste;

    @Column
    @Enumerated(EnumType.STRING)
    private Gorivo gorivo;

    @Column
    private boolean klima;

    @Column
    private int kubikaza;

    @Column
    @Enumerated(EnumType.STRING)
    private Boja boja;

    @OneToMany()
    private Set<Review> reviews = new HashSet<Review>();

    @OneToMany( mappedBy = "automobil", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Fotografija> fotografija = new HashSet<>();

    @Column
    private Double averagereview;

    @Column
    private int score;

    @OneToOne(cascade={CascadeType.ALL})
    private DodatneKarakteristike dodatneKarakteristike = new DodatneKarakteristike();

    public Automobil() {
    }

    public Automobil(String id, String marka, Karoserija karoserija, int cena, int godiste, Gorivo gorivo, boolean klima, int kubikaza, Boja boja, Set<Review> reviews, Double averagereview, int score) {
        this.naziv = id;
        this.marka = marka;
        this.karoserija = karoserija;
        this.cena = cena;
        this.godiste = godiste;
        this.gorivo = gorivo;
        this.klima = klima;
        this.kubikaza = kubikaza;
        this.boja = boja;
        this.reviews = reviews;
        this.averagereview = averagereview;
        this.score = score;
    }

    public Automobil(String id, String marka, Karoserija karoserija, int cena, int godiste, Gorivo gorivo, boolean klima, int kubikaza, Boja boja, int score) {
        this.naziv = id;
        this.marka = marka;
        this.karoserija = karoserija;
        this.cena = cena;
        this.godiste = godiste;
        this.gorivo = gorivo;
        this.klima = klima;
        this.kubikaza = kubikaza;
        this.boja = boja;
        this.score=score;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Karoserija getKaroserija() {
        return karoserija;
    }

    public void setKaroserija(Karoserija karoserija) {
        this.karoserija = karoserija;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public Gorivo getGorivo() {
        return gorivo;
    }

    public void setGorivo(Gorivo gorivo) {
        this.gorivo = gorivo;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public int getKubikaza() {
        return kubikaza;
    }

    public void setKubikaza(int kubikaza) {
        this.kubikaza = kubikaza;
    }

    public Boja getBoja() {
        return boja;
    }

    public void setBoja(Boja boja) {
        this.boja = boja;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Double getAveragereview() {
        return averagereview;
    }

    public void setAveragereview(Double averagereview) {
        this.averagereview = averagereview;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addToScore(int score) {

        this.score +=score;
    }

    public DodatneKarakteristike getDodatneKarakteristike() {
        return dodatneKarakteristike;
    }

    public void setDodatneKarakteristike(DodatneKarakteristike dodatneKarakteristike) {
        this.dodatneKarakteristike = dodatneKarakteristike;
    }

    public Set<Fotografija> getFotografija() {
        return fotografija;
    }

    public void setFotografija(Set<Fotografija> fotografija) {
        this.fotografija = fotografija;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getScore(),((Automobil) o).getScore());
    }
}
