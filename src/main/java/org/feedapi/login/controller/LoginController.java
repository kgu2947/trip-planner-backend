package org.feedapi.login.controller;

import org.feedapi.login.dto.LoginDTO;
import org.feedapi.login.dto.LoginDataDTO;
import org.feedapi.login.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/tryLogin")
    public LoginDataDTO tryLogin(@RequestBody LoginDTO loginDTO){
        return loginService.tryLogin(loginDTO);
    }

}
