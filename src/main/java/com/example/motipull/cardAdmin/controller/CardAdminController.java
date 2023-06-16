package com.example.motipull.cardAdmin.controller;

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
public class CardAdminController {
    @Autowired
    CardAdminService cardAdminService;
    @PostMapping("/cardAdmin/create")
    @ResponseBody
    public ResponseEntity createCardAdmin(@RequestBody CardAdminDto dto) {
        cardAdminService.creatCardAdmin(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/cardAdmin/searchAll")
    @ResponseBody
    public ResponseEntity<List<CardAdminDto>> getAllCard(){
        return ResponseEntity.ok(cardAdminService.getAllCardAdmin());
    }


    @GetMapping("/cardAdmin/searchById")
    @ResponseBody
    public List<String> getSearchById(@RequestParam Integer cardId){
        return cardAdminService.getSearchById(cardId);
    }
}
