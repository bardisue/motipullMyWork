package com.example.motipull.cardAdmin.service;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.card.service.CardService;
import com.example.motipull.cardAdmin.dto.CardAdminDto;
import com.example.motipull.cardAdmin.dto.CardAdminSearchDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(dto.getCardId());
        CardAdminEntity cardAdmin = CardAdminEntity.toEntity(cardService.getCardById(dto.getCardId()), dto.getAdmin());
        cardAdminRepository.save(cardAdmin);
    }

    public List<CardAdminDto> getAllCardAdmin() {
        List<CardAdminEntity> list = cardAdminRepository.findAll();

        List<CardAdminDto> dtos = list.stream().map(x -> CardAdminDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

    public List<String> getSearchById(Integer cardId) {
        List<CardAdminEntity> list = cardAdminRepository.findAll();
        List<String> testList = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCard().getId() == cardId){
                testList.add(list.get(i).getAdmin());
            }
        }
        return testList;
    }
}
