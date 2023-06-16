package com.example.motipull.ranking.dto;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.ranking.entity.RankingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RankingDto {
    private String memberName;
    private Integer rankingPoint;
    public static RankingDto toDto(RankingEntity ranking){
        return new RankingDto(ranking.getMemberName(), ranking.getRankingPoint());
    }
}
