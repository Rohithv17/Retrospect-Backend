package com.example.retrospect.user.services;

import com.example.retrospect.user.entity.RoomEntity;
import com.example.retrospect.user.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoomService implements IRoomService{

    @Autowired
    IRoomRepository iRoomRepository;

    @Override
    public List<RoomEntity> displayRooms() {
       return iRoomRepository.findAll();
    }

// Only admins are alllowed to create rooms
    public void createRoom(RoomEntity roomEntity) {

            iRoomRepository.save(roomEntity);
        }


    //  Deletes room by id
    public RoomEntity deleteRoom(long roomId ) {

        Optional<RoomEntity>optionalRoomEntity = iRoomRepository.findById(roomId);
        if(optionalRoomEntity.isPresent()){
            RoomEntity roomEntity=optionalRoomEntity.get();
            iRoomRepository.delete(roomEntity);
            return roomEntity;
        }
        else {
            throw  new NoSuchElementException("Room with id "+roomId+" not found");
        }}





    public RoomEntity updateRoom(long roomId, RoomEntity updatedRoomEntity) {

        Optional<RoomEntity>optionalRoomEntity = iRoomRepository.findById(roomId);
        if(optionalRoomEntity.isPresent()){
            RoomEntity roomEntity=optionalRoomEntity.get();


            roomEntity.setRoomName(updatedRoomEntity.getRoomName());
            roomEntity.setRoomDescription(updatedRoomEntity.getRoomDescription());
            roomEntity.setRoomStartDate(updatedRoomEntity.getRoomStartDate());
            roomEntity.setRoomStatus(updatedRoomEntity.getRoomStatus());
            roomEntity.setRoomEndDate(updatedRoomEntity.getRoomEndDate());
            roomEntity.setRoomImage(updatedRoomEntity.getRoomImage());

            return iRoomRepository.save(roomEntity);
        }
        else {
            throw  new NoSuchElementException("Room with id "+roomId+" not found");
        }}
    }

