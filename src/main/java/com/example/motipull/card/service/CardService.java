package com.example.motipull.card.service;

import com.example.motipull.card.dto.CardColChangeDto;
import com.example.motipull.card.dto.CardDto;
import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.card.repository.CardRepository;
import com.example.motipull.kanbanRow.service.KanbanRowService;
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
        CardEntity card = CardEntity.toEntity(dto);
        /***
        if (cardRepository.findById(card.getCardID()).isEmpty()) {
            log.info("[CardService] new member created! | name : {}", card.getCardName());
        }
         ***/
        cardRepository.save(card);
    }

    public void changeCard(CardColChangeDto dto) {
        CardEntity card = cardRepository.findById(dto.getCardId()).get();
        card.setColId(card.getColId()+1);
        cardRepository.save(card);
    }

    public void cheerUp(CardColChangeDto dto) {
        CardEntity card = cardRepository.findById(dto.getCardId()).get();
        card.setCheerUp(card.getCheerUp() + 1);
        cardRepository.save(card);
    }

    public CardEntity getCardById(Integer id){
        CardEntity card = cardRepository.findById(id).get();
        return card;
    }

    public List<CardDto> getAllCard() {
        List<CardEntity> list = cardRepository.findAll();

        List<CardDto> dtos = list.stream().map(x -> CardDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

    public void changeDueDate(CardColChangeDto dto) {
        CardEntity card = cardRepository.findById(dto.getCardId()).get();
        card.setDueDate(dto.getDueDate());
        cardRepository.save(card);
    }
}
