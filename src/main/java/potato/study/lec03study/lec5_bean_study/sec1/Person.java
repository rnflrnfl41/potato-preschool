package potato.study.lec03study.lec5_bean_study.sec1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Person {

    private final String name;
    private final int age;
}
