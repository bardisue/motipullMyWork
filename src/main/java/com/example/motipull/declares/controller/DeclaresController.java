package com.example.motipull.declares.controller;

import com.example.motipull.declares.dto.DeclaresDto;
import com.example.motipull.declares.service.DeclaresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeclaresController {

    private final DeclaresService declaresService;

    public DeclaresController(DeclaresService declareService) {
        this.declaresService = declareService;
    }


    @PostMapping("/declare/create")
    @ResponseBody
    public ResponseEntity createCardDetail(@RequestBody DeclaresDto dto) {
        declaresService.createDeclare(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
