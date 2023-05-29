package com.example.motipull.kanbanRow.service;

import com.example.motipull.kanbanRow.dto.KanbanRowDto;
import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.kanbanRow.repository.KanbanRepository;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.repository.MemberRepository;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KanbanRowService {
    @Autowired
    RoomService roomService;

    @Autowired
    MemberService memberService;

    private final KanbanRepository kanbanRepository;

    public void createKanbanRow(KanbanRowDto dto) {
        KanbanRowEntity kanbanRow = new KanbanRowEntity(dto.getRowId(), dto.getRowName(), roomService.getRoomById(dto.getRoomId()), dto.getRowIsBacklog(),
                MemberEntity.toEntity(memberService.getMemberById(dto.getRowCreateAdmin())), MemberEntity.toEntity(memberService.getMemberById(dto.getRowPullAdmin())), dto.getRowWIPLimit(),
                dto.getRowIsNoticePull(), dto.getRowIsPrimary(), dto.getRowNoticePrimary());
        if (kanbanRepository.findById(dto.getRowId()).isEmpty()) {
            log.info("[KanbanRowService] new KanbanRow created! | name : {}", dto.getRowName());
        }
        kanbanRepository.save(kanbanRow);
    }
}
