package com.example.retrospect.user.controller;

import com.example.retrospect.user.entity.RoomEntity;
import com.example.retrospect.user.repository.IRoomRepository;
import com.example.retrospect.user.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    IRoomService iRoomService;
    @Autowired
    IRoomRepository iRoomRepository;

    @GetMapping("/rooms")  // common for all users
    public List<RoomEntity>displayRooms(){
        return iRoomRepository.findAll();
    }

    @PostMapping("/createRoom")
    public void createRoom(@RequestBody RoomEntity room){

    }

    @DeleteMapping("/deleteRoom/{roomId}")
    public RoomEntity deleteRoom(@PathVariable long roomId){
       return iRoomService.deleteRoom(roomId);

    }


    @PutMapping("/updateRoom/{roomId}")
    public RoomEntity updateRoom(@PathVariable long roomId, @RequestBody RoomEntity updatedRoomEntity){
        return iRoomService.updateRoom(roomId, updatedRoomEntity);
    }
}
