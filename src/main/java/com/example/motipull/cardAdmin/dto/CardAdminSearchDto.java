package com.example.motipull.cardAdmin.dto;

import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CardAdminSearchDto {
    private Integer cardId;
    private Integer anyThing;

     public static CardAdminSearchDto toDto(CardAdminEntity cardAdmin){
        return new CardAdminSearchDto(cardAdmin.getCard().getId(), 0);
     }
}
