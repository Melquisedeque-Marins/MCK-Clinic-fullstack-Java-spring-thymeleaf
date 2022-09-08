package com.melck.mckthymeleaf.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.dtos.EmailDTO;
import com.melck.mckthymeleaf.models.Email;
import com.melck.mckthymeleaf.models.enums.StatusEmail;
import com.melck.mckthymeleaf.models.user.User;
import com.melck.mckthymeleaf.repositories.EmailRepository;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public Email sendEmail(User user) {

        String name = user.getName();
        String[] firstName = name.split(" ");
        String q = firstName[0];

        Email email = new Email();
        email.setSendDateEmail(LocalDateTime.now());
        email.setEmailTo(user.getEmail());
        email.setOwnerRef(q);

        email.setSubject("Conta criada com sucesso");
        email.setText("Olá, " + q + "\n Agora você faz parte da familia MCK Clinic. Aproveite e agende sua consulta");
        email.setEmailFrom("mck.enterprises.clinic@gmail.com");
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {

            return repository.save(email);

        }
    }

}
