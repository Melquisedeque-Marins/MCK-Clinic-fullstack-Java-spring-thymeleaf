package com.melck.mckthymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.models.client.Client;
import com.melck.mckthymeleaf.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client insert(Client client){
        Client c = repository.save(client);
        return c;
    }
    
}
