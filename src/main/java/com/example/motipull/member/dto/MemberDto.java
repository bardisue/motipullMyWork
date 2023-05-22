package com.example.motipull.member.dto;

import com.example.motipull.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {
    private int memberId;
    private String memberName;
    public static MemberDto toDto(MemberEntity member){
        return new MemberDto(member.getMemberID(), member.getMemberName());
    }
}
