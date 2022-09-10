package com.melck.mckthymeleaf.repositories;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    @Query("SELECT obj FROM Doctor obj INNER JOIN obj.expertises exp WHERE "
    + ":expertise IN exp")
    List<Doctor> findByExpertise(Expertise expertise);
}
