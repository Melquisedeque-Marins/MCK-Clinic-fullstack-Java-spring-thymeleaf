package com.melck.mckthymeleaf.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Long number;

    private Long postalCode;

    private String city;

    private String state;

    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<User> clients;

}

