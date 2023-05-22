package com.example.motipull.room.dto;

import com.example.motipull.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomDto {
    private int roomID;
    private String roomName;
    private int roomAdmin;
    public static RoomDto toDto(Room room){
        return new RoomDto(room.getRoomId(), room.getRoomName(), room.getRoomAdmin());
    }
}
