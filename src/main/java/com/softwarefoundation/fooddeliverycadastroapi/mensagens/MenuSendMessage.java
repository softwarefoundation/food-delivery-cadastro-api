package com.softwarefoundation.fooddeliverycadastroapi.mensagens;

import com.softwarefoundation.fooddeliverycadastroapi.dto.MenuPedidoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MenuSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.menu.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MenuSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MenuPedidoDto dto) {
        log.info(dto.toString());
        log.info(exchange);
        log.info(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, dto);
    }

}
