package pers.pengkk27.rabbitmqhelloworld.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 14811
 * @Data 2022/3/1
 */
public class Tut1Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send() {
        String message = "Hello World!";
        template.convertAndSend(queue.getName(), message);
        System.out.println("[x] Sent '" + message + "'");
    }

}
