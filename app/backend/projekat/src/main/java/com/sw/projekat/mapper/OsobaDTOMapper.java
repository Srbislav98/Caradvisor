package com.sw.projekat.mapper;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.OsobaDTO;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.Osoba;

public class OsobaDTOMapper {
    public static Osoba fromDTO(OsobaDTO dto){
        Osoba aut=new Osoba();
        aut.setId(1l);
        aut.setPol(dto.getPol());
        aut.setBrojClanovaPorodice(dto.getBrojClanovaPorodice());
        aut.setGodiste(dto.getGodiste());
        aut.setMestoPrebivalista(dto.getMestoPrebivalista());
        aut.setZaposlenost(dto.isZaposlenost());

        return aut;
    }
    public static OsobaDTO toDTO(Osoba aut){
        OsobaDTO dto=new OsobaDTO();
        dto.setBrojClanovaPorodice(aut.getBrojClanovaPorodice());
        dto.setGodiste(aut.getGodiste());
        dto.setMestoPrebivalista(aut.getMestoPrebivalista());
        dto.setPol(aut.getPol());
        dto.setZaposlenost(aut.isZaposlenost());
        return dto;
    }
}
