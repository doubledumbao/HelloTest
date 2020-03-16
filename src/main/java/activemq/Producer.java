package activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) throws JMSException {
        final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        final Connection connection = connectionFactory.createConnection("admin","admin");
        final Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        final Destination destination = session.createQueue("SampleQueue");
        final MessageProducer producer = session.createProducer(destination);
        final Message msg = session.createTextMessage("Sample four message");
        producer.send(msg);
        connection.close();
    }
}
