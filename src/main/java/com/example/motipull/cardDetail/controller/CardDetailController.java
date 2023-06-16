package com.example.motipull.cardDetail.controller;

import com.example.motipull.cardDetail.dto.CardDetailDto;
import com.example.motipull.cardDetail.service.CardDetailService;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardDetailController {

    private final CardDetailService cardDetailService;

    public CardDetailController(CardDetailService cardDetailService) {
        this.cardDetailService = cardDetailService;
    }

/***
    @PostMapping("/cardDetail/create")
    @ResponseBody
    public ResponseEntity createCardDetail(@RequestBody CardDetailDto dto) {
        cardDetailService.createCardDetail(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    ***/
}
