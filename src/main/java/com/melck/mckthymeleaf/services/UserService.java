package com.melck.mckthymeleaf.services;

import javax.persistence.EntityNotFoundException;

import com.melck.mckthymeleaf.models.client.Role;
import com.melck.mckthymeleaf.repositories.RoleRepository;
import com.melck.mckthymeleaf.services.exceptions.ObjectIsAlreadyInUseException;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.dtos.UserDTO;
import com.melck.mckthymeleaf.models.client.User;
import com.melck.mckthymeleaf.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO insert(UserDTO dto){
        if (repository.findByCpf(dto.getCpf()) != null){
            throw new ObjectIsAlreadyInUseException("cpf número: " + dto.getCpf() + " já esta sendo utilizado");
        }
        if (repository.findByEmail(dto.getEmail()) != null){
            throw new ObjectIsAlreadyInUseException("Endereço de e-mail: " + dto.getEmail() + " já esta sendo utilizado");
        }
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Role role = roleRepository.getReferenceById(2L);
        user.getRoles().add(role);
        user.setBirthDate(LocalDate.parse(dto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        UserDTO newUser = new UserDTO(repository.save(user));
        Long years = ChronoUnit.YEARS.between(user.getBirthDate(), LocalDate.now());
        newUser.setAge(years);
        return newUser;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> users = repository.findAll();
        return users.stream().map(c -> new UserDTO(c)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado para o id : " + id));
    }

    @Transactional
    public User login(String cpf, String password){
        var c1 = repository.findByCpf(cpf);
        if (c1 == null || !c1.getPassword().equals(password) ){
           throw new EntityNotFoundException("usuario não encontrado");
        }
        return c1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByCpf(username);
        if (user == null){
            throw new UsernameNotFoundException("Cpf não encontrado");
        }
        return user;
    }
}
