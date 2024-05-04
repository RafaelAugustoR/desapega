package com.rafaelaugustor.desapega.broker.producers;

import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue.email-confirmation}")
    private String emailConfirmationQueue;

    public void sendConfirmationEmail(EmailRequestDTO emailRequest) {
        rabbitTemplate.convertAndSend(emailConfirmationQueue, emailRequest);
    }
}
