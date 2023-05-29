package com.example.motipull.declares.service;

import com.example.motipull.card.service.CardService;
import com.example.motipull.declares.dto.DeclaresDto;
import com.example.motipull.declares.entity.DeclaresEntity;
import com.example.motipull.declares.repository.DeclaresRepository;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeclaresService {

    private final DeclaresRepository declareRepository;
    @Autowired
    public DeclaresService(DeclaresRepository declareRepository){
        this.declareRepository = declareRepository;
    }
    @Autowired
    CardService cardService;
    @Autowired
    MemberService memberService;

    public void createDeclare(DeclaresDto dto) {
        DeclaresEntity declare = DeclaresEntity.toEntity(dto, MemberEntity.toEntity(memberService.getMemberById(dto.getMemberId())), cardService.getCardById(dto.getCardId()));
        if (declareRepository.findById(dto.getId()).isEmpty()) {
            log.info("[Declare] new Declare created! | name : {}", dto.getId());
        }
        declareRepository.save(declare);
    }


}
