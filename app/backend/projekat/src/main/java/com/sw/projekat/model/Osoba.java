package com.sw.projekat.model;


import com.sw.projekat.model.enums.*;

import javax.persistence.*;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private Pol pol;
    @Column
    @Enumerated(EnumType.STRING)
    private Godiste godiste;
    @Column
    private boolean zaposlenost;
    @Column
    @Enumerated(EnumType.STRING)
    private MestoPrebivalista mestoPrebivalista;
    @Column
    @Enumerated(EnumType.STRING)
    private BrojClanovaPorodice brojClanovaPorodice;

    public Osoba() {
    }

    public Osoba(Pol pol, Godiste godiste, boolean zaposlenost, MestoPrebivalista mestoPrebivalista, BrojClanovaPorodice brojClanovaPorodice) {
        this.pol = pol;
        this.godiste = godiste;
        this.zaposlenost = zaposlenost;
        this.mestoPrebivalista = mestoPrebivalista;
        this.brojClanovaPorodice = brojClanovaPorodice;
    }

    public Osoba(Pol pol, boolean b, MestoPrebivalista selo) {
        this.pol = pol;
        this.zaposlenost = b;
        this.mestoPrebivalista = selo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Godiste getGodiste() {
        return godiste;
    }

    public void setGodiste(Godiste godiste) {
        this.godiste = godiste;
    }

    public boolean isZaposlenost() {
        return zaposlenost;
    }

    public void setZaposlenost(boolean zaposlenost) {
        this.zaposlenost = zaposlenost;
    }

    public MestoPrebivalista getMestoPrebivalista() {
        return mestoPrebivalista;
    }

    public void setMestoPrebivalista(MestoPrebivalista mestoPrebivalista) {
        this.mestoPrebivalista = mestoPrebivalista;
    }

    public BrojClanovaPorodice getBrojClanovaPorodice() {
        return brojClanovaPorodice;
    }

    public void setBrojClanovaPorodice(BrojClanovaPorodice brojClanovaPorodice) {
        this.brojClanovaPorodice = brojClanovaPorodice;
    }
}

