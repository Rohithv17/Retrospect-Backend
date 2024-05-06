package com.example.retrospect.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ChangePasswordDTO {
    String userEmail;
    String userOtp;
    String userNewPassword;
}
