package com.melck.mckthymeleaf.repositories;

import com.melck.mckthymeleaf.models.doctor.Expertise;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

    @Query("SELECT DISTINCT obj FROM Expertise obj WHERE "
    + "(:name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT (:name, '%')) )")
    Page<Expertise> findAllPaged(String name, Pageable pageable);
}
