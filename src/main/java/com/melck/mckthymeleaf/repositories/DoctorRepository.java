package com.melck.mckthymeleaf.repositories;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    @Query("SELECT obj FROM Doctor obj INNER JOIN obj.expertises exp WHERE "
    + ":expertise IN exp")
    List<Doctor> findByExpertise(Expertise expertise);

    @Query("SELECT DISTINCT obj FROM Doctor obj INNER JOIN obj.expertises exp WHERE "
    + "(:expertises IS NULL OR exp IN :expertises) AND"
    + "(:name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT ( '%', :name, '%')) )")
    Page<Doctor> findAllPaged(List<Expertise> expertises, String name, Pageable pageable);

    @Query("SELECT obj FROM Doctor obj JOIN FETCH obj.expertises WHERE obj IN :doctors")
    List<Doctor> findDoctorsWithexpertises(List<Doctor> doctors);
}
