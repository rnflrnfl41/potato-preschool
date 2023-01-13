package potato.study.lec03study.lec5_bean_study.sec2.person;

import org.springframework.stereotype.Component;

@Component
public class AgeService {

    public int getAgeFromDatabase1() {
        return 26;
    }

    public int getAgeFromDatabase2() {
        return 30;
    }

}
