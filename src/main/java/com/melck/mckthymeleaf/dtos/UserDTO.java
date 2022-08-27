package com.melck.mckthymeleaf.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melck.mckthymeleaf.models.user.User;
import com.melck.mckthymeleaf.models.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 5, max = 100, message = "Insira o nome completo")
    private String name;

    @Email(message = "Insira um email valido. Ex: nome@email.com")
    @NotBlank(message = "O campo e-mail é obrigatório")
    private String email;

    @CPF(message = "Insira um cpf valido. somente números")
    @NotBlank(message = "O campo cpf é obrigatório")
    private String cpf;

    @NotBlank(message = "O campo password é obrigatório")
    @Size(min = 8, max = 8, message = "A senha deve conter 8 digitos")
    private String password;

    @NotBlank(message = "O campo telefone é obrigatório")
    @Size(min = 9, max = 15, message = "A senha deve conter 8 digitos")
    private String phoneNumber;

    @NotEmpty(message =  "O campo data de nascimento é obrigatório")
    //@Past(message = "enter a valid date of birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birthDate;
    private Long age;

    private Gender gender;


    public UserDTO(User client) {
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