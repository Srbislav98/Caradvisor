package com.sw.projekat;

import com.sw.projekat.dto.OsobaQueryDTO;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.AutomobilQuery;
import com.sw.projekat.model.Osoba;
import com.sw.projekat.model.OsobaQuery;
import com.sw.projekat.model.enums.*;
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
public class AutomobilTest {

    @Test
    public void automobil1Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        AutomobilQuery q=new AutomobilQuery(1L,"BMW", Karoserija.LIMUZINA,4000,2010,Gorivo.BENZIN,true,100,Boja.CRNA);
//        AutomobilQuery q=new AutomobilQuery();
//        q.setMarka("BMW");
        kieSession.setGlobal("q", q);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.HECBEK,2000,2014,Gorivo.BENZIN,false,54,Boja.PLAVA,0);
//        Automobil automobil=new Automobil();
//        automobil.setMarka("BMW");
        kieSession.insert(automobil);

        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        System.out.println("Tacna marka(20)+Slicna karoserija-porodicni+Cena je do 50% manja " +
                "od unesene okvirne cene(20)+Godiste automobila je u rangu ± 5(20)+Tacno gorivo automobila(10)" +
                " = 70 BODOVA");
        assertEquals(automobil.getScore(),70);
        kieSession.dispose();
    }
    @Test
    public void automobil2Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        AutomobilQuery q=new AutomobilQuery(1L,"Mercedes", Karoserija.HECBEK,1900,2003,Gorivo.BENZIN,true,50,Boja.SIVA);
        kieSession.setGlobal("q", q);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.HECBEK,2000,2014,Gorivo.BENZIN_METAN,true,54,Boja.SIVA,0);
        kieSession.insert(automobil);

        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        System.out.println("Tacna karoserija automobila(20)+Cena je do 10% veca od unesene okvirne cene(10)+Slicna grupa goriva automobila - benzinac(5)+" +
                "Klima u automobilu(5)+Kubikaza automobila je u rangu ± 10(20)+Tacna boja automobila(10)" +
                " = 70 BODOVA");
        assertEquals(automobil.getScore(),70);
        kieSession.dispose();
    }
    @Test
    public void automobil3Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        AutomobilQuery q=new AutomobilQuery(1L,"Mercedes", Karoserija.DZIP,1900,2010,Gorivo.ELEKTRICNI_POGON,false,50,Boja.BRAON);
        kieSession.setGlobal("q", q);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.PICKUP,3500,2014,Gorivo.HIBRIDNI_POGON,false,60,Boja.SIVA,0);
        kieSession.insert(automobil);

        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        System.out.println("Slicna karoserija automobila - dzipovi+Godište automobila je u rangu ± 5(20)+Slicna grupa goriva automobila - ekoloski(5)" +
                "+Kubikaza automobila je u rangu ± 10(20)+Slicna grupa boje automobila - muska" +
                " = 45 BODOVA");
        assertEquals(automobil.getScore(),45);
        kieSession.dispose();
    }
    @Test
    public void automobil4Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");

        AutomobilQuery q=new AutomobilQuery(1L,"Mercedes", Karoserija.KABRIOLET,1900,2008,Gorivo.BENZIN,false,50,Boja.NARANDZASTA);
        kieSession.setGlobal("q", q);
        Automobil automobil=new Automobil("bmw","BMW", Karoserija.KUPE,5500,2014,Gorivo.BENZIN_METAN,false,80,Boja.CRVENA,0);
        kieSession.insert(automobil);

        kieSession.getAgenda().getAgendaGroup("based_on_car").setFocus();
        kieSession.fireAllRules();
        System.out.println("Slicna karoserija automobila - sportski/ljetni+Godište automobila je u rangu ± 10(10)+Slicna grupa goriva automobila - benzinac(5)+" +
                "Kubikaza automobila je u rangu ± 40(5)+Slicna grupa boje automobila - zenska" +
                " = 20 BODOVA");
        assertEquals(automobil.getScore(),20);
        kieSession.dispose();
    }
}
