package com.sw.projekat.dto;

import com.sw.projekat.model.enums.*;

public class OsobaDTO {

    private Pol pol;
    private Godiste godiste;
    private boolean zaposlenost;
    private MestoPrebivalista mestoPrebivalista;
    private BrojClanovaPorodice brojClanovaPorodice;

    public OsobaDTO() {
    }

    public OsobaDTO(Pol pol, Godiste godiste, boolean zaposlenost, MestoPrebivalista mestoPrebivalista, BrojClanovaPorodice brojClanovaPorodice) {
        this.pol = pol;
        this.godiste = godiste;
        this.zaposlenost = zaposlenost;
        this.mestoPrebivalista = mestoPrebivalista;
        this.brojClanovaPorodice = brojClanovaPorodice;
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
