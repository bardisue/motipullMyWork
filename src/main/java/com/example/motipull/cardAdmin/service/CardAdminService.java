package com.example.motipull.cardAdmin.service;

import com.example.motipull.card.service.CardService;
import com.example.motipull.cardAdmin.dto.CardAdminDto;
import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import com.example.motipull.cardAdmin.repository.CardAdminRepository;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import com.example.motipull.room.service.RoomService;
import com.example.motipull.roomMember.dto.RoomMemberDto;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import com.example.motipull.roomMember.repository.RoomMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardAdminService {
    private final CardAdminRepository cardAdminRepository;

    @Autowired
    CardService cardService;

    @Autowired
    MemberService memberService;


    public void creatCardAdmin(CardAdminDto dto) {
        CardAdminEntity cardAdmin = CardAdminEntity.toEntity(dto.getId(), cardService.getCardById(dto.getCardId()), MemberEntity.toEntity(memberService.getMemberById(dto.getMemberId())));
        if (cardAdminRepository.findById(dto.getId()).isEmpty()) {
            log.info("[CardAdmin] new CardAdmin created! | name : {}", dto.getId());
        }
        cardAdminRepository.save(cardAdmin);
    }

}
