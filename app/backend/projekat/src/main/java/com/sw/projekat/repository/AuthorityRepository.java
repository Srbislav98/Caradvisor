package com.sw.projekat.repository;

import com.sw.projekat.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
