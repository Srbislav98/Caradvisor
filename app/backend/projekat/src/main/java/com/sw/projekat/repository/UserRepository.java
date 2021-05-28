package com.sw.projekat.repository;

import com.sw.projekat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}
