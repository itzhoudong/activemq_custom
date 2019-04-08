package com.example.producer;

import com.example.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 * 生产者1
 */
@Slf4j
@Component
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String uuid, Object message) {
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY2, message, correlationId);

    }
}
