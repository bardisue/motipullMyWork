package com.example.motipull.rowPrimary.controller;

import com.example.motipull.kanbanRow.dto.KanbanRowDto;
import com.example.motipull.kanbanRow.service.KanbanRowService;
import com.example.motipull.rowPrimary.dto.RowPrimaryDto;
import com.example.motipull.rowPrimary.service.RowPrimaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RowPrimaryController {
    @Autowired
    RowPrimaryService rowPrimaryService;
    @PostMapping("/RowPrimary/create")
    @ResponseBody
    public ResponseEntity createRowPrimary(@RequestBody RowPrimaryDto dto) {
        rowPrimaryService.createRowPrimary(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
