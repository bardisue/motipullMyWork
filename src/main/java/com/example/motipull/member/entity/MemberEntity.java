package com.example.motipull.member.entity;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberID;

    @Column
    private String memberName;

    public static MemberEntity toEntity(MemberDto dto) {
        return new MemberEntity(dto.getMemberId(), dto.getMemberName());
    }

    public MemberEntity(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }


}