package com.sw.projekat.service;

import com.sw.projekat.model.Fotografija;
import com.sw.projekat.repository.AutomobilRepository;
import com.sw.projekat.repository.FotografijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FotografijaService {

    @Autowired
    FotografijaRepository fotografijaRepository;

    @Autowired
    AutomobilRepository automobilRepository;

    public Fotografija create(Fotografija entity) {
        entity.setAutomobil(automobilRepository.findByNaziv(entity.getCarNaziv()));
        if(!entity.getLokacijaFajl().equals(""))
            entity.setFoto(new File(entity.getLokacijaFajl()));
        return  fotografijaRepository.save(entity);
    }

    public Fotografija getByCarNaziv(String naziv) {
//        Fotografija a= new Fotografija();
//        for( Fotografija i : fotografijaRepository.findByCarNaziv(naziv)){
//            a=i;
//        }
//        return a;
        return fotografijaRepository.findByCarNaziv(naziv);
    }
}
