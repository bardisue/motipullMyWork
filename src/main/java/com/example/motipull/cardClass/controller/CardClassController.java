package com.example.motipull.cardClass.controller;

import com.example.motipull.cardClass.dto.CardClassDto;
import com.example.motipull.cardClass.service.CardClassService;
import org.springframework.web.bind.annotation.RestController;
import com.example.motipull.card.dto.CardDto;
import com.example.motipull.cardAdmin.dto.CardAdminDto;
import com.example.motipull.cardAdmin.dto.CardAdminSearchDto;
import com.example.motipull.cardAdmin.service.CardAdminService;
import com.example.motipull.roomMember.dto.RoomMemberDto;
import com.example.motipull.roomMember.service.RoomMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardClassController {

    private final CardClassService cardDetailService;

    public CardClassController(CardClassService cardDetailService) {
        this.cardDetailService = cardDetailService;
    }

    @PostMapping("/cardClass/create")
    @ResponseBody
    public ResponseEntity createCardClass(@RequestBody CardClassDto dto) {
        cardDetailService.createCardClass(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @GetMapping("/cardClass/searchById")
    @ResponseBody
    public List<String> getSearchById(@RequestParam Integer cardId){
        return cardDetailService.getSearchById(cardId);
    }
}
