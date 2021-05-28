package com.sw.projekat.service;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.dto.QueryDTO;
import com.sw.projekat.mapper.AutomobilDTOMapper;
import com.sw.projekat.mapper.AutomobilQueryDTOMapper;
import com.sw.projekat.mapper.OsobaDTOMapper;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.Osoba;
import com.sw.projekat.model.Query;
import com.sw.projekat.model.TestModel;
import com.sw.projekat.repository.AutomobilRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AutomobilService {


    @Autowired
    KieService kieService;

    @Autowired
    AutomobilService autoService;

    @Autowired
    AutomobilRepository automobilRepository;

    public List<AutomobilDTO> getYourTopCars(AutomobilQueryDTO autoQuery) {
        KieSession kieSession=kieService.getRulesSession();
        Query q=new Query();
        q.setAutomobilQuery(AutomobilQueryDTOMapper.fromDTO(autoQuery));
        kieSession.setGlobal("q", q.getAutomobilQuery());
        List<Automobil> automobils=autoService.findAll();
        for (Automobil a : automobils) {
            a.setScore(0);
            kieSession.insert(a);
        }
        List<Automobil> topCars=new ArrayList<>();
        //kieSession.setGlobal("topCars",topCars);
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        //topCars= (List<Automobil>) kieSession.getGlobal("topCars");
        kieService.disposeRulesSession();

        //System.out.println(automobils.size());
        Collections.sort(automobils,Collections.reverseOrder());
        //System.out.println(automobils.size());
        for (Automobil a :automobils) {
            topCars.add(a);
            if(topCars.size()==2){
                break;
            }
        }
        List<AutomobilDTO> topCarsDTO=new ArrayList<>();
        for(Automobil a: topCars){
            topCarsDTO.add(AutomobilDTOMapper.toDTO(a));
        }
        return topCarsDTO;
    }

    private List<Automobil> findAll() {
        return automobilRepository.findAll();
    }

    public List<AutomobilDTO> getYourTopCarsBasedOnYou(QueryDTO autoQuery) {
        KieSession kieSession=kieService.getRulesSession();
//        Query q=new Query();
//        q.setAutomobilQuery(AutomobilQueryDTOMapper.fromDTO(autoQuery.getAutomobilQuery()));
        kieSession.setGlobal("q", AutomobilQueryDTOMapper.fromDTO(autoQuery.getAutomobilQuery()));
        kieSession.setGlobal("qOsoba", autoQuery.getOsobaQuery());
        Osoba osoba= new Osoba(autoQuery.getOsobaQuery().getPol(),null,autoQuery.getOsobaQuery().isZaposlenost(),
                autoQuery.getOsobaQuery().getMestoPrebivalista(),null);
        kieSession.insert(osoba);
        List<Automobil> automobils=autoService.findAll();
        for (Automobil a : automobils) {
            a.setScore(0);
            kieSession.insert(a);
        }
        List<Automobil> topCars=new ArrayList<>();
        //kieSession.setGlobal("topCars",topCars);
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        //topCars= (List<Automobil>) kieSession.getGlobal("topCars");
        kieService.disposeRulesSession();
        //System.out.println(automobils.size());
        Collections.sort(automobils,Collections.reverseOrder());
        //System.out.println(automobils.size());
        for (Automobil a :automobils) {
            topCars.add(a);
            if(topCars.size()==2){
                break;
            }
        }
        List<AutomobilDTO> topCarsDTO=new ArrayList<>();
        for(Automobil a: topCars){
            topCarsDTO.add(AutomobilDTOMapper.toDTO(a));
        }
//        System.out.println(osoba.getBrojClanovaPorodice());
//        System.out.println(osoba.getGodiste());
        return topCarsDTO;
    }
}
