package com.example.motipull.card.dto;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardDto {
    private Integer cardId;
    private String cardName;
    private String cardExplanation;
    private String cardDomain;
    private Boolean cardDetail;
    private Integer rowId;

    public static CardDto toDto(CardEntity card){
        return new CardDto(card.getCardID(), card.getCardName(), card.getCardExplanation(),card.getCardDomain(), card.isCardDetail(), card.getRow().getRowID());
    }

}
