package com.melck.mckthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.mckthymeleaf.models.user.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
