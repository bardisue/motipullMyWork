package com.example.motipull.kanbanRow.controller;

import com.example.motipull.kanbanRow.dto.KanbanRowDto;
import com.example.motipull.kanbanRow.service.KanbanRowService;
import com.example.motipull.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KanbanRowController {
    @Autowired
    KanbanRowService kanbanRowService;
    @PostMapping("/kanbanRow/create")
    @ResponseBody
    public ResponseEntity createKanbanRow(@RequestBody KanbanRowDto dto) {
        kanbanRowService.createKanbanRow(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
