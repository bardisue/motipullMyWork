package com.example.motipull.rowPrimary.service;

import com.example.motipull.kanbanRow.service.KanbanRowService;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.repository.MemberRepository;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.service.RoomService;
import com.example.motipull.rowPrimary.dto.RowPrimaryDto;
import com.example.motipull.rowPrimary.entity.RowPrimaryEntity;
import com.example.motipull.rowPrimary.repository.RowPrimaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RowPrimaryService {

    private final RowPrimaryRepository rowPrimaryRepository;

    @Autowired
    public RowPrimaryService(RowPrimaryRepository rowPrimaryRepository){
        this.rowPrimaryRepository = rowPrimaryRepository;
    }
    @Autowired
    KanbanRowService kanbanRowService;

    @Autowired
    MemberService memberService;


    public void createRowPrimary(RowPrimaryDto dto) {
        RowPrimaryEntity rowPrimary = RowPrimaryEntity.toEntity(dto.getId(), kanbanRowService.getKanbanRowById(dto.getRowId()) ,MemberEntity.toEntity(memberService.getMemberById(dto.getMemberId())));
        if (rowPrimaryRepository.findById(dto.getMemberId()).isEmpty()) {
            log.info("[RowPrimary] new RowPrimary created! | name : {}", dto.getId());
        }
        rowPrimaryRepository.save(rowPrimary);
    }
    /***
    public List<MemberDto> getAllMembers() {
        List<MemberEntity> list = memberRepository.findAll();

        List<MemberDto> dtos = list.stream().map(x -> MemberDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

    public MemberDto getMemberById(Integer memberId){
        System.out.println(memberId);
        MemberEntity member = memberRepository.findById(memberId).get();
        return MemberDto.toDto(member);
    }
     ***/
}
