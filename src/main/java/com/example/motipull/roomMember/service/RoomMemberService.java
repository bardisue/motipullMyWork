package com.example.motipull.roomMember.service;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.room.repository.RoomRepository;
import com.example.motipull.room.service.RoomService;
import com.example.motipull.roomMember.dto.RoomMemberDto;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import com.example.motipull.roomMember.repository.RoomMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class RoomMemberService {
    @Autowired
    RoomService roomService;

    @Autowired
    MemberService memberService;
    private final RoomMemberRepository roomMemberRepository;
    public void createRoomMember(RoomMemberDto dto) {
        RoomMemberEntity roomMember = RoomMemberEntity.toEntity(roomService.getRoomById(dto.getRoomId()) , MemberEntity.toEntity(memberService.getMemberById(dto.getMemberId())));
        if (roomMemberRepository.findById(dto.getId()).isEmpty()) {
            log.info("[RoomMember] new room created! | name : {}", dto.getId());
        }
        roomMemberRepository.save(roomMember);
    }

}