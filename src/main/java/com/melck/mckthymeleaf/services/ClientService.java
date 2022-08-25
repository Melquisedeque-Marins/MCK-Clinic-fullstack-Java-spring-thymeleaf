package com.melck.mckthymeleaf.services;

import javax.persistence.EntityNotFoundException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.dtos.ClientDTO;
import com.melck.mckthymeleaf.models.client.Client;
import com.melck.mckthymeleaf.repositories.ClientRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        client.setBirthDate(LocalDate.parse(dto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return new ClientDTO(repository.save(client));
    }

    public Client login(String cpf, String password){
        var c1 = repository.findByCpf(cpf);
        var c2 = repository.findByPassword(password);
        if (c1 == null || c2 == null){
           throw new EntityNotFoundException("Cliente não encontrado");
        }
        return c1;
    }
    
}
