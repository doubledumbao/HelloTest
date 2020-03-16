public abstract class AbstractBird extends Animal{


    public abstract  void world();

    @Override
    public void bellow() {
        System.out.println("bird bellow");
    }
}

class Chicken extends  AbstractBird{

    @Override
    public void world() {
        System.out.println("Chicken wold");
    }
}
