package com.sw.projekat.model;

import com.sw.projekat.model.enums.Boja;
import com.sw.projekat.model.enums.Gorivo;
import com.sw.projekat.model.enums.Karoserija;

import javax.persistence.*;
import java.util.List;

@Entity
public class AutomobilQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public AutomobilQuery() {
    }

    public AutomobilQuery(Long id, String marka, Karoserija karoserija, int cena, int godiste, Gorivo gorivo, boolean klima, int kubikaza, Boja boja) {
        this.id = id;
        this.marka = marka;
        this.karoserija = karoserija;
        this.cena = cena;
        this.godiste = godiste;
        this.gorivo = gorivo;
        this.klima = klima;
        this.kubikaza = kubikaza;
        this.boja = boja;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
