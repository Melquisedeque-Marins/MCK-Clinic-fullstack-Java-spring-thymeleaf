package com.melck.mckthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.client.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByCpf(String cpf);

    User findByEmail(String email);

    User findByPassword(String password);
    
}
