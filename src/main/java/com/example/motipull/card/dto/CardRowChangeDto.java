package com.example.motipull.card.dto;

import com.example.motipull.card.entitiy.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardRowChangeDto {
    private Integer cardId;
    private Integer rowId;

}
