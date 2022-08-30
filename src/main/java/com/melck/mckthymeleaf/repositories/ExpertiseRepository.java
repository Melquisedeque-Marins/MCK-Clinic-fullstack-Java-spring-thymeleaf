package com.melck.mckthymeleaf.repositories;

import com.melck.mckthymeleaf.models.doctor.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {
}
