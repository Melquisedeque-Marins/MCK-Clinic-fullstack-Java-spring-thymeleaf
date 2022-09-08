package com.melck.mckthymeleaf.models;

import lombok.Data;

import javax.persistence.*;

import com.melck.mckthymeleaf.models.enums.StatusEmail;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}

