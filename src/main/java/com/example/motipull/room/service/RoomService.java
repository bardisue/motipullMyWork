package com.example.motipull.room.service;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    @Autowired
    MemberService memberService;

    private final RoomRepository roomRepository;

    public void createRoom(RoomDto dto) {
        Room room = Room.toEntity(dto, MemberEntity.toEntity(memberService.getMemberById(dto.getRoomAdmin().intValue())));
        if (roomRepository.findById(dto.getRoomId()).isEmpty()) {
            log.info("[RoomService] new room created! | name : {}", dto.getRoomName());
        }
        roomRepository.save(room);
    }

    public List<RoomDto> getAllRooms() {
        List<Room> list = roomRepository.findAll();

        List<RoomDto> dtos = list.stream().map(x -> RoomDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

    public Room getRoomById(int roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(IllegalArgumentException::new);
        return room;
    }

}
