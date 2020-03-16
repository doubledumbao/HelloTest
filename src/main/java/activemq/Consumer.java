package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {
        final ConnectionFactory factory = new ActiveMQConnectionFactory();
        final Connection connection = factory.createConnection("admin","admin");
        final Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        final Destination destination =  session.createQueue("SampleQueue");
        MessageConsumer consumer = session.createConsumer(destination);
        connection.start();
        Message msg = consumer.receive();
        if (msg instanceof TextMessage){
            System.out.println(((TextMessage)msg).getText());
        }
        else{
            System.out.println(msg);
        }
        connection.close();
    }
}
