package com.sw.projekat.repository;


import com.sw.projekat.model.Automobil;
import com.sw.projekat.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobilRepository extends JpaRepository<Automobil, Long> {
    Page<Automobil> findDistinctByMarkaContainingIgnoreCaseOrderByMarka(Pageable pageable, String marka);
}
