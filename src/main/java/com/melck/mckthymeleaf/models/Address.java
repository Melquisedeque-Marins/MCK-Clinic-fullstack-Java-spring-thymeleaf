package com.melck.mckthymeleaf.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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

