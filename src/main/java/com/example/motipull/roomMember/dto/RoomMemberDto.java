package com.example.motipull.roomMember.dto;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomMemberDto {
    private int id;
    private int memberId;
    private int roomId;
    /***
    public static RoomMemberDto toDto(RoomMemberEntity roomMember){
        return new RoomMemberDto(roomMember.getId(), .toDto(roomMember.getMember()), RoomDto.toDto(roomMember.getRoom()));
    }
     ***/
}
