package com.example.retrospect.user.services;

import com.example.retrospect.user.dto.LoginDTO;
import com.example.retrospect.user.dto.SignUpDTO;
import com.example.retrospect.user.entity.UserEntity;
import com.example.retrospect.user.repository.IUserRepository;
import com.example.retrospect.util.UserJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Contains both signup and login methods
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    SignUpDTO signUpDTO;
    @Autowired
    UserEntity userEntity;
    @Autowired
    UserJWT userJWT;
    @Override
    public String userSignup(SignUpDTO signUpDTO) {
       String encryptedPassword=bCryptPasswordEncoder.encode(signUpDTO.getUserPassword());
       signUpDTO.setUserPassword((encryptedPassword));
       userEntity.setUserPassword(encryptedPassword);
       userEntity.setUserName(signUpDTO.getUserName());
       userEntity.setUserEmail(signUpDTO.getUserEmail());
       userEntity.setUserRole(signUpDTO.getUserRole());
       iUserRepository.save(userEntity);
        System.out.println(userEntity);
       return  "You have been signed up successfully";

    }


    @Override
    public String userLogin(LoginDTO loginDTO) {
        UserEntity userEntity = iUserRepository.findByEmailId(loginDTO.getUserEmail());
        if (userEntity != null && bCryptPasswordEncoder.matches(loginDTO.getUserPassword(), userEntity.getUserPassword())) {
            String token = userJWT.generateToken(userEntity.getUserId());
            return "login successful"+token;

        } else {
            return "login failed";
        }

    }
    @Override
    public Optional<UserEntity> getUserByJWT(String token) {
        long userId = userJWT.decodeToken(token);
        System.out.println(" service" + userId);
        return iUserRepository.findById(userId);

    }


}
