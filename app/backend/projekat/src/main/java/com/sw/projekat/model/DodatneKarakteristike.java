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

    public DodatneKarakteristike() {
    }

    public DodatneKarakteristike(Long id, boolean porodicni, boolean muskaBoja, boolean zenskaBoja) {
        this.id = id;
        this.porodicni = porodicni;
        this.muskaBoja = muskaBoja;
        this.zenskaBoja = zenskaBoja;
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
}
