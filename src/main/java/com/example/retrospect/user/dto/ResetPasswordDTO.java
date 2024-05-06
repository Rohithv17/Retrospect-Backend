package com.example.retrospect.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResetPasswordDTO {
    String userEmail;
    String oldPassword;
    String newPassword;
}
