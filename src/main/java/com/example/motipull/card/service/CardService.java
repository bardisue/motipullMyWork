package com.example.motipull.card.service;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.card.dto.CardRowChangeDto;
import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.card.repository.CardRepository;
import com.example.motipull.kanbanRow.service.KanbanRowService;
import com.example.motipull.member.dto.MemberDto;
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
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    @Autowired
    KanbanRowService kanbanRowService;

    private final CardRepository cardRepository;


    public void createCard(CardDto dto) {
        CardEntity card = CardEntity.toEntity(dto, kanbanRowService.getKanbanRowById(dto.getRowId()));
        if (cardRepository.findById(dto.getCardId()).isEmpty()) {
            log.info("[CardService] new member created! | name : {}", dto.getCardName());
        }
        cardRepository.save(card);
    }

    public void changeCard(CardRowChangeDto dto) {
        CardEntity card = cardRepository.findById(dto.getCardId()).get();
        System.out.println(dto.getRowId());
        card.setRow(kanbanRowService.getKanbanRowById(dto.getRowId()));
        cardRepository.save(card);
    }

    public CardEntity getCardById(Integer id){
        CardEntity card = cardRepository.findById(id).get();
        return card;
    }
}
