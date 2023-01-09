package potato.study.lec03study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import potato.study.lec03study.entity.User;
import potato.study.lec03study.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public Map<String, Object> create(@RequestBody UserDto requestUser){
        Map<String, Object> resultMap = new HashMap<>();
        int result = service.createUser(requestUser);
        resultMap.put("result",result);
        return resultMap;}

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
