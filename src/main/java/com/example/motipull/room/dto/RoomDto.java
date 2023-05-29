package com.example.motipull.room.dto;

import com.example.motipull.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomDto {
    private Integer roomId;
    private String roomName;
    private Integer roomAdmin;
    public static RoomDto toDto(Room room){
        return new RoomDto(room.getRoomId(), room.getRoomName(), room.getRoomAdmin().getMemberID());
    }
}
