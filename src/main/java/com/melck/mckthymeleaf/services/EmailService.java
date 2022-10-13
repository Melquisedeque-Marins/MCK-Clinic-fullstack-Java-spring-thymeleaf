package com.melck.mckthymeleaf.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.melck.mckthymeleaf.models.Email;
import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.doctor.Expertise;
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
        email.setText("<h1>Olá, <style='text-transform:capitalize;'>" + q + "</h1>" 
                        + "\nAgora você faz parte da familia MCK Clinic. Aproveite e agende sua consulta. \n"
                        + "<img src='https://www.feedz.com.br/blog/wp-content/uploads/2021/10/mensagem-de-boas-vindas-para-novos-colaboradores-1.webp' alt='teste'/> ");
        email.setEmailFrom("mck.enterprises.clinic@gmail.com");
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getEmailFrom());
            helper.setTo(user.getEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getText(),true);
            helper.addAttachment("equipe.jpg", new ClassPathResource("/static/img/equipe.jpg"));
            mailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } catch (MessagingException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }
            return repository.save(email);
        
    }

    public Email sendEmailConfirmScheduling(User user, Scheduling scheduling) {

        String name = user.getName();
        String[] firstName = name.split(" ");
        String q = firstName[0];

        Set<Expertise> expertises =  scheduling.getDoctor().getExpertises();
        List<Expertise> expertise = expertises.stream().filter(exp -> exp != null).collect(Collectors.toList());
        String expertiseName = expertise.get(0).getName();
        String doctorName = scheduling.getDoctor().getName();
        String Date = scheduling.getSchedulingTime().toString().formatted("dd/MM/yyy hh:mm");


        Email email = new Email();
        email.setSendDateEmail(LocalDateTime.now());
        email.setEmailTo(user.getEmail());
        email.setOwnerRef(q);

        email.setSubject("Consulta agendada com sucesso");
        email.setText("<h1> hello </h1>" + "Olá, " + q + "\nA sua consulta foi agendada com sucesso!\n" + "Especialidade: " + expertiseName + "\nDoctor: " + doctorName + "\nHorario: " + Date + "\nhttps://hospitalauxiliadora.com.br/wp-content/uploads/2015/03/agendamento-01.png");
        
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
        } 
            return repository.save(email);
    }

}
