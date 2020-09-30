package com.softwarefoundation.fooddeliverycadastroapi.config;

import lombok.var;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder.directExchange(exchange)
                .durable(true)
                .build();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    //------------------------------------------------------------

//
//    @Value("${cadastro.client.rabbitmq.queue}")
//    String queueName;
//
//    @Value("${cadastro.rabbitmq.routingkey}")
//    private String routingkey;
//
//    @Bean
//    Queue queue() {
//        return QueueBuilder.nonDurable(queueName).build();
//    }
//
//    @Bean
//    @Autowired
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
//    }
//
//    @Bean
//    public MessageConverter producerJackson2MessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    @Autowired
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//        return rabbitTemplate;
//    }



}
