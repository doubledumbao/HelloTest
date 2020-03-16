
public class Animal {

    private String name;

    public Animal(){
        System.out.println("Animal construct");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal construct "+name);
    }

    public void bellow(){
        System.out.println("animal bellow");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



class Dog extends  Animal{

    public Dog() {
        System.out.println("Dog construct");
    }

    public Dog(String name) {
        //super(name);
        System.out.println("Dog construct "+name);
    }

    @Override
    public void bellow(){
        System.out.println("dog bellow");
    }

    public String hello(){
        try{
            return "hello";
        }finally {
            return "world";
        }
    }
}
class Cat extends  Animal{
    @Override
    public void bellow() {
        System.out.println("cat bellow");
    }
}
class Test{
    public static void main(String[] args) {
        Dog animal = new Dog("jinmao");
        animal.bellow();
        //System.out.println(animal.hello());
    }
}


