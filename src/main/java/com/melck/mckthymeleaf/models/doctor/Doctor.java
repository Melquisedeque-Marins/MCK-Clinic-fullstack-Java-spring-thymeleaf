package com.melck.mckthymeleaf.models.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_doctor")
public class Doctor implements Serializable {

    @Id
    private Long id;
    private String name;

    //@Column(unique = true)
    private String cpf;
    private String phoneNumber;
    private String email;
    @Column(name = "registry", nullable = false)
    private String registry;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Expertise expertise;


    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

}
