package potato.study.lec03study.controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String email;
    private String passwd;
    private String passwdConfirm;



}
