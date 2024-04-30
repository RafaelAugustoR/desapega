package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(EmailRequestDTO request){

        var message = new SimpleMailMessage();

        message.setFrom("noreply@gmail.com");
        message.setTo(request.getRecipient());
        message.setSubject("Mensagem de teste");
        message.setText(request.getMessage());

        mailSender.send(message);

    }
}
