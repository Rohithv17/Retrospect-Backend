package com.example.retrospect.user.controller;

import com.example.retrospect.user.dto.*;
import com.example.retrospect.user.entity.UserEntity;
import com.example.retrospect.user.repository.IUserRepository;
import com.example.retrospect.user.service.IUserService;
import com.example.retrospect.user.service.UserService;
import com.example.retrospect.util.ForgotPassword;
import com.example.retrospect.util.UserJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserJWT userJWT;
    @Autowired
    ResetPasswordDTO resetPasswordDTO;
    @Autowired
    ForgotPassword forgot;
    @PostMapping("/signup")
    public String userSignup(@RequestBody SignUpDTO signUpDTO) {
        return userService.userSignup(signUpDTO);

    }
    @PostMapping("/login")
    public String UserLogin(@RequestBody LoginDTO loginDTO) {
        return userService.Userlogin(loginDTO);

    }
    @GetMapping("/getbyJWT")
    public Optional<UserEntity> getUserByJWT(@RequestHeader String token) {
        return userService.getUserByJWT(token);
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser (@PathVariable int id, @RequestBody UpdateUserDTO userEntity) {
        return userService.updateUser(id,userEntity);
    }

    @PostMapping("/resetpassword")
    public String resetPassword (@RequestBody ResetPasswordDTO resetPassword) {
        return userService.resetPassword(resetPassword.getUserEmail(), resetPassword.getOldPassword(), resetPassword.getNewPassword());

    }

    @PostMapping("/forgot")
    String forgetPassword(@RequestBody ForgotPasswordDTO request){
        return userService.forgotPassword(request.getUserEmail());
    }
    @PostMapping("/change")
    String changePassword(@RequestBody ChangePasswordDTO change){
        return userService.changePassword(change.getUserEmail(),change.getUserOtp(),change.getUserNewPassword());
    }

}
