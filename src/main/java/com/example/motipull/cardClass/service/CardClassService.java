package com.example.motipull.cardClass.service;

import com.example.motipull.card.service.CardService;
import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import com.example.motipull.cardClass.dto.CardClassDto;
import com.example.motipull.cardClass.entity.CardClassEntity;
import com.example.motipull.cardClass.repository.CardClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class CardClassService {

    private final CardClassRepository cardClassRepository;
    @Autowired
    CardService cardService;

    @Autowired
    public CardClassService(CardClassRepository cardClassRepository){
        this.cardClassRepository = cardClassRepository;
    }

    public void createCardClass(CardClassDto dto) {
        CardClassEntity cardClass = CardClassEntity.toEntity(cardService.getCardById(dto.getCardId()), dto.getCardClass());
        cardClassRepository.save(cardClass);
    }

    public List<String> getSearchById(Integer cardId) {
        List<CardClassEntity> list = cardClassRepository.findAll();
        List<String> testList = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCard().getId() == cardId){
                testList.add(list.get(i).getCardClass());
            }
        }
        return testList;
    }


}
