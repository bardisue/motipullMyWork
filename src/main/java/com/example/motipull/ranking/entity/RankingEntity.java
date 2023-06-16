package com.example.motipull.ranking.entity;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
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
@Table(name = "ranking")
public class RankingEntity {

    @Id
    private String memberName;

    @Column
    private Integer rankingPoint;

    public RankingEntity(String memberName, Integer rankingPoint) {
        this.memberName = memberName;
        this.rankingPoint = rankingPoint;
    }
    public static MemberEntity toEntity(MemberDto dto) {
        return new MemberEntity(dto.getMemberId(), dto.getMemberName());
    }
}
