package potato.study.lec03study.lec5_bean_study.sec2.person;

import org.springframework.stereotype.Component;

@Component
public class NameService {

    public String getNameFromDatabase1() { return "han"; }

    public String getNameFromDatabase2() { return "bin"; }
}
