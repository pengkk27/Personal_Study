package pers.pengkk27.rabbitmqhelloworld.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 14811
 * @Data 2022/3/1
 */
@Configuration
public class Tut1Config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Tut1Receiver receiver() {
        return new Tut1Receiver();
    }

    @Bean
    public Tut1Sender sender() {
        return new Tut1Sender();
    }

}
