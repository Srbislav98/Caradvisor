package com.sw.projekat.model;

import com.sw.projekat.model.enums.Gorivo;
import com.sw.projekat.model.enums.MestoPrebivalista;
import com.sw.projekat.model.enums.Pol;

import javax.persistence.*;

@Entity
public class OsobaQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Pol gorivo;

    @Column
    private int godiste;

    @Column
    private boolean zaposlenost;

    @Column
    @Enumerated(EnumType.STRING)
    private MestoPrebivalista mesto;

    @Column
    private int brojClanovaPorodice;

    public OsobaQuery() {
    }

    public OsobaQuery(Long id, Pol gorivo, int godiste, boolean zaposlenost, MestoPrebivalista mesto, int brojClanovaPorodice) {
        this.id = id;
        this.gorivo = gorivo;
        this.godiste = godiste;
        this.zaposlenost = zaposlenost;
        this.mesto = mesto;
        this.brojClanovaPorodice = brojClanovaPorodice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pol getGorivo() {
        return gorivo;
    }

    public void setGorivo(Pol gorivo) {
        this.gorivo = gorivo;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public boolean isZaposlenost() {
        return zaposlenost;
    }

    public void setZaposlenost(boolean zaposlenost) {
        this.zaposlenost = zaposlenost;
    }

    public MestoPrebivalista getMesto() {
        return mesto;
    }

    public void setMesto(MestoPrebivalista mesto) {
        this.mesto = mesto;
    }

    public int getBrojClanovaPorodice() {
        return brojClanovaPorodice;
    }

    public void setBrojClanovaPorodice(int brojClanovaPorodice) {
        this.brojClanovaPorodice = brojClanovaPorodice;
    }
}
