package potato.study.lec03study.lec5_bean_study.sec1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class TestConfiguration {

    /*
    메소드를 Bean 등록해서 사용할수도 있다
    class 를 Bean 등록할때는 @Component
    메소드를 등록할때는 @Bean

    메인에서 @bean 되어있는 메서드를 사용하기 위해선
    var context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    이런식으로 클래스를 Context안에 넣어줘야한다.

    @Primary란? 같은 return타입을 가지는 @Bean 메서드가 여러가지일때 default값을 설정해주는 어노테이션이다.
    예) main에서 var name = context.getBean(String.class); 이런식으로 호출했을 때
        이 메서드가 저장되어 있는 클래스 안에 리턴타입이 String 인 Bean메서드가 여러 개일 경우 Spring은 그중에 어떤것을 쓸지 모른다.
        하지만 @Primary를 설정해 주면 이값을 기본값으로 쓰인다.

    @Qualifier란? @Primary와 같은 설정이 되어있을 경우 default값은 @Primary 어노테이션이 붙어있는 메서드를 사용하는대
                  @Primary가 붙은 메서드 이외에 같은 리턴 타입을 가지는 다른 Bean 메서드를 사용하고 싶을 때 사용한다.
    예) @Bean
        public Person personParam2(@Qualifier("name2") String a, int i) { return new Person(a,i); }
        @Bean 메서드를 만들때 이런식으로 parameter값 안에 어노테이션을 넣어준다.
     */

    @Bean
    @Primary
    public String name() {
        return "name1";
    }

    @Bean
    public int age() {
        return 26;
    }

    @Bean
    public Person person1() {
        return new Person("kim",50);
    }

    @Bean
    public Person person2() {
        return new Person(name(), age());
    }

    @Bean
    public Person personParam(String a, int i) {
        return new Person(a,i-10);
    }

    @Bean
    public Person personParam2(@Qualifier("name2") String a, int i) {
        return new Person(a,i);
    }

    @Bean
    public String name2() {
        return "name2";
    }
}
