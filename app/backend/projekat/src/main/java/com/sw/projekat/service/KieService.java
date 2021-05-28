package com.sw.projekat.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class KieService {

    private final KieContainer kieContainer;

    private KieSession rulesSession;

    public KieService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public KieContainer getKieContainer() {
        return kieContainer;
    }

    public KieSession getRulesSession() {
        rulesSession=kieContainer.newKieSession("rulesSession");
        return rulesSession;
    }

    public void setRulesSession(KieSession rulesSession) {
        this.rulesSession = rulesSession;
    }

    public void disposeRulesSession(){
        this.rulesSession.dispose();
        this.rulesSession=null;
    }
}
