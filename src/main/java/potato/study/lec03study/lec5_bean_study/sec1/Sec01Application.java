package potato.study.lec03study.lec5_bean_study.sec1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Sec01Application {

    /*
     main에서 Bean객체(메서드)를 불러올 때 var context = new AnnotationConfigApplicationContext(TestConfiguration.class);
     이런식으로 Bean이 들어있는 클래스를 컨테이너에 담아 가져와서 안에있는것들(Bean)을 꺼내 올수 있다.
     */

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        var name = context.getBean(String.class);
        var age = context.getBean(int.class);
        System.out.println("name : " + name);
        System.out.println("age : " + age);

        var person1 = context.getBean("person1",Person.class);
        var person2 = context.getBean("person2",Person.class);
        System.out.println(person1);
        System.out.println(person2);

        var person3 = context.getBean("personParam", Person.class);
        var person4 = context.getBean("personParam2", Person.class);
        System.out.println(person3);
        System.out.println(person4);

    }

}
