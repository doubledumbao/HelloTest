package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerDemo {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("192.168.0.119");
        factory.setPort(5672);
        Connection connection = factory.newConnection("生产者");
        Channel channel = connection.createChannel();
        //channel.queueDeclare("first-queue", false, false, false, null);

        for (int i = 0; i < 5; i++) {
            String message = "Hello World!";
            channel.basicPublish("", "first-queue", null, message.getBytes());
            System.out.println("发送消息成功！！！");
        }

        channel.close();
        connection.close();


    }
}
