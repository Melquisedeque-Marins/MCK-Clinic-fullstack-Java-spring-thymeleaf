package com.melck.mckthymeleaf.services;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.repositories.ExpertiseRepository;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private ExpertiseRepository expertiseRepository;

    @Transactional
    public Doctor insert(Doctor doctor){
        Doctor newDoctor = repository.save(doctor);
        return newDoctor;
    }

   @Transactional(readOnly = true)
    public Doctor findById(Long id){
        Optional<Doctor> doctor = repository.findById(id);
        return doctor.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Transactional(readOnly = true)
    public List<Doctor> findAll(){
       List<Doctor> doctors = repository.findAll();
        return doctors;
    }

    @Transactional(readOnly = true)
	public Page<Doctor> findAllPaged(Long expertiseId, String name, Pageable pageable) {
		List<Expertise> expertises = (expertiseId == 0) ? null : Arrays.asList(expertiseRepository.getReferenceById(expertiseId));
		Page<Doctor> page = repository.findAllPaged(expertises, name, pageable);
		repository.findDoctorsWithexpertises(page.getContent());
		return page;
	}

    @Transactional(readOnly = true)
    public List<Doctor> findByExpertise(Expertise expertise){
       List<Doctor> doctors = repository.findByExpertise(expertise);
        return doctors;
    }



}
