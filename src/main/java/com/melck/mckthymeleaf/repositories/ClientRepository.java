package com.melck.mckthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    Client findByCpf(String cpf);

    Client findByPassword(String password);
    
}
