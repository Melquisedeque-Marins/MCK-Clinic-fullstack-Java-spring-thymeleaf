package com.melck.mckthymeleaf.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.user.User;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{
    
       
    @Query("SELECT obj FROM Scheduling obj INNER JOIN obj.user u WHERE "
            + "(u IN :users)"
            + "ORDER BY obj.schedulingTime")
          //  + "(:name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT ('%', :name, '%')) )")
    Page<Scheduling> find(java.util.List<User> users, org.springframework.data.domain.Pageable pageable);

    @Query("SELECT obj FROM Scheduling obj INNER JOIN obj.doctor d  WHERE "
            + "(d IN :doctors)"
            + "ORDER BY obj.schedulingTime")
    List<Scheduling> findByDoctors(List<Doctor> doctors);

    @Query("SELECT obj FROM Scheduling obj INNER JOIN obj.doctor d  WHERE "
            + "(d = :doctors)"
            + "ORDER BY obj.schedulingTime")
    List<Scheduling> findByDoctor(Doctor doctors);

    
    @Query("SELECT obj FROM Scheduling obj WHERE "
            + "(obj.doctor.id = :doctorId) AND (obj.schedulingTime IN :schedules)"
            + "ORDER BY obj.schedulingTime")
    List<Scheduling> findBySchedule(List<LocalDateTime> schedules, Long doctorId);


    
}
