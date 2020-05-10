import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 消费者监听器
 */
public class ConsumerListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("接受消息：" + ((ActiveMQTextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
