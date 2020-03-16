public class RandomDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            double random = Math.random()*10000;
            System.out.println(random);
        }

    }
}
