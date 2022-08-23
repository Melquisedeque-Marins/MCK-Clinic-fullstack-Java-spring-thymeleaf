package com.melck.mckthymeleaf.models.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

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
    @OneToOne(mappedBy = "address")
    private Client client;

}

