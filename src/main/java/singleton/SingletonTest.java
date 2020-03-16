package singleton;

public class SingletonTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Singleton2 singleton2 = Singleton2.getInstance();
            System.out.println(singleton2);
        }

        for (int i = 0; i < 10; i++) {
            Singleton1 singleton1 = Singleton1.getInstance();
            System.out.println(singleton1);
        }

    }

}
