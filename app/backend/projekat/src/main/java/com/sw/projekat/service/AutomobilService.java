package com.sw.projekat.service;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.dto.OsobaQueryDTO;
import com.sw.projekat.dto.QueryDTO;
import com.sw.projekat.mapper.AutomobilDTOMapper;
import com.sw.projekat.mapper.AutomobilQueryDTOMapper;
import com.sw.projekat.mapper.OsobaDTOMapper;
import com.sw.projekat.model.*;
import com.sw.projekat.model.enums.BrojClanovaPorodice;
import com.sw.projekat.model.enums.Godiste;
import com.sw.projekat.model.enums.MestoPrebivalista;
import com.sw.projekat.model.enums.Pol;
import com.sw.projekat.repository.AutomobilRepository;
import com.sw.projekat.repository.UserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class AutomobilService {


    @Autowired
    KieService kieService;

    @Autowired
    AutomobilService autoService;

    @Autowired
    AutomobilRepository automobilRepository;

    @Autowired
    UserRepository userRepository;

    public List<AutomobilDTO> getYourTopCars(AutomobilQueryDTO autoQuery) {
        KieSession kieSession=kieService.getRulesSession();
        kieSession.setGlobal("q", AutomobilQueryDTOMapper.fromDTO(autoQuery));

        List<Automobil> automobils=autoService.findAll();
        for (Automobil a : automobils) {
            a.setScore(0);
            a.setDodatneKarakteristike(new DodatneKarakteristike());
            kieSession.insert(a);
        }
        List<Automobil> topCars=new ArrayList<>();
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        kieService.disposeRulesSession();


        Collections.sort(automobils,Collections.reverseOrder());
        for (Automobil a :automobils) {
            topCars.add(a);
            if(topCars.size()==1){
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
        kieSession.setGlobal("q", AutomobilQueryDTOMapper.fromDTO(autoQuery.getAutomobilQuery()));
        kieSession.setGlobal("qOsoba", autoQuery.getOsobaQuery());
        Osoba osoba= new Osoba(autoQuery.getOsobaQuery().getPol(),null,autoQuery.getOsobaQuery().isZaposlenost(),
                autoQuery.getOsobaQuery().getMestoPrebivalista(),null);
        kieSession.insert(osoba);

        List<Automobil> automobils=autoService.findAll();
        for (Automobil a : automobils) {
            a.setScore(0);
            a.setDodatneKarakteristike(new DodatneKarakteristike());
            kieSession.insert(a);
        }
        List<Automobil> topCars=new ArrayList<>();

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        //ovako treba, ali radi testiranja cu drugacije, a kasnije ovako
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User user=(User)auth.getPrincipal();
        //ovako ne treba
//        User user=new User();
//        ArrayList<String> lista=new ArrayList<String>();
//        lista.add("bmw najnoviji");
//        lista.add("dzip najbolji");
//        user.setPretraga(lista);
//        HashSet<Automobil> auta=new HashSet<Automobil>();
//        auta.add(automobilRepository.findByNaziv("Renault megane"));
//        user.setDetaljna_pretraga(auta);
        kieSession.insert(user);

        kieSession.getAgenda().getAgendaGroup("based_on_car_and_person").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("based_on_all_dodatno").setFocus();
        kieSession.fireAllRules();

        kieService.disposeRulesSession();

        //sortiranje automobila, vracanje najboljih
        Collections.sort(automobils,Collections.reverseOrder());
        for (Automobil a :automobils) {
            topCars.add(a);
            if(topCars.size()==1){
                break;
            }
        }
        List<AutomobilDTO> topCarsDTO=new ArrayList<>();
        for(Automobil a: topCars){
            topCarsDTO.add(AutomobilDTOMapper.toDTO(a));
        }
        return topCarsDTO;
    }

    public Page<Automobil> findAll(Pageable pageable) {
        return automobilRepository.findAll(pageable);
    }

    public Page<Automobil> filterByContentPage(Pageable pageable, String content) {
        try {
            Authentication auth= SecurityContextHolder.getContext().getAuthentication();
            User u=(User)auth.getPrincipal();
            if(u.getId()!=1){
                u.getPretraga().add(content);
                userRepository.save(u);
            }
        }catch (Exception e){
            System.out.println("Nema reg korisnika");
        }
//        return automobilRepository.findDistinctByNazivContainingOrOpisContainingOrderByNaziv(pageable, content, content);
        return automobilRepository.findDistinctByNazivContainingIgnoreCaseOrMarkaContainingIgnoreCaseOrderByNaziv(pageable,content,content);
    }

    public void createCar(AutomobilDTO autoDTO) throws Exception {
        Automobil auto =AutomobilDTOMapper.fromDTO(autoDTO);
        Automobil imaAuto=null;
        imaAuto =automobilRepository.findByNaziv(auto.getNaziv());
        if (imaAuto!=null){
            throw new Exception("Automobil sa ovim nazivom vec postoji");
        }
        automobilRepository.save(auto);
    }

    public Automobil getCar(String naziv) {
        Automobil autic= automobilRepository.findByNaziv(naziv);
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User u = (User) auth.getPrincipal();
            if(u.getId()!=1){
                u.getDetaljna_pretraga().add(autic);
                userRepository.save(u);
            }
        }catch (Exception e){
            System.out.println("Nema reg korisnika");
        }
        return autic;
    }

    public void deleteCar(String naziv) {
        System.out.println("naziv1");
        Automobil auto = automobilRepository.findByNaziv(naziv);
        System.out.println("naziv2");
        automobilRepository.delete(auto);
        System.out.println("naziv3");
        System.out.println(auto.getNaziv());
    }
}
