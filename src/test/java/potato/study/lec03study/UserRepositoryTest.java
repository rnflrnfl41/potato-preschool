package potato.study.lec03study;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import potato.study.lec03study.entity.User;
import potato.study.lec03study.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void createTest() {
        User user = new User();
        user.setName("김한빈");
        user.setEmail("rnflrnfl41@naver.com");
        user.setPasswd("1234");

        User user2 = new User();
        user.setName("김");
        user.setEmail("rnflrnfl41@naver.com");
        user.setPasswd("1234");

        User savedUser = repository.save(user2);


        assertThat(savedUser.getName()).isEqualTo(user.getName());

    }


}
