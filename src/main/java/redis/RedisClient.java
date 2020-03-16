package redis;



import java.io.*;
import java.net.Socket;

/**
 * @author doubledumbao
 */
public class RedisClient {

    public static final String RET_STR = "\r\n";
    InputStream reader = null;
    OutputStream writer = null;

    public RedisClient(String host,int port) throws IOException {
        Socket socket = new Socket(host,port);
        reader = socket.getInputStream();
        writer = socket.getOutputStream();
    }

    public void set(String key,String value) throws IOException {
        System.out.println("set method start");
        StringBuilder builder = new StringBuilder();
        builder.append("*3").append(RET_STR);
        builder.append("$3").append(RET_STR);
        builder.append("SET").append(RET_STR);
        builder.append("$").append(key.getBytes().length).append(RET_STR);
        builder.append(key).append(RET_STR);
        builder.append("$").append(value.getBytes().length).append(RET_STR);
        builder.append(value).append(RET_STR);
        System.out.println(builder.toString());
        writer.write(builder.toString().getBytes());
        writer.flush();
        byte[] response = new byte[1024];
        reader.read(response);
        System.out.println(new String(response));
        System.out.println("set method end");
    }

    public void get(String key) throws IOException {
        System.out.println("get method start");
        StringBuilder sb = new StringBuilder();
        sb.append("*2").append(RET_STR);
        sb.append("$").append(("GET").getBytes().length).append(RET_STR);
        sb.append("GET").append(RET_STR);
        sb.append("$").append(key.getBytes().length).append(RET_STR);
        sb.append(key).append(RET_STR);
        System.out.println(sb.toString());
        writer.write(sb.toString().getBytes());
        writer.flush();
        byte[] response = new byte[1024];
        reader.read(response);
        String st = new String(response);
        //System.out.println("st:"+st);
        String[] split = st.split(RET_STR);
        System.out.println(split[1]);
    }


    public static void main(String[] args) throws IOException {
        RedisClient client = new RedisClient("127.0.0.1",6379);
        //client.set("wuhan","yiqing");
        client.get("wuhan");
    }

}
