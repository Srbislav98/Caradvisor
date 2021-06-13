package com.sw.projekat.model;

import javax.persistence.*;
import java.io.File;

@Entity
public class Fotografija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String carNaziv;

    @Column
    private String lokacijaFajl;

    @Column
    private File foto;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
    private Automobil automobil;

    public Fotografija() {
    }

    public Fotografija(Integer id, String carNaziv, File foto,String lokacijaFajl) {
        this.id = id;
        this.carNaziv = carNaziv;
        this.foto = foto;
        this.lokacijaFajl=lokacijaFajl;
    }

    @Override
    public boolean equals(Object obj) {
        Fotografija o = (Fotografija) obj;
        if (this.getId() == null || o.getId() == null) {
            if (this.getCarNaziv().equals(o.getCarNaziv()))
                return true;
            else
                return false;
        } else
            return this.getId().equals(o.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNaziv() {
        return carNaziv;
    }

    public void setCarNaziv(String carNaziv) {
        this.carNaziv = carNaziv;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    public String getLokacijaFajl() {
        return lokacijaFajl;
    }

    public void setLokacijaFajl(String lokacijaFajl) {
        this.lokacijaFajl = lokacijaFajl;
    }
}

