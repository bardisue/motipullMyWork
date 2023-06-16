package com.example.motipull.ranking.service;

import com.example.motipull.cardClass.entity.CardClassEntity;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.repository.MemberRepository;
import com.example.motipull.ranking.entity.RankingEntity;
import com.example.motipull.ranking.repository.RankingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    @Autowired
    public RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    public void changeRanking(String memberName) {
        if (rankingRepository.findById(memberName).isEmpty()) {
            RankingEntity newRanking = new RankingEntity(memberName, 1);
            rankingRepository.save(newRanking);
        }
        else{
            RankingEntity ranking = rankingRepository.findById(memberName).get();
            ranking.setRankingPoint(ranking.getRankingPoint() + 1);
            rankingRepository.save(ranking);
        }
    }

    public Map<String, Integer> getPoints() {
        List<RankingEntity> list = rankingRepository.findAll();
        Map<String, Integer> returnMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            returnMap.put(list.get(i).getMemberName(), list.get(i).getRankingPoint());
        }
        return returnMap;
    }
}
