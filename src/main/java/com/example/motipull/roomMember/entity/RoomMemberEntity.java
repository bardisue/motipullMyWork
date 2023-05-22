package com.example.motipull.roomMember.entity;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.entity.Room;
import com.example.motipull.room.service.RoomService;
import com.example.motipull.roomMember.dto.RoomMemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room_member")
public class RoomMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public static RoomMemberEntity toEntity(Room room, MemberEntity member) {
        RoomMemberEntity roomMemberEntity = new RoomMemberEntity();
        roomMemberEntity.orderRoom(room);
        //roomMemberEntity.orderRoom(Room.toEntity(dto.getRoom()));
        roomMemberEntity.orderMember(member);
        return roomMemberEntity;
    }


    public void orderRoom(Room room){
        if(room.getRoomMemberList().contains(this)){
            room.getRoomMemberList().remove(this);
        }

        this.room = room;
        room.getRoomMemberList().add(this);

    }

    public void orderMember(MemberEntity member){
        this.member = member;
    }
}