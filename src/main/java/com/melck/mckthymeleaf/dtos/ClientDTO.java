package com.melck.mckthymeleaf.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melck.mckthymeleaf.models.client.Address;
import com.melck.mckthymeleaf.models.client.Client;
import com.melck.mckthymeleaf.models.enums.Gender;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String password;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Gender gender;


    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.cpf = client.getCpf();
        this.password = client.getPassword();
        this.phoneNumber = client.getPhoneNumber();
        this.birthDate = client.getBirthDate();
        this.gender = client.getGender();
    } 

}