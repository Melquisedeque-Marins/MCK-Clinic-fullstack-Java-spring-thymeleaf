package com.melck.mckthymeleaf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByCpf(String cpf);

    User findByEmail(String email);

    User findByPassword(String password);

    
    @Query("SELECT obj FROM User obj WHERE "
    + "(:cpf = '' OR obj.cpf LIKE :cpf )")
    Page<User> find( String cpf, Pageable pageable);
    
}
