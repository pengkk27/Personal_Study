package pers.pengkk27.rabbitmqhelloworld;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.pengkk27.rabbitmqhelloworld.tut1.Tut1Receiver;
import pers.pengkk27.rabbitmqhelloworld.tut1.Tut1Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitmqHelloworldApplicationTests {

    @Test
    public void rabbitTest() {
        Tut1Sender sender = new Tut1Sender();
        sender.send();

    }

}
