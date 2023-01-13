package potato.study.lec03study.lec5_bean_study.sec2.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import potato.study.lec03study.lec5_bean_study.sec1.Person;

@Component
public class PersonService {

    @Autowired
    private AgeService ageService;

    @Autowired
    private NameService nameService;

    public Person getPerson1() {
        return new Person(nameService.getNameFromDatabase1(), ageService.getAgeFromDatabase1());
    }

    public Person getPerson2() {
        return new Person(nameService.getNameFromDatabase2(), ageService.getAgeFromDatabase2());
    }



}
