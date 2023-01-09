package potato.study.lec03study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import potato.study.lec03study.entity.User;
import potato.study.lec03study.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    private User create(@RequestBody UserDto requestUser){return service.createUser(requestUser);}

    @PutMapping("{id}")
    private void update(@PathVariable Long id, @RequestBody UserDto requestedUser) {
        service.update(id, requestedUser);
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

    @GetMapping("/join")
    public ModelAndView join() throws Exception{
        ModelAndView view = new ModelAndView();
        view.setViewName("views/join");
        return view;
    }



}
