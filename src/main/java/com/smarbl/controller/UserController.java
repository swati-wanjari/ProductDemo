package com.smarbl.controller;

import com.smarbl.api.GenericResponse;
import com.smarbl.entity.LoginCredentials;
import com.smarbl.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @PostMapping("/login")
    public GenericResponse Login(@RequestBody User user) {
        String userId = user.getEmail();
        String password = user.getPassword();
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setMessage(" Login");

        if (userId.equals(LoginCredentials.USER1.getLoginId()) && password.equals(LoginCredentials.USER1.getPassword())) {
            genericResponse.setData("Successfully Login");
            genericResponse.setStatus(HttpStatus.OK.toString());
        } else {
            genericResponse.setData("Login Failed");
            genericResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
        return genericResponse;
    }
}
