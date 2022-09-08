package com.melck.mckthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    
}
