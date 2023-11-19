package com.smarbl.controller;

import com.smarbl.entity.LoginCredentials;
import com.smarbl.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UserController {

    @PostMapping("/login")
    public String Login(@RequestBody User user) {
        String userId = user.getEmail();
        String password = user.getPassword();

        if (userId.equals(LoginCredentials.USER1.getLoginId()) && password.equals(LoginCredentials.USER1.getPassword())) {
            return "Successfully Login";
        } else {
            return "Failed";
        }
    }
}
