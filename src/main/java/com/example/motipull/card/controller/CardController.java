package com.example.motipull.card.controller;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.card.dto.CardRowChangeDto;
import com.example.motipull.card.service.CardService;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.dto.MemberIdDto;
import com.example.motipull.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cardService;


    @PostMapping("/card/create")
    @ResponseBody
    public ResponseEntity createCard(@RequestBody CardDto dto) {
        cardService.createCard(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/card/rowChange")
    @ResponseBody
    public ResponseEntity createRoom(@RequestBody CardRowChangeDto dto) {
        cardService.changeCard(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
