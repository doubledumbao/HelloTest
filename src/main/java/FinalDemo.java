public class FinalDemo {
    public final Object object = new Object();
    public final int a = 2;

    public void hello(){
        System.out.println("hello");
    }

    public void world(){
        System.out.println("world");
    }

}
class FinalImpl extends FinalDemo{

    @Override
    public void world(){

    }
}
