package pers.pengkk27.rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.pengkk27.rabbitmq.config.RabbitmqConfig;

/**
 * @author 14811
 * @Data 2022/3/1
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend(RabbitmqConfig.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    }
}
