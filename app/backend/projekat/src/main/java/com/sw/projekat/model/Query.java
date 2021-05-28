package com.sw.projekat.model;

import javax.persistence.*;

@Entity
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AutomobilQuery automobilQuery;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OsobaQuery osobaQuery;

    public Query() {
    }

    public Query(Long id, AutomobilQuery automobilQuery, OsobaQuery osobaQuery) {
        this.id = id;
        this.automobilQuery = automobilQuery;
        this.osobaQuery = osobaQuery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AutomobilQuery getAutomobilQuery() {
        return automobilQuery;
    }

    public void setAutomobilQuery(AutomobilQuery automobilQuery) {
        this.automobilQuery = automobilQuery;
    }

    public OsobaQuery getOsobaQuery() {
        return osobaQuery;
    }

    public void setOsobaQuery(OsobaQuery osobaQuery) {
        this.osobaQuery = osobaQuery;
    }
}
