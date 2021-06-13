package com.sw.projekat.mapper;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.FotografijaDTO;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.Fotografija;

public class FotografijaDTOMapper {
    public static Fotografija fromDTO(FotografijaDTO dto){
        Fotografija aut=new Fotografija();
        aut.setId(dto.getId());
        aut.setCarNaziv(dto.getCarNaziv());
        aut.setFoto(dto.getFoto());
        aut.setLokacijaFajl(dto.getLokacijaFajl());
        return aut;
    }
    public static FotografijaDTO toDTO(Fotografija aut){
        FotografijaDTO dto=new FotografijaDTO();
        dto.setId(aut.getId());
        dto.setCarNaziv(aut.getCarNaziv());
        dto.setFoto(aut.getFoto());
        dto.setLokacijaFajl(aut.getLokacijaFajl());
        return dto;
    }
}
