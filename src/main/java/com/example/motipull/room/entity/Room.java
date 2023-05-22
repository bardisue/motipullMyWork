package com.example.motipull.room.entity;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;

import javax.persistence.*;

import com.example.motipull.roomMember.entity.RoomMemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;

    @Column
    private String roomName;

    @Column
    private int roomAdmin;

    @OneToMany(mappedBy = "room")
    private List<RoomMemberEntity> roomMemberList = new ArrayList<>();


    public static Room toEntity(RoomDto dto) {
        return new Room(dto.getRoomID(), dto.getRoomName(), dto.getRoomAdmin());
    }

    public Room(int roomId, String roomName, int roomAdmin) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomAdmin = roomAdmin;
    }
}