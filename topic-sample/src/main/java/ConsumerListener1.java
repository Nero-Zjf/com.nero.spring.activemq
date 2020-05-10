import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 消费者监听器1
 */
public class ConsumerListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Consumer - 1 接受消息：" + ((ActiveMQTextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
