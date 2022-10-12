package com.melck.mckthymeleaf.services;

import javax.persistence.EntityNotFoundException;

import com.melck.mckthymeleaf.models.user.Address;
import com.melck.mckthymeleaf.models.user.Role;
import com.melck.mckthymeleaf.repositories.RoleRepository;
import com.melck.mckthymeleaf.services.exceptions.InvalidDateException;
import com.melck.mckthymeleaf.services.exceptions.ObjectIsAlreadyInUseException;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.dtos.UserDTO;
import com.melck.mckthymeleaf.models.user.User;
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
    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

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
        user.setBirthDate(dto.getBirthDate());
        UserDTO newUser = new UserDTO(repository.save(user));
        Long years = ChronoUnit.YEARS.between(user.getBirthDate(), LocalDate.now());
        newUser.setAge(years);
        emailService.sendEmail(user);
        return newUser;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> users = repository.findAll();
        return users.stream().map(c -> new UserDTO(c)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
	public Page<User> findUser( String cpf, Pageable pageable) {
		Page<User> page = repository.find(cpf, pageable);
		return page;
	}


    @Transactional(readOnly = true)
    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado para o id : " + id));
    }

    @Transactional
    public User userLogged(){
       User user = authService.authenticated();
       return user;
    }

    public void delete(Long id){
        User user = findById(id);
        repository.delete(user);
    }

    @Transactional
    public void updateUser(UserDTO userDTO) {
        User user = authService.authenticated();
        User userEx = findById(user.getId());
        userEx.setPhoneNumber(userDTO.getPhoneNumber());
        userEx.setEmail(userDTO.getEmail());
       // userEx.setName(userDTO.getName());
       Address address = new Address();
       address.setStreet(userDTO.getAddress().getStreet());
       address.setNumber(userDTO.getAddress().getNumber());
       repository.save(userEx);
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
