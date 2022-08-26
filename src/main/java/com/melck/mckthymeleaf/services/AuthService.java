package com.melck.mckthymeleaf.services;

import com.melck.mckthymeleaf.models.client.User;
import com.melck.mckthymeleaf.repositories.UserRepository;
import com.melck.mckthymeleaf.services.exceptions.ForbiddenException;
import com.melck.mckthymeleaf.services.exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByCpf(username);
        } catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        var user = authenticated();

        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }
}
