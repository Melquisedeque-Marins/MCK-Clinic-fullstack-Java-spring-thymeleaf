package com.melck.mckthymeleaf.repositories;

import com.melck.mckthymeleaf.models.client.Role;
import com.melck.mckthymeleaf.models.client.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{


}
