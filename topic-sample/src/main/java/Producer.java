import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination destination;

    public void send() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            jmsTemplate.send(destination, session -> {
                return session.createTextMessage(finalI + " - hello world");
            });
            Thread.sleep(2000);
        }
    }
}
