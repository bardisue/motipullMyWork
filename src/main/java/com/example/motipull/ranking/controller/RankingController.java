package com.example.motipull.ranking.controller;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.dto.MemberIdDto;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.ranking.dto.RankingDto;
import com.example.motipull.ranking.entity.RankingEntity;
import com.example.motipull.ranking.service.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }


    @PostMapping("/ranking/plusPoint")
    @ResponseBody
    public ResponseEntity plusPoint(@RequestBody RankingDto dto) {
        rankingService.changeRanking(dto.getMemberName());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/ranking/getPoints")
    @ResponseBody
    public ResponseEntity getPoints() {
        return ResponseEntity.status(HttpStatus.OK).body(rankingService.getPoints());
    }
}
