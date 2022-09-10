package com.melck.mckthymeleaf.repositories;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.user.User;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{
    
       
    @Query("SELECT obj FROM Scheduling obj INNER JOIN obj.user u WHERE "
            + "(u IN :users)"
            + "ORDER BY obj.schedulingTime")
          //  + "(:name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT ('%', :name, '%')) )")
    Page<Scheduling> find(java.util.List<User> users, org.springframework.data.domain.Pageable pageable);
    
}
