package com.example.motipull.room.controller;

import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;


    @PostMapping("/room/create")
    @ResponseBody
    public ResponseEntity createRoom(@RequestBody RoomDto dto) {
        roomService.createRoom(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/rooms")
    @ResponseBody
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

}