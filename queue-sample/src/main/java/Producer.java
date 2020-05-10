import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination destination;

    public void send() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(finalI + " - hello world");
                }
            });
            Thread.sleep(2000);
        }
    }
}
