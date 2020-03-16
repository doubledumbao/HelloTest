package singleton;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        Process exec = runtime.exec("ps -ef | grep java");
        InputStream inputStream = exec.getInputStream();
    }
}
