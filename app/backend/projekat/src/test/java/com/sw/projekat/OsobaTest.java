package com.sw.projekat;

import com.sw.projekat.dto.OsobaQueryDTO;
import com.sw.projekat.model.Osoba;
import com.sw.projekat.model.OsobaQuery;
import com.sw.projekat.model.enums.BrojClanovaPorodice;
import com.sw.projekat.model.enums.Godiste;
import com.sw.projekat.model.enums.MestoPrebivalista;
import com.sw.projekat.model.enums.Pol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OsobaTest {

    @Test
    public void testOsobajeSamac(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

//        Osoba o = new Osoba(Pol.M, Godiste.MLADA_OSOBA,true, MestoPrebivalista.GRAD, BrojClanovaPorodice.PAR);
        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,22,true,MestoPrebivalista.GRAD,1);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.SAMAC);

        kieSession.dispose();
    }
    @Test
    public void OsobazivikaoParTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,22,true,MestoPrebivalista.GRAD,2);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.PAR);

        kieSession.dispose();
    }
    @Test
    public void OsobazivizaViseclanomPorodicomTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,22,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getBrojClanovaPorodice(),BrojClanovaPorodice.VISECLANA_PORODICA);

        kieSession.dispose();
    }
    @Test
    public void OsobaMladaTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,20,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getGodiste(),Godiste.MLADA_OSOBA);

        kieSession.dispose();
    }
    @Test
    public void OsobaSrednjihGodinaTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,40,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getGodiste(),Godiste.SREDNJE_GODINE);

        kieSession.dispose();
    }
    @Test
    public void OsobaStarijaTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();

        OsobaQueryDTO q=new OsobaQueryDTO(Pol.M,70,true,MestoPrebivalista.GRAD,5);
        kieSession.setGlobal("qOsoba",q);
        Osoba o =new Osoba();
        kieSession.insert(o);

        kieSession.getAgenda().getAgendaGroup("based_on_person").setFocus();
        kieSession.fireAllRules();

        assertEquals(o.getGodiste(),Godiste.STARIJA_OSOBA);

        kieSession.dispose();
    }
}
