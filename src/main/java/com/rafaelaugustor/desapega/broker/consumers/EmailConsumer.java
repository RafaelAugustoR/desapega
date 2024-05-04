package com.rafaelaugustor.desapega.broker.consumers;

import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import com.rafaelaugustor.desapega.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.email-confirmation}")
    public void listen(@Payload EmailRequestDTO request){
        emailService.sendEmail(request);
    }

}
