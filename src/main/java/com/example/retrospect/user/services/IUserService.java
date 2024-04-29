package com.example.retrospect.user.services;

import com.example.retrospect.user.dto.SignUpDTO;
import com.example.retrospect.user.dto.LoginDTO;
import com.example.retrospect.user.entity.UserEntity;

import java.util.Optional;

public interface IUserService {

    String userSignup(SignUpDTO signUpDTO);
    String userLogin(LoginDTO loginDTO);
    Optional<UserEntity> getUserByJWT(String token);
}
