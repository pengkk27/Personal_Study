package pers.pengkk27.rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author 14811
 * @Data 2022/2/28
 */
@Component
@RabbitListener(queues = "spring-boot")
public class Receiver {

    @RabbitHandler
    public void received(String message) {
        System.out.println(message);
    }
}
