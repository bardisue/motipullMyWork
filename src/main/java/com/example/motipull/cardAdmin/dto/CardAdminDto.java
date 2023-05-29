package com.example.motipull.cardAdmin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardAdminDto {
    private Integer id;
    private Integer cardId;
    private Integer memberId;
    /***
     public static RoomMemberDto toDto(RoomMemberEntity roomMember){
     return new RoomMemberDto(roomMember.getId(), .toDto(roomMember.getMember()), RoomDto.toDto(roomMember.getRoom()));
     }
     ***/
}
