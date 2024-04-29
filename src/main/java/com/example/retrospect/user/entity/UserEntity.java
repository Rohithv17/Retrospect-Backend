package com.example.retrospect.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@Table(name = "userTable")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
   private long userId;
    @Column
   private String userName;
    @Column
    private String userEmail;
    @Column
   private String userPassword;
    @Column
    private String userRole;

}
