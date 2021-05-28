package com.sw.projekat.mapper;

import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.model.AutomobilQuery;

public class AutomobilQueryDTOMapper {
    public static AutomobilQuery fromDTO(AutomobilQueryDTO dto){
        AutomobilQuery aut=new AutomobilQuery();
        aut.setId(1L);
        aut.setBoja(dto.getBoja());
        aut.setCena(dto.getCena());
        aut.setGodiste(dto.getGodiste());
        aut.setGorivo(dto.getGorivo());
        aut.setKaroserija(dto.getKaroserija());
        aut.setKlima(dto.isKlima());
        aut.setKubikaza(dto.getKubikaza());
        aut.setMarka(dto.getMarka());


        return aut;
    }
    public static AutomobilQueryDTO toDTO(AutomobilQuery aut){
        AutomobilQueryDTO dto=new AutomobilQueryDTO();
        dto.setBoja(aut.getBoja());
        dto.setCena(aut.getCena());
        dto.setGodiste(aut.getGodiste());
        dto.setGorivo(aut.getGorivo());
        dto.setKaroserija(aut.getKaroserija());
        dto.setKlima(aut.isKlima());
        dto.setKubikaza(aut.getKubikaza());
        dto.setMarka(aut.getMarka());
        return dto;
    }
}
