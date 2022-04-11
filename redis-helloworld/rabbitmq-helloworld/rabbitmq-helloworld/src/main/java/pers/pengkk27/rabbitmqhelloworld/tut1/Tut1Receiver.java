package pers.pengkk27.rabbitmqhelloworld.tut1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author 14811
 * @Data 2022/3/1
 */
@RabbitListener(queues = "hello")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println("[x] Received '" + in + "'");
    }
}
