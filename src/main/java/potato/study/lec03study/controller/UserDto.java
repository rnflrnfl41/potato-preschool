package potato.study.lec03study.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private String passwd;
    private String passwdConfirm;

}
