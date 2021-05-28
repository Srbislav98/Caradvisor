package com.sw.projekat.dto;


public class QueryDTO {

    private AutomobilQueryDTO automobilQuery;

    private OsobaQueryDTO osobaQuery;

    public QueryDTO() {
    }

    public QueryDTO(AutomobilQueryDTO automobilQuery, OsobaQueryDTO osobaQuery) {
        this.automobilQuery = automobilQuery;
        this.osobaQuery = osobaQuery;
    }





    public AutomobilQueryDTO getAutomobilQuery() {
        return automobilQuery;
    }

    public void setAutomobilQuery(AutomobilQueryDTO automobilQuery) {
        this.automobilQuery = automobilQuery;
    }

    public OsobaQueryDTO getOsobaQuery() {
        return osobaQuery;
    }

    public void setOsobaQuery(OsobaQueryDTO osobaQuery) {
        this.osobaQuery = osobaQuery;
    }
}

