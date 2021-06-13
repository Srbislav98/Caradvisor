package com.sw.projekat;

import com.sw.projekat.dto.OsobaQueryDTO;
import com.sw.projekat.model.*;
import com.sw.projekat.model.enums.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutomobilAndOsobaTest {

    @Test
    public void testPorodicniAutomobil(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,40,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        AutomobilQuery q2=new AutomobilQuery(1L,"BMW", Karoserija.DZIP,4000,2010,Gorivo.BENZIN,true,100,Boja.CRNA);
        kieSession.setGlobal("q", q2);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.KARAVAN,2000,2014,Gorivo.BENZIN,false,54,Boja.PLAVA,0);
        kieSession.insert(automobil);
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        User user=new User();
        ArrayList<String> lista=new ArrayList<String>();
        lista.add("bmw najnoviji");
        lista.add("mercedes najbolji");
        user.setPretraga(lista);
        kieSession.insert(user);

        kieSession.getAgenda().getAgendaGroup("based_on_car_and_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.VISECLANA_PORODICA);
        assertEquals(o.getGodiste(),Godiste.SREDNJE_GODINE);
        assertEquals(automobil.getScore(),85);
        System.out.println("pravilo - porodicni automobil!");

        kieSession.dispose();
    }
    @Test
    public void testPorodicniAutomobilDodatno(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,40,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        AutomobilQuery q2=new AutomobilQuery(1L,"BMW", Karoserija.DZIP,4000,2010,Gorivo.BENZIN,true,100,Boja.CRNA);
        kieSession.setGlobal("q", q2);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.KARAVAN,2000,2014,Gorivo.BENZIN,false,54,Boja.PLAVA,0);
        kieSession.insert(automobil);
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        User user=new User();
        ArrayList<String> lista=new ArrayList<String>();
        lista.add("bmw najnoviji");
        lista.add("dzip najbolji");
        user.setPretraga(lista);
        kieSession.insert(user);

        kieSession.getAgenda().getAgendaGroup("based_on_car_and_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.VISECLANA_PORODICA);
        assertEquals(o.getGodiste(),Godiste.SREDNJE_GODINE);
        assertEquals(automobil.getScore(),90);
        System.out.println("pravilo - porodicni automobil dodatno!");

        kieSession.dispose();
    }
    @Test
    public void testMuskiPoslovniAutomobil(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,40,true,MestoPrebivalista.SELO,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba(Pol.M,true,MestoPrebivalista.SELO);
        kieSession.insert(o);
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        AutomobilQuery q2=new AutomobilQuery(1L,"BMW", Karoserija.DZIP,4000,2010,Gorivo.BENZIN,true,100,Boja.CRNA);
        kieSession.setGlobal("q", q2);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.KARAVAN,2000,2014,Gorivo.BENZIN,false,54,Boja.BRAON,0);
        kieSession.insert(automobil);
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        User user=new User();
        ArrayList<String> lista=new ArrayList<String>();
        lista.add("bmw najnoviji");
        lista.add("mercedes najbolji");
        user.setPretraga(lista);
        kieSession.insert(user);

        kieSession.getAgenda().getAgendaGroup("based_on_car_and_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.VISECLANA_PORODICA);
        assertEquals(o.getGodiste(),Godiste.SREDNJE_GODINE);
        assertEquals(automobil.getScore(),100);
        System.out.println("pravilo - muski automobil!");
        System.out.println("pravilo - poslovni automobil!");
        kieSession.dispose();
    }
    @Test
    public void testZenskiAutomobil(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.Z,40,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba(Pol.Z,true,MestoPrebivalista.GRAD);
        kieSession.insert(o);
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        AutomobilQuery q2=new AutomobilQuery(1L,"BMW", Karoserija.DZIP,4000,2010,Gorivo.BENZIN,true,100,Boja.CRVENA);
        kieSession.setGlobal("q", q2);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.KARAVAN,2000,2014,Gorivo.BENZIN,false,54,Boja.NARANDZASTA,0);
        kieSession.insert(automobil);
        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();

        User user=new User();
        ArrayList<String> lista=new ArrayList<String>();
        lista.add("bmw najnoviji");
        lista.add("mercedes najbolji");
        user.setPretraga(lista);
        kieSession.insert(user);

        kieSession.getAgenda().getAgendaGroup("based_on_car_and_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.VISECLANA_PORODICA);
        assertEquals(o.getGodiste(),Godiste.SREDNJE_GODINE);
        assertEquals(automobil.getScore(),95);
        System.out.println("pravilo - zenski automobil!");

        kieSession.dispose();
    }
}
