package potato.study.lec03study.lec5_bean_study.sec2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import potato.study.lec03study.lec5_bean_study.sec2.person.PersonService;

@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    private PersonService personService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(personService.getPerson1());
        System.out.println(personService.getPerson2());
    }
}
