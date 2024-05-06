package com.example.retrospect.createchatroom.controller;

import com.example.retrospect.createchatroom.entity.CreateRoomEntity;
import com.example.retrospect.createchatroom.repository.IRoomRepository;
import com.example.retrospect.createchatroom.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")

public class Roomcontroller {
    @Autowired
    IRoomService iRoomService;

    @Autowired
    IRoomRepository iRoomRepository;

    @GetMapping("/rooms")
    List<CreateRoomEntity> getAllRooms(){
        return iRoomService.getAllRooms();
    }


    @PostMapping("/addrooms")

    CreateRoomEntity createRoom(@RequestBody CreateRoomEntity createRoomEntity){
        return iRoomService.createRoom(createRoomEntity);
    }

    @PutMapping("/updateRoom/{roomId}")
    public CreateRoomEntity updateRoom(@PathVariable long roomId, @RequestBody CreateRoomEntity updatedRoomEntity){
        return iRoomService.updateRoom(roomId, updatedRoomEntity);
    }
}
