package javaeight;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {

    public static void main(String[] args) {

        Student student1 = new Student(1,"zhangsan");
        Student student2 = new Student(2,"lisi");
        Student student3 = new Student(3,"wangwu");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.forEach(HelloService::print);
    }

}
