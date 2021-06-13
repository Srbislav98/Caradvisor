package com.sw.projekat.dto;

import java.io.File;

public class FotografijaDTO {

    private Integer id;
    private String carNaziv;
    private File foto;
    private String lokacijaFajl;


    public FotografijaDTO(Integer id, String carNaziv, File foto,String lokacijaFajl) {
        this.id = id;
        this.carNaziv = carNaziv;
        this.foto=foto;
        this.lokacijaFajl=lokacijaFajl;
    }

    public FotografijaDTO() {

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

    public String getLokacijaFajl() {
        return lokacijaFajl;
    }

    public void setLokacijaFajl(String lokacijaFajl) {
        this.lokacijaFajl = lokacijaFajl;
    }
}
