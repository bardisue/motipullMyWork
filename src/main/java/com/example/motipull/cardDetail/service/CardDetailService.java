package com.example.motipull.cardDetail.service;

import com.example.motipull.card.service.CardService;
import com.example.motipull.cardAdmin.repository.CardAdminRepository;
import com.example.motipull.cardDetail.dto.CardDetailDto;
import com.example.motipull.cardDetail.entity.CardDetailEntity;
import com.example.motipull.cardDetail.repository.CardDetailRepository;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CardDetailService {

    private final CardDetailRepository cardDetailRepository;
    @Autowired
    CardService cardService;

    @Autowired
    public CardDetailService(CardDetailRepository cardDetailRepository){
        this.cardDetailRepository = cardDetailRepository;
    }

    public void createCardDetail(CardDetailDto dto) {
        CardDetailEntity cardDetail = CardDetailEntity.toEntity(dto, cardService.getCardById(dto.getCardId()));
        if (cardDetailRepository.findById(dto.getId()).isEmpty()) {
            log.info("[CardDetai] new CardDetai created! | name : {}", dto.getId());
        }
        cardDetailRepository.save(cardDetail);
    }


}
