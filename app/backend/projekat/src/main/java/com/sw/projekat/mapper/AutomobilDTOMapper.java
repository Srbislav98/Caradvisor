package com.sw.projekat.mapper;


import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.AutomobilQuery;

public class AutomobilDTOMapper {
    public static Automobil fromDTO(AutomobilDTO dto){
        Automobil aut=new Automobil();
        aut.setNaziv(dto.getNaziv());
        aut.setBoja(dto.getBoja());
        aut.setCena(dto.getCena());
        aut.setGodiste(dto.getGodiste());
        aut.setGorivo(dto.getGorivo());
        aut.setKaroserija(dto.getKaroserija());
        aut.setKlima(dto.isKlima());
        aut.setKubikaza(dto.getKubikaza());
        aut.setMarka(dto.getMarka());
        aut.setScore(dto.getScore());
        return aut;
    }
    public static AutomobilDTO toDTO(Automobil aut){
        AutomobilDTO dto=new AutomobilDTO();
        dto.setNaziv(aut.getNaziv());
        dto.setBoja(aut.getBoja());
        dto.setCena(aut.getCena());
        dto.setGodiste(aut.getGodiste());
        dto.setGorivo(aut.getGorivo());
        dto.setKaroserija(aut.getKaroserija());
        dto.setKlima(aut.isKlima());
        dto.setKubikaza(aut.getKubikaza());
        dto.setMarka(aut.getMarka());
        dto.setScore(aut.getScore());
        return dto;
    }
}

