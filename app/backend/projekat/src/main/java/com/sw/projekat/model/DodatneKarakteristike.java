package com.sw.projekat.model;

import javax.persistence.*;

@Entity
@Table
public class DodatneKarakteristike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private boolean porodicni = false;
    @Column
    private boolean muskaBoja = false;
    @Column
    private boolean zenskaBoja = false;
    @Column
    private boolean karoserijaDzipovi = false;
    @Column
    private boolean karoserijaPorodicni = false;
    @Column
    private boolean karoserijaSportskiLjetni = false;
    @Column
    private boolean novi = false;
    @Column
    private boolean jeftin = false;
    @Column
    private boolean ekoloski = false;
    @Column
    private boolean momacki = false;


    public DodatneKarakteristike() {
        this.porodicni=false;
        this.muskaBoja=false;
        this.zenskaBoja=false;
        this.karoserijaDzipovi=false;
        this.karoserijaPorodicni=false;
        this.karoserijaSportskiLjetni=false;
        this.novi=false;
        this.jeftin=false;
        this.ekoloski=false;
        this.momacki=false;
    }

    public DodatneKarakteristike(Long id, boolean porodicni, boolean muskaBoja, boolean zenskaBoja, boolean karoserijaDzipovi, boolean karoserijaPorodicni, boolean karoserijaSportskiLjetni, boolean novi, boolean jeftin, boolean ekoloski,boolean momacki) {
        this.id = id;
        this.porodicni = porodicni;
        this.muskaBoja = muskaBoja;
        this.zenskaBoja = zenskaBoja;
        this.karoserijaDzipovi = karoserijaDzipovi;
        this.karoserijaPorodicni = karoserijaPorodicni;
        this.karoserijaSportskiLjetni = karoserijaSportskiLjetni;
        this.novi = novi;
        this.jeftin = jeftin;
        this.ekoloski = ekoloski;
        this.momacki=momacki;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPorodicni() {
        return porodicni;
    }

    public void setPorodicni(boolean porodicni) {
        this.porodicni = porodicni;
    }

    public boolean isMuskaBoja() {
        return muskaBoja;
    }

    public void setMuskaBoja(boolean muskaBoja) {
        this.muskaBoja = muskaBoja;
    }

    public boolean isZenskaBoja() {
        return zenskaBoja;
    }

    public void setZenskaBoja(boolean zenskaBoja) {
        this.zenskaBoja = zenskaBoja;
    }

    public boolean isKaroserijaDzipovi() {
        return karoserijaDzipovi;
    }

    public void setKaroserijaDzipovi(boolean karoserijaDzipovi) {
        this.karoserijaDzipovi = karoserijaDzipovi;
    }

    public boolean isKaroserijaPorodicni() {
        return karoserijaPorodicni;
    }

    public void setKaroserijaPorodicni(boolean karoserijaPorodicni) {
        this.karoserijaPorodicni = karoserijaPorodicni;
    }

    public boolean isKaroserijaSportskiLjetni() {
        return karoserijaSportskiLjetni;
    }

    public void setKaroserijaSportskiLjetni(boolean karoserijaSportskiLjetni) {
        this.karoserijaSportskiLjetni = karoserijaSportskiLjetni;
    }

    public boolean isNovi() {
        return novi;
    }

    public void setNovi(boolean novi) {
        this.novi = novi;
    }

    public boolean isJeftin() {
        return jeftin;
    }

    public void setJeftin(boolean jeftin) {
        this.jeftin = jeftin;
    }

    public boolean isEkoloski() {
        return ekoloski;
    }

    public void setEkoloski(boolean ekoloski) {
        this.ekoloski = ekoloski;
    }

    public boolean isMomacki() {
        return momacki;
    }

    public void setMomacki(boolean momacki) {
        this.momacki = momacki;
    }
}
