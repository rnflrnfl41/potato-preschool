package potato.study.lec03study.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import potato.study.lec03study.controller.UserDto;
import potato.study.lec03study.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void createTest() {
        service.createUser(new UserDto("김한빈","rnflrnfl41@naver.com","1234","1234"));
    }

    @Test
    void createTest2() {
        service.createUser(new UserDto("정수빈","aa9841@naver.com","1234","1234"));
    }

    @Test
    void updateTest() {
        service.update(102L, new UserDto("김길동","rnflrnfl41@naver.com","1234","1234"));
    }

    @Test
    void readOneTest() {
        User user = service.readOne(102L)
                .orElse(null);
        System.out.println("readOne result: " + user.toString());
    }

    @Test
    void readAllTest() {
        List<User> userList = service.readAll();
        System.out.println(userList);
    }

    @Test
    void deleteTest() {service.delete(102L);}

    @Test
    void deleteAllTest() {
        service.deleteAll();
    }

}