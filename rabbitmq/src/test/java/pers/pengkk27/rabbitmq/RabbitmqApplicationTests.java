package pers.pengkk27.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.pengkk27.rabbitmq.config.RabbitmqConfig;
import pers.pengkk27.rabbitmq.rabbitmq.Receiver;
import pers.pengkk27.rabbitmq.rabbitmq.Sender;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() {
        sender.send();
    }

}
