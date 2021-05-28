package com.sw.projekat.dto;

import com.sw.projekat.model.enums.Karoserija;
import com.sw.projekat.model.enums.MestoPrebivalista;
import com.sw.projekat.model.enums.Pol;

public class OsobaQueryDTO {

    private Pol pol;
    private int godiste;
    private boolean zaposlenost;
    private MestoPrebivalista mestoPrebivalista;
    private int brojClanovaPorodice;

    public OsobaQueryDTO() {
    }

    public OsobaQueryDTO(Pol pol, int godiste, boolean zaposlenost, MestoPrebivalista mestoPrebivalista, int brojClanovaPorodice) {
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

    public MestoPrebivalista getMestoPrebivalista() {
        return mestoPrebivalista;
    }

    public void setMestoPrebivalista(MestoPrebivalista mestoPrebivalista) {
        this.mestoPrebivalista = mestoPrebivalista;
    }

    public int getBrojClanovaPorodice() {
        return brojClanovaPorodice;
    }

    public void setBrojClanovaPorodice(int brojClanovaPorodice) {
        this.brojClanovaPorodice = brojClanovaPorodice;
    }
}
