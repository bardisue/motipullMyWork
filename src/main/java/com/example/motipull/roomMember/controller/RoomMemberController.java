package com.example.motipull.roomMember.controller;

import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.roomMember.dto.RoomMemberDto;
import com.example.motipull.roomMember.service.RoomMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomMemberController {
    @Autowired
    RoomMemberService roomMemberService;
    @PostMapping("/roommember/create")
    @ResponseBody
    public ResponseEntity createRoomMember(@RequestBody RoomMemberDto dto) {
        roomMemberService.createRoomMember(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}