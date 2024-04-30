package com.example.retrospect.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;
@Entity
@Data
@Table(name="room_table")
public class RoomEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;
    @Column
    private String roomName;
    @Column
    private String roomDescription;
    @Column
    private String roomStatus;
    @Column
    private String roomStartDate;
    @Column
    private String roomEndDate;
    @Column
    private String roomImage;



}
