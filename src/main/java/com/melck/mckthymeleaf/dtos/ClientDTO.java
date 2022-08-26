package com.melck.mckthymeleaf.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melck.mckthymeleaf.models.client.User;
import com.melck.mckthymeleaf.models.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    private Long id;

    @NotBlank(message = "This field cannot be black")
    @Size(min = 5, max = 100)
    private String name;

    @Email
    @NotBlank(message = "the e-mail field cannot be empty")
    private String email;

    @CPF(message = "Enter a valid cpf")
    @NotBlank(message = "the cpf field cannot be empty")
    private String cpf;

    @NotBlank(message = "the password field cannot be empty")
    @Size(min = 8, max = 8)
    private String password;

    @NotEmpty(message = "the phone number field cannot be empty")
    @Size(min = 9, max = 15)
    private String phoneNumber;

    @NotNull(message = "the birth date field cannot be empty")
    //@Past(message = "enter a valid date of birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birthDate;
    private Integer age;

    private Gender gender;


    public ClientDTO(User client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.cpf = client.getCpf();
        this.password = client.getPassword();
        this.phoneNumber = client.getPhoneNumber();
        this.birthDate = client.getBirthDate().toString();
        this.gender = client.getGender();
    } 

}