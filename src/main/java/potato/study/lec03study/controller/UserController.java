package potato.study.lec03study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import potato.study.lec03study.entity.User;
import potato.study.lec03study.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    private void create(@RequestBody UserDto requestUser){service.createUser(requestUser);}

    @PutMapping("{id}")
    private void update(@PathVariable Long id, @RequestBody UserDto requestedUser) {
        service.Update(id, requestedUser);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("{id}")
    private User readOne(@PathVariable Long id) {
        return service.readOne(id)
                .orElse(null);
    }

    @GetMapping
    private List<User> readAll() {
        return service.readAll();
    }



}
