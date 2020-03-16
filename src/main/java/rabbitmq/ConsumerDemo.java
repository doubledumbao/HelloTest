package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;


public class ConsumerDemo {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("192.168.0.119");
        factory.setPort(5672);

        Connection connection = factory.newConnection("消费者");

        Channel channel = connection.createChannel();
        String queueName = "first-queue";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.basicQos(0,1,false);

        channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag:" + consumerTag);
                System.out.println("DeliveryTag:" + envelope.getDeliveryTag());
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });


    }
}
