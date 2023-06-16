package com.example.motipull.card.controller;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.card.dto.CardColChangeDto;
import com.example.motipull.card.service.CardService;
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

    @GetMapping("/card/searchAll")
    @ResponseBody
    public ResponseEntity<List<CardDto>> getAllCard(){
        return ResponseEntity.ok(cardService.getAllCard());
    }

    @PostMapping("/card/colChange")
    @ResponseBody
    public ResponseEntity changeCard(@RequestBody CardColChangeDto dto) {
        cardService.changeCard(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/card/cheerUp")
    @ResponseBody
    public ResponseEntity cheerUp(@RequestBody CardColChangeDto dto) {
        cardService.cheerUp(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/card/dueDate")
    @ResponseBody
    public ResponseEntity changeDueDate(@RequestBody CardColChangeDto dto) {
        cardService.changeDueDate(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
