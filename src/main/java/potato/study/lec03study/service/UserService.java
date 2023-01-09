package potato.study.lec03study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import potato.study.lec03study.controller.UserDto;
import potato.study.lec03study.entity.User;
import potato.study.lec03study.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public int createUser(UserDto user) {

        int result = 200;

        if(repository.existsByEmail(user.getEmail())) {
            result = 300;
        }

        if(!user.getPasswd().equals(user.getPasswdConfirm())){
            result = 400;
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPasswd(user.getPasswd());
        repository.save(newUser);
        return result;

    }

    public void update(Long id, UserDto user) {
        Optional<User> findUser = readOne(id);

        if(findUser.isPresent()) {
            User updatedUser = findUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setPasswd(user.getPasswd());
            updatedUser.setEmail(user.getEmail());
            repository.save(updatedUser);
        }else {
            throw new IllegalArgumentException("500");
        }

    }

    public void delete(Long id) {
        Optional<User> aUser = readOne(id);
        if(aUser.isPresent()) {
            repository.delete(aUser.get());
        }
    }

    public Optional<User> readOne(Long id) {
        return repository.findById(id);
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }


}
