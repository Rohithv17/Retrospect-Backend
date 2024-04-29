package com.example.retrospect.user.controller;

import com.example.retrospect.user.dto.LoginDTO;
import com.example.retrospect.user.dto.SignUpDTO;
import com.example.retrospect.user.services.IUserService;
import com.example.retrospect.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// Contains both signup and login controllers
@RestController
@ResponseStatus(HttpStatus.OK)
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    UserService userService;
    @PostMapping("/Registration")
    public String userSignup(@RequestBody SignUpDTO signUpDTO){
        System.out.println(signUpDTO);
        return iUserService.userSignup(signUpDTO);

    }
    @PostMapping("/Login")
    public String UserLogin(@RequestBody LoginDTO loginDTO) {
        return iUserService.userLogin(loginDTO);

    }

}
