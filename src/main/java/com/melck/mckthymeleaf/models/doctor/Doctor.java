package com.melck.mckthymeleaf.models.doctor;

import lombok.*;

import javax.persistence.*;

import com.melck.mckthymeleaf.models.enums.OfficeHours;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_doctor")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@Column(unique = true)
    private String cpf;
    private String phoneNumber;
    private String email;
    @Column(name = "registry", nullable = false)
    private String registry;
    
    @Enumerated(EnumType.STRING)
    private OfficeHours officeHours;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_doctor_expertise",
    joinColumns = @JoinColumn(name = "doctor_id"),
    inverseJoinColumns = @JoinColumn(name = "expertise_id"))
    private Set<Expertise> expertises = new HashSet<>();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PrePersist
    public void preCreated(){
        createdAt = Instant.now();
    }
    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

}
