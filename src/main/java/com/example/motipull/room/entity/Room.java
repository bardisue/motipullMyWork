package com.example.motipull.room.entity;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.dto.RoomDto;

import javax.persistence.*;

import com.example.motipull.roomMember.entity.RoomMemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    @OneToMany(mappedBy = "room")
    private List<RoomMemberEntity> roomMemberList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity roomAdmin;


    public static Room toEntity(RoomDto dto, MemberEntity member) {
        return new Room(dto.getRoomId().intValue(), dto.getRoomName(), member);
    }

    public Room(int roomId, String roomName, MemberEntity member) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomAdmin = member;
    }
}
