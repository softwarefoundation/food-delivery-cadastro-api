package com.softwarefoundation.fooddeliverycadastroapi.mensagens;

import com.softwarefoundation.fooddeliverycadastroapi.dto.ClientePedidoDto;
import com.softwarefoundation.fooddeliverycadastroapi.dto.PedidoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.client.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ClientePedidoDto dto) {
        log.info(dto.toString());
        log.info(exchange.toString());
        log.info(routingkey.toString());
        rabbitTemplate.convertAndSend(exchange, routingkey, dto);
    }

}
