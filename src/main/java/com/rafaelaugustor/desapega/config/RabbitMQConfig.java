package com.rafaelaugustor.desapega.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.email-confirmation}")
    private String queueEmailConfirmation;

    @Value("${spring.rabbitmq.queue.password-reset}")
    private String queuePasswordReset;

    @Bean
    public Queue queueEmailConfirmation() {
        return new Queue(queueEmailConfirmation, true);
    }

    @Bean
    public Queue queuePasswordReset() {
        return new Queue(queuePasswordReset, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
