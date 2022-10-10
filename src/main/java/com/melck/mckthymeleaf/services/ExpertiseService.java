package com.melck.mckthymeleaf.services;

import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.repositories.ExpertiseRepository;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertiseService {

    @Autowired
    private ExpertiseRepository repository;

   
    @Transactional
    public Expertise insert(Expertise expertise){
        Expertise exp = repository.save(expertise);
        return exp;
    }

   @Transactional(readOnly = true)
    public Expertise findById(Long id){
        Optional<Expertise> expertise = repository.findById(id);
        return expertise.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Transactional(readOnly = true)
    public List<Expertise> findAll(){
       List<Expertise> expertises = repository.findAll();
        return expertises;
    }

    @Transactional(readOnly = true)
	public Page<Expertise> findAllPaged(String name, Pageable pageable) {
		Page<Expertise> page = repository.findAllPaged(name, pageable);
		return page;
	}

}
