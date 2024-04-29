package com.example.retrospect.user.repository;

import com.example.retrospect.user.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<RoomEntity,Long> {

}
