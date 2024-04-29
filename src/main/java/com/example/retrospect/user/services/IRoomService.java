package com.example.retrospect.user.services;

import com.example.retrospect.user.entity.RoomEntity;

import java.util.List;

public interface IRoomService {
  public List<RoomEntity> displayRooms();
  public void createRoom(RoomEntity room);
  public RoomEntity deleteRoom(long  roomId);
  public RoomEntity updateRoom(long  roomId, RoomEntity updatedRoomEntity);
}
