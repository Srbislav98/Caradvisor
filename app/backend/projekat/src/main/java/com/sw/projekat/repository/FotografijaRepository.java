package com.sw.projekat.repository;

import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.Fotografija;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FotografijaRepository extends JpaRepository<Fotografija, Integer> {

    Fotografija findByCarNaziv(String carNaziv);
}
