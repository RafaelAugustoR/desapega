package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(EmailRequestDTO request){

        var message = new SimpleMailMessage();

        message.setFrom("desapega.noreply@gmail.com");
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getText());

        mailSender.send(message);

    }
}
